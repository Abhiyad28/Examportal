package com.exam.exam.Model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

	
	 String authority;
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority;
	}
	public  Authority(String authority) {
		 this.authority=authority;
	}

}
