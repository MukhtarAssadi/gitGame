package com.github.hanyaeger.tutorial.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.entities.player.Player;

public class Tank extends Enemy{
    Coordinate2D location;
    public Tank(Coordinate2D location, Player player) {
        super(location, player, 100, "sprites/enemy.png");
        this.location = location;
        health = 10;
        speed = 1;
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
