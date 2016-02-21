/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.framework.Actor;

/**
 *
 * @author jmorvay
 */
public interface Openable {
    
    public  void open();
    public void close();
    boolean isOpen(Actor actor);
    
}
