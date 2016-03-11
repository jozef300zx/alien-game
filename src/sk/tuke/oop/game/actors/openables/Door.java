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
import sk.tuke.oop.game.actors.Usable;

/**
 *
 * @author jmorvay
 */
public class Door extends AbstractActor implements Usable,Openable,Trigger{
    boolean isOpen;
    private boolean locked;
    Set <Observer> listOfObservers = new HashSet<> ();
    Set <Observer> observersToBeRemoved = new HashSet<> ();
    private boolean initialCycle;
    
    public Door(boolean vertical) {
        if(vertical) {
        normalAnimation = new Animation("resources/sprites/vdoor.png",16,32,100);
        } else {
        normalAnimation = new Animation("resources/sprites/hdoor.png",32,16,100);     
        }
        setAnimation(normalAnimation);     
        normalAnimation.stop();
        normalAnimation.setLooping(false);
        isOpen = false;
        locked = false;
        initialCycle = true;
    }

    @Override
    public void use(Actor actor) {

    }

    @Override
    public void open() {
        if(!isLocked()){
        normalAnimation.setPingPong(false);
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
        
        
        for(Observer o : listOfObservers){
            o.giveNotice();
            o.giveNotice(this);
        }
        }
        
    }

    @Override
    public void close() {
        
        normalAnimation.setPingPong(true);
        normalAnimation.start();
        
        if(normalAnimation.getCurrentFrame() == 0)
            normalAnimation.stop();
        
        isOpen = false;
        if(getHeight() > getWidth()) {
        getWorld().setWall(this.getX() / 16, this.getY() / 16, true);
        getWorld().setWall(this.getX() / 16, (this.getY() + 16) / 16, true);
        }
        
        if(getWidth() > getHeight()) {
        getWorld().setWall(this.getX() / 16, this.getY() / 16, true);
        getWorld().setWall((this.getX() + 16) / 16, this.getY() / 16, true);    
        }
        
        for(Observer o : listOfObservers){
            o.giveNotice(this);
        }        
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
    
    public void addObserver(Observer o){
        listOfObservers.add(o);
    }
    
    public void removeObserver(Observer o){
        observersToBeRemoved.add(o);
    }    
    
    @Override
    public void act(){
        if(initialCycle){
            //set wall
              if(this.getHeight() > this.getWidth()) {
                    getWorld().setWall(this.getX() / 16, this.getY() / 16, true);
                    getWorld().setWall(this.getX() / 16, (this.getY() + 16) / 16, true);
                }
        
                if(this.getWidth() > this.getHeight()) {
                    getWorld().setWall(this.getX() / 16, this.getY() / 16, true);
                    getWorld().setWall((this.getX() + 16) / 16, this.getY() / 16, true);    
                }            

            
            //get list of observers
            if(this.getType().equals("1")){
            for(Actor actor : getWorld())
            {
                if(actor != this && ((AbstractActor) actor).getType().equals("1")){
                    addObserver((Observer)actor);
                }
            }
            }
            if(this.getType().equals("2")){
            for(Actor actor : getWorld())
            {
                if(actor != this && ((AbstractActor) actor).getType().equals("2")){
                    addObserver((Observer)actor);
                }
            }            
            }  
            if(this.getType().equals("3")){
            for(Actor actor : getWorld())
            {
                if(actor != this && ((AbstractActor) actor).getType().equals("3")){
                    addObserver((Observer)actor);
                }
            }            
            }             
            if(this.getType().equals("4")){
            for(Actor actor : getWorld())
            {
                if(actor != this && (((AbstractActor) actor).getType().equals("4") || ((AbstractActor) actor).getType().equals("4.5"))){
                    addObserver((Observer)actor);
                }
            }            
            }  
            if(this.getType().equals("5")){
            for(Actor actor : getWorld())
            {
                if(actor != this && (((AbstractActor) actor).getType().equals("5") || ((AbstractActor) actor).getType().equals("4.5"))){
                    addObserver((Observer)actor);
                }
            }            
            }            
            if(this.getType().equals("6")){
            for(Actor actor : getWorld())
            {
                if(actor != this && ((AbstractActor) actor).getType().equals("6")){
                    addObserver((Observer)actor);
                }
            }            
            }        
            if(this.getType().equals("8")){
            for(Actor actor : getWorld())
            {
                if(actor != this && ((AbstractActor) actor).getType().equals("8")){
                    addObserver((Observer)actor);
                }
            }            
            }               
            initialCycle = false;
        }
        if(!observersToBeRemoved.isEmpty()){
        for(Observer o : observersToBeRemoved){
            listOfObservers.remove(o);
        }
        observersToBeRemoved.clear();
        }
        
        
    }
    

    
    
}
