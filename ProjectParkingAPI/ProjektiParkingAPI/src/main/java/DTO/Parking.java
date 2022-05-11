package DTO;

public class Parking {


    private int parking_zone_id;
    private int parking_slot_count;
    private boolean ishandycap;


    public Parking(int parking_zone_id, int parking_slot_count, boolean ishandycap) {
        this.parking_zone_id = parking_zone_id;
        this.parking_slot_count = parking_slot_count;
        this.ishandycap = ishandycap;
    }


    public int getParking_zone_id() {
        return parking_zone_id;
    }


    public void setParking_zone_id(int parking_zone_id) {
        this.parking_zone_id = parking_zone_id;
    }

    public int getParking_slot_count() {
        return parking_slot_count;
    }

    public void setParking_slot_count(int parking_slot_count) {
        this.parking_slot_count = parking_slot_count;
    }

    public boolean isIshandycap() {
        return ishandycap;
    }

    public void setIshandycap(boolean ishandycap) {
        this.ishandycap = ishandycap;
    }
}
