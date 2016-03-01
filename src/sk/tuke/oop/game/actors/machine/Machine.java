/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.machine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.SmallExplosion;
import sk.tuke.oop.game.actors.openables.LockedDoor;

/**
 *
 * @author jmorvay
 */
public class Machine extends AbstractActor {
    private AbstractMachineState state;
    LockedDoor frontDoor;
    LockedDoor backDoor;
    int runningStateTimer;
    
    
    public Machine(){
        normalAnimation = new Animation("resources/sprites/invisible.png",16,16,100);
        setAnimation(normalAnimation);
        runningStateTimer = 500;
    }
    
public void floorSwitchActivated(){
    
    if(this.state instanceof Waiting){
        setState(getState().floorSwitchActivated());
        System.out.println("floorSwitchActivated");
       
    
    frontDoor.close();
    frontDoor.lock();
    backDoor.close();
    backDoor.lock();
    }
}
 
public void wallSwitchActivated(){
    if(this.state instanceof Waiting || this.state instanceof Locked){
        setState(getState().wallSwitchActivated());
        System.out.println("wallSwitchActivated");
       
    
    frontDoor.close();
    frontDoor.lock();
    backDoor.close();
    backDoor.lock();    
    }
}
 
public void leverRetracted(){
    List<Actor> toRemove = new ArrayList<> ();
    if(this.state instanceof Running){
        setState(getState().leverRetracted());
        System.out.println("leverRetracted");
      
    
    backDoor.unlock();
    backDoor.open();
    frontDoor.unlock();
    frontDoor.open();    
    
    for (Actor actor : getWorld()){
        if(actor instanceof SmallExplosion){
            toRemove.add(actor);
        }
    }
            
    for (Actor actor : toRemove){
        getWorld().removeActor(actor);
    }
    
    }
}
 
public void act(){
        List<Actor> toRemove = new ArrayList<> ();
    
        if (frontDoor == null){
            Iterator<Actor> iterator = getWorld().iterator();
            do {
            frontDoor = (LockedDoor) ((AbstractActor)iterator.next()).getActorByName("front door");            
            } while (frontDoor == null);  
        }
        
        if (backDoor == null){
            Iterator<Actor> iterator = getWorld().iterator();
            do {
            backDoor = (LockedDoor) ((AbstractActor)iterator.next()).getActorByName("back door");            
            } while (backDoor == null);  
        }       
        
        if(frontDoor.isOpen() && this.state == null ){
            backDoor.unlock();
            backDoor.open();
                this.setState(new Waiting());
                System.out.println("waiting");
            
        }
        
        if(this.state instanceof Running){
            
            if(Math.random() < 0.02) {
                SmallExplosion explosion = new SmallExplosion();
                explosion.setPosition((int) (80 + 96 * Math.random()), (int) (64 + 80 * Math.random()));
                getWorld().addActor(explosion);
                explosion.explode();
            }
            
            for (Actor actor : getWorld()){
                if(actor instanceof SmallExplosion){
                    ((SmallExplosion) actor).setTimer(((SmallExplosion) actor).getTimer() - 1);
                    if(((SmallExplosion) actor).getTimer() == 0){
                        toRemove.add(actor);
                    }
                }
            }
            
            for (Actor actor : toRemove){
                getWorld().removeActor(actor);
            }
            
        runningStateTimer -= 1;
        if(runningStateTimer == 0){
            leverRetracted();
        }            
            
        }


}    

    public AbstractMachineState getState() {
        return state;
    }

    public void setState(AbstractMachineState state) {
        this.state = state;
    }
}
