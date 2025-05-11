package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.Shooter;
import com.github.hanyaeger.tutorial.entities.player.Player;

public class GameScene extends DynamicScene {

    Shooter shooter;

    public GameScene(Shooter shooter) {
        this.shooter = shooter;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("sprites/vloer.png");
    }

    @Override
    public void setupEntities() {
        var player = new Player(new Coordinate2D(getWidth() / 2, getHeight() / 1.5));
        addEntity(player);
        player.setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
