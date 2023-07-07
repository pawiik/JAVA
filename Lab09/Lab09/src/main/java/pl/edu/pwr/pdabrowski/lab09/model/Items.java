package pl.edu.pwr.pdabrowski.lab09.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@javax.xml.bind.annotation.XmlRootElement(name = "items")
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
public class Items {
    @javax.xml.bind.annotation.XmlElement(name = "karta_informacyjna")
    private List<KartaInformacyjna> kartyInformacyjne;

    public List<KartaInformacyjna> getKartyInformacyjne() {
        return kartyInformacyjne;
    }

    public void setKartyInformacyjne(List<KartaInformacyjna> kartyInformacyjne) {
        this.kartyInformacyjne = kartyInformacyjne;
    }
}
