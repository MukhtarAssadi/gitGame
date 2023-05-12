package com.github.hanyaeger.tutorial.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.entities.player.Player;

import java.util.Random;

public class EnemySpawner extends EntitySpawner {
    double sceneWidth;
    double sceneHeigth;
    int amount = 0;
    int totalAmount;
    Coordinate2D location;
    Player player;
    Enemy enemy;

    public EnemySpawner(long intervalInMs, int totalAmount, Player player, double sceneWidth, double sceneHeigth) {
        super(intervalInMs);
        this.totalAmount = totalAmount;
        this.player = player;
        this.sceneWidth = sceneWidth;
        this.sceneHeigth = sceneHeigth;
    }

    public void spawnEntities() {
        this.location = randomCoord(70);
        Enemy enemy = new Enemy(location, player);
        this.enemy = enemy;
        spawn(this.enemy);
        enemy.setMotionNow(sceneWidth, sceneHeigth);
    }

    public Coordinate2D randomCoord(int size){
        int x;
        int y;
        do {
            x = new Random().nextInt((int) (sceneWidth));
            y = new Random().nextInt((int) (sceneHeigth));
        } while ((x > 100 && x < sceneWidth - 100 && y > 100 && y < sceneHeigth - 100));
        return new Coordinate2D(x, y);
    }

    @Override
    public void handle(long now) {
        super.handle(now);
        System.out.println(now);
        if (enemy != null) {
            enemy.setMotionNow(sceneWidth, sceneHeigth);
        }
    }
}

