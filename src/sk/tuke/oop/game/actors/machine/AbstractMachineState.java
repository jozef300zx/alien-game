/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.machine;

/**
 *
 * @author jmorvay
 */
public abstract class AbstractMachineState {
    
    
public AbstractMachineState floorSwitchActivated(){
    return this;
}
 
public AbstractMachineState wallSwitchActivated(){
    return this;
}
 
public AbstractMachineState leverRetracted(){
    return this;
}
 
public AbstractMachineState act(){
    return this;
}    
}
