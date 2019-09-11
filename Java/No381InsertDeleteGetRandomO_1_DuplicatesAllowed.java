import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

/*
 * @lc app=leetcode id=381 lang=java
 *
 * [381] Insert Delete GetRandom O(1) - Duplicates allowed
 */
class RandomizedCollection {
    Map<Integer,Set<Integer>> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Set<Integer> temp = null;
        boolean contains = map.containsKey(val);
        if(contains) {
            temp = map.get(val); 
        } else {
            temp = new HashSet<>();
            map.put(val, temp);
        }
        temp.add(list.size());
        list.add(val);
        return !contains;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        Set<Integer> set = map.get(val);
        int index = set.iterator().next();
        set.remove(index);
        if(set.isEmpty()) {
            map.remove(val);
        }
        if(index < list.size()-1) {
            int last = list.get(list.size()-1);
            map.get(last).add(index);
            map.get(last).remove(list.size()-1);
            list.set(index,last);
        }
        list.remove(list.size()-1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

