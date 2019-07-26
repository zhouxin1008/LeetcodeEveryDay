import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */
class No204CountPrimes {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        int[] primes = new int[n];
        int res = 0;
        for(int i=2; i<n; i++) {
            if(primes[i]!=0) continue;
            res++;
            for(int j=2; i*j<n; j++){
                primes[i*j] = 1;
            }
        }
        return res;
    }
}

