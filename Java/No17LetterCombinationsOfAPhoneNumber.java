import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class No17LetterCombinationsOfAPhoneNumber {
  public List<String> letterCombinations(String digits) {
    String n2 = "abc";
    String n3 = "def";
    String n4 = "ghi";
    String n5 = "jkl";
    String n6 = "mno";
    String n7 = "pqrs";
    String n8 = "tuv";
    String n9 = "wxyz";
    List<String> res = Arrays.asList("");
    for(char c : digits.toCharArray()) {
      switch (c) {
        case '2':
          res = generator(res, n2);
          break;
        case '3':
          res = generator(res, n3);
          break;
        case '4':
          res = generator(res, n4);
          break;
        case '5':
          res = generator(res, n5);
          break;
        case '6':
          res = generator(res, n6);
          break;
        case '7':
          res = generator(res, n7);
          break;
        case '8':
          res = generator(res, n8);
          break;
        case '9':
          res = generator(res, n9);
          break;
      }
    }
    if (res.size() == 1) return new ArrayList<>();
    return res;
  }
  private List<String> generator(List<String> list, String chars) {
    List<String> res = new ArrayList<>();
    for (char c : chars.toCharArray() ) {
      for (String s : list) {
        res.add(s + c);
      }
    }
    return res;
  }
}