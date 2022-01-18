package ru.spring;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassicalMusic implements Music {
    private List<String> songs = new ArrayList<>();

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
