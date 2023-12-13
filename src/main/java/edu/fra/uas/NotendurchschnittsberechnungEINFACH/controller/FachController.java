package edu.fra.uas.NotendurchschnittsberechnungEINFACH.controller;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.fra.uas.NotendurchschnittsberechnungEINFACH.model.Fach;
import edu.fra.uas.NotendurchschnittsberechnungEINFACH.service.FachService;





@RestController
public class FachController {
    private final Logger log = org.slf4j.LoggerFactory.getLogger(FachController.class);

@Autowired
FachService fachService;


@GetMapping(value = "/fach",
            produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public ResponseEntity<List<Fach>> list(){
    log.debug("list() is called");
    Iterable<Fach> fachiter = fachService.getAllFaecher();
    List<Fach> faecher = new ArrayList<>();
//e
    for(Fach fach: fachiter){
        faecher.add(fach);
    }
    if(faecher.isEmpty()){
        return ResponseEntity.noContent().build();
       }
    

    
    return new ResponseEntity<List<Fach>>(faecher, HttpStatus.OK);

}


@GetMapping(value = "/fach/durchschnitt",
            produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public ResponseEntity<Double>  berechneDurchschnitt(){
    log.debug("berechneDurchschnitt() is called");
   double durchschnitt= fachService.berechneDurchschnitt();
   return new ResponseEntity<Double>(durchschnitt, HttpStatus.OK);


}






    
}
