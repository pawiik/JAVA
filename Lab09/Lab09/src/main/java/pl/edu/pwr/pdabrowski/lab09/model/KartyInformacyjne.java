package pl.edu.pwr.pdabrowski.lab09.model;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@javax.xml.bind.annotation.XmlRootElement(name = "karty_informacyjne")
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
public class KartyInformacyjne {
    @javax.xml.bind.annotation.XmlElement(name = "items")
    private Items items;
    @javax.xml.bind.annotation.XmlElement(name = "start")

    private int start;
    @javax.xml.bind.annotation.XmlElement(name = "stop")

    private int stop;
    @javax.xml.bind.annotation.XmlElement(name = "size")

    private int size;

    public KartyInformacyjne(){

    }
    public void setItems(Items items) {
        this.items = items;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setStop(int stop) {
        this.stop = stop;
    }

    public int getSize() {
        return size;
    }

    public int getStart() {
        return start;
    }

    public int getStop() {
        return stop;
    }

    public Items getItems() {
        return items;
    }
}