/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.Usable;

/**
 *
 * @author jmorvay
 */
public class LockedDoor extends Door implements Usable{
    boolean locked;

    public LockedDoor(boolean vertical) {
        super(vertical);
        locked = true;
    }

    @Override
    public void use(Actor actor) {
        
    }
    
    public void lock(){
        locked = true;
    }
    
    public void unlock(){
        locked = false;
    }
    
    public boolean isLocked() {
        return this.locked;
    }
    

    
}
