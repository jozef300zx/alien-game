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
import sk.tuke.oop.game.actors.alien.Active;
import sk.tuke.oop.game.actors.alien.Alien;
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
                        

            if(this.getType().equals("4.1")){
            for(Actor actor : getWorld())
            {
                if(!(actor instanceof InvisibleTile) && ((AbstractActor) actor).getType().equals("4.1")){
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
            o.giveNotice();
            }
            giveNoticeOnce = false;
        }
            if(this.getType().equals("3.1")){
                Alien alien = null;
                Alien alien2 = null;
            for(Actor actor : getWorld())
            {
                if(actor instanceof Ripley && actor.intersects(this)){
                    alien = new Alien();
                    alien.setState(new Active(alien));
                    alien.setPosition(1456, 1232);
                    alien2 = new Alien();
                    alien2.setState(new Active(alien2));
                    alien2.setPosition(1552, 1232);   
                    
                }
            }
            if(alien != null && alien2 != null){
            getWorld().addActor(alien);
            getWorld().addActor(alien2);
            getWorld().removeActor(this);
            }
            }         
    }
    
    
    public void addObserver(Observer o){
        listOfObservers.add(o);
    }
    
    public void removeObserver(Observer o){
        listOfObservers.remove(o);
    } 
    
}
