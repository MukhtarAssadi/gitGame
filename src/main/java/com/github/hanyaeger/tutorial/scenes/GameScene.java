package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseButtonReleasedListener;
import com.github.hanyaeger.tutorial.Shooter;
import com.github.hanyaeger.tutorial.entities.enemies.*;
import com.github.hanyaeger.tutorial.entities.enviroment.Wall;
import com.github.hanyaeger.tutorial.entities.player.BulletSpawner;
import com.github.hanyaeger.tutorial.entities.player.Player;
import com.github.hanyaeger.tutorial.entities.text.BulletText;
import com.github.hanyaeger.tutorial.entities.text.LivesText;
import com.github.hanyaeger.tutorial.entities.text.ScoreText;
import javafx.scene.input.MouseButton;

public class GameScene extends DynamicScene implements EntitySpawnerContainer, MouseButtonPressedListener, MouseButtonReleasedListener {
    Player player;
    BulletSpawner gun;
    Shooter shooter;
    BulletText bulletsText;


    public GameScene(Shooter shooter) {
        this.shooter = shooter;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/waterworld.mp3");
        setBackgroundImage("sprites/vloer.png");
    }

    @Override
    public void setupEntities() {
        var livesText = new LivesText(new Coordinate2D(getWidth() / 13, getHeight() / 10));
        addEntity(livesText);
        bulletsText = new BulletText(new Coordinate2D(getWidth() / 1.2, getHeight() / 10));
        addEntity(bulletsText);
        ScoreText scoreText = new ScoreText(new Coordinate2D(getWidth() / 7, getHeight() / 10));
        addEntity(scoreText);
        player = new Player(new Coordinate2D(getWidth() / 2, getHeight() / 2), livesText, bulletsText, scoreText, shooter);
        addEntity(player);
        Wall wall = new Wall(new Coordinate2D(getWidth() / 2, getHeight() / 2), player);
        addEntity(wall);

        player.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        wall.setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }


    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        gun = new BulletSpawner(200, player, bulletsText);
        addEntitySpawner(gun);
    }

    @Override
    public void onMouseButtonReleased(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if (gun != null) {
            gun.remove();
        }

    }

    @Override
    public void setupEntitySpawners() {
        EnemySpawner enemySpawner = new EnemySpawner(3000, 5, player, getWidth(), getHeight());
        addEntitySpawner(enemySpawner);
        RunnerSpawner runnerSpawner = new RunnerSpawner(2225, 5, player, getWidth(), getHeight());
        addEntitySpawner(runnerSpawner);
        TankSpawner tankSpawner = new TankSpawner(9280, 5, player, getWidth(), getHeight());
        addEntitySpawner(tankSpawner);
    }
}

