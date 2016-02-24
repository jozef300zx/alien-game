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
public class Explosion extends AbstractActor{
    
        public Explosion(){
        normalAnimation = new Animation("resources/sprites/small_explosion.png",16,16,100);
        setAnimation(normalAnimation);
       
    }  
    
        public void explode(){
            normalAnimation.start();
        }
}
