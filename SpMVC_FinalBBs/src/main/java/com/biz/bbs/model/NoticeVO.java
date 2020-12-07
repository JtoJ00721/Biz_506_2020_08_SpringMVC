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
public class NoticeVO {
	
	private long id;
	private String date_time;
	private String writer;
	private String subject;
	private String text;

}
