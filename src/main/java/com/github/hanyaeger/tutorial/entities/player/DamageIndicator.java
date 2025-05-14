package com.github.hanyaeger.tutorial.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class DamageIndicator extends DynamicSpriteEntity implements TimerContainer {
    public DamageIndicator(Coordinate2D initialLocation) {
        super("sprites/damage.png", initialLocation);
    }

    @Override
    public void setupTimers() {
        Timer timer = new Timer(200) {
            @Override
            public void onAnimationUpdate(long l) {
                end();
            }
        };
        addTimer(timer);
    }

    public void end(){
        this.remove();
    }
}
