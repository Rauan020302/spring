package ru.spring;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class ClassicalMusic implements Music {
    private List<String> songs = new ArrayList<>();

    @PostConstruct
    public void doMyInit() {
        System.out.println("init");
    }
    @PreDestroy
    public void myDestroy() {
        System.out.println("destroy");
    }

    {
        songs.add("Hungarian Rhapsody");
        songs.add("Ave Maria");
        songs.add("Messiah");

    }

    @Override
    public List<String> getSongs() {
        return songs;
    }


}
