package pl.edu.pwr.pdabrowski.lab07.api_provider.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "klient")
public class Klient {
    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numer_klienta")
    private Long numerKlienta;

    @OneToMany(mappedBy = "numerKlienta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Instalacja> instalacje = new ArrayList<>();

    public Klient(){
    }

    public Klient(String imie, String nazwisko){
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Long getNumerKlienta() {
        return numerKlienta;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setNumerKlienta(Long numerKlienta) {
        this.numerKlienta = numerKlienta;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", numerKlienta=" + numerKlienta +
                ", instalacje=" + instalacje +
                '}';
    }
}
