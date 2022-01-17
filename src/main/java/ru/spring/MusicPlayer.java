package ru.spring;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private List<Music> music = new ArrayList<>();

    private String name;
    private int volume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    //IoC
    public MusicPlayer(List<Music> music) {
        this.music = music;
    }

    public MusicPlayer(){

    }

    public void playMusic() {
        for (Music m : music) {
            System.out.println(m.getSong());
        }
    }

    public List<Music> getMusic() {
        return music;
    }

    public void setMusic(List<Music> music) {
        this.music = music;
    }
}
