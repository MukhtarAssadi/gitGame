package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class Shooter extends YaegerGame {
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void setupGame() {
        setGameTitle("Shooter");
        setSize(new Size(1200, 800));
    }
    @Override
    public void setupScenes() {

    }
}
