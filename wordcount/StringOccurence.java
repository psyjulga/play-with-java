package wordcount;

public class StringOccurence {

  private String word;
  private int occurence;

  // Konstruktor ohne Access Modifier => accessable only inside package
  StringOccurence(String word, int occurence) {
    this.word = word;
    this.occurence = occurence;
  }

  public String getWord() {
    return this.word;
  }

  public int getOccurence() {
    return this.occurence;
  }
}
