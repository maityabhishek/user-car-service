package com.usercar.service;

public interface SimulationEndKeeper {
    void endSimulation(String simulationId);

    boolean isSimulationEndRequested(String simulationId);
}
