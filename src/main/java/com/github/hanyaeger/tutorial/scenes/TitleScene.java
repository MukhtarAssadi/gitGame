package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.Shooter;
import com.github.hanyaeger.tutorial.entities.buttons.SceneButton;

public class TitleScene extends StaticScene {
    private Shooter shooter;

    public TitleScene(Shooter shooter){
        this.shooter = shooter;
    }
    @Override
    public void setupScene() {
        setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("sprites/background.png");
    }

    @Override
    public void setupEntities() {
        var startButton = new SceneButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 1.5), shooter, 1, "Play game"
        );
        startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(startButton);
    }
}
