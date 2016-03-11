/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import java.util.HashSet;
import java.util.Set;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.alien.Active;
import sk.tuke.oop.game.actors.alien.Alien;
import sk.tuke.oop.game.actors.ripley.Ripley;
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
        Alien alien;
        Alien alien2;
        alien = new Alien();
        alien.setState(new Active(alien));
        alien2 = new Alien();
        alien2.setState(new Active(alien2));
        
        if(this.getType().equals("5.11")){
        alien2.setPosition(960, 400);           
        alien.setPosition(1184, 240);        
        }
        if(this.getType().equals("5.12")){
        alien2.setPosition(960, 624);           
        alien.setPosition(960, 784);        
        }
        if(this.getType().equals("5.13")){
        alien2.setPosition(1376, 240);           
        alien.setPosition(1568, 240);        
        }
        if(this.getType().equals("5.14")){
        alien2.setPosition(1440, 864);           
        alien.setPosition(1568, 864);        
        }        
        
        getWorld().addActor(alien);
        getWorld().addActor(alien2);

        
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
            for(Actor actor : getWorld())
            {
                if(((AbstractActor) actor).getType().equals("5.2")){
                    addObserver((Observer)actor);
                }
                
                if(actor != this && this.getType().equals("5.11") && ((AbstractActor) actor).getType().equals("5.11")){
                    addObserver((Observer)actor);
                }
                if(actor != this && this.getType().equals("5.12") && ((AbstractActor) actor).getType().equals("5.12")){
                    addObserver((Observer)actor);
                }
                if(actor != this && this.getType().equals("5.13") && ((AbstractActor) actor).getType().equals("5.13")){
                    addObserver((Observer)actor);
                }
                if(actor != this && this.getType().equals("5.14") && ((AbstractActor) actor).getType().equals("5.14")){
                    addObserver((Observer)actor);
                }                                
            }
            
            initialCycle = false;
        }
    }
    
    
}
