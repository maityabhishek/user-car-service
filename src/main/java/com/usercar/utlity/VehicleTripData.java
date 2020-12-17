package com.usercar.utlity;

import java.util.Date;

import com.microsoft.azure.sdk.iot.device.Message;

public class VehicleTripData implements CarDataGenerator {
	private static int kms=0;
	private static double fuel=60.0;
	public static void main(String args[])
	{
		(new VehicleTripData()).generateData("123");
	}
	@Override
	public Message generateData(String simulationId) {
		String msgStr = "{\"speed\":"+ ((int)(1000*Math.random()%180))+",\"simulationid\":\""+simulationId+"\",\"usercase\":\"VehicleTrip\""+",\"tripid\":"+ (1) +",\"longitude\":"+ ((int)(100*Math.random()))+",\"latitude\":"+ ((int)(100*Math.random()))+",\"vin\":"+ (100)+",\"fuel\":"+ (fuel)+",\"odometer\":"+ (kms++)+",\"timestamp\":"+ (new Date().getTime())+",\"rpm\":"+ ((int)(10000*Math.random()%2500))+"}";
		fuel=fuel-0.06;
		Message msg = new Message(msgStr);
		System.out.println(msgStr);
		return msg;
	}

}

