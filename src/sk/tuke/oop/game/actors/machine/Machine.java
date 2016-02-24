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
import sk.tuke.oop.game.actors.Explosion;
import sk.tuke.oop.game.actors.openables.LockedDoor;

/**
 *
 * @author jmorvay
 */
public class Machine extends AbstractActor {
    private AbstractMachineState state;
    LockedDoor frontDoor;
    LockedDoor backDoor;
    List<Explosion> bombs = new ArrayList<> ();
    
    public Machine(){
        normalAnimation = new Animation("resources/sprites/invisible.png",16,16,100);
        setAnimation(normalAnimation);
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
    if(this.state instanceof Running){
        setState(getState().leverRetracted());
        System.out.println("leverRetracted");
      
    
    backDoor.unlock();
    backDoor.open();
    frontDoor.unlock();
    frontDoor.open();    
    }
}
 
public void act(){
    
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
            
            if(Math.random() < 0.2) {
                Explosion bomb = new Explosion();
                bomb.setPosition((int) (80 + 96 * Math.random()), (int) (64 + 80 * Math.random()));
                bombs.add(bomb);
            }
            
            for (Explosion explosion : bombs){
                getWorld().addActor(explosion);
                explosion.explode();
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
