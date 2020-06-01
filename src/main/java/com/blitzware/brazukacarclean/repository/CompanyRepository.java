package com.blitzware.brazukacarclean.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blitzware.brazukacarclean.model.CompanyModel;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyModel, Long> {
	@Query(value = "SELECT * FROM tb_company where login_id = (SELECT id FROM tb_login where str_email LIKE :email)", nativeQuery = true)
	CompanyModel findByEmail(@Param("email") String email);

}
