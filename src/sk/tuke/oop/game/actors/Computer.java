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
public class Computer extends AbstractActor{
    
    public Computer(){
        normalAnimation = new Animation("resources/sprites/computer.png",80,48,150);
        normalAnimation.setLooping(true);
        setAnimation(normalAnimation);
    }
    
}
