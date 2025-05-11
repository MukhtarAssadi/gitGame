package com.github.hanyaeger.tutorial.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.tutorial.entities.player.Player;

public class Enemy extends DynamicSpriteEntity implements Collided, Collider {
    public int health;
    public int speed;


    public Enemy(Coordinate2D initialLocation) {
        super("sprites/enemy.png", initialLocation, new Size(70, 70));
        this.health = 3;
        this.speed = 5;
    }

    public Enemy(String resource, Coordinate2D initialLocation, Size size, int health, int speed){
        super(resource, initialLocation, size);
        this.health = health;
        this.speed = speed;
    }


    @Override
    public void onCollision(Collider collider) {
        if (collider.toString().contains("Bullet")) {
            health--;
        }
        if (health <= 0) {
            remove();
        }
    }
}
