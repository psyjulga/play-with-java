package car;

public class SuperCar extends NormalCar{
  private int numZyl;
  
  // must have own constructor
  public SuperCar(String brand, int numZyl){
    // super triggers base class constructor
    super(brand);
    this.numZyl = numZyl;
  }
  // Methoden überschreiben
  // method has to match 
  // without @Override methods could
  // e.g. have different amount of params
  // java would choose the method based on
  // how it is called
  // "method overloading"
  @Override
  public void normalDrive(){
    System.out.println("normaldrive overwritten!!");
  }

  public void superDrive(){
System.out.println("superdrive!!");
  }
}
