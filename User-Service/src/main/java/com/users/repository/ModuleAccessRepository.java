package com.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.users.entity.ModuleAccess;

import jakarta.transaction.Transactional;

@Repository
public interface ModuleAccessRepository extends JpaRepository<ModuleAccess, String> {
	
	ModuleAccess findByEmployeeId(String employeeId);
    ModuleAccess findByEmployeeIdAndCompanyId(String employeeId,String companyId);
	
	@Modifying
	@Transactional
	@Query("UPDATE ModuleAccess m SET m.leadAccess = :leadAccess, m.template = :template, m.email = :email WHERE m.companyId = :companyId")
	int updateModuleAccessByCompanyId(
	    @Param("leadAccess") Boolean leadAccess,
	    @Param("template") Boolean template,
	    @Param("email") Boolean email,
	    @Param("companyId") String companyId
	);
	
	@Modifying
	@Transactional
	@Query("UPDATE ModuleAccess m SET m.leadAccess = :leadAccess, m.template = :template, m.email = :email WHERE m.employeeId = :employeeId")
	int updateModuleAccessByEmployeeId(
	    @Param("leadAccess") Boolean leadAccess,
	    @Param("template") Boolean template,
	    @Param("email") Boolean email,
	    @Param("employeeId") String employeeId
	);

}
