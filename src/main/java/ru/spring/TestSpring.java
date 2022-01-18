package ru.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        Music music = context.getBean("someRockMusic", Music.class);
        Music classicalMusic = context.getBean("classicalMusic", Music.class);

        MusicPlayer musicPlayer = new MusicPlayer(music);
        MusicPlayer classicalMusicPlayer = new MusicPlayer(classicalMusic);

        musicPlayer.playMusic();
        classicalMusicPlayer.playMusic();
        context.close();
    }
}
