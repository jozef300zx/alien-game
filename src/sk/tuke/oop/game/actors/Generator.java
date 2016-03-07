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
public class Generator extends AbstractActor{
    Generator()
    {
        normalAnimation = new Animation("resources/sprites/generator.png",32,48,100);
        setAnimation(normalAnimation);
        normalAnimation.setRotation(90);
        normalAnimation.start();
    }    
    
}
