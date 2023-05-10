package com.github.hanyaeger.tutorial.entities.enemies;

import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.tutorial.entities.player.Player;

public class EnemySpawner extends EntitySpawner {
    Tank tank;
    Player player;
    public EnemySpawner(long intervalInMs, Tank tank, Player player) {
        super(intervalInMs);
        this.tank = tank;
        this.player = player;
    }

    public void spawnEntities() {
        spawn(new Enemy(tank.getAnchorLocation(), player));
        remove();
    }

    @Override
    protected void spawn(YaegerEntity entity) {
        super.spawn(entity);
    }
}

