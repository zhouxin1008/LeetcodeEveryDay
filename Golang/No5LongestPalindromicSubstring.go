package leetcode

func longestPalindrome(s string) string {
	str := []rune(s)
	len := len(s)
	if len == 1 {
		return s
	}
	max, left := 0, 0
	var mark [][]bool = make([][]bool, len)
    for i:=0; i<len; i++ {
		mark[i] = make([]bool, len)
	}
	for i:=0; i<len; i++ {
		for j:=i; j<len; j++ {
			if i <= 1 {
				mark[j-i][j] = str[j-i] == str[j]
			} else {
				mark[j-i][j] = mark[j-i+1][j-1] && str[j-i] == str[j]
			}
			if mark[j-i][j] && max < i + 1 {
				max = i + 1
				left = j - i 
			}
		}
	}
	return string(str[left:left+max])
}