package ru.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Random;

public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;

    public String getName() {
        return name;
    }
    public int getVolume() {
        return volume;
    }

    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }

    public String playMusic() {
        return "Playing: " + classicalMusic.getSong() + ", " + rockMusic.getSong();

    }


}
