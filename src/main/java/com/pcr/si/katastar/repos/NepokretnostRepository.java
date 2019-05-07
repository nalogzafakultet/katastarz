package com.pcr.si.katastar.repos;

import com.pcr.si.katastar.models.Nepokretnost;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NepokretnostRepository extends CrudRepository<Nepokretnost, String> {
    List<Nepokretnost> findAllByAdresaStartingWithIgnoreCase(String adresa);
}
