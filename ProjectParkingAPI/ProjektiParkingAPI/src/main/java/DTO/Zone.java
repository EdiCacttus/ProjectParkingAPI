package DTO;

import java.util.UUID;

public class Zone {

    private UUID id;
    private String name;
    private char zones;


    public Zone(UUID id, String name, char zones) {
        this.id = id;
        this.name = name;
        this.zones = zones;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getZones() {
        return zones;
    }

    public void setZones(char zones) {
        this.zones = zones;
    }
}
