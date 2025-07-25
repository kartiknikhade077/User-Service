package com.users.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.users.entity.Departments;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, Long> {

	Page<Departments> findByCompanyId(int companyId,Pageable pageable );
}
