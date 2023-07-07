package pl.edu.pwr.pdabrowski.lab06.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "instalacja")
public class Instalacja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numer_routera")
    private Long numerRoutera;

    @Column(name = "adres")
    private String adres;

    @Column(name = "typ_uslugi")
    private String typUslugi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numer_klienta")
    private Klient numerKlienta;

    public Instalacja(){}

    public Instalacja(String adres, String typUslugi, Klient numerKlienta){
        this.adres = adres;
        this.typUslugi = typUslugi;
        this.numerKlienta = numerKlienta;
    }

    public Long getNumerRoutera() {
        return numerRoutera;
    }

    public Klient getNumerKlienta() {
        return numerKlienta;
    }

    public String getTypUslugi() {
        return typUslugi;
    }

    public String getAdres() {
        return adres;
    }

    public void setNumerKlienta(Klient numerKlienta) {
        this.numerKlienta = numerKlienta;
    }

    public void setNumerRoutera(Long numerRoutera) {
        this.numerRoutera = numerRoutera;
    }

    public void setTypUslugi(String typUslugi) {
        this.typUslugi = typUslugi;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Instalacja{" +
                "numerRoutera=" + numerRoutera +
                ", adres='" + adres + '\'' +
                ", typUslugi='" + typUslugi + '\'' +
                ", numerKlienta=" + numerKlienta +
                '}';
    }
}
