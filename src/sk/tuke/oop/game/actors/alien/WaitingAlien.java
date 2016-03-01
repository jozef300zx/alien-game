/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.alien;

import sk.tuke.oop.game.actors.Observer;
import sk.tuke.oop.game.actors.openables.Door;

/**
 *
 * @author jmorvay
 */
public class WaitingAlien extends Alien implements Observer{
    private Door door;
    
    public WaitingAlien(){
        super();
        setState(new Waiting(this));
    }
    @Override
    public void giveNotice() {
        if(!(getState() instanceof Active)){
        setState(new Active(this));
        } else {
        setState(new Waiting(this));
        }
        
    }
    
    @Override
    public void act(){
        getState().act();
        if(getHealth() == 0)
        getDoor().removeObserver(this);
    }

    /**
     * @return the door
     */
    public Door getDoor() {
        return door;
    }

    /**
     * @param door the door to set
     */
    public void setDoor(Door door) {
        this.door = door;
    }
    
}
