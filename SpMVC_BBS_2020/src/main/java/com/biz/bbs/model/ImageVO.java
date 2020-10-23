package com.biz.bbs.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageVO {
	
	private Long i_seq;
	private Long i_b_seq;
	private String i_org_name;
	private String i_file_name;
	private Long i_down;
	
}
