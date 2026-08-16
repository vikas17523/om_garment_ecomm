package com.ecommerce.api.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.api.dto.BaseResponse;
import com.ecommerce.api.dto.UserLoginDTO;
import com.ecommerce.api.dto.UserLoginResponse;
import com.ecommerce.api.dto.UserRegistrationDTO;
import com.ecommerce.api.entity.UserRegistration;
import com.ecommerce.api.exception.AuthenticationFailedException;
import com.ecommerce.api.exception.EmailAlreadyExistsException;
import com.ecommerce.api.exception.MobileAlreadyExistsException;
import com.ecommerce.api.exception.UserNotFoundException;
import com.ecommerce.api.repository.UserRegistraionRepository;
import com.ecommerce.api.security.JwtService;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	
	private final UserRegistraionRepository userRegistrationRepository;;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
	
	UserService(UserRegistraionRepository userRegistrationRepository,
			PasswordEncoder passwordEncoder,JwtService jwtService) {
		this.userRegistrationRepository = userRegistrationRepository;
		this.passwordEncoder=passwordEncoder;
		this.jwtService=jwtService;
	}
	
	@Transactional
	 public BaseResponse userRegister(UserRegistrationDTO userRegistrationDTO) {

		 
		   //BaseResponse baseResponse=new BaseResponse();
		 
	        // Check email already exists
	        if (userRegistrationRepository.existsByEmail(userRegistrationDTO.getEmail())) 
	        {
	
	            //return new BaseResponse("failure", "Email already registered");
	        	throw new EmailAlreadyExistsException("Email already registered");
	        }

	        // Check mobile number already exists
	        if (userRegistrationRepository.existsByMobileNo(userRegistrationDTO.getMobileNo())) {
	        	
	        	//return new BaseResponse("failure","Mobile number already registered");
	        	throw new MobileAlreadyExistsException( "Mobile number already registered");
	        }

	        // Convert DTO to Entity
	        UserRegistration userRegister = new UserRegistration();

	        userRegister.setEmail(userRegistrationDTO.getEmail());
	        userRegister.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
	        userRegister.setMobileNo(userRegistrationDTO.getMobileNo());
	        userRegister.setFirstName(userRegistrationDTO.getFirstName());
	        userRegister.setLastName(userRegistrationDTO.getLastName());
	        userRegister.setGender(userRegistrationDTO.getGender());

	        // Save user
	        userRegistrationRepository.save(userRegister);

	        //return "User registered successfully";
	        
	        return new BaseResponse("Success","User registered successfully");
	    }
	
	public UserLoginResponse userLogin(UserLoginDTO userLoginDto) {

		UserRegistration user = userRegistrationRepository
	            .findByEmail(userLoginDto.getEmail())
	            .orElseThrow(() ->
	                    new UserNotFoundException("User not found"));
		
		boolean passwordMatches =
		        passwordEncoder.matches(
		            userLoginDto.getPassword(),
		            user.getPassword()
		        );
		
		if (!passwordMatches) {
		    throw new AuthenticationFailedException(
		            "Invalid email or password"
		    );
		}
		
		String token = jwtService.generateToken(user.getEmail());

	    return new UserLoginResponse(
	            "SUCCESS",
	            "User found successfully",
	            token
	    );
		
	}
}
