package seaport;

import java.util.Scanner;

/**
 * @date created
 * @author Ian Spooner
 */
public class FileLoader {

    private static Scanner input;

//    public void mapLoad(Map ptMap) throws FileNotFoundException {
//        this.input = new Scanner(this.mapFile);
//        String temp;
//        while (this.input.hasNext()) {
//            temp = this.input.nextLine();
//            ptMap.fromString(temp);
//        }
//        this.input.close();
//        System.out.println("Map loaded!");
//    }
    void process(String st) {
        System.out.println ("Processing >" + st + "<");
        Scanner sc = new Scanner(st);
        if (!sc.hasNext()) {
            return;
        }
        switch (sc.next()) {
            case "port":
                Port.addPort(sc);
                break;
            case "dock":
                Dock.addDock(sc);
                break;
            case "pship":
                PassengerShip.addShip(sc);
                break;
            case "cship":
                CargoShip.addShip(sc);
                break;
            case "job":
                Jobs.addJob(sc);
                break;
            case "person":
                Persons.addPerson(sc);
                break;
            case "//"
                break;
            default:
                GUI.warning("There was a parsing error...");
                break;
        }
        System.out.println("Dock loaded!");
    }

//    public static void Parse(File file) throws FileNotFoundException {
//        input = new Scanner(file);
//        String temp;
//        String tempArr[];
//        int i, docks;
//        Dock tempDock;
//        /**
//         * The first line of the port file contains the number of docks and
//         * cargos the port has.
//         */
//        temp = input.nextLine();
//        tempArr = temp.split(",");
//        ptPort.setName(tempArr[0]);     // THe docks name
//        docks = Integer.parseInt(tempArr[1].trim());    // The number of docks
//        cranes = Integer.parseInt(tempArr[2].trim());    // The number of cranes
//        piers = Integer.parseInt(tempArr[3].trim());    // The number of piers
//        cargo = Integer.parseInt(tempArr[4].trim());    // The number of cargos
//
//        /**
//         * After the first line, the next lines, if any, are the docks the
//         * string is passed to a new dock class object, then appended to the
//         * dock array in the port class.
//         */
//        for (i = 0; i < docks; i++) {
//            temp = this.input.nextLine();
//            tempDock = new Dock(temp);
//            ptPort.addDock(tempDock);
//        }
//
//        input.close();
//        System.out.println("Dock loaded!");
//    }

}
