package pl.edu.pwr.pdabrowski.lab07.api_provider.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dokonanie_wplaty")
public class DokonanieWplaty {
    @Column(name = "termin_wplaty")
    private LocalDate terminWplaty;
    @Column(name = "kwota_wplaty")
    private int kwotaWplaty;

    @Column(name = "numer_routera")
    private Long numerRoutera;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public DokonanieWplaty(){

    }

    public DokonanieWplaty(LocalDate data, int kwota, Long numer){
        this.kwotaWplaty = kwota;
        this.terminWplaty = data;
        this.numerRoutera = numer;
    }

    public int getKwotaWplaty() {
        return kwotaWplaty;
    }

    public LocalDate getTerminWplaty() {
        return terminWplaty;
    }

    public Long getNumerRoutera() {
        return numerRoutera;
    }

    public void setKwotaWplaty(int kwotaWplaty) {
        this.kwotaWplaty = kwotaWplaty;
    }

    public void setNumerRoutera(Long numerRoutera) {
        this.numerRoutera = numerRoutera;
    }

    public void setTerminWplaty(LocalDate terminWplaty) {
        this.terminWplaty = terminWplaty;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "DokonanieWplaty{" +
                "terminWplaty=" + terminWplaty +
                ", kwotaWplaty=" + kwotaWplaty +
                ", numerRoutera=" + numerRoutera +
                ", id=" + id +
                '}';
    }
}
