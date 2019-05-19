package com.practice.PostgreSQL.VO;

import lombok.Data;

@Data
public class MemberVO extends SearchVO {

	int user_no; 
	String id;
	String password;
	String email_addr;
	
}
