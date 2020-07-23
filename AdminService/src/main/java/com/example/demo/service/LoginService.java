package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

@Component
public class LoginService {
	
	@Autowired
	private UserRepository userRepository;

	public UserDto validateUser(String username, String password) {
		
		
		User user = userRepository.findUserByUsernameAndPassword(username,password);
		
		
		if(user == null) {
			return null;
		}else {
			UserDto userDto = new UserDto();
			
			
			
			BeanUtils.copyProperties(user,userDto);
			
			
			
			return userDto;
		}
		
		
		
		
		
	}

	public List<UserDto> getAllUsers() {
		
		
		
		
		List<User> users = userRepository.findAll();
		
		
		List<UserDto> userDtos = new ArrayList<UserDto>();
		
		for(User user : users) {
			UserDto userDto = new UserDto();
			
			BeanUtils.copyProperties(user,userDto);
			
			userDtos.add(userDto);
			
		}
		
		
		
		return userDtos;
		
	}

	public void processUser(UserDto userDto) {
		
		
			
			User user = new User();
			
			
			BeanUtils.copyProperties(userDto,user);
			
			userRepository.save(user);
			
		
		
		
		
	}

	public UserDto findById(Integer id) {
	
		
		User user = userRepository.getOne(id);
		
		UserDto userDto = new UserDto();
		
		BeanUtils.copyProperties(user,userDto);
		
		return userDto;
		
		
	}

}
