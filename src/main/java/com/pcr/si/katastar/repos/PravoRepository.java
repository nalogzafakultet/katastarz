package com.pcr.si.katastar.repos;

import com.pcr.si.katastar.models.Pravo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface PravoRepository extends CrudRepository<Pravo, String> {

}
