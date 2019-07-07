import java.util.Arrays;

/*
 * @lc app=leetcode id=165 lang=java
 *
 * [165] Compare Version Numbers
 */
class No165CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for(int i=0; i<v1.length || i<v2.length; i++){
            int a = Integer.parseInt( i>=v1.length ? "0" : v1[i]);
            int b = Integer.parseInt( i>=v2.length ? "0" : v2[i]);
            if(a!=b){
                return a > b ? 1 : -1;
            }
        }
        return 0;
    }
}

