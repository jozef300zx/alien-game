/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Message;
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author jmorvay
 */
public class Teleport extends AbstractActor implements  Observer{
    private Teleport destinationTeleport;
    private boolean teleported;
    private boolean poweredOn;
    private Ripley ripley;
    
    Teleport()
    {
        normalAnimation = new Animation("resources/sprites/teleport.png",64,64,100);
        setAnimation(normalAnimation);
        setPoweredOn(true);
    }
    
    public void teleportPlayer()
    {

        if(!isTeleported() && this.destinationTeleport != null && ripley.getX() + ripley.getWidth() < this.getX() + this.getWidth() && ripley.getX() > this.getX() && ripley.getY() > this.getY() && ripley.getY() + ripley.getHeight() < this.getY() + this.getHeight())
        {
            ripley.setPosition(this.destinationTeleport.getX() + 16, this.destinationTeleport.getY() + 16);
            this.destinationTeleport.setTeleported(true);
        }
    }
    
    public void resetTeleport()
    {
        if(this.isTeleported() && !(ripley.intersects(this)))
        {
            this.setTeleported(false);
        }   
    }
    
    public void act()
    {
        if(ripley == null || destinationTeleport == null){
            for(Actor actor : getWorld()){
                if(actor instanceof Ripley){
                    ripley = (Ripley) actor;
                }
                if(actor instanceof Teleport && actor != this){
                    destinationTeleport = (Teleport) actor;
                }
            }
        }
        
        if(ripley.intersects(this)){
        if(!isPoweredOn()){
            getWorld().showMessage(new Message("The teleport requires power to work...",100, 10));
        } else {
            teleportPlayer(); 
        }
        }
        
        resetTeleport();
    }

    public boolean isPoweredOn() {
        return poweredOn;
    }

    public void setPoweredOn(boolean poweredOn) {
        this.poweredOn = poweredOn;
    }

    public boolean isTeleported() {
        return teleported;
    }

    public void setTeleported(boolean teleported) {
        this.teleported = teleported;
    }

    @Override
    public void giveNotice(Trigger trigger) {
    }

    @Override
    public void giveNotice() {
        setPoweredOn(true);
    }
    
}
