/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;

/**
 *
 * @author admin
 */
public class LargeExplosion extends SmallExplosion{
    private int timer;
    
        public LargeExplosion(){
        normalAnimation = new Animation("resources/sprites/large_explosion.png",32,32,5);
        setAnimation(normalAnimation);
        timer = 5;
       
    }  
}

