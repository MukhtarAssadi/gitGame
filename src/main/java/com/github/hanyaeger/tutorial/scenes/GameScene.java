package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.Shooter;

public class GameScene extends DynamicScene {

    Shooter shooter;

    public GameScene(Shooter shooter) {
        this.shooter = shooter;
    }

    @Override
    public void setupScene() {
//        setBackgroundAudio("audio/");
        setBackgroundImage("sprites/vloer.png");
    }

    @Override
    public void setupEntities() {

    }
}
