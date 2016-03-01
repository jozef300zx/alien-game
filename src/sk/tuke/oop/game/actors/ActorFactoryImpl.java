/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.ActorFactory;
import sk.tuke.oop.game.actors.machine.FloorSwitch;
import sk.tuke.oop.game.actors.machine.Lever;
import sk.tuke.oop.game.actors.machine.Machine;
import sk.tuke.oop.game.actors.machine.WallSwitch;
import sk.tuke.oop.game.actors.openables.ExitDoor;
import sk.tuke.oop.game.actors.openables.LockedDoor;
import sk.tuke.oop.game.items.AccessCard;
import sk.tuke.oop.game.items.Ammo;
import sk.tuke.oop.game.items.Energy;
import sk.tuke.oop.game.items.EnergyPulseAmmo;

/**
 *
 * @author admin
 */
public class ActorFactoryImpl implements ActorFactory {
    
    public ActorFactoryImpl()
    {
        
    }

    @Override
    public Actor create(String string, String string1) {
        Actor actor;
        
        switch(string1){
            case "access card" : 
            {
                actor = new AccessCard();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }
            case "energy" : 
            {
                actor = new Energy();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }
            case "cooler" : 
            {
                actor = new Cooler();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }
            case "front door" : 
            {  
                actor = new LockedDoor("front door",true);
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }     
            case "back door" : 
            {  
                actor = new LockedDoor("back door",false);
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }             
            case "exit door" : 
            {  
                actor = new ExitDoor("exit door",true);
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }                
            case "ellen" : 
            {
                actor = new Ripley();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }                
            case "locker" : 
            {
                actor = new Locker();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }
            case "machine" : 
            {
                actor = new Machine();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }      
            case "floor switch" : 
            {
                actor = new FloorSwitch();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }         
            case "wall switch" : 
            {
                actor = new WallSwitch();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }        
            case "lever" : 
            {
                actor = new Lever();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }   
            case "ammo" : 
            {
                actor = new Ammo();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }       
            case "alien" : 
            {
                if(string.equals("waiting1") || string.equals("waiting2"))
                {
                actor = new WaitingAlien();
                } else {
                actor = new Alien();
                }
                
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);                
                return actor;
            }        
            case "alien mother" : 
            {
                actor = new AlienMother();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }      
            case "barrel" : 
            {
                actor = new Barrel();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }       
            case "pulse ammo" : 
            {
                actor = new EnergyPulseAmmo();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }                
            default: return null;
        }
        }
    }
    

