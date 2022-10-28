package com.cts.intcdb22jf003.pms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cts.intcdb22jf003.pms.dao.UserRepository;
import com.cts.intcdb22jf003.pms.models.Role;
import com.cts.intcdb22jf003.pms.models.User;
@Component
public class CustomeUserDetailsService implements UserDetailsService{
   @Autowired
	private UserRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repository.findByUsername(username);
		
		if(user==null)
		{
			throw new UsernameNotFoundException("User Not Found");
			
		}else
		{
			
List<Role> roles = user.getRoles();
			
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			
			for(Role r:roles)
			{
				SimpleGrantedAuthority auth= new SimpleGrantedAuthority(r.getRole());
				authorities.add(auth);
			}
			
			return new org.springframework.security.core.userdetails.User(username,user.getPassword(),authorities);
		}
		
		
		
	}

}
