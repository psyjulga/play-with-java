package car;

public class Car implements Comparable<Car> {
  private String brand;
  private int hp;
  // STATISCHE VARIABLE
  public static int numCars;

  // Car(String b, int h){
  //   brand=b;
  //   hp=h;
  // }

  // üblicherweise die gleichen Namen
  // dann THIS => 
  // bezieht sich auf die Klassenvariable
  public Car(String brand, int hp){
    numCars++;
    // bei jeder Instanziierung
    this.brand = brand;
    this.hp = hp;
  }

  // Multiple Konstruktoren möglich
  // => "Überladen"
  // Java wählt passende 
  public Car(String brand){
    this.brand = brand;
    this.hp = 150;
  }

  // PRIVATE METHODE
  private void prepareForDrive(){
    System.out.println("preparing");
  }

  public void drive() throws CarDriveException{

    // exceptions
    if(hp==0){
      throw new CarDriveException("Auto hat keinen Motor");
    }

    prepareForDrive();

    System.out.println(hp/0);
    // => throws error
    // (not caught, because we only catch our custom exception)
    // => caught as aritmetic exception
    System.out.println("Ein "+brand+" fährt mit "+hp+"PS");
  }

  // STATISCHE METHODE
  public static void myMethod(){
    // Car.myMethod();
  }

  // getter
  public String getBrand(){
    return brand;
  }

  public int getHp(){
    return hp;
  }

  // for Comparable Intercace
  // COMPARE NUMBER
  @Override
  public int compareTo(Car o) {
    // if (this.hp < o.getHp()) return -1;
    // else if (this.hp == o.getHp()) return 0;
    // else return 1;

    // Integer class vs. int type
    // Integer hp = this.hp;
    // return hp.compareTo(o.getHp());

    // return Integer.compare(hp, o.getHp());
    // statische Methode

    // zuerst PS vergleichen, dann Marke
    // if(Integer.compare(hp, o.getHp())==0)
    // zu kompliziert gedacht!!
    // if(hp==o.getHp()) return brand.compareTo(o.getBrand());
    // else return Integer.compare(hp, o.getHp());

    // zuerst Marke vergleichen, dann PS
    // !! brand==o.getBrand() !! string => equals
    if(brand.equals(o.getBrand())) return Integer.compare(hp, o.getHp());
    else return brand.compareTo(o.getBrand());
  }

  // COMPARE STRING
  //  public int compareTo(Car o) {
  //   return brand.compareTo(o.getBrand());
  // }

  @Override
  public String toString(){
    return brand+": "+hp;
  }

  @Override
  public boolean equals(Object o){
    if(this==o) return true;
    if(!(o instanceof Car)) return false;
    Car other = (Car) o;

    if(brand.equals(other.getBrand())&&hp==other.getHp()) return true;
    else return false;
  }

}
