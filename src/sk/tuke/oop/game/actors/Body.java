/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.commands.DropItem;
import sk.tuke.oop.game.items.BackpackImpl;
import sk.tuke.oop.game.items.Hammer;
import sk.tuke.oop.game.items.Money;
import sk.tuke.oop.game.items.Wrench;

/**
 *
 * @author admin
 */
public class Body extends AbstractActor implements Usable{
    private final BackpackImpl backpack;
    DropItem dropItem;
    boolean used;
    
    public Body()
    {
        normalAnimation = new Animation("resources/sprites/body.png",64,48,100);
        setAnimation(normalAnimation);
        this.backpack = new BackpackImpl(3);
        this.backpack.add(new Hammer());
        this.backpack.add(new Money());
        this.backpack.add(new Wrench());
        this.used = false;
    }
    

    @Override
    public void use(Actor actor) {
        int backpackSize = this.backpack.items.size();
        if(!used)
        {
        //for(Item item : backpack)
        for(int i = 0; i < backpackSize; i++)
        {
            dropItem = new DropItem(backpack, world, this.getX(), this.getY() - (this.backpack.getLastItem().getHeight() +1));
            dropItem.Execute();
        }
        used = true;
        }
    }
    
}
