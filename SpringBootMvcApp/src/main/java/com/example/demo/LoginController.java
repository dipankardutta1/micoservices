package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.UserDto;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Controller
public class LoginController {
	
	
	@Autowired
	 private RestTemplate restTemplate;
	 
	 @Autowired
	 private EurekaClient eurekaClient;
	
	
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	
	
	
	
	@RequestMapping(value="/login")
	public String goToLoginPage() {
		
		System.out.println("Login Page");
		
		// code 
		
		
		return "page.jsp";
		
		
		
	}
	
	
	
	@RequestMapping(value="/dologin")
	public String validateUser(Model model,@RequestParam("username") String username,@RequestParam("password") String password) {
		
		
		 Application application = eurekaClient.getApplication("zuulserver");
	     InstanceInfo instanceInfo = application.getInstances().get(0);
	     String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/admin/validateUser?username="+username+"&password="+password;
		
		
		System.out.println("Login Page");
		
		// code 
		
		UserDto userDto = restTemplate.getForObject(url, UserDto.class);//  loginService.validateUser(username,password);
		
		
		
		
		if(userDto == null) {
			return "page.jsp";
			
		}else {
			
			
			UserDto userformData = new UserDto();
			
			
			 url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/admin/findAllUsers";
			
			List<UserDto> users = restTemplate.getForObject(url,List.class); //loginService.getAllUsers();
			
			
			model.addAttribute("users",users);
			
			
			model.addAttribute("userformData",userformData);
			
			return "dashboard.jsp";
		}
		
		
		
		
		
		
	}
	
	
	
	
	@RequestMapping(value="/processUser",method = RequestMethod.POST)
	public String submitForm(Model model,@ModelAttribute("userformData") UserDto userDto) {
		
		
		
		
		//loginService.processUser(userDto);
		
		UserDto userformData = new UserDto();
		//List<UserDto> users = loginService.getAllUsers();
		
		//model.addAttribute("users",users);
		model.addAttribute("userformData",userformData);
		
		return "dashboard.jsp";
		
	}
	
	
	
	@RequestMapping(value="/editUser",method = RequestMethod.GET)
	public String editUser(Model model,@RequestParam("id") Integer id) {
		
		
		//UserDto userformData = loginService.findById(id);
		
		
		
		
		//List<UserDto> users = loginService.getAllUsers();
		
		//model.addAttribute("users",users);
		//model.addAttribute("userformData",userformData);
		
		return "dashboard.jsp";
		
	}
	
	
	
	

}
