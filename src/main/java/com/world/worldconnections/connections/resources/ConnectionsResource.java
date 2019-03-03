package com.world.worldconnections.connections.resources;

import com.world.worldconnections.connections.model.ConnectionsResponse;
import com.world.worldconnections.connections.service.ConnectionsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * @author anupkumarpuppala on 2019-02-16
 */

@RestController
@RequestMapping("/connections")
public class ConnectionsResource {


    private final ConnectionsServiceImpl service;

    @Autowired
    public ConnectionsResource(final ConnectionsServiceImpl connectionsService) {
        this.service = connectionsService;
    }

    @PostMapping("/isConnected")
    public ResponseEntity<String> isConnected(@RequestParam String origin,@RequestParam String destination) {

        if (service.isConnected(origin,destination)) {
            return new ResponseEntity<>("yes", HttpStatus.OK);
        }
        return new ResponseEntity<>("no", HttpStatus.OK);
    }


    @PostMapping("/addCities")
    public ResponseEntity<String> addCities(@RequestParam String origin,@RequestParam String destination) {

        if (service.isConnected(origin,destination)) return new ResponseEntity<>("Already exists", HttpStatus.BAD_REQUEST);

        if(service.addCities(origin, destination)) return new ResponseEntity<>("Cities added", HttpStatus.OK);

        return new ResponseEntity<>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/getForecast")
    public ResponseEntity<ConnectionsResponse> getWeatherUpdates(@RequestParam int zip) {

        ConnectionsResponse response = service.getTemperatures(zip);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
