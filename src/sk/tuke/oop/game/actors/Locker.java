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
import sk.tuke.oop.game.items.Money;
import sk.tuke.oop.game.items.Wrench;

/**
 *
 * @author jmorvay
 */
public class Locker extends AbstractActor implements Usable {
    private BackpackImpl backpack;
    DropItem dropItem;
    boolean used;
    
    public Locker(){
        normalAnimation = new Animation("resources/sprites/locker.png",16,16,100);
        setAnimation(normalAnimation);
        this.backpack = new BackpackImpl(1);
        this.backpack.add(new Hammer());
        this.used = false;
    }    

    @Override
    public void use(Actor actor) {
        int backpackSize = this.backpack.items.size();
        if(!used)
        {
        for(int i = 0; i < backpackSize; i++)
        {
            dropItem = new DropItem(backpack, world, this.getX() + (this.backpack.getLastItem().getWidth() +1), this.getY());
            dropItem.Execute();
        }
        used = true;
        }
    }
    
}
