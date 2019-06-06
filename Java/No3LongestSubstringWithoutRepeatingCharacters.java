import java.util.Map;

class No3LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> lastOccur = new HashMap();
    int maxLen = 0;
    int left = -1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (lastOccur.containsKey(c) && lastOccur.get(c) >= left) {
        left = lastOccur.get(c);
      }
      lastOccur.put(c, i);
      maxLen = Math.max(maxLen, i - left);
    }          
    return maxLen;
  }
}