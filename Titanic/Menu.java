//Ian Spooner
//Titanic
//03/06/16
//This program echos data from a file with Statistical additions
import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Menu {

private LocalTime startTime;
private LocalTime stopTime;
private Duration duration;
public static int percentLived, percentFirst, percentSecond, percentThird;
public static int percentUnder, percentLetter, percentMale, percentFemale; 
public static int percentRatio, percentDied, count;
boolean done;
String choice, letter;
Scanner scanner = new Scanner(System.in);

public Menu(){
while(done==false){
    //char menuChoice;
System.out.println(" ");
System.out.println("***********************************************");
System.out.println("*******Welcome to the Titanic Program!*********");
System.out.println("Please Select an option to print:");
System.out.println(" ");
System.out.println("1. Total number of passengers on the Titanic");
System.out.println("2. Percentage of passengers who perished on the Titanic");
System.out.println("3. Percentage of Passengers who survived the sinking of the Titanic ");
System.out.println("4. Percentage passengers who survived the sinking of the Titanic as a function of the passenger class");
System.out.println("5. A list of the names of passengers who were less than 10 years old who perished on the Titanic");
System.out.println("6. The count of the number of passengers as a function of the first letter of their last name");
System.out.println("7. Ratio of male to female passengers");
System.out.println(" ");
System.out.println("'Q' to Exit");
System.out.println(" ");
choice = scanner.nextLine();
System.out.println(choice);
if(choice.equals("done")){//for debugging
done=true;
}
if(choice.equals("[1234567Qq]")){
    if(choice.equals("1")){
            Menu.count = Stat.Count();
            System.out.println("The total number is passengers was: " + count);
            }
        else if(choice.equals("2")){
            System.out.println("The percentage of passengers who perished when the Titanic sank is: " + Stat.percentDied);
            }
        else if(choice.equals("3")){
            System.out.println("The percentage of passengers who survived when the Titanic sank is: " + Stat.percentLived);
           }
        else if(choice.equals("4")){
            System.out.println("The percentage of first class passengers who survived when the Titanic sank is: " + Stat.percentFirst);
            System.out.println("The percentage of second class passengers who survived when the Titanic sank is: " + Stat.percentSecond);
            System.out.println("The percentage of third class passengers who survived when the Titanic sank is: " + Stat.percentThird);
            }
        else if(choice.equals("5")){
            System.out.println("The number of passengers under 10 years old who perished when the Titanic sank is: " + Stat.percentUnder);
            }
        else if(choice.equals("6")){
            System.out.println("Enter the first letter of the last name you want to look up: ");
            letter = scanner.next();
            Stat.letter = this.letter;
            System.out.println("The number of passengers who perished with a last name that started with " + letter + " is: " + Stat.percentLetter);
            }
        else if(choice.equals("7")){
            System.out.println("The number of male passengers was: " + Stat.percentMale);
            System.out.println("The number of female passengers was: " + Stat.percentFemale);
            System.out.println("The ratio of male to female passengers was: " + Stat.percentMale + ":" + Stat.percentFemale);
            }
        else if(choice.equals("[Qq}")){
            System.out.println("Thanks for using the program!");
            System.out.println("Goodbye!");
            Stat.stopTime = LocalTime.now();
            System.out.println(Stat.getElapsedTime());
            done=true;
}
else{
System.out.println("That's not a valid input! Try again:");
}
} 
}
}
}
