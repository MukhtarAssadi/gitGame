package com.github.hanyaeger.tutorial.timers;

import com.github.hanyaeger.tutorial.entities.player.Player;
import com.github.hanyaeger.tutorial.entities.text.BulletText;

import java.util.TimerTask;

public class reloadTimer extends TimerTask {
    Player player;
    BulletText bulletText;
    public reloadTimer(Player player, BulletText bulletText){
        this.bulletText = bulletText;
        this.player = player;
    }
    @Override
    public void run() {
        player.bullets = 15;
        bulletText.setBulletsText(player.bullets);
        bulletText.setBulletsText(15);
    }
}
