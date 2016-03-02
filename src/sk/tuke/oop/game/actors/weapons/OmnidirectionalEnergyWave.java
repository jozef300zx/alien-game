/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.weapons;

import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author jmorvay
 */
public class OmnidirectionalEnergyWave implements Gun{
    Ripley ripley;
    
    public OmnidirectionalEnergyWave(Ripley ripley){
        this.ripley = ripley;
    }

    @Override
    public void shoot() {
            EnergyWave wave1 = new EnergyWave(ripley.getX(),ripley.getY(),0);
            EnergyWave wave2 = new EnergyWave(ripley.getX(),ripley.getY(),45);
            EnergyWave wave3 = new EnergyWave(ripley.getX(),ripley.getY(),90);
            EnergyWave wave4 = new EnergyWave(ripley.getX(),ripley.getY(),135);
            EnergyWave wave5 = new EnergyWave(ripley.getX(),ripley.getY(),180);
            EnergyWave wave6 = new EnergyWave(ripley.getX(),ripley.getY(),225);
            EnergyWave wave7 = new EnergyWave(ripley.getX(),ripley.getY(),270);
            EnergyWave wave8 = new EnergyWave(ripley.getX(),ripley.getY(),315);
            wave1.setPosition(ripley.calculateX(wave1,false), ripley.calculateY(wave1,false));
            wave2.setPosition(ripley.calculateX(wave2,false), ripley.calculateY(wave2,false));
            wave3.setPosition(ripley.calculateX(wave3,false), ripley.calculateY(wave3,false));
            wave4.setPosition(ripley.calculateX(wave4,false), ripley.calculateY(wave4,false));
            wave5.setPosition(ripley.calculateX(wave5,false), ripley.calculateY(wave5,false));
            wave6.setPosition(ripley.calculateX(wave6,false), ripley.calculateY(wave6,false));
            wave7.setPosition(ripley.calculateX(wave7,false), ripley.calculateY(wave7,false));
            wave8.setPosition(ripley.calculateX(wave8,false), ripley.calculateY(wave8,false));
            
            if(ripley.getPulse()> 0){
            ripley.getWorld().addActor(wave1);
            ripley.getWorld().addActor(wave2);
            ripley.getWorld().addActor(wave3);
            ripley.getWorld().addActor(wave4);
            ripley.getWorld().addActor(wave5);
            ripley.getWorld().addActor(wave6);
            ripley.getWorld().addActor(wave7);
            ripley.getWorld().addActor(wave8);
            
            ripley.setPulse(ripley.getPulse() - 1);
            }        
    }
    
}
