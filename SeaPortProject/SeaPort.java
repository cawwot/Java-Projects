package seaport;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @date created
 * @author Ian Spooner
 */
public class SeaPort extends Thing {

    ArrayList<Dock> docks;
    ArrayList<Ship> que; // the list of ships waiting to dock
    ArrayList<Ship> ships; // a list of all the ships at this port
    ArrayList<Person> persons; // people with skills at this port

    public SeaPort(ArrayList<Dock> docks, ArrayList<Ship> que, ArrayList<Ship> ships, ArrayList<Person> persons, Scanner sc) {
        super(sc);
        this.docks = docks;
        this.que = que;
        this.ships = ships;
        this.persons = persons;
    }

}
