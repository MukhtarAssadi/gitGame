package com.github.hanyaeger.tutorial.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.entities.player.Player;

public class Tank extends Enemy {
    Coordinate2D location;

    public Tank(Coordinate2D location, Player player) {
        super(location, player, 150, "sprites/enemy.png", "audio/dood.mp3", 1, 7);
        this.location = location;
    }
}
