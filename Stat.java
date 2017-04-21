
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
import java.io.BufferedReader;
import java.time.Duration;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

public class Stat {
    
public static LocalTime startTime;
public static LocalTime stopTime;
private static Duration duration;
String[] pClass = new String[1000];
String[] pLived = new String[1000];
String[] pName = new String[1000];
String[] pSex = new String[1000];
String[] pAge = new String[1000];
String[] pFare = new String[1000];
public static int percentLived, percentFirst, percentSecond, percentThird;
public static int percentUnder, percentLetter, percentMale, percentFemale; 
public static int percentRatio, percentDied, count=0; //count needs int
Scanner scanner = new Scanner(System.in);
public static String letter;
    
public Stat(String arguOne) throws FileNotFoundException, IOException{  
BufferedReader CSVFile = 
new BufferedReader(new FileReader(arguOne));
String dataRow;
while ((dataRow = CSVFile.readLine()) != null){
    String [] dataArray;
    String delimiter = "\t";
    dataArray = dataRow.split(delimiter); 
    String Class = dataArray[0];
    pClass[count] = Class;
    String lived = dataArray[1];
    pLived[count] = lived;
    String Name = dataArray[2];
    pName[count] = Name;
    String Sex = dataArray[3];
    pSex[count] = Sex;
    String Age = dataArray[4];
    pAge[count] = Age;
    String Fare = dataArray[5];
    pFare[count] = Fare;
    count++;
 }
}
    
public static Duration getElapsedTime() {
System.out.println("The elapsed time in seconds is " + Duration.between(startTime, stopTime).toNanos()/1000000000);
duration = Duration.between(stopTime, startTime);
return duration;
}

public static int Count(){
    count=Stat.count;
    return count;
}
public int Died(String pLived[]) {
int e, i;
for(i=0;i<=count;i++){
e = Integer.parseInt(pLived[i]);
if(e==0){
percentDied = percentDied+e;
}
}
percentDied = percentDied/count;
return percentDied;
}

public int Lived(String pLived[]) {
int e, i;
for(i=0;i<=count;i++){
e = Integer.parseInt(pLived[i]);
if(e==1){
percentLived = percentLived+e;
}
}
percentLived = percentLived/count;
return percentLived;
}

public int ClassFirst(String pClass[]) {
int e, i;
for(i=0;i<=count;i++){
e = Integer.parseInt(pClass[i]);
if(e==1){
percentFirst = percentFirst+e;
}
}
return percentFirst;
}

public int ClassSecond(String pClass[]) {
int e, i;
for(i=0;i<=count;i++){
e = Integer.parseInt(pClass[i]);
if(e==2){
percentSecond = percentSecond+e;
}
}
return percentSecond;
}

public int ClassThird(String pClass[]) {
int e, i;
for(i=0;i<=count;i++){
e = Integer.parseInt(pClass[i]);
if(e==1){
percentThird = percentThird+e;
}
}
return percentThird;
}

public int underTen(String pAge[]) {
int e, i;
for(i=0;i<=count;i++){
e = Integer.parseInt(pAge[i]);
if(e<10){
percentUnder = percentUnder+e; //not actually a percent
}
}
return percentUnder;
}

public int Nletter(String pName[]) {
int i;
String e;
for(i=0;i<=count;i++){
e = String.valueOf(pName[i].charAt(0));
if(e.equalsIgnoreCase(letter)){
percentLetter++;
}
}
percentLetter = percentLetter/100;
return percentLetter;
}

public int NMale(String pSex[]) {
int i;
String e;
for(i=0;i<=count;i++){
e = String.valueOf(pSex[i].charAt(0));
if(e.equalsIgnoreCase("m")){
percentMale++;
}
}
return percentMale;//also not a percent
}

public int NFemale(String pSex[]) {
int i;
String e;
for(i=0;i<=count;i++){
e = String.valueOf(pSex[i].charAt(0));
if(e.equalsIgnoreCase("f")){
percentFemale++;
}
}
return percentFemale;// also not a percent. 
}//TODO think of different names for these...

}//close stat