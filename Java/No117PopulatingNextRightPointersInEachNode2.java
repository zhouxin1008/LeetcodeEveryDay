/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class No117PopulatingNextRightPointersInEachNode2 {
    public Node connect(Node root) {
        if(root==null) return root;
        Queue<Node> q = new LinkedList<>();
        Node preLast = root;
        Node curLast = root;
        Node pre = null;
        q.offer(root);
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.left!=null) {
                q.offer(cur.left);
                curLast = cur.left;
            }
            if(cur.right!=null) {
                q.offer(cur.right);
                curLast = cur.right;
            }
            if(pre!=null){
                pre.next = cur;
            }
            pre = cur;
            if(cur==preLast){
                cur.next = null;
                pre = null;
                preLast = curLast;
            }
        }
        return root;
    }
}

