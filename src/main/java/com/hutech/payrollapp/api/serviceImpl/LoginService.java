package com.hutech.payrollapp.api.serviceImpl;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hutech.payrollapp.api.model.Employee;
import com.hutech.payrollapp.api.model.Login;
import com.hutech.payrollapp.api.repository.Loginrepository;

@Service
public class LoginService implements UserDetailsService {
	
	@Autowired
	private Loginrepository loginrepository;
	
	@Override
	public UserDetails loadUserByUsername(String s)throws UsernameNotFoundException{
	return new User("sasmita.hutech@gmail.com","hutech",new ArrayList<>());	
	}
	
	
	
}

