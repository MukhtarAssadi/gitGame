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
    protected Player player;
    protected WaveSpawner wave;

    protected int health;
    protected int speed;

    public Enemy(Coordinate2D initialLocation, Player player, WaveSpawner wave) {
        super("sprites/enemy.png", initialLocation, new Size(70, 70));

        this.health = 3;
        this.speed = 3;
        this.player = player;
        this.wave = wave;
    }

    public Enemy(String resource, Coordinate2D initialLocation, Size size, int health, int speed, Player player, WaveSpawner wave){
        super(resource, initialLocation, size);

        this.health = health;
        this.speed = speed;
        this.player = player;
        this.wave = wave;
    }

    public void death(){
        wave.notifyEnemyDeath();
        remove();
    }

    public void damage(){
        player.changeHealth(-1);
        wave.damageIndication(getAnchorLocation());
        wave.notifyEnemyDeath();
        remove();
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Bullet) {
            health--;
        }
        if (health <= 0) {
            death();
        }
        if (collider instanceof Player player){
            damage();
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
