package com.blitzware.brazukacarclean.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blitzware.brazukacarclean.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

}
