package com.spring.examples.c1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository // because db interaction
@Qualifier("mysqlConnection")
public class MysqlDbDataService implements DataService{
    @Override
    public int [] retriveData(){
        return new int []{8,5,10,4,7};
    }
}
