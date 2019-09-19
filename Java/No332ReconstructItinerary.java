import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 */
class No332ReconstructItinerary {
    Map<String, List<String>> flight;
    Map<String, Integer> count;
    List<String> res;
    boolean find = false;
    int numOfTickets;
    public List<String> findItinerary(List<List<String>> tickets) {
        flight = new HashMap<>();
        count = new HashMap<>();
        numOfTickets = tickets.size();
        for(List<String> t : tickets) {
            String from = t.get(0), to = t.get(1);
            if(!flight.containsKey(from)) flight.put(from, new ArrayList<>());
            flight.get(from).add(to);
            String key = from+to;
            count.put(key, count.getOrDefault(key, 0) + 1);
        }
        for(List<String> list : flight.values()) {
            Collections.sort(list);
        }
        List<String> temp = new ArrayList<>();
        temp.add("JFK");
        dfs("JFK", temp);
        return res;
    }
    private void dfs(String start, List<String> temp) {
        if(find) return;
        if(temp.size()==numOfTickets+1) {
            find = true;
            res = new ArrayList<>(temp);
            return;
        }
        for(String next : flight.getOrDefault(start, new ArrayList<>())) {
            String key = start+next;
            if(count.get(key)==0) continue;
            count.put(key, count.get(key) - 1);
            temp.add(next);
            dfs(next, temp);
            temp.remove(temp.size()-1);
            count.put(key, count.get(key) + 1);
        }
    }
}

