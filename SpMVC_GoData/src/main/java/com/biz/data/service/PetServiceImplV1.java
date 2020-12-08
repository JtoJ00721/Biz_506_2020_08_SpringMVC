package com.biz.data.service;

import java.lang.reflect.ParameterizedType;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.biz.data.config.DataGoConfig;
import com.biz.data.model.GoPetVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PetServiceImplV1 {

	public List<GoPetVO> getHost() {

		String queryString = DataGoConfig.PET_URL;
		queryString += "/getDongMulHospital";
		queryString += "?serviceKey=" + DataGoConfig.SERVICE_KEY;
		queryString += "&pageNo=1";
		queryString += "&numofRows=100";
		queryString += "dongName=";

		// spring.http 패키지의 클래스
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemp = new RestTemplate();
		URI restURI = null;

		ResponseEntity<List<GoPetVO>> result = null;
		
		// GoPetVO가 담긴 List 타입으로 RestTemplate의 데이터를 받고자 할때
		// List는 클래스가 아닌 인터페이스이기 때문에 RestTemplate에서
		// 데이터를 생성하지 못한다.
		// 인터페이스를 RestTemplate의 데이터 타입으로 사용하기 위해서
		// Parameter... 클래스를 이용하여 변환을 시켜준다.
		ParameterizedTypeReference<List<GoPetVO>> paramType = new ParameterizedTypeReference<List<GoPetVO>>() {
			
		};

		try {
			restURI = new URI(queryString);
			result = restTemp.exchange(restURI, HttpMethod.GET, entity, paramType);
			List<GoPetVO> petList = result.getBody();
			
			log.debug(petList.toString());
			return petList;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return null;
	}
}
