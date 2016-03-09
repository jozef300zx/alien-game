/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.alien.Lurker;
import sk.tuke.oop.game.actors.alien.LurkerSpawn;
import sk.tuke.oop.game.commands.DropItem;
import sk.tuke.oop.game.items.BackpackImpl;
import sk.tuke.oop.game.items.Hammer;

/**
 *
 * @author admin
 */
public class Body extends AbstractActor implements Usable,Observer{
    private final BackpackImpl backpack;
    DropItem dropItem;
    boolean used;
    private int timer;
    private boolean spawn;    
    LurkerSpawn lurkerSpawn;      
    private boolean initialCycle;
    
    public Body(boolean horizontal)
    {
        normalAnimation = new Animation("resources/sprites/body.png",64,48,100);
        setAnimation(normalAnimation);
        if(!horizontal) {
            getAnimation().setRotation(270);
        }
        this.backpack = new BackpackImpl(3);
        this.used = false;     
        initialCycle = true;
        timer = 60;
    }
    

    @Override
    public void use(Actor actor) {
        int backpackSize = this.backpack.items.size();
        if(!used)
        {
        for(int i = 0; i < backpackSize; i++)
        {
            dropItem = new DropItem(backpack, getWorld(),getX() + getWidth(),getY());
            dropItem.Execute();
        }
        used = true;
        }
    }
    
    public void act(){
        if(initialCycle){
            if(getType().equals("hammer")){   
            this.backpack.add(new Hammer());
            }
            initialCycle = false;
        }
        if(spawn && timer >= 1){
            
            if(timer % 60 == 0){
                lurkerSpawn  = new LurkerSpawn();
                lurkerSpawn.setPosition(this.getX(), this.getY());
                getWorld().addActor(lurkerSpawn);
                lurkerSpawn.getAnimation().start();
            }            
            
            if(timer == 1){
                getWorld().removeActor(lurkerSpawn);
                Lurker lurker  = new Lurker();
                lurker.setPosition(this.getX()+ 16, this.getY() + 16);
                getWorld().addActor(lurker);
                spawn = false;
            }
                timer--;
            
        }        

    }

    @Override
    public void giveNotice() {
        spawn = true;

    }

    @Override
    public void giveNotice(Trigger trigger) {
    }
    
}
