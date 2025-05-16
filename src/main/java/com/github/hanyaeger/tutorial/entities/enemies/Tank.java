package com.github.hanyaeger.tutorial.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.tutorial.entities.player.Player;

public class Tank extends Enemy {
    public Tank(Coordinate2D initialLocation, Player player, WaveSpawner wave){
        super("sprites/enemy.png", initialLocation, new Size(140, 140), 10, 2, player, wave);
    }

    @Override
    public void death(){
        wave.notifyEnemyDeath();
        wave.itemSpawn(getAnchorLocation());
        remove();
    }
}
