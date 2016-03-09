/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.tiles;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Observer;
import sk.tuke.oop.game.actors.Trigger;

/**
 *
 * @author jmorvay
 */
public class BlackTile extends AbstractActor implements Observer{
    public BlackTile(){
        normalAnimation = new Animation("resources/sprites/black_tile.png",16,16,100);
        setAnimation(normalAnimation);     
    }

    @Override
    public void giveNotice(Trigger trigger) {
        getWorld().removeActor(this);
    }

    @Override
    public void giveNotice() {
    }

}
