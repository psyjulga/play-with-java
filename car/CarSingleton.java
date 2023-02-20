package car;
public class CarSingleton {
  // SINGLETON => nur eine Instanz möglich
  
  private static CarSingleton instance;

  // INSTRUKTOR PRIVATISIEREN
  private CarSingleton(){

  }

  // Sobald Instanz einmal erstellt ist
  // wird immer diese Instanz zurückgegeben
  public static CarSingleton getInstance(){
    if (instance==null) instance = new CarSingleton();
    return instance;
  }

  // CarSingleton.getInstance();
  // CarSingleton.getInstance().myMethod();
}
