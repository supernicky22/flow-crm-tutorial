package com.example.application.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.saml.SAMLCredential;

public class SAMLUserDetailsServiceImpl {
	
	
	private static final Logger LOG =LoggerFactory.getLogger(SAMLUserDetailsServiceImpl.class);
	
	public Object LoadUserBysAML (SAMLCredential credential) throws UsernameNotFoundException
	{
		String userId = credential.getNameID().getValue();
		LOG.info(userId + "is logged in");
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");

        authorities.add(authority);



        // In a real scenario, this implementation has to locate user in a arbitrary

        // dataStore based on information present in the SAMLCredential and

        // returns such a date in a form of application specific UserDetails object.

        return new User(userId, "<abc123>", true, true, true, true, authorities);
	}

}
