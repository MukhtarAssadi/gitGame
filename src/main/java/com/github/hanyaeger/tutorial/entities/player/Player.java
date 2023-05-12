package com.github.hanyaeger.tutorial.entities.player;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.api.userinput.MouseMovedListener;
import com.github.hanyaeger.api.userinput.MouseMovedWhileDraggingListener;
import com.github.hanyaeger.tutorial.Shooter;
import com.github.hanyaeger.tutorial.entities.sounds.Audio;
import com.github.hanyaeger.tutorial.entities.text.BulletText;
import com.github.hanyaeger.tutorial.entities.text.LivesText;
import com.github.hanyaeger.tutorial.entities.text.ScoreText;
import com.github.hanyaeger.tutorial.timers.reloadTimer;
import javafx.scene.input.KeyCode;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class Player extends DynamicSpriteEntity implements KeyListener, MouseMovedListener, MouseMovedWhileDraggingListener {
    int lives = 5;
    public int bullets = 15;

    public int kills = 0;
    LivesText livesText;
    BulletText bulletsText;
    ScoreText scoreText;
    Shooter shooter;
    double angle;
    public boolean reloading = false;
    Audio reloadSound = new Audio("audio/herladen.mp3");
    public Player(Coordinate2D location, LivesText livesText, BulletText bulletsText,ScoreText scoreText, Shooter shooter){
        super("sprites/player.png",location, new Size(70, 70), 1, 2);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);

        this.livesText = livesText;
        livesText.setLivesText(lives);

        this.bulletsText = bulletsText;
        bulletsText.setBulletsText(bullets);

        this.scoreText = scoreText;
        scoreText.setScoreText(kills);

        this.shooter = shooter;
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if(pressedKeys.contains(KeyCode.R)){
            TimerTask task = new reloadTimer(this, bulletsText);
            Timer reloadTimer = new Timer("reloadTimer");
            reloading = true;
            reloadSound.play();

            reloadTimer.schedule(task, 1000L);
        }
    }

    @Override
    public void onMouseMoved(Coordinate2D mouseCoordinate) {
        angle = 180 + angleTo(mouseCoordinate);
        setRotate(angle);
    }

    @Override
    public void onMouseMovedWhileDragging(Coordinate2D mouseCoordinate) {
        angle = 180 + angleTo(mouseCoordinate);
        setRotate(angle);
    }

    public void removeLive(){
        lives--;
        livesText.setLivesText(lives);
        if (lives <= 0){
            shooter.setActiveScene(2);
        }
    }

    public void addKill(){
        scoreText.setScoreText(kills);
    }


}
