/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.weapons;

import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author jmorvay
 */
public class EnergyGunDecorator extends GunDecorator{

    public EnergyGunDecorator(Gun decoratedGun, Ripley ripley) {
        super(decoratedGun, ripley);
    }
    

    
    public void shoot(){
            EnergyBullet energyBullet = new EnergyBullet(ripley.getX(),ripley.getY(),ripley.getAnimation().getRotation());
            energyBullet.setPosition(ripley.calculateX(energyBullet, true), ripley.calculateY(energyBullet, true));
            if(ripley.getAmmo() > 0){
            ripley.getWorld().addActor(energyBullet);
            ripley.setAmmo(ripley.getAmmo() - 1);
            }
    }
    
}
