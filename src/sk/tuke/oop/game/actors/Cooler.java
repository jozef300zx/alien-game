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
public class Cooler extends AbstractActor {
    public Cooler()
    {
        normalAnimation = new Animation("resources/sprites/fan.png",32,32,200);
        setAnimation(normalAnimation);
        normalAnimation.start();
    }    
    
}
