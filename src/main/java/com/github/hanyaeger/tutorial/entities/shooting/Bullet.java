package com.github.hanyaeger.tutorial.entities.shooting;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Bullet extends DynamicSpriteEntity implements Collider, Collided{
    public Bullet(Coordinate2D initialLocation, int speed, double angle) {
        super("sprites/bullet.png", initialLocation, new Size(5, 10), 1, 1);
        setMotion(speed, 180 +angle);
        setRotate(180 + angle);
    }

    @Override
    public void onCollision(Collider collider) {
        remove();
    }
}
