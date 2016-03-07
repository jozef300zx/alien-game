/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.weapons;

import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author admin
 */
public class RegularGun implements Gun {
    Ripley ripley;
    
    public RegularGun(Ripley ripley){
        this.ripley = ripley;
    }

    @Override
    public void shoot() {
            Bullet bullet = new Bullet(ripley.getX(),ripley.getY(),ripley.getAnimation().getRotation());
            bullet.setPosition(ripley.calculateX(bullet, false), ripley.calculateY(bullet, false));
            if(ripley.getAmmo() > 0){
            ripley.getWorld().addActor(bullet);
            ripley.setAmmo(ripley.getAmmo() - 1);
            }        
    }
    
}
