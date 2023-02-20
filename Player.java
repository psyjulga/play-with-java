public class Player {
  private String name;
  private int numberOfCards;

  // KONSTRUKTOR
  Player(String n, int c){
    name=n;
    numberOfCards=c;
  }

  // GETTER
  public int getNumberOfCards(){
    return numberOfCards;
  }

  // SETTER
  public void setName(String n){
    name=n;
  }

  // METHOD
  public void playCard(){
    numberOfCards--;
  }

  public void printPlayerInfo(){
    System.out.println(name + " ("+ numberOfCards +")");
  }
}
