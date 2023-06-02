import java.util.Scanner;
import java.util.ArrayList;

public class PlantArrayListExample {

public static void PrintArrayList(ArrayList<Plant> myGarden) {
for(int i=0; i<myGarden.size(); i++) {
System.out.println("Plant " + (i+1) + " Information: ");
myGarden.get(i).printInfo();
System.out.println();
}
}

public static void main(String[] args) {
Scanner scnr = new Scanner(System.in);
String input;
  ArrayList<Plant> myGarden = new ArrayList<Plant>();

  String plantName, plantCost, colorOfFlowers;
  boolean isAnnual;

  input = scnr.nextLine();
  while(!input.equals("-1")){
     String[] info = input.split(" ");

     if(info[0].toLowerCase().equals("plant")){
        Plant pObj = new Plant();
        pObj.setPlantName(info[1]);
        pObj.setPlantCost(info[2]);
        myGarden.add(pObj);
     }
     else{
        Flower fObj = new Flower();
        fObj.setPlantName(info[1]);
        fObj.setPlantCost(info[2]);
        fObj.setPlantType(Boolean.parseBoolean(info[3]));
        fObj.setColorOfFlowers(info[4]);
        myGarden.add(fObj);
     }
     input = scnr.nextLine();
  }
  
  PrintArrayList(myGarden);
}
}
