/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.commands.DropItem;
import sk.tuke.oop.game.items.BackpackImpl;
import sk.tuke.oop.game.items.Hammer;

/**
 *
 * @author admin
 */
public class Body extends AbstractActor implements Usable{
    private final BackpackImpl backpack;
    DropItem dropItem;
    boolean used;
    private boolean initialCycle;
    
    public Body(boolean vertical)
    {
        normalAnimation = new Animation("resources/sprites/body.png",64,48,100);
        setAnimation(normalAnimation);
        if(!vertical) {
            getAnimation().setRotation(270);
        }
        this.backpack = new BackpackImpl(3);
        this.used = false;     
        initialCycle = true;
    }
    

    @Override
    public void use(Actor actor) {
        int backpackSize = this.backpack.items.size();
        if(!used)
        {
        for(int i = 0; i < backpackSize; i++)
        {
            dropItem = new DropItem(backpack, getWorld(), this.getX(), this.getY() - (this.backpack.getLastItem().getHeight() +1));
            dropItem.Execute();
        }
        used = true;
        }
    }
    
    public void act(){
        if(initialCycle && getType().equals("hammer")){         
            this.backpack.add(new Hammer());
        }

    }
    
}
