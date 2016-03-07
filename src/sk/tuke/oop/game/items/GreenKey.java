/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Usable;
import sk.tuke.oop.game.actors.openables.LockedDoor;
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author jmorvay
 */
public class GreenKey extends AbstractActor implements Usable,Item{
    Ripley ripley;
    public GreenKey(){
        normalAnimation = new Animation("resources/sprites/green_key.png",16,16,100);
        setAnimation(normalAnimation);
    }    
    
    
    public void use(Actor actor) {
        if(actor instanceof LockedDoor && ((LockedDoor)actor).isLocked()){
            ((LockedDoor)actor).unlock();
            for (Actor ripley : getWorld()){
                if(ripley instanceof Ripley){
                    ((Ripley) ripley).getBackpack().items.remove(this);
                }
            
            }
        }
    }

    public void act()
    {
        if(ripley == null)
        {
        for (Actor actor : getWorld())
        {
            if(actor instanceof Ripley)
            {
                this.ripley = (Ripley) actor;
            }
        }
        }
        
        if(this.intersects(ripley))
        {
            ripley.getBackpack().add(this);
            getWorld().removeActor(this);
        }
    }    
}
