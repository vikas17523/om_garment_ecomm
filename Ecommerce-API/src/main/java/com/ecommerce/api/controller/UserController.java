package com.ecommerce.api.controller;

import java.net.http.HttpResponse.ResponseInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.representer.BaseRepresenter;

import com.ecommerce.api.dto.BaseResponse;
import com.ecommerce.api.dto.UserLoginDTO;
import com.ecommerce.api.dto.UserLoginResponse;
import com.ecommerce.api.dto.UserRegistrationDTO;
import com.ecommerce.api.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private final UserService userService;

	UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public BaseResponse userRegister(@RequestBody UserRegistrationDTO userRegisterDto)
	{
		System.out.println("register controller called");
		BaseResponse response=userService.userRegister(userRegisterDto);
		
		return response;
	}
	
	@PostMapping("/login")
	public UserLoginResponse userLogin(@RequestBody UserLoginDTO userLoginDto) {
		
		System.out.println("login called");
		//UserLoginResponse resposne=new UserLoginResponse();
		
		
		
		return userService.userLogin(userLoginDto);
	}
	
	@PostMapping("/profile")
	public String userPorfile() {
		
		
		return "profile called";
	}
	
	
}
