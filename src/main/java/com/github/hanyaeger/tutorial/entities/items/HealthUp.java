package com.github.hanyaeger.tutorial.entities.items;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.tutorial.entities.player.Player;

public class HealthUp extends PowerUp {
    public HealthUp(Coordinate2D initialLocation, Player player) {
        super("sprites/health.png", initialLocation, player);
    }

    @Override
    public void usePowerUp(Player player) {
        player.changeHealth(3);
    }
}
