public class LabProgram {
    public static void main(String[] args) {
        FancyCar car = new FancyCar();
        car.drive(50);
        System.out.println("Miles driven: " + car.checkOdometer());
        System.out.println("Gas Tank: " + car.checkGasGauge() + " gallons");
        car.honkHorn();
        car.addGas(5.5);
        System.out.println("Gas Tank: " + car.checkGasGauge() + " gallons");
        car.startEngine();
        car.stopEngine();
    }
}
