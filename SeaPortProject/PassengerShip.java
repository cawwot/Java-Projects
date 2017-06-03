package seaport;

import java.util.Scanner;

/**
 * @date created
 * @author Ian Spooner
 */
public class PassengerShip extends Ship {

    int numberOfOccupiedRooms, numberOfPassengers, numberOfRooms;

    public PassengerShip(PortTime dockTime) {
        super(dockTime);
    }

    public PassengerShip(PortTime arrivalTime, PortTime dockTime, double draft, double length, double weight, double width) {
        super(arrivalTime, dockTime, draft, length, weight, width);
    }

    public PassengerShip(int numberOfOccupiedRooms, int numberOfPassengers, int numberOfRooms, PortTime arrivalTime, PortTime dockTime, double draft, double length, double weight, double width) {
        super(arrivalTime, dockTime, draft, length, weight, width);
        this.numberOfOccupiedRooms = numberOfOccupiedRooms;
        this.numberOfPassengers = numberOfPassengers;
        this.numberOfRooms = numberOfRooms;
    }

    public PassengerShip(Scanner sc) {
        super(sc);
        if (sc.hasNextInt()) {
            numberOfPassengers = sc.nextInt();
        }
        if (sc.hasNextInt()) {
            numberOfRooms = sc.nextInt();
        }
        if (sc.hasNextInt()) {
            numberOfOccupiedRooms = sc.nextInt();
        }
    }

//    public PassengerShip(String shipString) {
//        String token[];
//        token = shipString.split(",");
//        this.name = token[0];
//        this.draft = Double.parseDouble(token[1]);
//        this.length = Double.parseDouble(token[2]);
//        this.weight = Double.parseDouble(token[3]);
//        this.width = Double.parseDouble(token[4]);
//        //this.jobs = Double.parseDouble(token[6]);
//    }
    
    @Override
    public void print() {
        System.out.printf("Name:  %s\n", this.name);
        System.out.printf("Length:  %f\n", this.length);
        System.out.printf("Draft:  %f\n", this.draft);
    }

}
