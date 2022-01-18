package ru.spring;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("someRockMusic")
public class RockMusic implements Music {
    private List<String> songs = new ArrayList<>();

    {
        songs.add("Highway to Hell");
        songs.add("Paint it black");
        songs.add("Wind cries Mary");
    }

    @Override
    public List<String> getSongs() {
        return songs;
    }
}
