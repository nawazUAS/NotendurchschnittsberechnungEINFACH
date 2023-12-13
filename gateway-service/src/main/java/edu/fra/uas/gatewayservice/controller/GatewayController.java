package edu.fra.uas.gatewayservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.fra.uas.gatewayservice.FachService;
import edu.fra.uas.gatewayservice.model.Fach;

@RestController
public class GatewayController {
    private final Logger log = org.slf4j.LoggerFactory.getLogger(GatewayController.class);

    @Autowired
    FachService fachService;





@GetMapping(value = "/faecher",
            produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public ResponseEntity<List<Fach>> list(){
    log.debug("list() is called");
 ResponseEntity<?> response = fachService.getAllFaecher();

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NO_CONTENT)) {
            return new ResponseEntity<>("not found", HttpStatus.NO_CONTENT);
        }        

        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
       }








}
