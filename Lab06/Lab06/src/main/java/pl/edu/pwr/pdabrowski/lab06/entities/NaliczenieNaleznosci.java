package pl.edu.pwr.pdabrowski.lab06.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "naliczenie_platnosci")
public class NaliczenieNaleznosci {
    @Column(name = "termin_platnosci")
    private LocalDate terminPlatnosci;
    @Column(name = "kwota_do_zaplaty")
    private Long kwota;
    @Column(name = "numer_routera")
    private Long numer_routera;
    @Id
    @Column(name = "id")
    private Long id;

    public NaliczenieNaleznosci(){}

    public NaliczenieNaleznosci(LocalDate terminPlatnosci, Long kwota, Long numer_routera){
        this.terminPlatnosci = terminPlatnosci;
        this.kwota = kwota;
        this.numer_routera = numer_routera;
    }

    public LocalDate getTerminPlatnosci() {
        return terminPlatnosci;
    }

    public Long getKwota() {
        return kwota;
    }

    public Long getNumer_routera() {
        return numer_routera;
    }

    public void setKwota(Long kwota) {
        this.kwota = kwota;
    }

    public void setNumer_routera(Long numer_routera) {
        this.numer_routera = numer_routera;
    }

    public void setTerminPlatnosci(LocalDate terminPlatnosci) {
        this.terminPlatnosci = terminPlatnosci;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "NaliczenieNaleznosci{" +
                "terminPlatnosci=" + terminPlatnosci +
                ", kwota=" + kwota +
                ", numer_routera=" + numer_routera +
                ", id=" + id +
                '}';
    }
}
