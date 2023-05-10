package com.github.hanyaeger.tutorial.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.entities.player.Player;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Enemy extends DynamicSpriteEntity implements KeyListener, Collider, Collided {
    Player player;
    int health;
    int speed;
    public Enemy(Coordinate2D location, Player player) {
       super("sprites/enemy.png", location, new Size(50, 50), 1, 1);
        this.player = player;
        speed = 2;
        health = 5;
        setRotate(180 + angleTo(player.getAnchorLocation()));
        setMotion(speed, angleTo(player.getAnchorLocation()));
    }

    public Enemy(Coordinate2D location, Player player, int size, String sprite) {
        super(sprite, location, new Size(size, size), 1, 1);
        this.player = player;
        speed = 2;
        health = 5;
        setRotate(180 + angleTo(player.getAnchorLocation()));
        setMotion(speed, angleTo(player.getAnchorLocation()));
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        setRotate(180 + angleTo(player.getAnchorLocation()));
        setMotion(speed, angleTo(player.getAnchorLocation()));
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider.toString().contains("Bullet")) {
            health--;
        }
        if (health <= 0){
            remove();
        }
    }

    public int getHealth(){
        return health;
    }
}
