package com.github.hanyaeger.tutorial.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.tutorial.entities.player.Player;

public class Runner extends Enemy {
    public Runner(Coordinate2D initialLocation, Player player, WaveSpawner wave){
        super("sprites/runner.png", initialLocation, new Size(35, 35), 1, 4, player, wave);
    }
}

