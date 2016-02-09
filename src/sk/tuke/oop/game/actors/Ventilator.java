/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;

/**
 *
 * @author jmorvay
 */
public class Ventilator extends AbstractActor implements Usable {
    private boolean switchedOn;

    public Ventilator()
    {
        normalAnimation = new Animation("resources/sprites/ventilator.png",32,32,100);
        setAnimation(normalAnimation);
    }
    @Override
    public void use(Actor actor) {
        if(this.switchedOn)
        {
            normalAnimation.stop();
        } else
        {
            normalAnimation.start();
        }
        
    }

    public boolean isSwitchedOn() {
        return switchedOn;
    }

    public void setSwitchedOn(boolean switchedOn) {
        this.switchedOn = switchedOn;
    }
    
    
    
}
