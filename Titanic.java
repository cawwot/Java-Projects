
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
//Ian Spooner
//Week 8 - Titanic
//03/06/16
//This program echos data from a file with statistical additions
//import packages
import java.io.IOException;
import java.util.Scanner;
public class Titanic {
/**
* @param args the command line arguments
     * @throws java.io.IOException
*/
public static void main(String[] args) throws IOException {
String choice;
String arguOne, newline;
Boolean done =false;
Scanner scanner = new Scanner(System.in);

if (args.length == 1){
arguOne = (args[0]);
System.out.println("Entered data file: " + arguOne + ".");
Menu newMenu = new Menu();
Stat newStat = new Stat(arguOne);
}

else {	
System.out.println("Application requires a file name passed as a command line argument.");
System.out.println("Please try again.");	
System.exit(0);
}
} 
} 