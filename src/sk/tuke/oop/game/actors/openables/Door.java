/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Usable;

/**
 *
 * @author jmorvay
 */
public class Door extends AbstractActor implements Usable,Openable{
    boolean isOpen;
    private boolean locked;
    
    public Door(String name, boolean vertical) {
        if(vertical) {
        normalAnimation = new Animation("resources/sprites/vdoor.png",16,32,100);
        //getWorld().setWall(this.getX() / 16, this.getY() / 16, true);
        //getWorld().setWall(this.getX() / 16, (this.getY() + 16) / 16, true);
        } else {
        normalAnimation = new Animation("resources/sprites/hdoor.png",32,16,100);
        //getWorld().setWall(this.getX() / 16, this.getY() / 16, true);
        //getWorld().setWall((this.getX() + 16) / 16, this.getY() / 16, true);         
        }
        setAnimation(normalAnimation);     
        normalAnimation.stop();
        normalAnimation.setLooping(false);
        isOpen = false;
        locked = false;
        this.setName(name);
    }

    @Override
    public void use(Actor actor) {

    }

    @Override
    public void open() {
        if(!isLocked()){
        normalAnimation.start();
        isOpen = true;
        if(getHeight() > getWidth()) {
        getWorld().setWall(this.getX() / 16, this.getY() / 16, false);
        getWorld().setWall(this.getX() / 16, (this.getY() + 16) / 16, false);
        }
        
        if(getWidth() > getHeight()) {
        getWorld().setWall(this.getX() / 16, this.getY() / 16, false);
        getWorld().setWall((this.getX() + 16) / 16, this.getY() / 16, false);    
        }
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
        return locked;
    }
    

    
    
}
