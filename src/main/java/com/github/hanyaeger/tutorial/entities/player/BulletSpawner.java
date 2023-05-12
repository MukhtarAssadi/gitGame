package com.github.hanyaeger.tutorial.entities.player;

import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.entities.shooting.Bullet;
import com.github.hanyaeger.tutorial.entities.sounds.Audio;
import com.github.hanyaeger.tutorial.entities.text.BulletText;

public class BulletSpawner extends EntitySpawner {
    Player player;
    BulletText bulletText;
    Audio sound = new Audio("audio/schiet.mp3");

    public BulletSpawner(long intervalInMs, Player player, BulletText bulletText) {
        super(intervalInMs);
        this.player = player;
        this.bulletText = bulletText;
    }

    @Override
    public void spawnEntities() {
        if (player.bullets > 0) {
            spawn(new Bullet(player.getAnchorLocation(), 10, player.angle));
            player.bullets--;
            bulletText.setBulletsText(player.bullets);
            sound.play();
        }
    }
}
