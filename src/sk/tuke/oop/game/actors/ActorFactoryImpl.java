/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.ActorFactory;
import sk.tuke.oop.game.items.Energy;

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
        
        switch(string){
            case "access card" : 
            {
                
                return null;
            }
            case "energy" : 
            {
                actor = new Energy();
                ((AbstractActor) actor).setName(string1);
                return actor;
            }
            case "cooler" : 
            {
                actor = new Cooler();
                ((AbstractActor) actor).setName(string1);
                return actor;
            }
            case "door" : return null;
            case "ellen" : 
            {
                actor = new Ripley();
                ((AbstractActor) actor).setName(string1);
                return actor;
            }                
            case "locker" : return null;
            default: return null;
        }
        }
    }
    

