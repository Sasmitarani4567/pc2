package com.hutech.payrollapp.api.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hutech.payrollapp.api.jwtUtill.JwtUtil;
import com.hutech.payrollapp.api.model.Login;
import com.hutech.payrollapp.api.model.LoginResponse;
import com.hutech.payrollapp.api.serviceImpl.LoginService;



@RestController
@RequestMapping
public class LoginController {

	
	private static final @NotEmpty @Size(min = 8, message = "password should have at least 8 character") String String = null;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private LoginService loginService;
	
	 @PostMapping("/logintoken")
	 public ResponseEntity<?> createAuthenticationToken(@RequestBody Login login) throws Exception {
		  
			
			 
			  try { 
				  authenticationManager.authenticate( new
			  UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword())
			  );
			  
			  } catch (BadCredentialsException e) { throw new
			  Exception("Incorrect username or password", e);
			  
			  }
			 
		 final UserDetails userDetails = loginService
				  .loadUserByUsername(login.getUsername());
				  
		 final String jwt = jwtTokenUtil.generateToken(userDetails);
		  
		  return ResponseEntity.ok(new LoginResponse(jwt,login.getUsername(),login.getPassword())); 	
}
}