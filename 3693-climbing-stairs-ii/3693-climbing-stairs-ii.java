class Solution {
    public int climbStairs(int n, int[] costs) {
        if(n==1){
            return costs[0]+1;
        }
        int dp[]=new int[n+1];
        dp[1]=costs[0]+1;
        dp[2]=Math.min(costs[1]+4,dp[1]+costs[1]+1);
        for(int i=3;i<=n;i++){
            int first=costs[i-1]+dp[i-1]+1;
            int sec=costs[i-1]+dp[i-2]+4;
            int third=costs[i-1]+dp[i-3]+9;
            dp[i]=Math.min(first,Math.min(sec,third));
        }
        return dp[n];
    }
}