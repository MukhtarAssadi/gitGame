package com.github.hanyaeger.tutorial.entities.terrain;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Wall extends SpriteEntity implements Collider {
    public Wall(Coordinate2D location, Size size, String imageUrl) {
        super(imageUrl, location, size);
    }
}
