package wordcount;

import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringOccurenceAnalyzer {

  public List<StringOccurence> analyze(List<String> words) {

    HashMap<String, Integer> occurences = new HashMap<>();

    for (String word : words) {
      if (occurences.containsKey(word)) {
        int n = occurences.get(word); // get(key) => returns value
        // n++;
        occurences.put(word, n + 1);
      } else
        occurences.put(word, 1);
    }

    ArrayList<StringOccurence> list = new ArrayList<>();

    for (Map.Entry<String, Integer> entry : occurences.entrySet()) {

      list.add(new StringOccurence(entry.getKey(), entry.getValue()));
    }

    // Collections.sort(list, new StringOccurenceComparator());
    // param 2 => our own comparator => implements Comparator => 1, 0, -1

    // da wir diese Sortierfunktion nur einmal hier brauchen
    // geht es auch ohne eigene Klasse

    // Collections.sort(list, new Comparator<StringOccurence>() {
    // @Override
    // public int compare(StringOccurence o1, StringOccurence o2) {
    // if (o1.getOccurence() < o2.getOccurence())
    // return 1;
    // else if (o1.getOccurence() == o2.getOccurence())
    // return 0;
    // else
    // return -1;
    // }
    // });

    // Kurzschreibweise
    // Integer.compare => gibt auch 0,1,-1 zurück
    // sortiert aufsteigend
    // Collections.sort(list, (o1, o2) -> -Integer.compare(o1.getOccurence(),
    // o2.getOccurence()));

    // noch kürzer (;
    list.sort((o1, o2) -> -Integer.compare(o1.getOccurence(), o2.getOccurence()));

    return list;
  }

}
