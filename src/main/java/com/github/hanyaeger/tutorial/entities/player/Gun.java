package com.github.hanyaeger.tutorial.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseButtonReleasedListener;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;

import java.util.Optional;

public class Gun extends EntitySpawner {
    private Player player;
    public boolean isFiringOnce = false;

    public Gun(Player player) {
        super(200);
        this.player = player;
    }

    public Gun(Player player, long shootingInterval) {
        super(shootingInterval);
        this.player = player;
    }

    @Override
    protected void spawnEntities() {
        spawn(new Bullet(player.getAnchorLocation(), player.getFacingAngle()));
    }

    public void spawn() {
        spawn(new Bullet(player.getAnchorLocation(), player.getFacingAngle()));
    }



}
