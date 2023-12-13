package edu.fra.uas.NotendurchschnittsberechnungEINFACH.controller;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody; //DAS ist das richtige einfach verzweifelt junge
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.fra.uas.NotendurchschnittsberechnungEINFACH.model.Fach;
import edu.fra.uas.NotendurchschnittsberechnungEINFACH.service.FachService;





@RestController
public class FachController {
    private final Logger log = org.slf4j.LoggerFactory.getLogger(FachController.class);

@Autowired
FachService fachService;


@GetMapping(value = "/faecher",
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


@GetMapping(value = "/facher/durchschnitt",
            produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public ResponseEntity<Double>  berechneDurchschnitt(){
    log.debug("berechneDurchschnitt() is called");
   double durchschnitt= fachService.berechneDurchschnitt();
   return new ResponseEntity<Double>(durchschnitt, HttpStatus.OK);


}


    @PostMapping(value = "/fach", 
                 consumes = MediaType.APPLICATION_JSON_VALUE, 
                 produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> add(@RequestBody Fach fach){
        log.debug("add() is called");
        String detail=null;

        if(fach == null){
            detail="fach must not be null";
        }
        else if(fach.getFachBezeichnung() == null){
            detail="Fachbezeichnung must not be null";
        }
        else if(fach.getFachBezeichnung().isEmpty()){
            detail="Fachbezeichnung must not be empty";}

        else if(fach.getNote()>7||fach.getNote()<1){
            detail="Note must be in range between 1 and 6";
        }


if (detail != null) {
            ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.UNPROCESSABLE_ENTITY, detail); 
            pd.setInstance(URI.create("/faecher"));
            pd.setTitle("JSON Object Error");
            return ResponseEntity.unprocessableEntity().body(pd);
        }

        fach = fachService.createFach(fach);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/fach" + fach.getId()));
        return new ResponseEntity<Fach>(fach, headers, HttpStatus.CREATED);
    }


  @DeleteMapping(value = "/fach/{id}",
                   produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable("id") Long faecherId){
        log.debug("delete() is called");
        Fach fach = fachService.deleteFach(faecherId);
        if(fach==null){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<Fach>(fach,HttpStatus.OK);
    }
    





     @PutMapping(value = "/fach/{id}", 
                 consumes = MediaType.APPLICATION_JSON_VALUE, 
                 produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Fach neuesfach, @PathVariable("id") Long fachId){
        log.debug("update() is called");
        Fach fach = fachService.getFachById(fachId);
        if (fach == null) {
            return new ResponseEntity<Fach>(HttpStatus.NOT_FOUND);
        }

        String detail=null;

        if(neuesfach== null){
            detail="fach must not be null";
        }
        else if(neuesfach.getFachBezeichnung() == null){
            detail="Fachbezeichnung must not be null";
        }
        else if(neuesfach.getFachBezeichnung().isEmpty()){
            detail="Fachbezeichnung must not be empty";}

        else if(neuesfach.getNote()>7||neuesfach.getNote()<1){
            detail="Note must be in range between 1 and 6";
        }


if (detail != null) {
            ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.UNPROCESSABLE_ENTITY, detail); 
            pd.setInstance(URI.create("/fach"));
            pd.setTitle("JSON Object Error");
            return ResponseEntity.unprocessableEntity().body(pd);
        }

        fach.setFachBezeichnung(neuesfach.getFachBezeichnung());
        fach.setNote(neuesfach.getNote());
        fach = fachService.updateFach(fach);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/faach" + fach.getId()));
        return new ResponseEntity<Fach>(fach, headers, HttpStatus.CREATED);
    }




     @PutMapping(value = "/fach/{id}/note", 
                 consumes = MediaType.APPLICATION_JSON_VALUE, 
                 produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> updateNote(@RequestBody int note, @PathVariable("id") Long fachId){
        log.debug("updateNote() is called");
        Fach fach = fachService.getFachById(fachId);
        if (fach == null) {
            return new ResponseEntity<Fach>(HttpStatus.NOT_FOUND);
        }

        String detail=null;

        if(note >6||note<1){
            detail="fach must be between 1 and 6";
        }
        else if(note == 0){
            detail="Fachbezeichnung must not be null";
        }


if (detail != null) {
            ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.UNPROCESSABLE_ENTITY, detail); 
            pd.setInstance(URI.create("/fach"));
            pd.setTitle("JSON Object Error");
            return ResponseEntity.unprocessableEntity().body(pd);
        }

      //  fach.setNote(note);
        fach = fachService.updateNote(fachId, note);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/fach" + fach.getId()));
        return new ResponseEntity<Fach>(fach, headers, HttpStatus.CREATED);
    }




    
    

}
