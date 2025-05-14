package com.github.hanyaeger.tutorial.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.entities.items.HealthUp;
import com.github.hanyaeger.tutorial.entities.items.PowerUp;
import com.github.hanyaeger.tutorial.entities.items.SpeedUp;
import com.github.hanyaeger.tutorial.entities.player.DamageIndicator;
import com.github.hanyaeger.tutorial.entities.player.Player;
import com.github.hanyaeger.tutorial.entities.text.WaveText;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemySpawnHandler extends EntitySpawner {
    private Player player;
    private WaveText waveText;

    private int wave = 1;
    private List<Enemy> enemiesToSpawn = new ArrayList<>();
    private int enemiesLeft = 0;

    private final double width;
    private final double height;


    public EnemySpawnHandler(double width, double height, Player player, WaveText waveText) {
        super(1000);

        this.width = width;
        this.height = height;
        this.player = player;
        this.waveText = waveText;

        spawnWave();
    }

    public void spawnWave() {
        int total = 5 + 2 * wave;
        enemiesLeft = total;

        for (int i = 0; i < total; i++) {
            Enemy enemy;
            if ((i + 1) % 7 == 0) {
                enemy = new Tank(randomSpawnLocation(), player, this);
            } else if (i % 2 == 1) {
                enemy = new Runner(randomSpawnLocation(), player, this);
            } else {
                enemy = new Enemy(randomSpawnLocation(), player, this);
            }
            enemiesToSpawn.add(enemy);
        }
    }

    @Override
    protected void spawnEntities() {
        System.out.println(enemiesLeft);
        if (!enemiesToSpawn.isEmpty()) {
            Enemy next = enemiesToSpawn.remove(0);
            spawn(next);
        } else if (enemiesLeft == 0){
            wave++;
            waveText.setWaveText(wave);
            spawnWave();
        }
    }

    private Coordinate2D randomSpawnLocation() {
        List<Coordinate2D> spawnPoints = List.of(
                new Coordinate2D(width * 1 / 9.0, height * 1 / 9.0),        // top-left
                new Coordinate2D(width * 4.5 / 9.0, height * 1 / 9.0),      // top-middle
                new Coordinate2D(width * 8 / 9.0, height * 1 / 9.0),        // top-right
                new Coordinate2D(width * 1 / 9.0, height * 4.5 / 9.0),      // middle-left
                new Coordinate2D(width * 8 / 9.0, height * 4.5 / 9.0),      // middle-right
                new Coordinate2D(width * 1 / 9.0, height * 8 / 9.0),        // bottom-left
                new Coordinate2D(width * 4.5 / 9.0, height * 8 / 9.0),      // bottom-middle
                new Coordinate2D(width * 8 / 9.0, height * 8 / 9.0)         // bottom-right
        );

        return spawnPoints.get((int)(Math.random() * spawnPoints.size()));
    }

    public void notifyEnemyDeath() {
        enemiesLeft--;
    }

    public void setWaveText(){
        waveText.setWaveText(wave);
    }

    public void itemSpawn(Coordinate2D spawnLocation) {
        Random random = new Random();
        if (random.nextDouble() <= 0.25) {
            PowerUp powerUp;

            if(player.speed <= 7) {
                if (random.nextBoolean()) {
                    powerUp = new HealthUp(spawnLocation, player);
                } else {
                    powerUp = new SpeedUp(spawnLocation, player);
                }
                spawn(powerUp);
            } else {
                if (random.nextBoolean()) {
                    powerUp = new HealthUp(spawnLocation, player);
                    spawn(powerUp);
                }
            }
        }
    }

    public void damageIndication(Coordinate2D location){
        DamageIndicator damageIndicator = new DamageIndicator(location);
        spawn(damageIndicator);
    }
}
