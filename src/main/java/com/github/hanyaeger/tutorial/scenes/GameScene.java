package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseButtonReleasedListener;
import com.github.hanyaeger.tutorial.Shooter;
import com.github.hanyaeger.tutorial.entities.enemies.Enemy;
import com.github.hanyaeger.tutorial.entities.enemies.EnemySpawner;
import com.github.hanyaeger.tutorial.entities.enemies.Runner;
import com.github.hanyaeger.tutorial.entities.enemies.Tank;
import com.github.hanyaeger.tutorial.entities.enviroment.Wall;
import com.github.hanyaeger.tutorial.entities.player.BulletSpawner;
import com.github.hanyaeger.tutorial.entities.player.Player;
import com.github.hanyaeger.tutorial.entities.text.BulletText;
import com.github.hanyaeger.tutorial.entities.text.LivesText;
import com.github.hanyaeger.tutorial.entities.text.StartText;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

import java.util.Random;
import java.util.Set;

public class GameScene extends DynamicScene implements EntitySpawnerContainer, MouseButtonPressedListener, MouseButtonReleasedListener, KeyListener {
    Player player;
    BulletSpawner gun;
    Shooter shooter;
    BulletText bulletsText;
    StartText startText;
    Tank tank;
    boolean running = false;
    public GameScene(Shooter shooter){
        this.shooter = shooter;
    }
    @Override
    public void setupScene() {
        setBackgroundAudio("audio/waterworld.mp3");
        setBackgroundImage("backgrounds/background4.jpg");
    }

    @Override
    public void setupEntities() {
        var livesText = new LivesText(new Coordinate2D(getWidth() / 10, getHeight() / 10));
        addEntity(livesText);
        bulletsText = new BulletText(new Coordinate2D(getWidth() / 1.2, getHeight() / 10));
        addEntity(bulletsText);
        StartText startText = new StartText(new Coordinate2D(getWidth() / 2, getHeight() / 8));
        addEntity(startText);
        player = new Player(new Coordinate2D(getWidth() / 2, getHeight() / 2), livesText, bulletsText,  shooter, 3);
        addEntity(player);
        var enemy = new Enemy(randomCoord(70), player);
        addEntity(enemy);
        var runner = new Runner(randomCoord(50), player);
        addEntity(runner);
        tank = new Tank(randomCoord(150), player);
        addEntity(tank);
        Wall wall = new Wall(new Coordinate2D(getWidth() / 2, getHeight() / 2), player);
        addEntity(wall);

        player.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        wall.setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }


    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if (running) {
            gun = new BulletSpawner(200, player, bulletsText);
            addEntitySpawner(gun);
        }
    }

    @Override
    public void onMouseButtonReleased(MouseButton mouseButton, Coordinate2D coordinate2D) {
        gun.remove();
        if (player.kills >= player.neededKills){
            running = false;
            shooter.setActiveScene(2);
        }
    }
    @Override
    public void setupEntitySpawners() {
        EnemySpawner spawner = new EnemySpawner(5000, 5, player, getWidth(), getHeight());
        addEntitySpawner(spawner);
    }

    public Coordinate2D randomCoord(int size){
        int x;
        int y;
        do {
            x = new Random().nextInt((int) (getWidth()));
            y = new Random().nextInt((int) (getHeight()));
        } while ((x > 100 && x < getWidth() - 100 && y > 100 && y < getHeight() - 100));
        return new Coordinate2D(x, y);
    }


    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        running = true;
    }
}
