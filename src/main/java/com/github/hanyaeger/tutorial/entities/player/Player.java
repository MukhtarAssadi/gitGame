package com.github.hanyaeger.tutorial.entities.player;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.api.userinput.MouseMovedListener;
import com.github.hanyaeger.api.userinput.MouseMovedWhileDraggingListener;
import com.github.hanyaeger.tutorial.Shooter;
import com.github.hanyaeger.tutorial.entities.text.BulletText;
import com.github.hanyaeger.tutorial.entities.text.LivesText;
import com.github.hanyaeger.tutorial.timers.reloadTimer;
import javafx.scene.input.KeyCode;

import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Collided, MouseMovedListener, MouseMovedWhileDraggingListener {
    int lives = 5;
    public int bullets = 15;
    boolean colliding = false;
    LivesText livesText;
    BulletText bulletsText;
    Shooter shooter;
    double angle;
    public Player(Coordinate2D location, LivesText livesText, BulletText bulletsText, Shooter shooter){
        super("sprites/player.png",location, new Size(50, 50), 1, 2);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);

        this.livesText = livesText;
        livesText.setLivesText(lives);

        this.bulletsText = bulletsText;
        bulletsText.setBulletsText(bullets);

        this.shooter = shooter;
    }
    @Override
    public void onCollision(Collider collider) {
        if (collider.toString().contains("Enemy")){
            lives--;
            setAnchorLocation(new Coordinate2D(new Random().nextInt((int)(getSceneWidth()-getWidth() - 50)), new Random().nextInt((int)(getSceneHeight()-getHeight() - 50))));
            livesText.setLivesText(lives);
            if (lives <= 0){
                shooter.setActiveScene(2);
            }
        }
        if (collider.toString().contains("Wall")) {
            setSpeed(0);
            System.out.println(collider.getBoundingBox());
            colliding = true;
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setSpeed(0);

        switch(border){
            case TOP:
                setAnchorLocationY(50);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 50);
                break;
            case LEFT:
                setAnchorLocationX(50);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 50);
            default:
                break;
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        int speed = 2;
            if (pressedKeys.contains(KeyCode.LEFT)) {
                if (pressedKeys.contains(KeyCode.UP)) {
                    setMotion(speed, 225d);
                } else if (pressedKeys.contains(KeyCode.RIGHT)) {
                    setMotion(0, 0d);
                } else if (pressedKeys.contains(KeyCode.DOWN)) {
                    setMotion(speed, 315d);
                } else {
                    setMotion(speed, 270d);
                }
            } else if (pressedKeys.contains(KeyCode.UP)) {
                if (pressedKeys.contains(KeyCode.RIGHT)) {
                    setMotion(speed, 135d);
                } else if (pressedKeys.contains(KeyCode.DOWN)) {
                    setMotion(0, 0d);
                } else {
                    setMotion(speed, 180d);
                }

            } else if (pressedKeys.contains(KeyCode.DOWN)) {
                if (pressedKeys.contains(KeyCode.RIGHT)) {
                    setMotion(speed, 45d);
                } else {
                    setMotion(speed, 0d);
                }
            } else if (pressedKeys.contains(KeyCode.RIGHT)) {
                setMotion(speed, 90d);
            }
            if (pressedKeys.isEmpty()) {
                setSpeed(0);
            }

        if(pressedKeys.contains(KeyCode.R)){
            TimerTask task = new reloadTimer(this, bulletsText);
            Timer reloadTimer = new Timer("reloadTimer");
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


}
