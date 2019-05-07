package com.pcr.si.katastar.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Nepokretnost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "TIP")
    private String tip;

    @Column(name = "ADRESA")
    private String adresa;

    @Column(name = "POVRSINA")
    private double povrsina;

    @Column(name = "PRAVNI_STATUS")
    private String pravniStatus;

    @ManyToOne
    private Parcela parcela;

    @OneToMany(mappedBy = "nepokretnost")
    private Set<Pravo> prava = new HashSet<>();

    @OneToMany(mappedBy = "nepokretnost")
    private Set<Hipoteka> hipoteke = new HashSet<>();

    public Nepokretnost(String tip, String adresa, double povrsina, String pravniStatus, Parcela parcela, Set<Pravo> prava, Set<Hipoteka> hipoteke) {
        this.tip = tip;
        this.adresa = adresa;
        this.povrsina = povrsina;
        this.pravniStatus = pravniStatus;
        this.prava = prava;
        this.parcela = parcela;
        this.hipoteke = hipoteke;
    }

    public Nepokretnost() {
    }

    public boolean podHipotekom() {
        return hipoteke.stream().anyMatch(hipoteka -> hipoteka.getDatumIsteka() == null);
    }

    public void upisiHipoteku(Hipoteka hipoteka) {
        this.hipoteke.add(hipoteka);
    }

    public Set<Hipoteka> getHipoteke() {
        return hipoteke;
    }

    public void setHipoteke(Set<Hipoteka> hipoteke) {
        this.hipoteke = hipoteke;
    }

    public void dodajPravo(Pravo pravo) {
        this.prava.add(pravo);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public double getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(double povrsina) {
        this.povrsina = povrsina;
    }

    public String getPravniStatus() {
        return pravniStatus;
    }

    public void setPravniStatus(String pravniStatus) {
        this.pravniStatus = pravniStatus;
    }

    public Set<Pravo> getPrava() {
        return prava;
    }

    public void setPrava(Set<Pravo> prava) {
        this.prava = prava;
    }

    @Override
    public String toString() {
        return "Nepokretnost{" +
                "id='" + id + '\'' +
                ", tip='" + tip + '\'' +
                ", adresa='" + adresa + '\'' +
                ", povrsina=" + povrsina +
                ", pravniStatus='" + pravniStatus + '\'' +
                '}';
    }
}
