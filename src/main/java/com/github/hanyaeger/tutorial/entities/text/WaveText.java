package com.github.hanyaeger.tutorial.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class WaveText extends TextEntity {
    public WaveText(Coordinate2D initialLocation) {
        super(initialLocation);
        setFill(Color.BLUE);
        setFont(Font.font("Verdana", FontWeight.NORMAL, 30));
    }
    public void setWaveText(int wave) {
        setText("Wave: " + wave);
    }
}
