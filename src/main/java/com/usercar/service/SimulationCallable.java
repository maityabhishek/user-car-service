package com.usercar.service;

import com.microsoft.azure.sdk.iot.device.DeviceClient;
import com.usercar.utlity.VehicleAllData;
import com.usercar.utlity.VehicleConditionData;
import com.usercar.utlity.VehicleEmissionData;
import com.usercar.utlity.VehicleTripData;
import org.apache.qpid.proton.reactor.impl.IO;

import java.util.concurrent.Callable;

public class SimulationCallable implements Runnable {
    private int datamodelno;
    private int numRequests;
    private DeviceClient client;
    private String simulationId;
    private IOTSender iotSender;

    public SimulationCallable(int datamodelno,
                              int numRequests,
                              DeviceClient client,
                              String simulationId,
                              IOTSender iotSender) {
        this.datamodelno = datamodelno;
        this.numRequests = numRequests;
        this.client = client;
        this.simulationId = simulationId;
        this.iotSender = iotSender;
    }

    @Override
    public void run() {
        switch (datamodelno) {
            case 1:
                iotSender.sendMessageToIOTHUB(numRequests, client, new VehicleTripData(), simulationId);
                break;
            case 2:
                iotSender.sendMessageToIOTHUB(numRequests, client, new VehicleEmissionData(), simulationId);
                break;
            case 3:
                iotSender.sendMessageToIOTHUB(numRequests, client, new VehicleConditionData(), simulationId);
                break;
            case 4:
                iotSender.sendMessageToIOTHUB(numRequests, client, new VehicleAllData(), simulationId);
                break;
        }
    }
}
