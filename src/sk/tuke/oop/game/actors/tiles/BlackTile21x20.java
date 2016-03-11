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
public class BlackTile21x20 extends BlackTile{
        public BlackTile21x20(){
        normalAnimation = new Animation("resources/sprites/black_tile_21x20.png",336,320,100);
        setAnimation(normalAnimation);     
    }
    
}
