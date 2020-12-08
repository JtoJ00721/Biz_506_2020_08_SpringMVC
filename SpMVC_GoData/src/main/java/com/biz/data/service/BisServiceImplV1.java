package com.biz.data.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpMethod;
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
