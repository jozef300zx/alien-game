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
public class BlackTile30x27 extends BlackTile{
    public BlackTile30x27(){
        normalAnimation = new Animation("resources/sprites/black_tile_30x27.png",480,432,100);
        setAnimation(normalAnimation);     
    }    
    
}
