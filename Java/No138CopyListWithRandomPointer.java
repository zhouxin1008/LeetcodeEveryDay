/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class No138CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node p = head;
        while(p!=null){
            Node copy = new Node(p.val, p.next, p.random);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }
        p = head.next;
        while(p!=null){
            if(p.random!=null){
                p.random = p.random.next;
            }
            p = p.next==null ? p.next : p.next.next;
        }
        p = head;
        head = head.next;
        while(p!=null){
            Node next = p.next;
            p.next = next.next;
            next.next = p.next==null ? null : p.next.next;
            p = p.next;
        }
        return head;
    }
}

