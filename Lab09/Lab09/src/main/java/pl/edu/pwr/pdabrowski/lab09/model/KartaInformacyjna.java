package pl.edu.pwr.pdabrowski.lab09.model;

import jakarta.xml.bind.annotation.*;
import java.net.URL;
import java.util.Date;
import java.util.List;

@javax.xml.bind.annotation.XmlRootElement(name = "karta_informacyjna")
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
public class KartaInformacyjna {
    @XmlElement(name = "link")
    private String link;

    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "data")
    private String data;

    @XmlElement(name = "skrot_organizacja")
    private String skrotOrganizacja;

    @XmlElement(name = "komponent_srodowiska")
    private String komponentSrodowiska;

    @XmlElement(name = "typ_karty")
    private String typKarty;

    @XmlElement(name = "rodzaj_karty")
    private String rodzajKarty;

    @XmlElement(name = "nr_wpisu")
    private String nrWpisu;

    @XmlElement(name = "znak_sprawy")
    private String znakSprawy;

    @XmlElement(name = "dane_wnioskodawcy")
    private String daneWnioskodawcy;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSkrotOrganizacja() {
        return skrotOrganizacja;
    }

    public void setSkrotOrganizacja(String skrotOrganizacja) {
        this.skrotOrganizacja = skrotOrganizacja;
    }

    public String getKomponentSrodowiska() {
        return komponentSrodowiska;
    }

    public void setKomponentSrodowiska(String komponentSrodowiska) {
        this.komponentSrodowiska = komponentSrodowiska;
    }

    public String getTypKarty() {
        return typKarty;
    }

    public void setTypKarty(String typKarty) {
        this.typKarty = typKarty;
    }

    public String getRodzajKarty() {
        return rodzajKarty;
    }

    public void setRodzajKarty(String rodzajKarty) {
        this.rodzajKarty = rodzajKarty;
    }

    public String getNrWpisu() {
        return nrWpisu;
    }

    public void setNrWpisu(String nrWpisu) {
        this.nrWpisu = nrWpisu;
    }

    public String getZnakSprawy() {
        return znakSprawy;
    }

    public void setZnakSprawy(String znakSprawy) {
        this.znakSprawy = znakSprawy;
    }

    public String getDaneWnioskodawcy() {
        return daneWnioskodawcy;
    }

    public void setDaneWnioskodawcy(String daneWnioskodawcy) {
        this.daneWnioskodawcy = daneWnioskodawcy;
    }

    @Override
    public String toString() {
        return "KartaInformacyjna{" +
                "link='" + link + '\'' +
                ", id='" + id + '\'' +
                ", data='" + data + '\'' +
                ", skrotOrganizacja='" + skrotOrganizacja + '\'' +
                ", komponentSrodowiska='" + komponentSrodowiska + '\'' +
                ", typKarty='" + typKarty + '\'' +
                ", rodzajKarty='" + rodzajKarty + '\'' +
                ", nrWpisu='" + nrWpisu + '\'' +
                ", znakSprawy='" + znakSprawy + '\'' +
                ", daneWnioskodawcy='" + daneWnioskodawcy + '\'' +
                '}';
    }
}

