package seaport;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @date created
 * @author Ian Spooner
 */
public class Ship extends Thing {

    protected PortTime arrivalTime, dockTime;
    protected double draft, length, weight, width;
    protected ArrayList<Job> jobs;

    public Ship(PortTime dockTime) {
        this.dockTime = dockTime;
    }

    public Ship(PortTime arrivalTime, PortTime dockTime, double draft, double length, double weight, double width) {
        this.arrivalTime = arrivalTime;
        this.dockTime = dockTime;
        this.draft = draft;
        this.length = length;
        this.weight = weight;
        this.width = width;
    }
    
    public Ship(String shipString) {
        String token[];
        token = shipString.split(",");
        this.name = token[0];
        this.draft = Double.parseDouble(token[1]);
        this.length = Double.parseDouble(token[2]);
        this.weight = Double.parseDouble(token[3]);
        this.width = Double.parseDouble(token[4]);
        //this.jobs = Double.parseDouble(token[6]);
    }
    
        public Ship(Scanner sc) {
        super(sc);
        if (sc.hasNextInt()) {
            int tempTime;
            tempTime = sc.nextInt(); 
            PortTime pt = new PortTime(tempTime);
            arrivalTime = pt;
        }
        if (sc.hasNextInt()) {
            int tempTime;
            tempTime = sc.nextInt(); 
            PortTime pt = new PortTime(tempTime);
            dockTime = pt;
        }
        if (sc.hasNextInt()) {
            draft = sc.nextInt();
        }
        if (sc.hasNextInt()) {
            length = sc.nextInt();
        }
        if (sc.hasNextInt()) {
            weight = sc.nextInt();
        }
        if (sc.hasNextInt()) {
            width = sc.nextInt();
        }
    }
    
    public void print(){
        System.out.printf("Name:  %s\n",this.name);
        System.out.printf("Length:  %f\n",this.length);
        System.out.printf("Draft:  %f\n",this.draft);
    }
    
    @Override
    public String toString() {
        String temp;
        String union = ",";
        
        temp = this.name + union + Double.toString(this.length) + union + 
                Double.toString(this.draft) + union;
        return temp;
    }

}
