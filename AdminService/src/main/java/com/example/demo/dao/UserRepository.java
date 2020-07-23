package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	@Query("from User where username= ?1 and password=?2")
	User findUserByUsernameAndPassword(String username, String password);

}
