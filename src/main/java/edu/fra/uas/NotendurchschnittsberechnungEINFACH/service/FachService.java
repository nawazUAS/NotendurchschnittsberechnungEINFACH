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

    public Fach createFach(Fach fach){
        fach.setId(nextId++);
        log.debug("createFach: "+fach.getId());
        fachRepository.put(fach.getId(), fach);
        return fachRepository.get(fach.getId());
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

    public Fach deleteFach(long id){
        log.debug("deleteFach: "+ getFachById(id).getFachBezeichnung());

        return fachRepository.remove(id);
    }


    public Fach updateNote(long id, int neueNote){
    Fach fach = getFachById(id);
    fach.setNote(neueNote);
    return fach;
    }

    public double berechneDurchschnitt(){
    ArrayList<Fach> faecher= new ArrayList<>();

    Iterable<Fach> allefaecher = getAllFaecher();
    for(Fach fach: allefaecher){
        faecher.add(fach);
    }

    if (faecher.isEmpty()) {
        log.warn("faecher is empty!");
        return 0.0;
    }

    double summe=0;
    for (Fach fach : faecher) {
        if(!(fach.getNote()>6 || fach.getNote()<1)){
        summe += fach.getNote();}
    }

    return summe / faecher.size();
}



    

}
