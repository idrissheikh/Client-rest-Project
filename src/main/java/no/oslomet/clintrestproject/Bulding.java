package no.oslomet.clintrestproject;

import lombok.Data;

@Data
public class Bulding {
    private  long id;
    private String name;
    private  String address;

    public Bulding(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
public Bulding(){

}

}
