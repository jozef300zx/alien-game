/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.items.AccessCard;
import sk.tuke.oop.game.items.Hammer;

/**
 *
 * @author jmorvay
 */
public class Door extends AbstractActor implements Usable,Openable{
    boolean isOpen;
    boolean isLocked;
    
    public Door() {
        normalAnimation = new Animation("resources/sprites/vdoor.png",16,32,100);
        setAnimation(normalAnimation);     
        normalAnimation.stop();
        normalAnimation.setLooping(false);
        isOpen = false;
        isLocked = true;
    }

    @Override
    public void use(Actor actor) {

    }

    @Override
    public void open() {
        if(!this.isLocked){
        normalAnimation.start();
        isOpen = true;
        getWorld().setWall(6, 4, false);
        getWorld().setWall(6, 5, false);
        }
    }

    @Override
    public void close() {
        /*
        if(!this.isLocked){
        normalAnimation.start();
        getWorld().setWall(6, 4, true);
        getWorld().setWall(6, 5, true);
        }
*/
    }

    
    @Override
    public boolean isOpen(Actor actor) {
            return this.isOpen;
    }

    
    public boolean isOpen() {
            return this.isOpen;
    }
    
    public boolean isLocked() {
            return this.isLocked;
    }
    
    public void setLock(boolean locked) {
        this.isLocked = locked;
          
    }
    
}
