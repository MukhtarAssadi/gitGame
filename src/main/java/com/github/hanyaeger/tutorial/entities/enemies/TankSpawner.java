package com.github.hanyaeger.tutorial.entities.enemies;

import com.github.hanyaeger.tutorial.entities.player.Player;

public class TankSpawner extends EnemySpawner{
    public TankSpawner(long intervalInMs, int totalAmount, Player player, double sceneWidth, double sceneHeigth) {
        super(intervalInMs, totalAmount, player, sceneWidth, sceneHeigth);
    }

    public void spawnEntities() {
        this.location = randomCoord(70);
        Tank enemy = new Tank(location, player);
        this.enemy = enemy;
        spawn(this.enemy);
        enemy.setMotionNow(sceneWidth, sceneHeigth);
    }
}
