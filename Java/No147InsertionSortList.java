import java.util.Stack;

/*
 * @lc app=leetcode id=147 lang=java
 *
 * [147] Insertion Sort List
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class No147InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        Stack<ListNode> s = new Stack<>();
        int len = getLen(head);
        for(int i=1; i<len; i++){
            ListNode p = head;
            int j=i;
            while(j>0){
                s.push(p);
                p=p.next;
                j--;
            }
            ListNode next = p.next;
            while(!s.isEmpty()){
                ListNode peek = s.pop();
                if(peek.val > p.val) {
                    p.next = peek;
                    peek.next = next;
                    next = peek;
                } else {
                    peek.next = p;
                    p = peek;
                }
            }
            head = p;
        }
        return head;
    }
    private int getLen(ListNode head){
        int count = 0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
}

