package com.users.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.users.dto.EmployeeDto;
import com.users.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
	
	Employee findEmployeeByEmail(String username);
	
	Employee findByEmployeeId(String CId);
	
	List<Employee> findByCompanyId(String companyId);
	
	@Query(value = """
	        SELECT 
	            e.employee_id AS employeeId,
	            e.user_id AS userId,
	            e.company_id AS companyId,
	            e.name AS name,
	            e.email AS email,
	            e.phone AS phone,
	            e.description AS description,
	            e.department AS department,
	            e.gender AS gender,
	            ma.lead_access AS leadAccess,
	            ma.template AS templateAccess,
	            ma.email AS emailAccess
	        FROM employee e
	         JOIN module_access ma 
	            ON e.employee_id = ma.employee_id 
	        WHERE e.email = :email
	        """, nativeQuery = true)
	    EmployeeDto findByEmailWithAccess(@Param("email") String email);
	 Page<Employee> findByCompanyId(String companyId, Pageable pageable);
	 
	 @Query("SELECT e.employeeId, e.name FROM Employee e WHERE e.employeeId IN :ids")
	 List<Object[]> findEmployeeIdAndNameRaw(@Param("ids") List<String> ids);



}
