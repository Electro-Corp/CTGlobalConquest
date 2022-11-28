package gd.rf.jsgames;

import java.util.ArrayList;


import gd.rf.jsgames.structures.Structure;
import gd.rf.jsgames.units.*;
import gd.rf.jsgames.tiles.*;
public class ObjectManager {
    public ArrayList<Unit> units = new ArrayList<>();
    public ArrayList<Structure> structures = new ArrayList<>();
    public ObjectManager(){

    }
    public Tile[][] updateObjects(Tile[][] tiles){
        for(int i = 0; i < units.size(); i++){
            units.get(i).update();
            tiles[(int) units.get(i).x][(int) units.get(i).y].unitOn = units.get(i);
        }
        for(int i = 0; i < structures.size(); i++){
            structures.get(i).update();
        }
        return tiles;
    }
    
    
}
