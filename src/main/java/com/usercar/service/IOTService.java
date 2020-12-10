package com.usercar.service;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usercar.service.IOTSender;
import com.usercar.utlity.VehicleAllData;
import com.usercar.utlity.VehicleConditionData;
import com.usercar.utlity.VehicleEmissionData;
import com.usercar.utlity.VehicleTripData;
import com.microsoft.azure.sdk.iot.device.DeviceClient;
import com.microsoft.azure.sdk.iot.device.IotHubClientProtocol;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IOTService {
	
	@Autowired
	IOTSender iotSender;
	
	public void connect(int datamodelno) {
		log.info("Starting...");
		log.info("Beginning setup.");
		int numRequests=200;
		String pathToCertificate = null;
		String connString ="HostName=iot-eventhub.azure-devices.net;DeviceId=dev1;SharedAccessKey=6o57ILHnYxDv1xYETcg2QrinmS52ppq4Y9n4kKoSAZI=";
		IotHubClientProtocol protocol= IotHubClientProtocol.HTTPS;
		String protocolStr = "https";
		log.info("Successfully read input parameters.");
		log.info("Using communication protocol {} .",protocol.name());
		DeviceClient client = null;
		try {
			client = new DeviceClient(connString, protocol);
		} catch (IllegalArgumentException e2) {
			
			e2.printStackTrace();
		} catch (URISyntaxException e2) {
		
			e2.printStackTrace();
		}
		log.info("Successfully created an IoT Hub client.");
		switch(datamodelno)
		{
		case 1:
			iotSender.sendMessageToIOTHUB(numRequests, client,new VehicleTripData());
			break;
		case 2:
			iotSender.sendMessageToIOTHUB(numRequests, client,new VehicleEmissionData());
			break;
		case 3:
			iotSender.sendMessageToIOTHUB(numRequests, client,new VehicleConditionData());
			break;
		case 4:
			iotSender.sendMessageToIOTHUB(numRequests, client,new VehicleAllData());
			break;
		}
		
	}

}
