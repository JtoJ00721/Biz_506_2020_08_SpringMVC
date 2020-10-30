package com.biz.grade.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GradeVO {

	private long seq;
	private String name;
	private int guk;
	private int young;
	private int su;
	private int sum;
	private int avg;

}
