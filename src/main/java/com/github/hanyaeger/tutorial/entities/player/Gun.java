package com.github.hanyaeger.tutorial.entities.player;

import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.media.SoundClip;

public class Gun extends EntitySpawner {
    private Player player;

    public Gun(Player player) {
        super(200);
        this.player = player;
    }

    @Override
    protected void spawnEntities() {
        spawn(new Bullet(player.getAnchorLocation(), player.getFacingAngle()));
        new SoundClip("audio/schiet.mp3").play();
    }

    public void spawn() {
        spawn(new Bullet(player.getAnchorLocation(), player.getFacingAngle()));
    }

}
