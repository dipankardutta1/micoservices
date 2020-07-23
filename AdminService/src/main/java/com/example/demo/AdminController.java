package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.service.LoginService;

@RestController
public class AdminController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="validateUser",method = RequestMethod.GET)
	@ResponseBody
	public UserDto validateUser(@RequestParam("username") String username,@RequestParam("password") String password) {
		
		
		return loginService.validateUser(username, password);
		
	}
	
	
	@RequestMapping(value="findAllUsers",method = RequestMethod.GET)
	@ResponseBody
	public List<UserDto> findAllUsers(){
		return loginService.getAllUsers();
	}

}
