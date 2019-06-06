fun lengthOfLongestSubstring(s: String): Int {
    val lastOccur = mapOf<Char, Int>()
    var maxLength = 0
    var left = -1
    s.toCharArray().forEachIndexed{ i,c -> 
      lastOccur[c]?.let {
        left = if (it >= left) it else left
      }
      lastOccur[c] = i
      maxLength = if (i-left > maxLength) i-left else maxLength
    }
    return maxLength
}