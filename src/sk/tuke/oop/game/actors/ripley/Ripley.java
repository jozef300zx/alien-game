/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.ripley;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.actors.AbstractCharacter;
import sk.tuke.oop.game.actors.Cooler;
import sk.tuke.oop.game.actors.openables.Door;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.items.BackpackImpl;

/**
 *
 * @author admin
 */
public class Ripley extends AbstractCharacter implements Movable{
    private int ammo;
    int countdown;
    private BackpackImpl backpack;
    boolean poisoned;
    int gametime;
    RipleyState state;
    Running running;
    Dying dying;

    
    public Ripley()
    {
        normalAnimation = new Animation("resources/sprites/player.png",32,32,100);
        normalAnimation.setPingPong(true);
        setAnimation(normalAnimation);
        setHealth(100);
        this.ammo = 100;
        this.backpack = new BackpackImpl(10);
        running = new Running(this);
        dying = new Dying(this);
        poisoned = false;
        gametime = 0;
    }
    
    @Override
        public void act() {
        normalAnimation.stop();
        if(getHealth() > 0){
            state = running;
        } else {
            state = dying;
        }
        
        state.act();
        
        
        //running.act();
        //dying.act();
    }


    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    @Override
    public void addedToWorld(World world) {
        this.setWorld(world);
        this.getWorld().showBackpack(backpack);
        this.getWorld().centerOn(this);
        
    }
    
    public boolean isPoisoned(Cooler cooler, Door door) {
        return cooler.isBroken() && door.isOpen();
    }        
    
    public Cooler getCooler(){
        Cooler returnCooler = null;
        for(Actor actor : getWorld()){
            if(actor instanceof Cooler){
                returnCooler = (Cooler) actor;
            } 
        }
        return returnCooler;
    }
    
    public Door getDoor(){
        Door returnDoor = null;
        for(Actor actor : getWorld()){
            if(actor instanceof Door){
                returnDoor = (Door) actor;
            } 
        }
        return returnDoor;
    }  
    
    public void drawHealth(int time){
        if(isPoisoned(getCooler(),getDoor()) && (time % 10) == 0){
            setHealth(getHealth() - 2);
            if(getHealth() <= 0)
                setHealth(0);
            System.out.println(getHealth());
        }
    }
    

    
    public BackpackImpl getBackpack(){
        return this.backpack;
    }


}

    

    

