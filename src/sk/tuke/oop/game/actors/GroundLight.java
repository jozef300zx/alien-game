/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;

/**
 *
 * @author jmorvay
 */
public class GroundLight extends AbstractActor implements Switchable, Observer{
    private boolean turnedOn;
    private Animation offAnimation;
    
    public GroundLight(){
        offAnimation = new Animation("resources/sprites/button_red.png",16,16,100);
        setAnimation(offAnimation);
    }     

    @Override
    public void turnOn() {
        normalAnimation = new Animation("resources/sprites/button_green.png",16,16,100);
        setAnimation(normalAnimation);        
    }

    @Override
    public void turnOff() {
    }

    @Override
    public boolean isOn() {
        return this.turnedOn;
    }

    @Override
    public void giveNotice(Trigger trigger) {
        turnOn();
    }
    
}
