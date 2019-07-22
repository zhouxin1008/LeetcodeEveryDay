import java.util.Stack;

/*
 * @lc app=leetcode id=331 lang=java
 *
 * [331] Verify Preorder Serialization of a Binary Tree
 */
class No331VerifyPreorderSerializationOf_A_BinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int len = nodes.length;
        int[] count = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<len; i++){
            if(nodes[i].equals("#")){
                if((stack.isEmpty() && len!=1) || count[0]==2) return false;
                count[i] = 2;
                int j = i;
                while(count[j] == 2 && !stack.isEmpty()){
                    int next = stack.peek();
                    count[next] = count[next] + 1;
                    if(count[next] == 2) stack.pop();
                    j = next;
                }
            }else{
                stack.push(i);
            }
        }
        for(int i=0; i<len; i++){
            if(count[i]!=2) return false;
        }
        return true;
    }
}

