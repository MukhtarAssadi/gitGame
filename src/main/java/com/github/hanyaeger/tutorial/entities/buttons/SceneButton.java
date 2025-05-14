package com.github.hanyaeger.tutorial.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.Shooter;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SceneButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private Shooter shooter;
    private int id;

    public SceneButton(Coordinate2D initialLocation, Shooter shooter, int id, String text){
        super(initialLocation,text);
        setFill(Color.RED);
        setFont(Font.font("Roboto", FontWeight.BOLD, 60));

        this.shooter = shooter;
        this.id = id;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        shooter.setActiveScene(id);
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.WHITE);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.RED);
        setCursor(Cursor.DEFAULT);
    }
}

