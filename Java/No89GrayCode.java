import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 */
class No89GrayCode {
    public List<Integer> grayCode(int n) {
        Set<Integer> res = new LinkedHashSet<>();
        res.add(0);
        if(n!=0) {
            char[] codes = new char[n];
            Arrays.fill(codes, '0');
            dfs(codes, res);
        }
        return new ArrayList<Integer>(res);
    }
    private void dfs(char[] codes, Set<Integer> res){
        for(int i=0; i<codes.length; i++){
            char origin = codes[i];
            if(codes[i]=='0') codes[i] = '1';
            else codes[i] = '0';
            int temp = toInt(codes);
            if(!res.contains(temp)){
                res.add(temp);
                dfs(codes, res);
                break;
            }
            codes[i] = origin;
        }
    }

    private int toInt(char[] codes) {
        String s = new String(codes);
        return Integer.parseInt(s, 2);
    }
}

