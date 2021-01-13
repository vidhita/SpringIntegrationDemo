package com.vidhita.integration;

public class PersonDirectoryService {

    public Person findNewPerson(){
        System.out.println("Inbound Adapter has polled the service");
        return new Person("Vidhita", "Deshmukh");
    }
}
