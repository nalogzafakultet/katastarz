package com.pcr.si.katastar.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class FizickoLice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "JMBG")
    private String jmbg;

    @Column(name = "IME")
    private String ime;

    @Column(name = "PREZIME")
    private String prezime;

    @OneToMany(mappedBy = "odgovornoLice")
    private Set<PravnoLice> pravnaLica = new HashSet<>();

    @OneToMany(mappedBy = "fizickoLice")
    private Set<Pravo> prava = new HashSet<>();

    @OneToMany(mappedBy = "fizickoLice")
    private Set<Hipoteka> hipoteke = new HashSet<>();

    public FizickoLice(String jmbg, String ime, String prezime, Set<PravnoLice> pravnaLica, Set<Hipoteka> hipoteke, Set<Pravo> prava) {
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.pravnaLica = pravnaLica;
        this.prava = prava;
        this.hipoteke = hipoteke;
    }

    public FizickoLice() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Set<PravnoLice> getPravnaLica() {
        return pravnaLica;
    }

    public void setPravnaLica(Set<PravnoLice> pravnaLica) {
        this.pravnaLica = pravnaLica;
    }

    public Set<Hipoteka> getHipoteke() {
        return hipoteke;
    }

    public void setHipoteke(Set<Hipoteka> hipoteke) {
        this.hipoteke = hipoteke;
    }

    public Set<Pravo> getPrava() {
        return prava;
    }

    public void setPrava(Set<Pravo> prava) {
        this.prava = prava;
    }

    @Override
    public String toString() {
        return "FizickoLice{" +
                "id='" + id + '\'' +
                ", jmbg='" + jmbg + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", pravnaLica=" + pravnaLica +
                ", prava=" + prava +
                ", hipoteke=" + hipoteke +
                '}';
    }
}
