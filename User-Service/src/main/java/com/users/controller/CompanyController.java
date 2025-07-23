package com.users.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.users.dto.CompanyDto;
import com.users.dto.EmployeeDto;
import com.users.entity.Company;
import com.users.entity.Departments;
import com.users.entity.Employee;
import com.users.entity.ModuleAccess;
import com.users.entity.Role;
import com.users.entity.User;
import com.users.repository.CompanyRepository;
import com.users.repository.DepartmentsRepository;
import com.users.repository.EmployeeRepository;
import com.users.repository.ModuleAccessRepository;
import com.users.repository.RoleRepository;
import com.users.repository.UserRepository;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EmployeeRepository employRepository;
	@Autowired
	private ModuleAccessRepository moduleAccessRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private DepartmentsRepository departmentsRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	
	
	Company company;
	User user;

	@ModelAttribute
	public void companyDetails(@RequestHeader("userName") String  userName) {

		company = companyRepository.findByCompanyEmail(userName);
		user=userRepository.getUserByUserName(userName);
		
	}
	
	@GetMapping("/getCompanyInfo")
	public Company getCompanyInfo(@RequestHeader("userName") String  userName) {

		return  companyRepository.findByCompanyEmail(userName);
		
		
	}
	
	

	@PostMapping("/createEmployee")
	public ResponseEntity<?> createEmployee(@RequestBody EmployeeDto employeeDto) {
		try {
			Employee employee = new Employee();
			employee.setName(employeeDto.getName());
			employee.setEmail(employeeDto.getEmail());
			employee.setPhone(employeeDto.getPhone());
			employee.setDepartment(employeeDto.getDepartment());
			employee.setGender(employeeDto.getGender());
			employee.setDescription(employeeDto.getDescription());
			employee.setUserId(company.getUserId());
			employee.setCompanyId(company.getCompanyId());
			employee.setDepartmentId(employeeDto.getDepartmentId());
			employee.setRoleId(employeeDto.getRoleId());
			employee.setRoleName(employeeDto.getRoleName());

			employRepository.save(employee);

			User employeeUser = new User();
			employeeUser.setName(employeeDto.getName());
			employeeUser.setEmail(employeeDto.getEmail());
			employeeUser.setPassword(bCryptPasswordEncoder.encode(employeeDto.getPassword()));
			employeeUser.setEnabled(false);
			employeeUser.setRole("ROLE_EMP");
			employeeUser.setExpirayDate(user.getExpirayDate());

			userRepository.save(employeeUser);

			ModuleAccess module = new ModuleAccess();
			module.setCompanyId(company.getCompanyId());
			module.setEmployeeId(employee.getEmployeeId());
			module.setEmail(employeeDto.isEmailAccess());
			module.setLeadAccess(employeeDto.isLeadAccess());
			module.setTemplate(employeeDto.isTemplateAccess());

			moduleAccessRepository.save(module);

			return ResponseEntity.ok(employee);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error creating employee: " + ex.getMessage());
		}
	}
	
	
	@GetMapping("/checkDuplicateEmail/{email}")
	public boolean checkDuplicate(@PathVariable String email) {
		boolean isUserExist = true;

		User user = userRepository.getUserByUserName(email);

		if (user != null) {
			isUserExist = false;
		}

		return isUserExist;
	}

	@GetMapping("/getEmployeeList/{page}/{size}")
	public ResponseEntity<?> getEmployeeList(@PathVariable int page ,@PathVariable int size, @RequestParam(defaultValue = "") String name) {
		try {
			Map<String ,Object> data=new HashMap<String , Object>();
			 Pageable pageable = PageRequest.of(page, size, Sort.by("employeeId").descending());
		        Page<Employee> employeePage = employRepository.findByCompanyIdAndNameContainingIgnoreCase(company.getCompanyId(), name, pageable);
		        List<Employee> employeeList = employeePage.getContent();
		        data.put("employeeList", employeeList);
		        data.put("totalPages", employeePage.getTotalPages());
		        data.put("currentPage", employeePage.getNumber());
			return ResponseEntity.ok(data);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error creating employee: " + e.getMessage());
		}
	}
	
	@GetMapping("/getEmployee/{employeeId}")
	public ResponseEntity<?> getEmployee(@PathVariable int employeeId) {
		try {
           Map<String,Object> employeeDetails=new HashMap<String, Object>();
			
			Employee employee = employRepository.findByEmployeeId(employeeId);
			ModuleAccess module=moduleAccessRepository.findByEmployeeId(employeeId);
            
			employeeDetails.put("employeeInfo", employee);
			employeeDetails.put("moduleAccess", module);
			return ResponseEntity.ok(employeeDetails);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error creating employee: " + e.getMessage());
		}
	}
	
	
	@PutMapping("/updateEmployeeInfo")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {

		try {
			employRepository.save(employee);
			return ResponseEntity.ok(employee);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error creating employee: " + e.getMessage());
		}
	   
   }
	
	
	@PutMapping("/updateEmployeeModules")
	public ResponseEntity<?> updateCompanyModules(@RequestBody ModuleAccess moduleAccess) {

		try {
			
			moduleAccessRepository.updateModuleAccessByEmployeeId(moduleAccess.isLeadAccess(),moduleAccess.isTemplate(),moduleAccess.isEmail(),moduleAccess.getEmployeeId());
			return ResponseEntity.ok("Modules Updated Succesfully");

		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}
	}
	
	@PostMapping("/createDepartment")
	public ResponseEntity<?> createDepartment(@RequestBody Departments departments) {

		try {
			departments.setCompanyId(company.getCompanyId());
			departmentsRepository.save(departments);
			return ResponseEntity.ok(departments);

		} catch (Exception e) {

			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}

	}
	
	
	@PutMapping("/updateDepartment")
	public ResponseEntity<?> updateDepartment(@RequestBody Departments departments) {

		try {
			departments.setCompanyId(company.getCompanyId());
			departmentsRepository.save(departments);
			return ResponseEntity.ok(departments);

		} catch (Exception e) {

			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}

	}
	
	@GetMapping("/getDepartments/{page}/{size}")
	public ResponseEntity<?> getDepartments(@PathVariable int page ,@PathVariable int size){

		try {
			Pageable pageable = PageRequest.of(page, size, Sort.by("departmentId").descending());
			Page<Departments> deparmentList=departmentsRepository.findByCompanyId(company.getCompanyId(),pageable);
			Map<String ,Object> data=new HashMap<String,Object>();
			data.put("deparmentList", deparmentList.getContent());
			data.put("currentPage", deparmentList.getNumber());
			data.put("totalPage", deparmentList.getTotalPages());
			return ResponseEntity.ok(deparmentList);

		} catch (Exception e) {

			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}

	}
	
	@PostMapping("/createRole")
	public ResponseEntity<?> createRole(@RequestBody Role role) {

		try {
			role.setCompanyId(company.getCompanyId());
			roleRepository.save(role);
			return ResponseEntity.ok(role);

		} catch (Exception e) {

			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}

	}
	
	@PutMapping("/updateRole")
	public ResponseEntity<?> updateRole(@RequestBody Role role) {

		try {
			role.setCompanyId(company.getCompanyId());
			roleRepository.save(role);
			return ResponseEntity.ok(role);

		} catch (Exception e) {

			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}

	}

	@GetMapping("/getRoleByCompanyId/{page}/{size}")
	public ResponseEntity<?> getRolesByCompanyId(@PathVariable int page , @PathVariable int size) {

		try {
			Pageable pageable = PageRequest.of(page, size,Sort.by("roleId").descending());
			Page<Role> rolePage = roleRepository.findByCompanyId(company.getCompanyId(), pageable);
			Map<String, Object> response = new HashMap<>();
			response.put("roles", rolePage.getContent());
			response.put("currentPage", rolePage.getNumber());
			response.put("totalItems", rolePage.getTotalElements());
			response.put("totalPages", rolePage.getTotalPages());

			return ResponseEntity.ok(response);

		} catch (Exception e) {

			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}

	}
	
	@GetMapping("/getRolesByDepartmentId/{departmentId}")
	public ResponseEntity<?> getRolesByDepartmentId(@PathVariable int departmentId) {

		try {

			List<Role> roleList = roleRepository.findByDepartmentId(departmentId);

			return ResponseEntity.ok(roleList);

		} catch (Exception e) {

			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}

	}

	@GetMapping("/getRolesByRoleId/{roleId}")
	public ResponseEntity<?> getRolesByRoleId(@PathVariable int roleId) {

		try {

			Role roleList = roleRepository.findByRoleId(roleId);

			return ResponseEntity.ok(roleList);

		} catch (Exception e) {

			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}

	}
	
	
	

}
