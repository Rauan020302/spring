package ru.spring;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ClassicalMusic implements Music {

    @PostConstruct
    public void doMyInit() {
        System.out.println("init");
    }
    @PreDestroy
    public void myDestroy() {
        System.out.println("destroy");
    }
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }


}
