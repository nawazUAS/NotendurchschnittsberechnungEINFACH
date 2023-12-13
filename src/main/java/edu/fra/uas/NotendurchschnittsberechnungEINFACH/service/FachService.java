package edu.fra.uas.NotendurchschnittsberechnungEINFACH.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fra.uas.NotendurchschnittsberechnungEINFACH.model.Fach;
import edu.fra.uas.NotendurchschnittsberechnungEINFACH.repository.FachRepository;


@Service
public class FachService {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(FachService.class);

    @Autowired
    FachRepository fachRepository;

    private long nextId=1;

    public Iterable<Fach> getAllFaecher(){
        log.debug("getAllFaecher");
        return fachRepository.values();
    }

    public Fach createFach(String fachBezeichnung, int note){
        Fach neuesFach = new Fach();
        neuesFach.setFachBezeichnung(fachBezeichnung);
        neuesFach.setNote(note);
        neuesFach.setId(nextId++);
        log.debug(fachBezeichnung);
        fachRepository.put(neuesFach.getId(), neuesFach);
    return neuesFach;
    }

    public Fach getFachById(long id){
        log.debug("getFach: "+id);
    return fachRepository.get(id);
    }

    public Fach updateFach(Fach fach){
        log.debug("updateFach "+ fach.getFachBezeichnung());

        fachRepository.put(fach.getId(), fach);
        return fachRepository.get(fach.getId());
    }

    public double berechneDurchschnitt(){
    ArrayList<Fach> faecher= new ArrayList<>();

    Iterable<Fach> allefaecher = getAllFaecher();
    for(Fach fach: allefaecher){
        faecher.add(fach);
    }

    if (faecher.isEmpty()) {
        return 0.0;
    }

    int summe=0;
    for (Fach fach : faecher) {
        summe += fach.getNote();
    }

    return (double) summe / faecher.size();
}



    

}
