package com.usercar.controller;

import com.usercar.model.SimulationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.usercar.service.IOTService;

@RestController
@CrossOrigin(origins = "*")
public class IotController {

    @Autowired
    IOTService iotService;

    @RequestMapping(path = "/senddata/trip/{startPoint}/{endPoint}", method = RequestMethod.GET)
    public ResponseEntity<SimulationResponse> sendTripData(@PathVariable("startPoint") String startPoint,
                                                           @PathVariable("startPoint") String endPoint) {
        SimulationResponse response = new SimulationResponse();
        try {
            response.setSimulationId(iotService.connect(1));
        } catch (Exception e) {
            new ResponseEntity<>("Data Sending Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @RequestMapping(path = "/senddata/vcondition", method = RequestMethod.GET)
    public ResponseEntity<?> sendVehicleData() {
        try {

            iotService.connect(3);
        } catch (Exception e) {
            new ResponseEntity<>("Data Sending Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Data Sent to IOT HUB", HttpStatus.OK);
    }

    @RequestMapping(path = "/senddata/econdition", method = RequestMethod.GET)
    public ResponseEntity<?> sendEmissionData() {
        try {

            iotService.connect(2);
        } catch (Exception e) {
            new ResponseEntity<>("Data Sending Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Data Sent to IOT HUB", HttpStatus.OK);
    }

    @RequestMapping(path = "/senddata/all", method = RequestMethod.GET)
    public ResponseEntity<?> sendAllData() {
        try {

            iotService.connect(4);
        } catch (Exception e) {
            return new ResponseEntity<>("Data Sending Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Data Sent to IOT HUB", HttpStatus.OK);
    }

    @GetMapping(path = "/simulation/stop/{simulationId}")
    public ResponseEntity<Boolean> stopSimulation(@PathVariable("simulationId") String simulationId) {
        iotService.stopSimulation(simulationId);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
