package com.kav.business;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class BusinessLogics {

    @PostConstruct
    void init(){
        System.out.println("---> external package loaded <---");
    }
}
