/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.darktiles;

import sk.tuke.oop.framework.Animation;

/**
 *
 * @author jmorvay
 */
public class BlackTile8x9 extends BlackTile{
    public BlackTile8x9(){
        normalAnimation = new Animation("resources/sprites/black_tile_8x9.png",128,144,100);
        setAnimation(normalAnimation);     
    }       
    
}
