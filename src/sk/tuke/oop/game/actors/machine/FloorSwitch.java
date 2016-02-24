/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.machine;

import java.util.Iterator;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;

/**
 *
 * @author jmorvay
 */
public class FloorSwitch extends AbstractActor{
    private Machine machine;
    
    public FloorSwitch(){
        normalAnimation = new Animation("resources/sprites/floor_switch.png",16,16,100);
        setAnimation(normalAnimation);   
        machine = null;
    }
    
    public void act(){
        if (machine == null){
            Iterator<Actor> iterator = getWorld().iterator();
            do {
            machine = (Machine) ((AbstractActor)iterator.next()).getActorByName("machine");            
            } while (machine == null);            
        }
        
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }
    
}
