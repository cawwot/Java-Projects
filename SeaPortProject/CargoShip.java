package seaport;

/**
 * @date created
 * @author Ian Spooner
 */
public class CargoShip extends Ship {

    double cargoValue;
    double cargoVolume;
    double cargoWeight;

    public CargoShip(PortTime arrivalTime, PortTime dockTime, double draft, double length, double weight, double width) {
        super(arrivalTime, dockTime, draft, length, weight, width);
    }

}
