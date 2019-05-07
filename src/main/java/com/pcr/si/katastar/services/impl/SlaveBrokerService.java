package com.pcr.si.katastar.services.impl;

import com.pcr.si.katastar.services.BrokerService;
import com.pcr.si.katastar.services.dtos.EndPointDTO;
import com.pcr.si.katastar.services.dtos.ServiceDTO;
import org.springframework.stereotype.Service;

@Service
public class SlaveBrokerService implements BrokerService {

    private final String BROKER_SERVICE_INVOKE_URL = "http://localhost:8080/services";

    @Override
    public void removeService() {

    }

    @Override
    public void registerService() {
//        ServiceDTO serviceDTO = new ServiceDTO();
//        serviceDTO.setName("katastar");
//        serviceDTO.setUrl("localhost:9000/katastar");
        System.out.println("SADJKJDSKLD");
    }

    @Override
    public String invoke(String serviceName, String body) {
        return null;
    }


}
