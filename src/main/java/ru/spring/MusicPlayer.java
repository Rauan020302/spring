package ru.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer {
    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }

    public void playMusic(MusicEnum musicEnum) {
        Random rand = new Random();
        int randNumber = rand.nextInt(3);

        if (musicEnum == MusicEnum.ROCK) {
            System.out.println(rockMusic.getSongs().get(randNumber));
        }else {
            System.out.println(classicalMusic.getSongs().get(randNumber));
        }

    }


}
