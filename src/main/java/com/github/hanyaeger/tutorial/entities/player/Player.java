package com.github.hanyaeger.tutorial.entities.player;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.api.userinput.MouseMovedListener;
import javafx.scene.input.KeyCode;

import java.util.Random;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Collided, MouseMovedListener {
    int lives = 5;
    public Player(Coordinate2D location){
        super("sprites/player.png",location, new Size(50, 50), 1, 2);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
    @Override
    public void onCollision(Collider collider) {
        if (collider.toString().contains("Enemy")){
            lives--;
            setAnchorLocation(new Coordinate2D(new Random().nextInt((int)(getSceneWidth()-getWidth())), new Random().nextInt((int)(getSceneHeight()-getHeight()))));
        };
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setSpeed(0);

        switch(border){
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        int speed = 2;
        if(pressedKeys.contains(KeyCode.LEFT)) {
            if (pressedKeys.contains(KeyCode.UP)) {
                setMotion(speed, 225d);
            } else if (pressedKeys.contains(KeyCode.RIGHT)) {
                setMotion(0, 0d);
            } else if (pressedKeys.contains(KeyCode.DOWN)) {
                setMotion(speed, 315d);
            } else {
                setMotion(speed, 270d);
            }
        } else
        if(pressedKeys.contains(KeyCode.UP)){
            if(pressedKeys.contains(KeyCode.RIGHT)){
                setMotion(speed, 135d);
            } else
            if(pressedKeys.contains(KeyCode.DOWN)){
                setMotion(0, 0d);
            }  else {
                setMotion(speed, 180d);
            }

        } else
        if(pressedKeys.contains(KeyCode.DOWN)){
            if (pressedKeys.contains(KeyCode.RIGHT)) {
                setMotion(speed, 45d);
        } else {
                setMotion(speed, 0d);
            }
        } else
        if(pressedKeys.contains(KeyCode.RIGHT)){
            setMotion(speed, 90d);
        }
        if(pressedKeys.isEmpty()){
            setSpeed(0);
        }
    }

    @Override
    public void onMouseMoved(Coordinate2D mouseCoordinate) {
        setRotate(180 + angleTo(mouseCoordinate));
    }
}
