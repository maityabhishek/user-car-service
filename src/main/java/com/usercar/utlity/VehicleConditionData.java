package com.usercar.utlity;

import com.microsoft.azure.sdk.iot.device.Message;
import java.util.Random;

public class VehicleConditionData implements CarDataGenerator {

	
	@Override
	public Message generateData(String simulationId)
	{
		Random r = new Random();
		int low = 80;
		int high = 120;
		int coolanttemp = r.nextInt(high-low) + low;		
		String msgStr = "{\"coolanttemp\":" + coolanttemp +",\"usercase\":\"VehicleCondition\"" +",\"vin\":"+ (100)+",\"engineload\":" + ((int)(100*Math.random()%100)) + "}";
		Message msg = new Message(msgStr);
		System.out.println(msgStr);
		return msg;
		
	}

}
