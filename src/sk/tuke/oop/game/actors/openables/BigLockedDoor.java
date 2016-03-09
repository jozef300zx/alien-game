/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.openables;

import java.util.HashSet;
import java.util.Set;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Observer;
import sk.tuke.oop.game.actors.Trigger;

/**
 *
 * @author jmorvay
 */
public class BigLockedDoor extends AbstractActor implements Observer,Trigger{
    private boolean initialCycle;
    Set <Observer> listOfObservers = new HashSet<> ();
    
    public BigLockedDoor() {
        normalAnimation = new Animation("resources/sprites/fdoor.png",16,48,100);
        setAnimation(normalAnimation);
        normalAnimation.setRotation(270);
        normalAnimation.setLooping(false);
        normalAnimation.stop();
        initialCycle = true;
    }

    @Override
    public void giveNotice(Trigger trigger) {
    }

    @Override
    public void giveNotice() {
        open();
        for(Observer o : listOfObservers){
            o.giveNotice(this);
        } 
        
    }
    public void open() {
        normalAnimation.start();
        getWorld().setWall(this.getX() / 16, (this.getY() + 16) / 16, false);
        getWorld().setWall((this.getX() + 16) / 16, (this.getY() + 16) / 16, false);
        getWorld().setWall((this.getX() + 32) / 16, (this.getY() + 16) / 16, false);
    }    
    
    public void act(){
        if(initialCycle){
        getWorld().setWall(this.getX() / 16, (this.getY() + 16) / 16, true);
        getWorld().setWall((this.getX() + 16) / 16, (this.getY() + 16) / 16, true);
        getWorld().setWall((this.getX() + 32) / 16, (this.getY() + 16) / 16, true);
        
        
        if(this.getType().equals("5.4")){
            for(Actor actor : getWorld())
            {
                if(actor != this && ((AbstractActor) actor).getType().equals("6.1")){
                    addObserver((Observer)actor);
                }
            }        
        }
        initialCycle = false;        
        }
        
           
        
        
    }

    public void addObserver(Observer o){
        listOfObservers.add(o);
    }
    
    public void removeObserver(Observer o){
        listOfObservers.remove(o);
    }  
    
}
