package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.tutorial.scenes.TitleScene;

public class Shooter extends YaegerGame {
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void setupGame() {
        setGameTitle("Shooter");
        setSize(new Size(1600, 900));
    }
    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
    }
}
