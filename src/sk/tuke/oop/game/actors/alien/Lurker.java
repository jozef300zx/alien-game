/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.alien;

import sk.tuke.oop.framework.Animation;

/**
 *
 * @author jmorvay
 */
public class Lurker extends Alien{
    
    public Lurker()
    {
        normalAnimation = new Animation("resources/sprites/lurker_alien.png",32,32,100);
        normalAnimation.setPingPong(true);
        setAnimation(normalAnimation);
        setHealth(5);
        setState(new Active(this));
        setStep(3);
    }    
    
}
