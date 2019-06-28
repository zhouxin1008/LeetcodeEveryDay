import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */
class No120Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        List<Integer> last = null;
        int res = 0;
        for(int i=0; i<size; i++){
            List<Integer> path = triangle.get(i);
            if(last==null) {
                last = path;
                res = path.get(0);
                continue;
            }
            res = Integer.MAX_VALUE;
            for(int j=0; j<path.size(); j++){
                int min = 0;
                if(j==0){
                    min = last.get(j);
                }else if(j==path.size()-1){
                    min = last.get(j-1);
                }else{
                    min = Math.min(last.get(j-1),last.get(j));
                }
                int curMin = min + path.get(j);
                path.set(j, curMin);
                res = Math.min(res, curMin);
            }
            last = path;
        }
        return res;
    }
}

