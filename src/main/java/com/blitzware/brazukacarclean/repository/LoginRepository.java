package com.blitzware.brazukacarclean.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.blitzware.brazukacarclean.model.LoginModel;

public interface LoginRepository extends CrudRepository<LoginModel, Long> {
	@Query(value = "SELECT * FROM tb_login where str_email like :email", nativeQuery = true)
	Optional<LoginModel> findByEmail(@Param("email") String email);
}
