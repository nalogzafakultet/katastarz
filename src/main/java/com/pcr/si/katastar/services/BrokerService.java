package com.pcr.si.katastar.services;

import com.pcr.si.katastar.services.dtos.HttpMethod;
import com.pcr.si.katastar.services.dtos.ServiceDTO;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.stereotype.Service;

@Service
public interface BrokerService {
    void removeService();
    void registerService();
    String invoke(HttpMethod method, String serviceName, String body);


}
