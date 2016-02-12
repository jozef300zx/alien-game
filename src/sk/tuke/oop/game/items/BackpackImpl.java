/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.items;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import sk.tuke.oop.framework.Backpack;
import sk.tuke.oop.framework.Item;

/**
 *
 * @author jmorvay
 */
public class BackpackImpl implements Backpack{
    int capacity;
    public List<Item> items = new ArrayList<>(); 
    Iterator<Item> iterator = items.iterator();
    
    
    public BackpackImpl(int capacity)
    {
        this.capacity = capacity;
    }

    @Override
    public void add(Item item) {
        if(items.size() < this.capacity)
        {
        items.add(0, item);
        }
        else
        {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public void remove(Item item) {

        if(items.isEmpty() || !items.contains(item))
            {
            throw new NoSuchElementException();  
            }
        else
            {
            items.remove(item);
            }
    }

    @Override
    public Iterator<Item> iterator() {
        return this.iterator;
    }
    
    public Item getLastItem()
    {
        return items.get(0);
    }
    
}
