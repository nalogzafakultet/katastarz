package com.pcr.si.katastar;

import com.pcr.si.katastar.services.BrokerService;
import com.pcr.si.katastar.services.dtos.ServiceDTO;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KatastarApplication {

	@Autowired
	BrokerService brokerService;

	@Bean
	public SmartInitializingSingleton registerService() {
		return () -> brokerService.registerService();
	}

	public static void main(String[] args) {
		SpringApplication.run(KatastarApplication.class, args);
	}

}