package com.github.hanyaeger.tutorial.entities.items;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.entities.player.Player;

public abstract class PowerUp extends DynamicSpriteEntity implements Collided {
    Player player;

    public PowerUp(String resource, Coordinate2D initialLocation, Player player) {
        super(resource, initialLocation, new Size(35, 35));
        this.player = player;
    }

    public abstract void usePowerUp(Player player);

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Player player) {
            usePowerUp(player);
            new SoundClip("audio/pop.mp3").play();
            remove();
        }
    }


}
