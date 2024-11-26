package com.kav.CrudeApiService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.kav.business", "com.kav.CrudeApiService"} )
public class CrudeApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudeApiServiceApplication.class, args);
	}

}
