package com.github.hanyaeger.tutorial.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.entities.player.Player;

public class Runner extends Enemy {
    public Runner(Coordinate2D location, Player player) {
        super(location, player, 30, "sprites/enemy.png");
        health = 3;
        speed = 3;
        setMotion(speed, angleTo(player.getAnchorLocation()));
    }

    public void onCollision(Collider collider) {
        if (collider.toString().contains("Bullet")) {
            health--;
        }
        if (health <= 0){
            remove();
        }
    }
}
