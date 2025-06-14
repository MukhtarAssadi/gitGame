package com.github.hanyaeger.tutorial.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Rotatable;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Bullet extends DynamicSpriteEntity implements Rotatable, Collider, Collided {
    private int speed = 10;

    public Bullet(Coordinate2D initialLocation, double shootingAngle) {
        super("sprites/bullet.png", initialLocation, new Size(5, 10));
        setMotion(speed, shootingAngle + 180);
        setRotate(shootingAngle + 180);
    }

    @Override
    public void onCollision(Collider collider) {
        System.out.println(collider.toString());
        if (collider instanceof Player player) {
        } else {
            remove();
        }
    }
}
