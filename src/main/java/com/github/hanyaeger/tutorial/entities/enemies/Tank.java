package com.github.hanyaeger.tutorial.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.tutorial.entities.player.Player;

public class Tank extends Enemy {
    public Tank(Coordinate2D initialLocation, Player player){
        super("sprites/enemy.png", initialLocation, new Size(140, 140), 10, 3, player);
    }
}
