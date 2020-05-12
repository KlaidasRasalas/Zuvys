package com.example.zuvys;

public class Zuvis {

    String pavadinimas,aprasymas,zuviesID;

    public Zuvis() {}

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public void setAprasymas(String aprasymas) {
        this.aprasymas = aprasymas;
    }

    public String getZuviesID() {
        return zuviesID;
    }

    public Zuvis(String pavadinimas, String aprasymas    ) {

        this.pavadinimas = pavadinimas;
        this.aprasymas = aprasymas;

    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public String getAprasymas() {
        return aprasymas;
    }

    public void setZuviesID(String zuviesID) {
        this.zuviesID = zuviesID;
    }

    public String toString() {
        return pavadinimas;
    }
}
