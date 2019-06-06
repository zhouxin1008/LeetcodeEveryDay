package leetcode

func lengthOfLongestSubstring(s string) int {
		var lastOccur =  make(map[rune]int)
		max, left := 0, -1
		arr := []rune(s)
		for i, c := range arr {
			if temp, ok := lastOccur[c]; ok && left < temp {
				left = temp
			}
			lastOccur[c] = i
			if max < i - left {
				max = i - left
			}
		}
		return max
}