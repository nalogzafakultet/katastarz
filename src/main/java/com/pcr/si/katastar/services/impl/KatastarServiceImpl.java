package com.pcr.si.katastar.services.impl;

import com.pcr.si.katastar.models.*;
import com.pcr.si.katastar.repos.HipotekaRepository;
import com.pcr.si.katastar.repos.NepokretnostRepository;
import com.pcr.si.katastar.repos.ParcelaRepository;
import com.pcr.si.katastar.repos.PravnoLiceRepository;
import com.pcr.si.katastar.services.KatastarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class KatastarServiceImpl implements KatastarService {

    @Autowired
    private HipotekaRepository hipotekaRepository;

    @Autowired
    private ParcelaRepository parcelaRepository;

    @Autowired
    private NepokretnostRepository nepokretnostRepository;


    @Override
    public void upisiHipotekuNaParcelu(Hipoteka hipoteka, String parcelaId) throws EntityNotFoundException {
        Parcela parcela = parcelaRepository.findById(parcelaId).orElseThrow(EntityNotFoundException::new);
        parcela.upisiHipoteku(hipoteka);
        parcelaRepository.save(parcela);
    }

    @Override
    public void upisiHipotekuNaNepokretnost(Hipoteka hipoteka, String objekatId) {
        Nepokretnost nepokretnost = nepokretnostRepository.findById(objekatId).orElseThrow(EntityNotFoundException::new);
        nepokretnost.upisiHipoteku(hipoteka);
        nepokretnostRepository.save(nepokretnost);
    }

    @Override
    public void obrisiHipoteku(Hipoteka hipoteka) {
        hipotekaRepository.delete(hipoteka);
    }

    @Override
    public void izmeniPravniStatus(String pravniStatus, String objekatId) throws EntityNotFoundException {
        Nepokretnost nepokretnost = nepokretnostRepository.findById(objekatId)
                                            .orElseThrow(EntityNotFoundException::new);

        nepokretnost.setPravniStatus(pravniStatus);
        nepokretnostRepository.save(nepokretnost);
    }

    @Override
    public void upisiNovoizgradjeniObjekat(Nepokretnost objekat, String parcelaId) throws EntityNotFoundException {
        Parcela parcela = parcelaRepository.findById(parcelaId).orElseThrow(EntityNotFoundException::new);
        parcela.dodajNepokretnost(objekat);
        parcelaRepository.save(parcela);
    }

    @Override
    public void izmeniListuImalacaPrava(String parcelaId, List<Pravo> prava) throws EntityNotFoundException {
        Parcela parcela = parcelaRepository.findById(parcelaId).orElseThrow(EntityNotFoundException::new);
        parcela.setPrava(new HashSet<>(prava)); // Business logic
        parcelaRepository.save(parcela);
    }

    @Override
    public List<Parcela> nadjiDostupneParcele(double latitude, double longitude, double radius, List<String> tipovi) {
        List<Parcela> parcele = new ArrayList<>();
        parcelaRepository.findAll().forEach(parcele::add);
        return parcele.stream()
                .filter(parcela -> dist(parcela.getCentroidLng(), parcela.getCentroidLat(), longitude, latitude) - radius < 0)
                .filter(parcela -> tipovi.contains(parcela.getTip()))
                .collect(Collectors.toList());
    }

    private double dist(double cntLng, double cntLtt, double givenLng, double givenLtt) {
        return Math.sqrt(Math.pow(cntLng - givenLng, 2) + Math.pow(cntLtt - givenLtt, 2));
    }

    @Override
    public List<Nepokretnost> pretragaNepokretnostiPoAdresi(String adresa) {
        return nepokretnostRepository.findAllByAdresaStartingWithIgnoreCase(adresa);
    }

    @Override
    public List<Parcela> pretragaParcelaPoPostanskomKodu(int postanskiKod) {
        return parcelaRepository.findAllByPostanskiKod(postanskiKod);
    }
}
