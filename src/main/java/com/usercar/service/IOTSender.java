package com.usercar.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.usercar.utlity.CarDataGenerator;
import com.microsoft.azure.sdk.iot.device.DeviceClient;
import com.microsoft.azure.sdk.iot.device.IotHubConnectionStatusChangeCallback;
import com.microsoft.azure.sdk.iot.device.IotHubConnectionStatusChangeReason;
import com.microsoft.azure.sdk.iot.device.IotHubEventCallback;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.transport.IotHubConnectionStatus;

@RequiredArgsConstructor
@Service
@Slf4j
public class IOTSender {

	private static final int MAX_SIMULATIONS = 10000;
	private static final int D2C_MESSAGE_TIMEOUT = 200000;   // 2 seconds
	private static List failedMessageListOnClose = new ArrayList(); // List of messages that failed on close

	private final SimulationEndKeeper simulationEndKeeper;

	public void sendMessageToIOTHUB(int numRequests ,DeviceClient client,CarDataGenerator datagenerator, String simulationId) {

	// Set your token expiry time limit here
			long time = 240000;
			// client.setOption("SetSASTokenExpiryTime", time);
			client.registerConnectionStatusChangeCallback(new IotHubConnectionStatusChangeCallbackLogger(), new Object());
			try {
				client.open();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out.println("Opened connection to IoT Hub.");

			System.out.println("Beginning to receive messages...");

			System.out.println("Sending the following event messages: ");

			System.out.println("Updated token expiry time to " + time);

			String deviceId = "giciotdevice";
			double temperature = 0.0;
			double humidity = 0.0;
			int i = 0;
			// for (int i = 0; i < numRequests; ++i) {
			while (!simulationEndKeeper.isSimulationEndRequested(simulationId) && MAX_SIMULATIONS > i) {
				try {
					Message msg = datagenerator.generateData(simulationId);
					msg.setContentTypeFinal("application/json");
					msg.setProperty("deviceid", deviceId);
					msg.setProperty("messageid", "" + i++);
					msg.setMessageId(java.util.UUID.randomUUID().toString());
					msg.setExpiryTime(D2C_MESSAGE_TIMEOUT);

					EventCallback eventCallback = new EventCallback();
					client.sendEventAsync(msg, eventCallback, msg);

					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace(); // Trace the exception
				}
			}

			log.info("Number of messages sent to DeviceClient - " + i);
			System.out.println("Wait for " + D2C_MESSAGE_TIMEOUT / 1000 + " second(s) for response from the IoT Hub...");

			// Wait for IoT Hub to respond.
			try {
				Thread.sleep(D2C_MESSAGE_TIMEOUT);
			}

			catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

			protected static class EventCallback implements IotHubEventCallback {
				public void execute(IotHubStatusCode status, Object context) {
					Message msg = (Message) context;
					System.out.println("IoT Hub responded to message " + msg.getMessageId() + " with status " + status.name());
					if (status == IotHubStatusCode.MESSAGE_CANCELLED_ONCLOSE) {
						failedMessageListOnClose.add(msg.getMessageId());
					}
				}
			}
			protected static class IotHubConnectionStatusChangeCallbackLogger implements IotHubConnectionStatusChangeCallback {
				@Override
				public void execute(IotHubConnectionStatus status, IotHubConnectionStatusChangeReason statusChangeReason,
						Throwable throwable, Object callbackContext) {
					System.out.println();
					System.out.println("CONNECTION STATUS UPDATE: " + status);
					System.out.println("CONNECTION STATUS REASON: " + statusChangeReason);
					System.out.println("CONNECTION STATUS THROWABLE: " + (throwable == null ? "null" : throwable.getMessage()));
					System.out.println();

					if (throwable != null) {
						throwable.printStackTrace();
					}

					if (status == IotHubConnectionStatus.DISCONNECTED) {
						// connection was lost, and is not being re-established. Look at provided
						// exception for
						// how to resolve this issue. Cannot send messages until this issue is resolved,
						// and you manually
						// re-open the device client
					} else if (status == IotHubConnectionStatus.DISCONNECTED_RETRYING) {
						// connection was lost, but is being re-established. Can still send messages,
						// but they won't
						// be sent until the connection is re-established
					} else if (status == IotHubConnectionStatus.CONNECTED) {
						// Connection was successfully re-established. Can send messages.
					}
				}
			}
	}
