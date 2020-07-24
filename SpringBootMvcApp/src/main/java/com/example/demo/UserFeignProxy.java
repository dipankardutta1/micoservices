package com.example.demo;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.UserDto;

@FeignClient(name="admin-service" )
@RibbonClient(name="admin-service")
public interface UserFeignProxy {
	
	 @RequestMapping(method = RequestMethod.GET, value = "/findAllUsers")
	 List<UserDto> getAllUsers();
	 
	 @RequestMapping(method = RequestMethod.GET, value = "/validateUser")
	 UserDto validateUser(@RequestParam("username") String username,@RequestParam("password") String password);

}
