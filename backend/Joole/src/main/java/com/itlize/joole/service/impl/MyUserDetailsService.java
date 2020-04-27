package com.itlize.joole.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itlize.joole.entity.Consumer;
import com.itlize.joole.repository.ConsumerRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private ConsumerRepository consumerRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
   
    	String password;
    	Optional <Consumer> c = consumerRepo.findByConsumerUsername(username);

    	if (c.isPresent()) password = c.get().getConsumerPassword();
    	else password = null;
    	
        return new User(username, password, new ArrayList<>());
    }
}
