package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.core.Updatable;
import com.github.hanyaeger.tutorial.entities.player.Player;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Enemy extends DynamicSpriteEntity implements KeyListener, Collider {
    Player player;
    public Enemy(Coordinate2D location, Player player) {
       super("sprites/enemy.png", location, new Size(50, 50), 1, 1);
        this.player = player;
    }


    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        setRotate(180 + angleTo(player.getAnchorLocation()));
        setMotion(2, angleTo(player.getAnchorLocation()));
    }
}
