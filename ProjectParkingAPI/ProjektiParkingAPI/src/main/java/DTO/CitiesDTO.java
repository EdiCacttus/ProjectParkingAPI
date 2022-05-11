package DTO;

import java.util.UUID;

public class CitiesDTO {

    private UUID id;
    private String zone;
    private int nrmakinave;

    public CitiesDTO(UUID id, String zone, int nrmakinave, UUID cityRequestId) {
        this.id = id;
        this.zone = zone;
        this.nrmakinave = nrmakinave;
    }

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
