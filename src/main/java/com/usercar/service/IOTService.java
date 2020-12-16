package com.usercar.service;

import java.net.URISyntaxException;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.RequiredArgsConstructor;
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

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Slf4j
@Service
public class IOTService {

	private final IOTSender iotSender;
	private final SimulationEndKeeper simulationEndKeeper;
	private ExecutorService executorService = Executors.newFixedThreadPool(10);

	public String connect(int datamodelno) {
		log.info("Starting...");
		log.info("Beginning setup.");
		int numRequests=200;
		String pathToCertificate = null;
		String connString = "HostName=cartelemetryiot.azure-devices.net;DeviceId=cartelemetryiotdevice;SharedAccessKey=z+6jIVZIh6M0ai0i8itVeolXQ6qSdOndtUMNcEagbPc=";
		//String connString ="HostName=iot-eventhub.azure-devices.net;DeviceId=dev1;SharedAccessKey=6o57ILHnYxDv1xYETcg2QrinmS52ppq4Y9n4kKoSAZI=";
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
		String simulationId = UUID.randomUUID().toString();
		runSimulation(datamodelno, numRequests, client, simulationId);

		return simulationId;
	}

	public Boolean stopSimulation(String simulationId) {
		simulationEndKeeper.endSimulation(simulationId);
		return true;
	}

	private void runSimulation(int datamodelno, int numRequests, DeviceClient client, String simulationId) {
		executorService.submit(new SimulationCallable(datamodelno, numRequests, client, simulationId, iotSender));
	}


}
