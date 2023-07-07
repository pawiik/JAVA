package pl.edu.pwr.pdabrowski.lab09.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@javax.xml.bind.annotation.XmlRootElement(name = "bip.poznan.pl")
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
public class Bip {
    @javax.xml.bind.annotation.XmlElement(name = "data")
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public Bip(){

    }
}
