/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Input;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.commands.Move;

/**
 *
 * @author admin
 */
public abstract class AbstractActor implements Actor {
    
    int x;
    int y;
    int height;
    int width;
    int step;
    String name;
    Animation normalAnimation;
    Input input;
    Move moveUp;
    Move moveDown;
    Move moveRight;
    Move moveLeft;
    Move moveDownRight;
    Move moveDownLeft;
    Move moveUpRight;
    Move moveUpLeft;
    World world;

    public AbstractActor() {
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setPosition(int i, int i1) {
        this.x = i;
        this.y = i1;
    }

    @Override
    public Animation getAnimation() {
        return this.normalAnimation;
    }

    @Override
    public void setAnimation(Animation anmtn) {
        this.normalAnimation = anmtn;
    }

    @Override
    public void act() {
    }

    @Override
    public boolean intersects(Actor actor) {
        return true;
    }

    @Override
    public void addedToWorld(World world) {
        this.world = world;
    }

    @Override
    public World getWorld() {
        return this.world;
    }

    @Override
    public String getName() {
        return this.name;
    }
    
    public String toString()
    {
        return this.name + " " + this.getX() + " " + this.getY() + " " + this.getAnimation().getRotation();
    }
    
}
