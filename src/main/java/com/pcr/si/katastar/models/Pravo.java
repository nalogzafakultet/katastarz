package com.pcr.si.katastar.models;

import javax.persistence.*;

@Entity
@Table
public class Pravo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "TIP_PRAVA")
    private String tipPrava;

    @Column(name = "UDEO")
    private double udeo;

    @ManyToOne
    private FizickoLice fizickoLice;

    @ManyToOne
    private Nepokretnost nepokretnost;

    @ManyToOne
    private Parcela parcela;

    public Pravo(String tipPrava, double udeo, FizickoLice fizickoLice, Nepokretnost nepokretnost, Parcela parcela) {
        this.tipPrava = tipPrava;
        this.udeo = udeo;
        this.fizickoLice = fizickoLice;
        this.nepokretnost = nepokretnost;
        this.parcela = parcela;
    }

    public Pravo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipPrava() {
        return tipPrava;
    }

    public void setTipPrava(String tipPrava) {
        this.tipPrava = tipPrava;
    }

    public double getUdeo() {
        return udeo;
    }

    public void setUdeo(double udeo) {
        this.udeo = udeo;
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

    public FizickoLice getFizickoLice() {
        return fizickoLice;
    }

    public void setFizickoLice(FizickoLice fizickoLice) {
        this.fizickoLice = fizickoLice;
    }

    @Override
    public String toString() {
        return "Pravo{" +
                "id='" + id + '\'' +
                ", tipPrava='" + tipPrava + '\'' +
                ", udeo=" + udeo +
                ", fizickoLice=" + fizickoLice +
                ", nepokretnost=" + nepokretnost +
                ", parcela=" + parcela +
                '}';
    }
}
