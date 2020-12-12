package com.usercar.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SimulationEndKeeperImpl implements SimulationEndKeeper {

    private Map<String, Boolean> simulationMap = new ConcurrentHashMap();

    @Override
    public void endSimulation(String simulationId) {
        simulationMap.put(simulationId, true);
    }

    @Override
    public boolean isSimulationEndRequested(String simulationId) {
        return simulationMap.containsKey(simulationId);
    }
}
