import java.util.HashMap;

/*
 * @lc app=leetcode id=690 lang=java
 *
 * [690] Employee Importance
 */
/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class No690EmployeeImportance {
    Map<Integer, Employee> map = new HashMap<>();
    Set<Integer> seen = new HashSet<>();
    private int dfs(int id) {
        if(seen.contains(id)) return 0;
        seen.add(id);
        Employee e = map.get(id);
        int v = e.importance;
        for(int i : e.subordinates){
            v += dfs(i);
        }
        return v;
    }
    public int getImportance(List<Employee> employees, int id) {
        for(Employee e : employees){
            map.put(e.id, e);
        }
        return dfs(id);
    }
}

