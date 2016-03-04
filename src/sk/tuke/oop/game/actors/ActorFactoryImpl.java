/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.game.actors.tiles.BlackTile;
import sk.tuke.oop.game.actors.alien.AlienMother;
import sk.tuke.oop.game.actors.alien.Alien;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.ActorFactory;
import sk.tuke.oop.game.actors.alien.AlienEgg;
import sk.tuke.oop.game.actors.tiles.BlackTile20x12;
import sk.tuke.oop.game.actors.tiles.BlackTile8x9;
import sk.tuke.oop.game.actors.machine.FloorSwitch;
import sk.tuke.oop.game.actors.machine.Lever;
import sk.tuke.oop.game.actors.machine.Machine;
import sk.tuke.oop.game.actors.machine.WallSwitch;
import sk.tuke.oop.game.actors.openables.Door;
import sk.tuke.oop.game.actors.tiles.BlackTile11x20;
import sk.tuke.oop.game.actors.tiles.BlackTile21x21;
import sk.tuke.oop.game.actors.tiles.InvisibleTile;
import sk.tuke.oop.game.items.AccessCard;
import sk.tuke.oop.game.items.Ammo;
import sk.tuke.oop.game.items.Energy;
import sk.tuke.oop.game.items.EnergyPulseAmmo;
import sk.tuke.oop.game.items.GunUpgrade;

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
            case "horizontal door" : 
            {  
                actor = new Door("horizontal door",false);
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }     
            case "vertical door" : 
            {  
                actor = new Door("vertical door",true);
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
                actor = new Alien();
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
            case "gun upgrade" : 
            {
                actor = new GunUpgrade();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }         
            case "computer" : 
            {
                actor = new Computer();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }              
            case "black tile" : 
            {
                actor = new BlackTile();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }     
            case "black tile 20x12" : 
            {
                actor = new BlackTile20x12();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }     
            case "black tile 8x9" : 
            {
                actor = new BlackTile8x9();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }       
            case "black tile 11x20" : 
            {
                actor = new BlackTile11x20();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }       
            case "black tile 21x21" : 
            {
                actor = new BlackTile21x21();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }     
            case "hole" : 
            {
                actor = new Hole();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }  
            case "vertical body" : 
            {
                actor = new Body(true);
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }  
            case "horizontal body" : 
            {
                actor = new Body(false);
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }            
            case "invisible tile" : 
            {
                actor = new InvisibleTile();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }  
            case "ground light" : 
            {
                actor = new GroundLight();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }
            case "alien egg" : 
            {
                actor = new AlienEgg();
                ((AbstractActor) actor).setName(string1);
                ((AbstractActor) actor).setType(string);
                return actor;
            }             
            
            default: return null;
        }
        }
    }
    

