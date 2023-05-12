package com.github.hanyaeger.tutorial.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoseText extends TextEntity {
    public LoseText(Coordinate2D initialLocation) {
        super(initialLocation);
        setText("Game over");
        setFont(Font.font("Roboto", FontWeight.NORMAL, 60));
        setFill(Color.BLUE);
    }

}