package com.biz.book.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * BookVO 객체들의 리스트를 담을 리스트 클래스
 * 
 * RestTemplate 기능을 사용하여 API 데이터를 가져오기위한
 * 핵심 기능을 사용하기 위한 매우 중요한 model 클래스
 * API를 통해 가져올 데이터(VO)들을 담을 List를 선언하는데
 * 
 * 이때 변수의 이름은 API에서 보내주는 데이터의 이름을 참조하여 
 * 만들어야 한다.
 */

@XmlRootElement(name="rss")
public class Book_XML_Parent {
	
	@XmlElement(name="channel")
	public Book_XML_Channel channel;
	
}
