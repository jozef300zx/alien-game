/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.actors.weapons.EnergyGunDecorator;
import sk.tuke.oop.game.actors.weapons.LaserGunDecorator;

/**
 *
 * @author jmorvay
 */
public class GunUpgrade extends AbstractActor implements Item{
    Ripley ripley;
    
    public GunUpgrade(){
        normalAnimation = new Animation("resources/sprites/gun_upgrade.png",16,16,100);
        setAnimation(normalAnimation);
    }
    public void act()
    {
        if(ripley == null)
        {
        for (Actor actor : getWorld())
        {
            if(actor instanceof Ripley)
            {
                this.ripley = (Ripley) actor;
            } 
        }
        }
        
        if(this.intersects(ripley))
        {
            if(ripley.getGun() instanceof EnergyGunDecorator){
            ripley.setGun(new LaserGunDecorator(ripley.getGun(), ripley));
            } else {
            ripley.setGun(new EnergyGunDecorator(ripley.getGun(), ripley));
            }
            getWorld().removeActor(this);
        }
    }    
}
