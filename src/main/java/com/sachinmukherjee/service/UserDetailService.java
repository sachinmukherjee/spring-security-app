package com.sachinmukherjee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sachinmukherjee.model.User;
import com.sachinmukherjee.model.UserPrincipal;
import com.sachinmukherjee.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not Found");
		}
		
		return new UserPrincipal(user);
	}

}
