package com.usercar.utlity;

import org.springframework.stereotype.Service;

import com.microsoft.azure.sdk.iot.device.Message;

@Service
public interface CarDataGenerator {
	public Message generateData();
}
