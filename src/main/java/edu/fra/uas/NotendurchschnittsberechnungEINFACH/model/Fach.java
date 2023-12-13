package edu.fra.uas.NotendurchschnittsberechnungEINFACH.model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fach implements java.io.Serializable{

    private static final Logger log = LoggerFactory.getLogger(Fach.class);
    private long id;
    private String fachBezeichnung;
    private int note;

    public Fach(){
        log.debug("Fach created without values");
    }

    public Fach(long id, String fachBezeichnung, int note){
        this.fachBezeichnung=fachBezeichnung;
        this.note=note;
        this.id=id; 
        log.debug("Fach created:" + fachBezeichnung);  
    }

    public void setFachBezeichnung(String fachBezeichnung) {
        this.fachBezeichnung = fachBezeichnung;
    }
    public String getFachBezeichnung() {
        return fachBezeichnung;
    }
    public void setNote(int note) {
        this.note = note;
    }
    public int getNote() {
        return note;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
@Override
public String toString() {
    // TODO Auto-generated method stub
    return "Fachbezeichnung: "+getFachBezeichnung()+" ID: "+getId();
}
    
}
