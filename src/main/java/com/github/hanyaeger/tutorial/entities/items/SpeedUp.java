package com.github.hanyaeger.tutorial.entities.items;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.tutorial.entities.player.Player;

public class SpeedUp extends PowerUp {

    public SpeedUp(Coordinate2D initialLocation, Player player) {
        super("sprites/speed.png", initialLocation, player);
    }

    @Override
    public void usePowerUp(Player player) {
        player.speed += 1;
    }

}
