package com.pcr.si.katastar.services.dtos;

public class NepokretnostReqDTO {

    private String tip;
    private String adresa;
    private double povrsina;
    private String pravniStatus;

    public NepokretnostReqDTO() {
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

    @Override
    public String toString() {
        return "NepokretnostReqDTO{" +
                ", tip='" + tip + '\'' +
                ", adresa='" + adresa + '\'' +
                ", povrsina=" + povrsina +
                ", pravniStatus='" + pravniStatus + '\'' +
                '}';
    }
}
