/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import java.util.ArrayList;
import java.util.List;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
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
    int rotation;
    
    public Bullet(int x, int y, int rotation){
        setPosition(x, y);
        this.rotation = rotation;
        normalAnimation = new Animation("resources/sprites/bullet.png",16,16,100);
        normalAnimation.setPingPong(true);
        normalAnimation.setRotation(rotation);
        setAnimation(normalAnimation);        
        
    }
    
    public void act(){
        List<Actor> toRemove = new ArrayList<> ();
        List<Actor> toAdd = new ArrayList<> ();
        //inicializacia 
        if (moveUp == null) {
            moveUp = new Move(this, 3, 0, -1);
        }
        if (moveDown == null) {
            moveDown = new Move(this, 3, 0, 1);
        }
        if (moveRight == null) {
            moveRight = new Move(this, 3, 1, 0);
        }
        if (moveLeft == null) {
            moveLeft = new Move(this, 3, -1, 0);
        }
        if (moveDownRight == null) {
            moveDownRight = new Move(this, 3, 1, 1);
        }
        if (moveDownLeft == null) {
            moveDownLeft = new Move(this, 3, -1, 1);
        }
        if (moveUpRight == null) {
            moveUpRight = new Move(this, 3, 1, -1);
        }
        if (moveUpLeft == null) {
            moveUpLeft = new Move(this, 3, -1, -1);
        }        
        
        switch (rotation) {
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
        
        if(getWorld().intersectWithWall(this)){
            getWorld().removeActor(this);
            Explosion impact = new Explosion();
            impact.setPosition(getX(), getY());
            impact.getAnimation().setDuration(5);
            impact.setTimer(5);
            getWorld().addActor(impact);
            impact.explode();
        }
        
        for (Actor actor : getWorld()){
            if(actor instanceof Enemy && this.intersects(actor)){
            toRemove.add(this);
            Explosion impact = new Explosion();
            impact.setPosition(getX(), getY());
            impact.getAnimation().setDuration(5);
            impact.setTimer(5);
            toAdd.add(impact);
            impact.explode();
            ((AbstractCharacter)actor).setHealth(((AbstractCharacter)actor).getHealth() - 10);
            }
        }
        
        for (Actor actor : toRemove){
            getWorld().removeActor(actor);
        }

        for (Actor actor : toAdd){
            getWorld().addActor(actor);
        }

    
    }
}
