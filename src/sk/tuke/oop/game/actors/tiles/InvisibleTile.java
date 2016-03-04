/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.tiles;

import java.util.HashSet;
import java.util.Set;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Observer;
import sk.tuke.oop.game.actors.Trigger;
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author jmorvay
 */
public class InvisibleTile extends AbstractActor implements Trigger{
    Set <Observer> listOfObservers = new HashSet<> ();
    private boolean initialCycle;
    Actor ripley;
    private boolean giveNoticeOnce;
    
    public InvisibleTile(){
        normalAnimation = new Animation("resources/sprites/invisible.png",16,16,100);
        setAnimation(normalAnimation);    
        initialCycle = true;
        giveNoticeOnce = true;
    }    
    public void act(){
        if(initialCycle){         
            //get list of observers
            if(this.getType().equals("1.1")){
            for(Actor actor : getWorld())
            {
                if(!(actor instanceof InvisibleTile) && ((AbstractActor) actor).getType().equals("1.1")){
                    addObserver((Observer)actor);
                }
            }
            }
            
            for(Actor actor : getWorld()){
                if(actor instanceof Ripley){
                    this.ripley = actor;
                }
            }
            initialCycle = false;
        }
        
        if(this.intersects(ripley) && giveNoticeOnce)
        {
            for(Observer o : listOfObservers){
            o.giveNotice(this);
            }
            giveNoticeOnce = false;
        }
    }
    
    
    public void addObserver(Observer o){
        listOfObservers.add(o);
    }
    
    public void removeObserver(Observer o){
        listOfObservers.remove(o);
    } 
    
}
