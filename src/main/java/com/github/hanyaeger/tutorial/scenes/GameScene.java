package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseButtonReleasedListener;
import com.github.hanyaeger.tutorial.Shooter;
import com.github.hanyaeger.tutorial.entities.enemies.EnemySpawnHandler;
import com.github.hanyaeger.tutorial.entities.items.HealthUp;
import com.github.hanyaeger.tutorial.entities.items.SpeedUp;
import com.github.hanyaeger.tutorial.entities.terrain.WallTileMap;
import com.github.hanyaeger.tutorial.entities.text.PlayerHealthText;
import com.github.hanyaeger.tutorial.entities.player.Gun;
import com.github.hanyaeger.tutorial.entities.player.Player;
import com.github.hanyaeger.tutorial.entities.text.WaveText;
import javafx.scene.input.MouseButton;

public class GameScene extends DynamicScene implements EntitySpawnerContainer, MouseButtonPressedListener, MouseButtonReleasedListener, TileMapContainer {
    Shooter shooter;
    Player player;
    Gun gun;
    EnemySpawnHandler wave;
    WaveText waveText;

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
        var playerHealthText = new PlayerHealthText(new Coordinate2D(getWidth() * 1 / 9.0, getHeight() * 1 / 9.0));
        addEntity(playerHealthText);
        waveText = new WaveText(new Coordinate2D(getWidth() * 8 / 9.0, getHeight() * 1 / 9.0));
        addEntity(waveText);



        player = new Player(new Coordinate2D(getWidth() / 2, getHeight() / 2), playerHealthText);
        addEntity(player);
        player.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        playerHealthText.setHealthText(player.health);

        var healthUp = new HealthUp(new Coordinate2D(getWidth() * 8 / 9.0, getHeight() * 8 / 9.0), player);
        addEntity(healthUp);
        var speedUp = new SpeedUp(new Coordinate2D(getWidth() * 7 / 9.0, getHeight() * 7 / 9.0), player);
        addEntity(speedUp);

    }

    @Override
    public void setupEntitySpawners() {
        wave = new EnemySpawnHandler(getWidth(), getHeight(), player, waveText);
        addEntitySpawner(wave);
        wave.setWaveText();
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new WallTileMap());
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
}
