package com.spring.examples.c1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
//@Component // it is generic
@Service // using service because writing business logic
public class BusinessCalculationService {
    DataService dataService;
    // constructor injection since we have two implementations  of DataService interface that's why it will inject to primary one
    // to inject with mysql we can pass in constructor  @Qualifier ("mysqlConnection") DataService dataService
    public  BusinessCalculationService ( DataService dataService) {
        super();
        this.dataService = dataService;
    }
    public  int findmax() {
       return Arrays.stream(dataService.retriveData()).max().orElse(0);
    }
    }

