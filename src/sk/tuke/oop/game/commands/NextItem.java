/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.commands;

import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.items.BackpackImpl;

/**
 *
 * @author admin
 */
public class NextItem implements Command {
BackpackImpl backpack;
Item item;

    public NextItem(BackpackImpl backpack)
    {
        this.backpack = backpack;
    }
    @Override
    public void Execute() {
        this.item = this.backpack.getLastItem();
        this.backpack.remove(item);
        this.backpack.add(item);
    }
    
}
