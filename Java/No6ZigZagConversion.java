import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class No6ZigZagConversion{
  public String convert(String s, int numRows) {
    if (numRows == 1) return s;
    Map<Integer, List<Character>> map = new HashMap<>();
    boolean up = true;
    int index = 0;
    for (char c : s.toCharArray()) {
      index = up ? index + 1 : index - 1;
      List<Character> temp = map.get(index);
      if (temp == null) {
        temp = new ArrayList<>();
        map.put(index, temp);
      }
      temp.add(c);
      if (index == numRows && up) up = false;
      else if (index == 1 && !up) up = true;
    }
    StringBuilder res = new StringBuilder();
    for (int i=0; i<=numRows; i++) {
      List<Character> temp = map.get(i);
      if (temp != null) {
        for (char c : temp) {
          res.append(c);
        }
      }
    }
    return res.toString();
  }
}