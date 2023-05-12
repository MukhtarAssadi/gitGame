package com.github.hanyaeger.tutorial.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.tutorial.entities.player.Player;
import com.github.hanyaeger.tutorial.entities.sounds.Audio;

public class Enemy extends DynamicSpriteEntity implements Collider, Collided {
    Player player;
    int health;
    int speed;
    Audio deathSound;

    public Enemy(Coordinate2D location, Player player) {
       super("sprites/enemy.png", location, new Size(70, 70), 1, 1);
        this.player = player;
        speed = 2;
        health = 3;
        deathSound = new Audio("audio/dood.mp3");
    }

    public Enemy(Coordinate2D location, Player player, int size, String sprite, String audio, int speed, int health) {
        super(sprite, location, new Size(size, size), 1, 1);
        this.player = player;
        this.speed = speed;
        this.health = health;
        deathSound = new Audio(audio);
    }


    @Override
    public void onCollision(Collider collider) {
        if (collider.toString().contains("Bullet")) {
            health--;
        }
        if (collider.toString().contains("Wall")) {
            player.removeLive();
            System.out.println("hit!");
            remove();
        }
        if (health <= 0){
            remove();
            deathSound.play();
            player.kills++;
        }
    }

    public int getHealth(){
        return health;
    }
    public Coordinate2D getSceneCenter(double sceneWidth, double sceneHeigth) {
        double xCenter = sceneWidth / 2;
        double yCenter = sceneHeigth / 2;
        return new Coordinate2D(800, 450);
    }

    public void setMotionNow(double sceneWidth, double sceneHeigth){
        setRotate(180 + angleTo(getSceneCenter(sceneWidth, sceneHeigth)));
        setMotion(speed, angleTo(getSceneCenter(sceneWidth, sceneHeigth)));
    }
}
