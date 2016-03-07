/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.items.Hammer;
import sk.tuke.oop.game.items.Wrench;

/**
 *
 * @author admin
 */
public class BrokenCooler extends Cooler implements Repairable{
    private boolean broken;

    
    public BrokenCooler()
    {
        super();
        normalAnimation.stop();
        broken = true;
    }
    
    public boolean isBroken()
    {
        return broken;
    }

    @Override
    public void repair(Actor actor) {
        if(actor instanceof Wrench)
        {
        this.broken = false;
        normalAnimation.start();
        }
    }
    
}
