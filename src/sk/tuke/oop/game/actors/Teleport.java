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
public class Teleport extends AbstractActor{
    private Teleport destinationTeleport;
    private boolean teleported;
    private boolean poweredOn;
    private Ripley ripley;
    
    Teleport()
    {
        normalAnimation = new Animation("resources/sprites/teleport.png",64,64,100);
        setAnimation(normalAnimation);
        setPoweredOn(false);
    }
    
    public void teleportPlayer()
    {

        if(this.isTeleported() == false && this.destinationTeleport != null && ripley.getX() < this.getX() + this.getWidth() && ripley.getX() + ripley.getWidth() > this.getX() && ripley.getY() < this.getY() + this.getHeight() && ripley.getY() + ripley.getHeight() > this.getY())
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
                if(actor instanceof Teleport && ((AbstractActor)actor).getType().equals("teleport 1") && actor != this){
                    destinationTeleport = (Teleport) actor;
                }
            }
        }
        
        
        if(!isPoweredOn() && ripley.intersects(this)){
            getWorld().showMessage(new Message("The teleport requires power to work...",100, 10));
        } else {
     this.teleportPlayer();   
     this.resetTeleport();
        }
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
    
}
