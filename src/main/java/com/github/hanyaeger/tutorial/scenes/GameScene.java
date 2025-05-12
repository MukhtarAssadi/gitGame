package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseButtonReleasedListener;
import com.github.hanyaeger.tutorial.Shooter;
import com.github.hanyaeger.tutorial.entities.enemies.Enemy;
import com.github.hanyaeger.tutorial.entities.enemies.Runner;
import com.github.hanyaeger.tutorial.entities.enemies.Tank;
import com.github.hanyaeger.tutorial.entities.player.Gun;
import com.github.hanyaeger.tutorial.entities.player.Player;
import javafx.scene.input.MouseButton;

public class GameScene extends DynamicScene implements EntitySpawnerContainer, MouseButtonPressedListener, MouseButtonReleasedListener {
    Shooter shooter;
    Player player;
    Gun gun;

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
        player = new Player(new Coordinate2D(getWidth() / 2, getHeight() / 1.5));
        addEntity(player);
        player.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        var enemy = new Enemy(new Coordinate2D(getWidth() / 7, getHeight() / 7), player);
        addEntity(enemy);
        var runner = new Runner(new Coordinate2D(getWidth() / 9, getHeight() / 9), player);
        addEntity(runner);
        var tank = new Tank(new Coordinate2D(getWidth() / 1.2, getHeight() / 12), player);
        addEntity(tank);
    }


    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if (mouseButton == MouseButton.PRIMARY) {
            gun = new Gun(player);
            addEntitySpawner(gun);
            gun.spawn();
        }
    }

    @Override
    public void onMouseButtonReleased(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if (mouseButton == MouseButton.PRIMARY) {
            if (gun != null) {
                gun.remove();
            }
        }
    }

    @Override
    public void setupEntitySpawners() {

    }
}
