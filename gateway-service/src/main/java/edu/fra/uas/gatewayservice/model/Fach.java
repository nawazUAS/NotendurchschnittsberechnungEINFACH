package edu.fra.uas.gatewayservice.model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fach  implements java.io.Serializable{

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



@Override
public boolean equals(Object object) {
    if (object == null) 
    return false;
if (object == this) 
    return true;
if (this.getClass() != object.getClass()) 
    return false;
if (this.fachBezeichnung == null){
    if (((Fach)object).fachBezeichnung!=null)
    return false;
} else if(!this.fachBezeichnung.equals(((Fach)object).fachBezeichnung)){
    return false;
}
return true;

}

@Override
public int hashCode() {
    int hash = 7;
    hash = 31 * hash + (this.fachBezeichnung != null ? this.fachBezeichnung.hashCode() : 0);

    return hash;
}
}
