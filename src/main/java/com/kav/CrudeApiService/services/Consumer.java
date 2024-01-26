package com.kav.CrudeApiService.services;

import com.kav.CrudeApiService.dto.TodosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consume")
public class Consumer {
//    @Autowired
//    RestTemplate restTemplate ;

    @GetMapping("{ver}")
    private ResponseEntity<?> getJson (@PathVariable  String ver){
        return ResponseEntity.ok(new RestTemplate().getForObject("https://jsonplaceholder.typicode.com/todos/"+ ver, TodosDto.class));
    }
}
