    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;

/**
 *
 * @author jmorvay
 */
public class AlienMother extends AbstractCharacter {
    
    public AlienMother()
    {
        normalAnimation = new Animation("resources/sprites/mother.png",112,162,200);
        normalAnimation.setPingPong(true);
        setAnimation(normalAnimation);
        setHealth(200);
    }
    
}
