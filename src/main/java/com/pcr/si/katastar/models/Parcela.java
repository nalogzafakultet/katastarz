package com.pcr.si.katastar.models;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Parcela {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "TIP")
    private String tip;

    @Column(name = "POVRSINA")
    private double povrsina;

    @Column(name = "GEOMETRIJA")
    private String geometrija;

    @Column(name = "POSTANSKI_KOD")
    private int postanskiKod;

    @Column(name = "CENTROID_LAT")
    private double centroidLat;

    @Column(name = "CENTROID_LNG")
    private double centroidLng;

    @OneToMany(mappedBy = "parcela", cascade = CascadeType.ALL)
    private Set<Nepokretnost> nepokrenosti = new HashSet<>();

    @OneToMany(mappedBy = "parcela", cascade = CascadeType.ALL)
    private Set<Pravo> prava = new HashSet<>();

    @OneToMany(mappedBy = "parcela")
    private Set<Hipoteka> hipoteke = new HashSet<>();

    public Parcela(String tip, double povrsina, String geometrija, double centroidLat, double centroidLng, int postanskiKod, Set<Nepokretnost> nepokrenosti, Set<Pravo> prava, Set<Hipoteka> hipoteke) {
        this.tip = tip;
        this.povrsina = povrsina;
        this.geometrija = geometrija;
        this.postanskiKod = postanskiKod;
        this.nepokrenosti = nepokrenosti;
        this.centroidLat = centroidLat;
        this.centroidLng = centroidLng;
        this.prava = prava;
        this.hipoteke = hipoteke;
    }

    public Parcela() {
    }

    public boolean isDostupna() {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED);
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

    public double getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(double povrsina) {
        this.povrsina = povrsina;
    }

    public String getGeometrija() {
        return geometrija;
    }

    public void setGeometrija(String geometrija) {
        this.geometrija = geometrija;
    }

    public int getPostanskiKod() {
        return postanskiKod;
    }

    public void setPostanskiKod(int postanskiKod) {
        this.postanskiKod = postanskiKod;
    }

    public double getCentroidLat() {
        return centroidLat;
    }

    public void setCentroidLat(double centroidLat) {
        this.centroidLat = centroidLat;
    }

    public double getCentroidLng() {
        return centroidLng;
    }

    public void setCentroidLng(double centroidLng) {
        this.centroidLng = centroidLng;
    }

    public Set<Nepokretnost> getNepokrenosti() {
        return nepokrenosti;
    }

    public void upisiHipoteku(Hipoteka hipoteka) {
        this.hipoteke.add(hipoteka);
    }

    public void dodajNepokretnost(Nepokretnost nepokretnost) {
        this.nepokrenosti.add(nepokretnost);
    }

    public void setNepokrenosti(Set<Nepokretnost> nepokrenosti) {
        this.nepokrenosti = nepokrenosti;
    }

    public Set<Nepokretnost> getParcele() {
        return nepokrenosti;
    }

    public void setParcele(Set<Nepokretnost> nepokrenosti) {
        this.nepokrenosti = nepokrenosti;
    }

    public Set<Pravo> getPrava() {
        return prava;
    }

    public void setPrava(Set<Pravo> prava) {
        this.prava = prava;
    }

    public Set<Hipoteka> getHipoteke() {
        return hipoteke;
    }

    public void setHipoteke(Set<Hipoteka> hipoteke) {
        this.hipoteke = hipoteke;
    }

    @Override
    public String toString() {
        return "Parcela{" +
                "id='" + id + '\'' +
                ", tip='" + tip + '\'' +
                ", povrsina=" + povrsina +
                ", geometrija='" + geometrija + '\'' +
                ", postanskiKod=" + postanskiKod +
                ", nepokretnosti=" + nepokrenosti +
                ", prava=" + prava +
                ", hipoteke=" + hipoteke +
                '}';
    }
}
