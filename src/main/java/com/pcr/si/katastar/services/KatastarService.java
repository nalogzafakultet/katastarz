package com.pcr.si.katastar.services;

import com.pcr.si.katastar.models.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KatastarService {
    void upisiHipotekuNaParcelu(Hipoteka hipoteka, String parcelaId);
    void upisiHipotekuNaNepokretnost(Hipoteka hipoteka, String objekatId);
    void obrisiHipoteku(Hipoteka hipoteka);
    void izmeniPravniStatus(String pravniStatus, String objekatId);
    void upisiNovoizgradjeniObjekat(Nepokretnost objekat, String parcelaId);
    void izmeniListuImalacaPrava(String parcelaid, List<Pravo> imaociPrava);
    List<Parcela> nadjiDostupneParcele(double latitude, double longitude, double radius, List<String> tipovi);
    List<Nepokretnost> pretragaNepokretnostiPoAdresi(String adresa);
    List<Parcela> pretragaParcelaPoPostanskomKodu(int postanskiKod);
}
