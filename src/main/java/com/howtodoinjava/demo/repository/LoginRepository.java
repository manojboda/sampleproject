package com.howtodoinjava.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.demo.model.Login;
 
@Repository
public interface LoginRepository
        extends JpaRepository<Login, Long> {
	Login findByUsernameAndPassWord(String username,String password);
 
}
