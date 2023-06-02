import java.util.Scanner;

public class MileageTrackerLinkedList {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      // References for MileageTrackerNode objects
      MileageTrackerNode headNode;
      MileageTrackerNode currNode;
      MileageTrackerNode lastNode;

      double miles;
      String date;
      int numNodes;
      
      // Front of nodes list
      headNode = new MileageTrackerNode();
      lastNode = headNode;

      // Scan the number of nodes
      numNodes = scnr.nextInt();
      scnr.nextLine();

      for (int i = 0; i < numNodes; i++) {
         miles = scnr.nextDouble();
         scnr.nextLine();
         date = scnr.nextLine();

         currNode = new MileageTrackerNode(miles, date);
         lastNode.insertAfter(currNode);
         lastNode = currNode;
      }

      currNode = headNode.getNext();
      while (currNode != null) {
         currNode.printNodeData();
         currNode = currNode.getNext();
      }
   }
}
