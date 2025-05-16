package com.github.hanyaeger.tutorial.entities.player;

import com.github.hanyaeger.api.entities.EntitySpawner;

public class Gun extends EntitySpawner {
    private Player player;

    public Gun(Player player) {
        super(200);
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
