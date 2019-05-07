package com.pcr.si.katastar.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Hipoteka {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "DATUM_UPISA")
    private Date datumUpisa;

    @Column(name = "DATUM_ISTEKA")
    private Date datumIsteka;

    @Column(name = "TIP_PREDMETA")
    private String tipPredmeta;

    @Column(name = "UDEO")
    private double udeo;

    @ManyToOne
    private Nepokretnost nepokretnost;

    @ManyToOne
    private Parcela parcela;

    @ManyToOne
    private FizickoLice fizickoLice;

    @ManyToOne
    private PravnoLice pravnoLice;

    public Hipoteka(Date datumUpisa, Date datumIsteka, String tipPredmeta, double udeo, Nepokretnost nepokretnost,
                    Parcela parcela, FizickoLice fizickoLice, PravnoLice pravnoLice) {
        this.datumUpisa = datumUpisa;
        this.datumIsteka = datumIsteka;
        this.tipPredmeta = tipPredmeta;
        this.udeo = udeo;
        this.nepokretnost = nepokretnost;
        this.parcela = parcela;
        this.fizickoLice = fizickoLice;
        this.pravnoLice = pravnoLice;
    }

    public Hipoteka() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDatumUpisa() {
        return datumUpisa;
    }

    public void setDatumUpisa(Date datumUpisa) {
        this.datumUpisa = datumUpisa;
    }

    public Date getDatumIsteka() {
        return datumIsteka;
    }

    public void setDatumIsteka(Date datumIsteka) {
        this.datumIsteka = datumIsteka;
    }

    public String getTipPredmeta() {
        return tipPredmeta;
    }

    public void setTipPredmeta(String tipPredmeta) {
        this.tipPredmeta = tipPredmeta;
    }

    public double getUdeo() {
        return udeo;
    }

    public void setUdeo(double udeo) {
        this.udeo = udeo;
    }

    public FizickoLice getFizickoLice() {
        return fizickoLice;
    }

    public void setFizickoLice(FizickoLice fizickoLice) {
        this.fizickoLice = fizickoLice;
    }

    public PravnoLice getPravnoLice() {
        return pravnoLice;
    }

    public void setPravnoLice(PravnoLice pravnoLice) {
        this.pravnoLice = pravnoLice;
    }

    public Nepokretnost getNepokretnost() {
        return nepokretnost;
    }

    public void setNepokretnost(Nepokretnost nepokretnost) {
        this.nepokretnost = nepokretnost;
    }

    public Parcela getParcela() {
        return parcela;
    }

    public void setParcela(Parcela parcela) {
        this.parcela = parcela;
    }

    @Override
    public String toString() {
        return "Hipoteka{" +
                "id='" + id + '\'' +
                ", datumUpisa=" + datumUpisa +
                ", datumIsteka=" + datumIsteka +
                ", tipPredmeta='" + tipPredmeta + '\'' +
                ", udeo=" + udeo +
                ", nepokretnost=" + nepokretnost +
                ", parcela=" + parcela +
                ", fizickoLice=" + fizickoLice +
                ", pravnoLice=" + pravnoLice +
                '}';
    }
}
