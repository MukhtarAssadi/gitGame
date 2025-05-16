package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.Shooter;
import com.github.hanyaeger.tutorial.entities.buttons.SceneButton;

public class DeathScene extends StaticScene {
    private Shooter shooter;

    public DeathScene(Shooter shooter){
        this.shooter = shooter;
    }
    @Override
    public void setupScene() {
        setBackgroundImage("sprites/background.png");
    }

    @Override
    public void setupEntities() {
        var restartButton = new SceneButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 1.5), shooter, 1, "Restart"
        );
        restartButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(restartButton);
    }
}

