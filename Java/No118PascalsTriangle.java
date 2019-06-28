import java.util.ArrayList;

/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */
class No118PascalsTriangle {
    private List<List<Integer>> res;
    public List<List<Integer>> generate(int numRows) {
        res = new ArrayList<>();
        for(int n=1; n<=numRows; n++){
            doGenerate(n);
        }
        return res;
    }
    private void doGenerate(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if(n==1) {
            res.add(list);
            return;
        }
        if(n>2) {
            List<Integer> last = res.get(res.size()-1);
            for(int i=1; i<last.size(); i++){
                list.add(last.get(i-1) + last.get(i));
            }
        }
        list.add(1);
        res.add(list);
    }
}

