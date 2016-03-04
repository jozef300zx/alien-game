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
public class BlackTile20x12 extends BlackTile{
    public BlackTile20x12(){
        normalAnimation = new Animation("resources/sprites/black_tile_20x12.png",320,192,100);
        setAnimation(normalAnimation);     
    }    
    
}
