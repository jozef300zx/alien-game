/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.items.Hammer;

/**
 *
 * @author jmorvay
 */
public class BrokenFan extends AbstractActor implements Repairable {
    private boolean broken;

    public BrokenFan()
    {
        super();
        normalAnimation.stop();
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
        }
    }
    
    
    
}
