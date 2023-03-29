package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.entities.Enemy;
import com.github.hanyaeger.tutorial.entities.player.Player;

public class GameScene extends DynamicScene {
    @Override
    public void setupScene() {
        setBackgroundAudio("audio/waterworld.mp3");
        setBackgroundImage("backgrounds/background4.jpg");
    }

    @Override
    public void setupEntities() {
        var player = new Player(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        addEntity(player);
        var enemy = new Enemy(new Coordinate2D(getWidth() / 10, getHeight() / 10), player);
        addEntity(enemy);
    }

}
