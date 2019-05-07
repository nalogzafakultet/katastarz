package com.pcr.si.katastar.repos;

import com.pcr.si.katastar.models.Parcela;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParcelaRepository extends CrudRepository<Parcela, String> {
    List<Parcela> findAllByPostanskiKod(int postanskiKod);
}
