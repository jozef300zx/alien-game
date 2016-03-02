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
public class LaserGunDecorator extends GunDecorator{
    
    public LaserGunDecorator(Gun decoratedGun, Ripley ripley) {
        super(decoratedGun, ripley);
    }
    
    public void shoot(){
            LaserBeam laserBeam = new LaserBeam(ripley.getX(),ripley.getY(),ripley.getAnimation().getRotation());
            laserBeam.setPosition(ripley.calculateX(laserBeam, true), ripley.calculateY(laserBeam, true));
            if(ripley.getAmmo() > 0){
            ripley.getWorld().addActor(laserBeam);
            ripley.setAmmo(ripley.getAmmo() - 1);
            }
    }    
    
}
