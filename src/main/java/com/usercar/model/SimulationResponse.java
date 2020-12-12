package com.usercar.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SimulationResponse {
    String simulationId;
    LocalDateTime simulationStartDate;
}
