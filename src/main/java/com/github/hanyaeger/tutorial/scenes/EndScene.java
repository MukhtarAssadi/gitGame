package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.Shooter;
import com.github.hanyaeger.tutorial.entities.buttons.SceneButton;


public class EndScene extends StaticScene {
    Shooter shooter;

    public EndScene(Shooter shooter){
        this.shooter = shooter;
    }
    @Override
    public void setupScene() {
        setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("backgrounds/background4.jpg");
    }

    @Override
    public void setupEntities() {
        var shooterButton = new SceneButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 2), shooter, 0, "Main Menu"
        );
        shooterButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(shooterButton);
    }
}
