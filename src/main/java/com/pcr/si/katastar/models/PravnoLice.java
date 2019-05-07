package com.pcr.si.katastar.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class PravnoLice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "MATICNI_BROJ")
    private String maticniBroj;

    @Column(name = "PIB")
    private String pib;

    @Column(name = "NAZIV_FIRME")
    private String nazivFirme;

    @Column(name = "SIFRA_DELATNOSTI")
    private int sifraDelatnosti;

    @ManyToOne
    private FizickoLice odgovornoLice;

    @OneToMany(mappedBy = "pravnoLice")
    private Set<Hipoteka> hipoteke = new HashSet<>();

    public PravnoLice(String maticniBroj, String pib, String nazivFirme, int sifraDelatnosti, FizickoLice odgovornoLice) {
        this.maticniBroj = maticniBroj;
        this.pib = pib;
        this.nazivFirme = nazivFirme;
        this.sifraDelatnosti = sifraDelatnosti;
        this.odgovornoLice = odgovornoLice;
    }

    public PravnoLice() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getNazivFirme() {
        return nazivFirme;
    }

    public void setNazivFirme(String nazivFirme) {
        this.nazivFirme = nazivFirme;
    }

    public int getSifraDelatnosti() {
        return sifraDelatnosti;
    }

    public void setSifraDelatnosti(int sifraDelatnosti) {
        this.sifraDelatnosti = sifraDelatnosti;
    }

    public FizickoLice getOdgovornoLice() {
        return odgovornoLice;
    }

    public void setOdgovornoLice(FizickoLice odgovornoLice) {
        this.odgovornoLice = odgovornoLice;
    }

    @Override
    public String toString() {
        return "PravnoLice{" +
                "id='" + id + '\'' +
                ", maticniBroj='" + maticniBroj + '\'' +
                ", pib='" + pib + '\'' +
                ", nazivFirme='" + nazivFirme + '\'' +
                ", sifraDelatnosti=" + sifraDelatnosti +
                '}';
    }
}
