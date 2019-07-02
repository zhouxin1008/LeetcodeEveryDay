import java.util.Stack;

/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class No143ReorderList {
    public void reorderList(ListNode head) {
        HashMap<Integer,ListNode> map = new HashMap<>();
        for(int i = 1;head != null;head = head.next,i++){
            map.put(i,head);
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for(int i = 1,j = map.size();i <= j;i++,j--){   //1,2,3,4
            curr.next = map.get(i);                     //curr->1
            if(i!= j) map.get(i).next = map.get(j);     //1->4
            map.get(j).next = null;                     //4->null
            curr = map.get(j);                          ///curr = 4,then 1->4
        }
    }
}

