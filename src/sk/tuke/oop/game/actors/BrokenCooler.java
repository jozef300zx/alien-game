/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import java.util.HashSet;
import java.util.Set;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.tiles.InvisibleTile;
import sk.tuke.oop.game.items.Wrench;

/**
 *
 * @author admin
 */
public class BrokenCooler extends Cooler implements Repairable,Trigger{
    private boolean broken;
    Set <Observer> listOfObservers = new HashSet<> ();
    Set <Observer> observersToBeRemoved = new HashSet<> ();    
    private boolean initialCycle;    

    
    public BrokenCooler()
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
        if(actor instanceof Wrench)
        {
        this.broken = false;
        normalAnimation.start();
        for(Observer o : listOfObservers){
            o.giveNotice(this);
        }        
        }
    }

    public void addObserver(Observer o){
        listOfObservers.add(o);
    }
    
    public void removeObserver(Observer o){
        observersToBeRemoved.add(o);
    }    
    
    public void act(){
        if(initialCycle){         
            //get list of observers
            for(Actor actor : getWorld())
            {
                if(((AbstractActor) actor).getType().equals("5.5")){
                    addObserver((Observer)actor);
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
