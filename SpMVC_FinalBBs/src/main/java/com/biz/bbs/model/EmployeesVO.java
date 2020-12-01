package com.biz.bbs.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Generated
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeesVO {
	
	private long id;
	private String first_name;
	private String last_name;
	private String address;
	private String tel;
	private String email;
	
}
