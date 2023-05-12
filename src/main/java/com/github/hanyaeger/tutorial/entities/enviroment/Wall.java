package com.github.hanyaeger.tutorial.entities.enviroment;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.tutorial.entities.player.Player;

public class Wall extends DynamicSpriteEntity implements Collider {
    public Player player;
    public Wall(Coordinate2D location, Player player) {
        super("sprites/muur.png", location, new Size(300, 300), 1, 1);
        this.player = player;
    }
}
