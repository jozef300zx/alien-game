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
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author admin
 */
public class Energy extends AbstractActor implements Item {
 Ripley ripley;
 Animation normalAnimation;
 
    public Energy()
    {
        normalAnimation = new Animation("resources/sprites/energy.png",16,16,100);
        setAnimation(normalAnimation);
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
        
        if(this.intersects(ripley) && ripley.getHealth() < 100)
        {
            ripley.setHealth(100);
            getWorld().removeActor(this);
        }
    }
}
