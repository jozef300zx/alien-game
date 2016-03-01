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
public class EnergyWave extends Bullet{
    
    public EnergyWave(int x, int y, int rotation) {
        super(x, y, rotation);
        normalAnimation = new Animation("resources/sprites/energy_wave.png",16,16,100);
        normalAnimation.setRotation(rotation);
        setAnimation(normalAnimation);        
        damage = 20;        
    }
    
}
