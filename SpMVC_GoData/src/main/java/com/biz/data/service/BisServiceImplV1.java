package com.biz.data.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.biz.data.config.DataGoConfig;
import com.biz.data.model.StationList;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BisServiceImplV1 {

	public StationList getStation() {

		// 공공DB로 부터 데이터를 수집하는 용도의 클래스
		RestTemplate restTemp = new RestTemplate();
		ResponseEntity<StationList> resList = null;

		String apiURI = DataGoConfig.BIS_URL;
		apiURI += "?serviceKey" + DataGoConfig.SERVICE_KEY;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType("application", "json", Charset.forName("UTF-8"))));
		headers.add("Content-Type", "application/json");
		HttpEntity<String> entity = new HttpEntity<>(null, headers);

		try {
			URI bisURI = new URI(DataGoConfig.BIS_URL);
			resList = restTemp.exchange(bisURI, HttpMethod.GET, null, StationList.class);
			log.debug(resList.getBody().toString());
			return resList.getBody();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;

	}

}
