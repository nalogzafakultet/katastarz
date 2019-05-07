package com.pcr.si.katastar.models;

import java.util.Set;

public class NepokretnostBuilder {
    private String tip;
    private String adresa;
    private double povrsina;
    private String pravniStatus;
    private Parcela parcela;
    private Set<Pravo> prava;
    private Set<Hipoteka> hipoteke;

    public NepokretnostBuilder setTip(String tip) {
        this.tip = tip;
        return this;
    }

    public NepokretnostBuilder setAdresa(String adresa) {
        this.adresa = adresa;
        return this;
    }

    public NepokretnostBuilder setPovrsina(double povrsina) {
        this.povrsina = povrsina;
        return this;
    }

    public NepokretnostBuilder setPravniStatus(String pravniStatus) {
        this.pravniStatus = pravniStatus;
        return this;
    }

    public NepokretnostBuilder setParcela(Parcela parcela) {
        this.parcela = parcela;
        return this;
    }

    public NepokretnostBuilder setPrava(Set<Pravo> prava) {
        this.prava = prava;
        return this;
    }

    public NepokretnostBuilder setHipoteke(Set<Hipoteka> hipoteke) {
        this.hipoteke = hipoteke;
        return this;
    }

    public Nepokretnost createNepokretnost() {
        return new Nepokretnost(tip, adresa, povrsina, pravniStatus, parcela, prava, hipoteke);
    }
}