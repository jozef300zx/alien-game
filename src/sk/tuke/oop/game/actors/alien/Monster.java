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
public class Monster extends Alien {
    public Monster()
    {
        normalAnimation = new Animation("resources/sprites/monster_2.png",78,127,100);
        normalAnimation.setPingPong(true);
        setAnimation(normalAnimation);
        setHealth(300);
        setState(new Waiting(this));
        setStep(2);
    }    
    
}
