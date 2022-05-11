package Model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
public class Cities {

    @Id
    private UUID id;
    private String zone;
    private int nrmakinave;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public int getNrmakinave() {
        return nrmakinave;
    }

    public void setNrmakinave(int nrmakinave) {
        this.nrmakinave = nrmakinave;
    }


}
