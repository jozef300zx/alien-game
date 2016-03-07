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
public class BlackTile11x9 extends BlackTile{
    public BlackTile11x9(){
        normalAnimation = new Animation("resources/sprites/black_tile_11x9.png",176,144,100);
        setAnimation(normalAnimation);     
    }    
    
}
