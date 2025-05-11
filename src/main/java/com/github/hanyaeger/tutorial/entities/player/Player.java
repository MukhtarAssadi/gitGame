package com.github.hanyaeger.tutorial.entities.player;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Rotatable;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.api.userinput.MouseMovedListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, MouseMovedListener, Rotatable {

    double facingAngle = 0d;
    public Player(Coordinate2D location) {
        super("sprites/player.png", location, new Size(70, 70), 1, 2);

        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys){
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

            setMotion(3, angle);
        } else {
            setSpeed(0);
        }
    }

    @Override
    public void onMouseMoved(Coordinate2D mousePosition) {
        double mouseX = mousePosition.getX();
        double mouseY = mousePosition.getY();
        double playerX = this.getLocationInScene().getX();
        double playerY = this.getLocationInScene().getY();

        double angleRadians = Math.atan2(mouseX - playerX, mouseY - playerY);
        double angleDegrees = Math.toDegrees(angleRadians);

        facingAngle = (angleDegrees + 180) % 360;
        setRotate(facingAngle);
    }











    public double getFacingAngle(){
        return this.facingAngle;
    }
}
