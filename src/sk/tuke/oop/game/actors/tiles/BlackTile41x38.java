/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.tiles;

import sk.tuke.oop.framework.Animation;

/**
 *
 * @author jmorvay
 */
public class BlackTile41x38 extends BlackTile{
    public BlackTile41x38(){
        normalAnimation = new Animation("resources/sprites/black_tile_41x38.png",656,608,100);
        setAnimation(normalAnimation);     
    }
    
}
