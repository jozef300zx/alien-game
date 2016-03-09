/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import java.util.HashSet;
import java.util.Set;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;

/**
 *
 * @author jmorvay
 */
public class Reactor extends AbstractActor implements Observer,Trigger{
    private int fanCounter;
    private boolean isOn;
    private boolean initialCycle;
    Set <Observer> listOfObservers = new HashSet<> ();

    
    Reactor()
    {
        normalAnimation = new Animation("resources/sprites/reactor_hot.png",80,80,100);
        setAnimation(normalAnimation);
        normalAnimation.setPingPong(true);
        normalAnimation.start();
        fanCounter = 0;
        isOn = false;
        initialCycle = true;
    }     

    @Override
    public void giveNotice() {
        if(++fanCounter == 4){
        normalAnimation = new Animation("resources/sprites/reactor_on.png",80,80,150);
        setAnimation(normalAnimation);
        normalAnimation.setPingPong(true);
        normalAnimation.start();  
        isOn = true;
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
            if(this.getType().equals("5.2")){
            for(Actor actor : getWorld())
            {
                if(actor != this && (((AbstractActor) actor).getType().equals("5.3")) || ((AbstractActor) actor).getType().equals("5.4")){
                    addObserver((Observer)actor);
                }
            }
            }
            initialCycle = false;
        }
        if(isOn){
            for(Observer o : listOfObservers){
            o.giveNotice();
        }    
        isOn = false;
        }
            
    }

    @Override
    public void giveNotice(Trigger trigger) {
    }
}
