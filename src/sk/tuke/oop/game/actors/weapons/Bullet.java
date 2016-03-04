/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.weapons;

import java.util.ArrayList;
import java.util.List;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.AbstractCharacter;
import sk.tuke.oop.game.actors.alien.Enemy;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.actors.Projectile;
import sk.tuke.oop.game.actors.SmallExplosion;
import sk.tuke.oop.game.commands.Move;

/**
 *
 * @author jmorvay
 */
public class Bullet extends AbstractActor implements Movable,Projectile{
    Move moveUp;
    Move moveDown;
    Move moveRight;
    Move moveLeft;
    Move moveDownRight;
    Move moveDownLeft;
    Move moveUpRight;
    Move moveUpLeft;
    private int damage;
    
    public Bullet(int x, int y, int rotation){
        setPosition(x, y);
        normalAnimation = new Animation("resources/sprites/bullet.png",16,16,100);
        normalAnimation.setRotation(rotation);
        setAnimation(normalAnimation);        
        setDamage(5);
        
    }
    
    public void act(){
        List<Actor> toRemove = new ArrayList<> ();
        List<Actor> toAdd = new ArrayList<> ();
        //inicializacia 
        if (moveUp == null) {
            moveUp = new Move(this, 5, 0, -1);
        }
        if (moveDown == null) {
            moveDown = new Move(this, 5, 0, 1);
        }
        if (moveRight == null) {
            moveRight = new Move(this, 5, 1, 0);
        }
        if (moveLeft == null) {
            moveLeft = new Move(this, 5, -1, 0);
        }
        if (moveDownRight == null) {
            moveDownRight = new Move(this, 5, 1, 1);
        }
        if (moveDownLeft == null) {
            moveDownLeft = new Move(this, 5, -1, 1);
        }
        if (moveUpRight == null) {
            moveUpRight = new Move(this, 5, 1, -1);
        }
        if (moveUpLeft == null) {
            moveUpLeft = new Move(this, 5, -1, -1);
        }        
        
        
        if(getWorld().intersectWithWall(this)){
            getWorld().removeActor(this);
            SmallExplosion impact = new SmallExplosion();
            impact.setPosition(getX(), getY());
            impact.getAnimation().setDuration(5);
            impact.setTimer(5);
            getWorld().addActor(impact);
            impact.explode();
            return;
        }
        
        switch (normalAnimation.getRotation()) {
            case 135 : moveDownRight.Execute(); break;
            case 225 : moveDownLeft.Execute();break;
            case 45 :  moveUpRight.Execute();break;
            case 315 : moveUpLeft.Execute();break;
            case 0 :   moveUp.Execute();break;
            case 180:  moveDown.Execute();break;
            case 90 :  moveRight.Execute();break;
            case 270:  moveLeft.Execute();break;
            default:break;
        }   
        
        for (Actor actor : getWorld()){
            if(actor instanceof Enemy && this.intersects(actor)){
            toRemove.add(this);
            SmallExplosion impact = new SmallExplosion();
            impact.setPosition(getX(), getY());
            impact.getAnimation().setDuration(5);
            impact.setTimer(5);
            toAdd.add(impact);
            impact.explode();
            ((AbstractCharacter)actor).setHealth(((AbstractCharacter)actor).getHealth() - getDamage());
            }
        }        
        
        for (Actor actor : toRemove){
            getWorld().removeActor(actor);
        }

        for (Actor actor : toAdd){
            getWorld().addActor(actor);
        }

    
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
