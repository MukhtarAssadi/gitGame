package com.github.hanyaeger.tutorial.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.entities.player.Player;

public class Runner extends Enemy {
    public Runner(Coordinate2D location, Player player) {
        super(location, player, 50, "sprites/runner.png", "audio/dood.mp3", 3, 1);
    }


}
