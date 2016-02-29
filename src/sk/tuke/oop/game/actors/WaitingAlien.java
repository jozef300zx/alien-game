/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

/**
 *
 * @author jmorvay
 */
public class WaitingAlien extends Alien implements Observer{

    public WaitingAlien(){
        super();
        setState(new Waiting(this));
    }
    @Override
    public void giveNotice() {
        if(!(getState() instanceof Active)){
        setState(new Active(this));
        } else {
        setState(new Waiting(this));
        }
        
        
        
    }
    
}
