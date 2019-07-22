import java.util.LinkedList;

/*
 * @lc app=leetcode id=341 lang=java
 *
 * [341] Flatten Nested List Iterator
 */
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Deque<NestedInteger> q;

    public NestedIterator(List<NestedInteger> nestedList) {
        q = new LinkedList<>();
        for(NestedInteger it : nestedList){
            q.offerLast(it);
        }
    }

    @Override
    public Integer next() {
        NestedInteger next = q.pollFirst();
        if(next.isInteger()){
            return next.getInteger();
        }else{
            List<NestedInteger> list = next.getList();
            Stack<NestedInteger> temp = new Stack<>();
            for(NestedInteger it : list) {
                temp.push(it);
            }
            while(!temp.isEmpty()){
                q.offerFirst(temp.pop());
            }
            return this.next();
        }
    }

    @Override
    public boolean hasNext() {
        if(q.isEmpty()) return false;
        NestedInteger next = q.peekFirst();
        if(next.isInteger()){
            return true;
        }else{
            next = q.pollFirst();
            List<NestedInteger> list = next.getList();
            Stack<NestedInteger> temp = new Stack<>();
            for(NestedInteger it : list) {
                temp.push(it);
            }
            while(!temp.isEmpty()){
                q.offerFirst(temp.pop());
            }
            return this.hasNext();
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

