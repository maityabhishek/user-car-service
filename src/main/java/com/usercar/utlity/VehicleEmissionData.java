package com.usercar.utlity;

import com.microsoft.azure.sdk.iot.device.Message;

public class VehicleEmissionData implements CarDataGenerator {
	

	@Override
	public Message generateData(String simulationId) {
		String msgStr = "{\"co2level\":"+ ((int)(1500*Math.random())) +",\"usercase\":\"VehicleEmission\"" +",\"nolevel\":"+ ((int)(80*Math.random()))+ ",\"vin\":"+ ((int)(10000*Math.random()))+"}";
		Message msg = new Message(msgStr);
		System.out.println(msgStr);
		return msg;
	}

}
