package models;

import java.util.Date;

public class Incident {
    String ref,status;
    Date time;

    public String getIdmembre() {
        return idmembre;
    }

    String idmembre;
    public String getRef() {
        return ref;
    }

    public Date getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public Incident(String ref, String status, Date time){
        this.ref=ref;
        this.status=status;
        this.time=time;
    }

}
