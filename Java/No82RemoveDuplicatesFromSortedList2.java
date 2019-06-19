import java.util.Set;

/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class No82RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode dummy = new ListNode(0);
        Set<Integer> set = new HashSet<>();
        ListNode preP = dummy;
        ListNode p = dummy;
        while(head != null) {
            if(set.contains(head.val)){
                head = head.next;
                continue;
            }
            if(p==dummy ||p.val!=head.val){
                p.next = head;
                preP = p;
                p = p.next;
            }else{
                set.add(head.val);
                p = preP;
            }
            head = head.next;
        }
        p.next = null;
        return dummy.next;
    }
}

