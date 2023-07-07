package pl.edu.pwr.pdabrowski.lab09.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@javax.xml.bind.annotation.XmlRootElement(name = "data")
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
public class Data {
    @javax.xml.bind.annotation.XmlElement(name = "karty_informacyjne")

    private KartyInformacyjne kartyInformacyjne;

    public Data(){

    }

    public void setKartyInformacyjne(KartyInformacyjne kartyInformacyjne) {
        this.kartyInformacyjne = kartyInformacyjne;
    }

    public KartyInformacyjne getKartyInformacyjne() {
        return kartyInformacyjne;
    }
}
