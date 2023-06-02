public class FancyCar{

   // Declare private fields
   private int odometer;
   private double gallonsOfGas;
   private double MPG;
   private double drivingCapacity;
   String carModel;
   private final int FULL_TANK = 14;

   // Default constructor
   public FancyCar() {
      /* Complete the method */ 
      odometer=5;
      gallonsOfGas = FULL_TANK;
      MPG = 24.0;
      carModel = "Old Clunker";
   }
   
   // Constructor (String make, double mpg)
   public FancyCar(String make, double mpg) {
      /* Complete the method */ 
      carModel= make;
      MPG = mpg;
      odometer=5;
      gallonsOfGas = FULL_TANK;
   }

   // Return car model
   public String getModel() {
      /* Update the return statment */  
      return carModel;
   }
    
   // Return miles per gallon (MPG)      
    public double getMPG(){
       /* Update the return statment */  
       return MPG;
    }
    
   // Return miles on odometer    
   public int checkOdometer() {
      /* Update the return statment */  
      return odometer;
   } 
         
   // Return amount of gas in tank
   public double checkGasGauge() {
      /* Update the return statment */  
      return gallonsOfGas;
   }   
   
   // Honk horn
   public void honkHorn() {
      /* Complete the method */ 
      System.out.println("The "+ carModel +" Civic says beep beep!");
      }
   
   // Drive car requested miles but check for enough
   // gas and check for positive value
   public void drive(int milesToDrive) {
      /* Complete the method */  
    }
 
   // Add gas to tank. Check for positive value.
   public void addGas(double amtToAdd) {
      /* Complete the method */       
   }
      
   // Set boolean variable to true
    public void startEngine(){
       /* Complete the method */ 
    }
      
   // Set boolean variable to false  
   public void stopEngine(){
      /* Complete the method */ 
   } 
    
}
