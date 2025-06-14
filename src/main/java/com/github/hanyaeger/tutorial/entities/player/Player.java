package com.github.hanyaeger.tutorial.entities.player;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Rotatable;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.api.userinput.MouseMovedListener;
import com.github.hanyaeger.api.userinput.MouseMovedWhileDraggingListener;
import com.github.hanyaeger.tutorial.Shooter;
import com.github.hanyaeger.tutorial.entities.terrain.Wall;
import com.github.hanyaeger.tutorial.entities.text.PlayerHealthText;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, MouseMovedListener, MouseMovedWhileDraggingListener, Rotatable, SceneBorderTouchingWatcher, Collider, Collided {
    public int health = 5;
    public int speed = 3;
    public double facingAngle = 0d;

    private PlayerHealthText playerHealthText;
    private Shooter shooter;
    private Coordinate2D previousPosition;


    public Player(Coordinate2D location, PlayerHealthText playerHealthText, Shooter shooter) {
        super("sprites/player.png", location, new Size(70, 70), 1, 2);

        this.playerHealthText = playerHealthText;
        this.shooter = shooter;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys){
        previousPosition = getAnchorLocation();

        boolean left = pressedKeys.contains(KeyCode.LEFT);
        boolean right = pressedKeys.contains(KeyCode.RIGHT);
        boolean up = pressedKeys.contains(KeyCode.UP);
        boolean down = pressedKeys.contains(KeyCode.DOWN);


        if (left || right || up || down) {
            double angle = -1;

            if (up && right) {
                angle = 135;
            } else if (up && left) {
                angle = 225;
            } else if (down && right) {
                angle = 45;
            } else if (down && left) {
                angle = 315;
            } else if (up) {
                angle = 180;
            } else if (down) {
                angle = 0;
            } else if (left) {
                angle = 270;
            } else if (right) {
                angle = 90;
            }

            setMotion(speed, angle);
        } else {
            setSpeed(0);
        }
    }

    @Override
    public void onMouseMoved(Coordinate2D mousePosition) {
        facingAngle = 180 + angleTo(mousePosition);
        setRotate(facingAngle);
    }

    @Override
    public void onMouseMovedWhileDragging(Coordinate2D mousePosition) {
        facingAngle = 180 + angleTo(mousePosition);
        setRotate(facingAngle);
    }


    public double getFacingAngle(){
        return this.facingAngle;
    }


    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        setSpeed(0);

        switch(sceneBorder){
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

    public void changeHealth(int healthChange){
        this.health += healthChange;
        playerHealthText.setHealthText(this.health);
        if (this.health <= 0){
            shooter.setActiveScene(2);
        }
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Wall) {
            setAnchorLocation(previousPosition);
            setSpeed(0);
        }
    }


}
