package gd.rf.jsgames;

import java.util.ArrayList;

import gd.rf.jsgames.structures.Structure;
import gd.rf.jsgames.units.*;

public class ObjectManager {
    public ArrayList<Unit> units = new ArrayList<>();
    public ArrayList<Structure> structures = new ArrayList<>();
    public ObjectManager(){

    }
    public void updateObjects(){
        for(int i = 0; i < units.size(); i++){
            units.get(i).update();
        }
        for(int i = 0; i < structures.size(); i++){
            structures.get(i).update();
        }
    }
    
    
}
