package com.project.myapp.VO;


import lombok.Data;

@Data // getter setter 생성해주는 어노
public class LoginVO {

	private String id;
	private String password;
	private String useCookie;

}
