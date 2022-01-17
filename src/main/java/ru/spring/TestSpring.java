package ru.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        MusicPlayer musicPlayer = context.getBean("musicPlayer",MusicPlayer.class);
        MusicPlayer musicPlayer2 = context.getBean("musicPlayer1",MusicPlayer.class);

        musicPlayer.playMusic();

        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());

        musicPlayer2.playMusic();

        context.close();
    }
}
