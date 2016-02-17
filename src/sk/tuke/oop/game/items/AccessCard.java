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
import sk.tuke.oop.game.actors.Door;
import sk.tuke.oop.game.actors.Ripley;
import sk.tuke.oop.game.actors.Usable;

/**
 *
 * @author jmorvay
 */
public class AccessCard extends AbstractActor implements Usable,Item{
    
    public AccessCard(){
        normalAnimation = new Animation("resources/sprites/key.png",16,16,100);
        setAnimation(normalAnimation);
    }

    @Override
    public void use(Actor actor) {
        if(actor instanceof Door && ((Door)actor).isLocked()){
            ((Door)actor).setLock(false);
            for (Actor ripley : getWorld()){
                if(ripley instanceof Ripley){
                    ((Ripley) ripley).getBackpack().items.remove(this);
                }
            
            }
        }
    }
    
}
