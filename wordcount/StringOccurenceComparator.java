package wordcount;

import java.util.Comparator;

public class StringOccurenceComparator implements Comparator<StringOccurence> {

  @Override
  public int compare(StringOccurence o1, StringOccurence o2) {

    if (o1.getOccurence() < o2.getOccurence())
      return 1;
    else if (o1.getOccurence() == o2.getOccurence())
      return 0;
    else
      return -1;

  }

}
