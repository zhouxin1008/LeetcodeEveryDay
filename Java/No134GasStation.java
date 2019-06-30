/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */
class No134GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int start = 0;
        int leftInTank = 0;
        for(int i=0; i<gas.length; i++) {
            total += gas[i] - cost[i];
            leftInTank += gas[i] - cost[i];
            if(leftInTank < 0){
                start = i+1;
                leftInTank = 0;
            }
        }
        return total<0 ? -1: start;
    }
}

