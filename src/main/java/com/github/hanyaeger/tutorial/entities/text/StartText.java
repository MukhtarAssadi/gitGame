package com.github.hanyaeger.tutorial.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class StartText extends TextEntity implements KeyListener {
    public StartText(Coordinate2D initialLocation) {
        super(initialLocation);
        setText("press any key to start");
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        remove();
    }
}