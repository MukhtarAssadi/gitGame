package com.github.hanyaeger.tutorial.entities.enviroment;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Wall extends DynamicSpriteEntity implements Collider {
    public Wall(Coordinate2D location) {
        super("sprites/muur.png", location, new Size(200, 200), 1, 1);
    }
}
