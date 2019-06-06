package leetcode

type ListNode struct {
	  Val int
	  Next *ListNode
}
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
		dummy := new(ListNode)
		p := dummy
		flag := 0
		for ; l1 != nil || l2 != nil || flag != 0; {
			val1 := getValOfListNode(l1)
			val2 := getValOfListNode(l2)
			temp := val1 + val2 + flag
			flag = temp / 10
			p.Next = &ListNode{temp%10, nil}
			p = p.Next
			l1 = getNextOfListNode(l1)
			l2 = getNextOfListNode(l2)
		}
		return dummy.Next
}

func getValOfListNode(l *ListNode) int {
	if l != nil {
		return l.Val
	}
	return 0 
}

func getNextOfListNode(l *ListNode) *ListNode {
	if l != nil {
		return l.Next
	}
	return nil 
}