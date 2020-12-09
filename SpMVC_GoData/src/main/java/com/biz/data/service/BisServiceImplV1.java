package com.biz.data.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.biz.data.config.DataGoConfig;
import com.biz.data.model.BisStationData;
import com.biz.data.model.BisStationList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BisServiceImplV1 implements BisService {

	public List<BisStationData> getStation() {

		// 공공DB로부터 데이터를 수집하는 용도의 클래스
		RestTemplate restTemp = new RestTemplate();
		ResponseEntity<BisStationList> resList = null;

		String apiURI = DataGoConfig.BIS_URL;
		apiURI += "?ServiceKey=" + DataGoConfig.SERVICE_KEY;

// 		springframework.http 패키지의 클래스
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections
				.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity 
			= new HttpEntity<String>("parameters",headers);

		try {

			URI bisURI = new URI(apiURI);
			resList = restTemp.exchange(bisURI, HttpMethod.GET, entity, BisStationList.class);
			// log.debug(resList.getBody().STATION_LIST.toString());
			return resList.getBody().STATION_LIST;

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getString() {

		// 공공DB로부터 데이터를 수집하는 용도의 클래스
		RestTemplate restTemp = new RestTemplate();
		ResponseEntity<String> resString = null;

		String apiURI = DataGoConfig.BIS_URL;
		apiURI += "?serviceKey=" + DataGoConfig.SERVICE_KEY;

		try {
			URI bisURI = new URI(apiURI);
			resString = restTemp.exchange(bisURI, HttpMethod.GET, null, String.class);

			log.debug(resString.getBody());
			// return resList.getBody();
			return resString.getBody();

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}