package com.usercar.utlity;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.microsoft.azure.sdk.iot.device.Message;

@Component
public class VehicleAllData implements CarDataGenerator {

	
	@Override
	public Message generateData() {
		RestTemplate res=new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
		String msgStr= res.exchange("http://localhost:8080/infoall", HttpMethod.GET, entity, String.class).getBody();
		Message msg = new Message(msgStr);
		System.out.println(msgStr);
		return msg;
	}

}