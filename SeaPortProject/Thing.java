package seaport;

import java.util.Scanner;

/**
 * @date created
 * @author Ian Spooner
 */
public class Thing implements Comparable<Thing> {

    int index;
    String name;
    int parent;

    public Thing(int index, String name, int parent) {
        this.index = index;
        this.name = name;
        this.parent = parent;
    }

    public Thing() {
    }
    
    public Thing(Scanner sc) {
        //super(sc); //debug
    }

    @Override
    public int compareTo(Thing o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
