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
public abstract class GunDecorator implements Gun{
    protected Gun decoratedGun;
    protected Ripley ripley;
    
    public GunDecorator(Gun decoratedGun, Ripley ripley){
        this.decoratedGun = decoratedGun;
        this.ripley = ripley;
    }
    
    public void shoot(){
        decoratedGun.shoot();
    }
}
