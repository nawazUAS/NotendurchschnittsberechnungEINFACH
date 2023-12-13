package edu.fra.uas.NotendurchschnittsberechnungEINFACH.config;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.fra.uas.NotendurchschnittsberechnungEINFACH.model.Fach;
import edu.fra.uas.NotendurchschnittsberechnungEINFACH.service.FachService;
import jakarta.annotation.PostConstruct;

@Component
public class InitializeDB {
    private final Logger log = org.slf4j.LoggerFactory.getLogger(InitializeDB.class);
    
    
    @Autowired
    FachService fachService;



@PostConstruct
public void init(){
    log.debug("### Initialize Data ###");

    log.debug("Create 1. Fach");
    Fach fach1 = new Fach();
    fach1.setFachBezeichnung("Mathe");
    fach1.setNote(3); 
    fachService.createFach(fach1.getFachBezeichnung(), fach1.getNote());

    log.debug("Create 2. Fach");
    Fach fach2 = new Fach();
    fach2.setFachBezeichnung("Englisch");
    fach2.setNote(2);
    fachService.createFach(fach2.getFachBezeichnung(), fach2.getNote());


  


}

}
