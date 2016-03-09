/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import java.util.HashSet;
import java.util.Set;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.items.Hammer;

/**
 *
 * @author jmorvay
 */
public class BrokenFan extends Fan implements Repairable,Trigger {
    private boolean broken;
    Set <Observer> listOfObservers = new HashSet<> ();
    private boolean initialCycle;    

    public BrokenFan()
    {
        super();
        normalAnimation.stop();
        broken = true;
        initialCycle = true;
    }
    
    public boolean isBroken()
    {
        return broken;
    }
    

    @Override
    public void repair(Actor actor) {
        if(actor instanceof Hammer)
        {
        this.broken = false;
        normalAnimation.start();
        for(Observer o : listOfObservers){
            o.giveNotice();
        }     
        }
    }

    public void addObserver(Observer o){
        listOfObservers.add(o);
    }
    
    public void removeObserver(Observer o){
        listOfObservers.remove(o);
    } 
    
    public void act(){
        if(initialCycle){
            //get list of observers
            if(this.getType().equals("5.1")){
            for(Actor actor : getWorld())
            {
                if(actor != this && ((AbstractActor) actor).getType().equals("5.2")){
                    addObserver((Observer)actor);
                }
            }
            }
            initialCycle = false;
        }
    }
    
    
}
