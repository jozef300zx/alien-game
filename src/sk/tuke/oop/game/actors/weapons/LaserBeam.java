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
import sk.tuke.oop.game.actors.AbstractCharacter;
import sk.tuke.oop.game.actors.explosions.SmallExplosion;
import sk.tuke.oop.game.actors.alien.Enemy;
import sk.tuke.oop.game.commands.Move;

/**
 *
 * @author jmorvay
 */
public class LaserBeam extends Bullet {
    
    public LaserBeam(int x, int y, int rotation) {
        super(x, y, rotation);
        normalAnimation = new Animation("resources/sprites/laser_beam.png",16,16,100);
        normalAnimation.setRotation(rotation);
        setAnimation(normalAnimation);    
        setDamage(2);        
    }
    
    public void act(){
        List<Actor> toAdd = new ArrayList<> ();
        //inicializacia 
        if (moveUp == null) {
            moveUp = new Move(this, 6, 0, -1);
        }
        if (moveDown == null) {
            moveDown = new Move(this, 6, 0, 1);
        }
        if (moveRight == null) {
            moveRight = new Move(this, 6, 1, 0);
        }
        if (moveLeft == null) {
            moveLeft = new Move(this, 6, -1, 0);
        }
        if (moveDownRight == null) {
            moveDownRight = new Move(this, 6, 1, 1);
        }
        if (moveDownLeft == null) {
            moveDownLeft = new Move(this, 6, -1, 1);
        }
        if (moveUpRight == null) {
            moveUpRight = new Move(this, 6, 1, -1);
        }
        if (moveUpLeft == null) {
            moveUpLeft = new Move(this, 6, -1, -1);
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
        
        if(getWorld().intersectWithWall(this)){
            getWorld().removeActor(this);
            SmallExplosion impact = new SmallExplosion();
            impact.setPosition(getX(), getY());
            impact.getAnimation().setDuration(5);
            impact.setTimer(5);
            getWorld().addActor(impact);
            impact.explode();
        }
        
        for (Actor actor : getWorld()){
            if(actor instanceof Enemy && this.intersects(actor)){
            SmallExplosion impact = new SmallExplosion();
            impact.setPosition(getX(), getY());
            impact.getAnimation().setDuration(5);
            impact.setTimer(5);
            toAdd.add(impact);
            impact.explode();
            ((AbstractCharacter)actor).setHealth(((AbstractCharacter)actor).getHealth() - getDamage());
            }
        }

        for (Actor actor : toAdd){
            getWorld().addActor(actor);
        }

    
    }    
    
}
