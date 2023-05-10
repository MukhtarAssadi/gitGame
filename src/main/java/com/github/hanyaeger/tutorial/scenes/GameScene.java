package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseButtonReleasedListener;
import com.github.hanyaeger.tutorial.Shooter;
import com.github.hanyaeger.tutorial.entities.Enemy;
import com.github.hanyaeger.tutorial.entities.player.BulletSpawner;
import com.github.hanyaeger.tutorial.entities.player.Player;
import com.github.hanyaeger.tutorial.entities.text.BulletText;
import com.github.hanyaeger.tutorial.entities.text.LivesText;
import javafx.scene.input.MouseButton;

public class GameScene extends DynamicScene implements EntitySpawnerContainer, MouseButtonPressedListener, MouseButtonReleasedListener {
    Player player;
    BulletSpawner gun;
    Shooter shooter;
    BulletText bulletsText;
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
        player = new Player(new Coordinate2D(getWidth() / 2, getHeight() / 2), livesText, bulletsText,  shooter);
        addEntity(player);
        var enemy = new Enemy(new Coordinate2D(getWidth() / 10, getHeight() / 10), player);
        addEntity(enemy);
//        var wall = new Wall(new Coordinate2D(getWidth() / 4, getHeight() / 4));
//        addEntity(wall);
    }


    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        gun = new BulletSpawner(200, player, bulletsText);
        addEntitySpawner(gun);
    }

    @Override
    public void onMouseButtonReleased(MouseButton mouseButton, Coordinate2D coordinate2D) {
        gun.remove();
    }

    @Override
    public void setupEntitySpawners() {

    }
}
