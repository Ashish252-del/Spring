package com.spring.examples.c1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository // because kind of db interaction
@Primary
public class MongoDbDataService implements DataService{
    @Override
    public int [] retriveData(){
        System.out.println("Running MongoDbDataService =======>");
        return new int []{1,5,1,4,7};
    }
}
