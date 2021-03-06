/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.weapons;

import sk.tuke.oop.framework.Animation;

/**
 *
 * @author jmorvay
 */
public class EnergyBullet extends Bullet{
    
    public EnergyBullet(int x, int y, int rotation) {
        super(x, y, rotation);
        normalAnimation = new Animation("resources/sprites/energy_bullet.png",16,16,100);
        normalAnimation.setPingPong(true);
        normalAnimation.setRotation(rotation);
        setAnimation(normalAnimation);    
        setDamage(10);
    }
    
    
}
