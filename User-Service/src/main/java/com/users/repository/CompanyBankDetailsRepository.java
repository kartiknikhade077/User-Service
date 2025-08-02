package com.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.users.entity.CompanyBankDetails;

public interface CompanyBankDetailsRepository extends JpaRepository<CompanyBankDetails , String> {

	CompanyBankDetails findByCompanyId(String companyId);
}
