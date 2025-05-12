package com.github.hanyaeger.tutorial.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Rotatable;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.tutorial.entities.player.Bullet;
import com.github.hanyaeger.tutorial.entities.player.Player;

public class Enemy extends DynamicSpriteEntity implements Collided, Collider, TimerContainer, Rotatable {
    private Player player;

    public int health;
    public int speed;

    public Enemy(Coordinate2D initialLocation, Player player) {
        super("sprites/enemy.png", initialLocation, new Size(70, 70));
        this.health = 3;
        this.speed = 4;
        this.player = player;
    }

    public Enemy(String resource, Coordinate2D initialLocation, Size size, int health, int speed, Player player){
        super(resource, initialLocation, size);
        this.health = health;
        this.speed = speed;
        this.player = player;
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Bullet bullet) {
            health--;
            System.out.println("hit! " + health);
        }
        if (health <= 0) {
            remove();
        }
    }

    @Override
    public void setupTimers() {
        Timer timer = new Timer(100) {
            @Override
            public void onAnimationUpdate(long l) {
                setMotion(speed, angleTo(player.getAnchorLocation()));
                setRotate(angleTo(player.getAnchorLocation()) + 180);
            }
        };
        addTimer(timer);
    }
}
