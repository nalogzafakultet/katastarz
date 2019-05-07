package com.pcr.si.katastar.controller;

import com.pcr.si.katastar.exceptions.BadRequestException;
import com.pcr.si.katastar.models.*;
import com.pcr.si.katastar.services.KatastarService;
import com.pcr.si.katastar.services.dtos.ErrorDTO;
import com.pcr.si.katastar.services.dtos.NepokretnostReqDTO;
import com.pcr.si.katastar.services.dtos.PravniStatusDTO;
import com.pcr.si.katastar.services.dtos.ProstornaPretragaReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class KatastarController {

    @Autowired
    private KatastarService katastarService;

    @GetMapping("/pretraga")
    public List<Parcela> pretraziParcele(
            @RequestParam(value = "brojParcele", required = false) String brojParcele,
            @RequestParam(value = "postanskiKod", required = false) String postanskiKod) {
        if (postanskiKod == null && brojParcele == null) {
            throw new BadRequestException("There must be atleast one query param of postanskiKod / brojParcele");
        }
        if (postanskiKod != null && brojParcele != null) {
            throw new BadRequestException("You cannot search by both query postanskiKod or brojParcele.");
        }
        if (postanskiKod != null) {
            return katastarService.pretragaParcelaPoPostanskomKodu(Integer.valueOf(postanskiKod));
        }
        return katastarService.pretraziParcelePoBrojuParcele(brojParcele);
    }

    @PostMapping("/prostornaPretraga")
    public List<Parcela> prostornaPretraga(@RequestBody ProstornaPretragaReqDTO request) {
        return katastarService.nadjiDostupneParcele(request.getLat(), request.getLng(), request.getRadijus(), request.getTipovi());
    }

    @GetMapping("/pretragaAdresnogRegistra")
    public List<Nepokretnost> pretragaAdresnogRegistra(@RequestParam("adresa") String adresa) {
        return katastarService.pretragaNepokretnostiPoAdresi(adresa);
    }

    @PostMapping("/katastar/parcela/{parcelaId}/objekti")
    public void upisiObjekatNaParcelu(@PathVariable("parcelaId") String parcelaId,
                                      @RequestBody NepokretnostReqDTO nepokretnostDTO) {
        NepokretnostBuilder builder = new NepokretnostBuilder();

        Nepokretnost nepokretnost = builder.setAdresa(nepokretnostDTO.getAdresa())
                                            .setPovrsina(nepokretnostDTO.getPovrsina())
                                            .setTip(nepokretnostDTO.getTip())
                                            .setPravniStatus(nepokretnostDTO.getPravniStatus())
                                            .createNepokretnost();

        katastarService.upisiNepokrenostNaParcelu(nepokretnost, parcelaId);
    }

    @PutMapping("/katastar/parcela/{parcelaId}/imaociPrava")
    public void izmeniImaocePrava(@PathVariable("parcelaId") String parcelaId, @RequestBody List<Pravo> prava) {
        katastarService.izmeniListuImalacaPrava(parcelaId, prava);
    }

    @PutMapping("/katastar/parcela/{parcelaId}/objekat/{objekatId}/pravniStatus")
    public void promeniPravniStatusObjekta(@PathVariable("parcelaId") String parcelaId,
                                           @PathVariable("objekatId") String objekatId,
                                           @RequestBody PravniStatusDTO pravniStatusDTO) {
        katastarService.izmeniPravniStatus(pravniStatusDTO.getPravniStatus(), objekatId);
    }

    @PostMapping("/parcela/{parcelaId}/hipoteke")
    public void dodajHipotekuNaParcelu(@PathVariable("parcelaId") String parcelaId, @RequestBody Hipoteka hipoteka) {
        katastarService.upisiHipotekuNaParcelu(hipoteka, parcelaId);
    }

    @DeleteMapping("/parcela/{parcelaId}/hipoteke/{hipotekaId}")
    public void obrisiHipotekuSaParcele(@PathVariable("parcelaId") String parcelaId,
                                        @PathVariable("hipotekaId") String hipotekaId) {
        katastarService.obrisiHipoteku(hipotekaId);
    }

    @PostMapping("/parcela/{parcelaId}/objekat/{objekatId}/hipoteke")
    public void dodajHipotekuNaNepokrenost(@PathVariable("parcelaId") String parcelaId,
                                           @PathVariable("objekatId") String objekatId,
                                           @RequestBody Hipoteka hipoteka) {
        katastarService.upisiHipotekuNaNepokretnost(hipoteka, objekatId);
    }

    @DeleteMapping("/parcela/{parcelaId}/objekat/{objekatId}/hipoteke/{hipotekaId}")
    public void obrisiHipotekuSaNepokrenosti(@PathVariable("parcelaId") String parcelaId,
                                             @PathVariable("objekatId") String objekatId,
                                             @PathVariable("hipotekaId") String hipotekaId) {
        katastarService.obrisiHipoteku(hipotekaId);
    }

    @ExceptionHandler({BadRequestException.class, EntityNotFoundException.class})
    public ResponseEntity<ErrorDTO> handle(Exception ex) {
        return ResponseEntity.badRequest().body(new ErrorDTO(ex.getMessage()));
    }


}