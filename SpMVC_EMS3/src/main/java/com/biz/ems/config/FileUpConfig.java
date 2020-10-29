package com.biz.ems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/*
 * -context.xml 파일을 대체할 Java Config
 * 필요한 이름으로 클랫스르 선언하고 @Configration Annotation을 붙인다.
 * 내부에서 필요한 클래스를 객체로 생성하는 method를 정의하고
 * 객체를 return 하도록 한다.
 * method에 @Bean Annotation을 붙인다.
 * 
 * 생성한 클래스를 WebConfig에 등록해준다.
 */

@Configuration
public class FileUpConfig {

	@Bean
	public MultipartResolver multipartResolver() {

		MultipartResolver mr = new CommonsMultipartResolver();

		((CommonsMultipartResolver) mr).setMaxUploadSize(30000000);
		((CommonsMultipartResolver) mr).setMaxUploadSizePerFile(3000000);

		return mr;
	}

	@Bean(name = "winPath")
	public String winPath() {
		return "c:/bizwork/workspace/upload";
	}
	
	@Bean(name = "linuxPath")
	public String linuxPath() {
		return "/Users/callor/Documents/workspace/upload";
	}

}
