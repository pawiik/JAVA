package pl.edu.pwr.pdabrowski.lab06.entities;


import jakarta.persistence.*;

@Entity
@Table(name="cennik")
public class Cennik {

    @Column(name = "typ_uslugi")
    String typUslugi;
    @Column
    int cena;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Cennik(){

    }

    public Cennik(String typUslugi, int cena){
        this.typUslugi = typUslugi;
        this.cena = cena;
    }

    public int getCena() {
        return cena;
    }

    public String getTypUslugi() {
        return typUslugi;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public void setTypUslugi(String typUslugi) {
        this.typUslugi = typUslugi;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
