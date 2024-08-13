package com.spring.examples.c1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
//@Component // it is generic
@Service // using service because writing business logic
public class BusinessCalculationService {
    DataService dataService;
    // constructor injection
    public  BusinessCalculationService (DataService dataService) {
        super();
        this.dataService = dataService;
    }
    public  int findmax() {
       return Arrays.stream(dataService.retriveData()).max().orElse(0);
    }
    }

