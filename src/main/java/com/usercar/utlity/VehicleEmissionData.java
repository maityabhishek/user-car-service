package com.usercar.utlity;

import com.microsoft.azure.sdk.iot.device.Message;
import java.util.Random;

public class VehicleEmissionData implements CarDataGenerator {
	

	@Override
	public Message generateData(String simulationId) {
		Random r = new Random();
		int low = 800;
		int high = 1200;
		int co2level = r.nextInt(high-low) + low;
		
		Random r1 = new Random();
		int low1 = 45;
		int high1 = 70;
		int nolevel = r1.nextInt(high1-low1) + low1;
				
		String msgStr = "{\"co2level\":"+ co2level +",\"usercase\":\"VehicleEmission\"" +",\"nolevel\":"+ nolevel + ",\"vin\":"+ (100)+"}";
		Message msg = new Message(msgStr);
		System.out.println(msgStr);
		return msg;
	}

}
