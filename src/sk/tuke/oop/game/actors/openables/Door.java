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
import sk.tuke.oop.game.actors.Usable;
import sk.tuke.oop.game.actors.WaitingAlien;

/**
 *
 * @author jmorvay
 */
public class Door extends AbstractActor implements Usable,Openable{
    boolean isOpen;
    private boolean locked;
    Set <Observer> listOfObersvers = new HashSet<> ();
    private boolean initialCycle;
    
    public Door(String name, boolean vertical) {
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
        this.setName(name);
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
        if(normalAnimation.getCurrentFrame() == 3)
            normalAnimation.stop();
        isOpen = true;
        if(getHeight() > getWidth()) {
        getWorld().setWall(this.getX() / 16, this.getY() / 16, false);
        getWorld().setWall(this.getX() / 16, (this.getY() + 16) / 16, false);
        }
        
        if(getWidth() > getHeight()) {
        getWorld().setWall(this.getX() / 16, this.getY() / 16, false);
        getWorld().setWall((this.getX() + 16) / 16, this.getY() / 16, false);    
        }
        
        
        for(Observer o : listOfObersvers){
            o.giveNotice();
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
        
        for(Observer o : listOfObersvers){
            o.giveNotice();
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
        listOfObersvers.add(o);
    }
    
    public void removeObserver(Observer o){
        listOfObersvers.remove(o);
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

            
            //get list of observing aliens
            if(this.getName().equals("front door")){
            for(Actor actor : getWorld())
            {
                if(actor instanceof WaitingAlien && ((AbstractActor) actor).getType().equals("waiting1")){
                    addObserver((Observer)actor);
                    ((WaitingAlien)actor).setDoor(this);
                }
            }
            }
            if(this.getName().equals("back door")){
            for(Actor actor : getWorld())
            {
                if(actor instanceof WaitingAlien && ((AbstractActor) actor).getType().equals("waiting2")){
                    addObserver((Observer)actor);
                    ((WaitingAlien)actor).setDoor(this);
                }
            }
            }            
            
        }
        
        initialCycle = false;
    }

    
    
}
