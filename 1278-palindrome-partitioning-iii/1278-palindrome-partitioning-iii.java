class Solution {
    int dp[][];
    int memo[][];
    int solve(int n,int pos,int parts){
        if(n==pos){
            return parts==0?0:Integer.MAX_VALUE;
        }
        if(parts<0){
            return Integer.MAX_VALUE;
        }
        if(memo[pos][parts]!=-1){
            return memo[pos][parts];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=pos;i<n;i++){
            int min=solve(n,i+1,parts-1);
            if(min!=Integer.MAX_VALUE){
                ans=Math.min(ans,dp[pos][i]+min);
            }
        }
        return memo[pos][parts]=ans;
    }
    public int palindromePartition(String s, int k) {
        int n=s.length();
        dp=new int[n][n];
        for(int len=1;len<=n;len++){
            for(int l=0;l<n-len+1;l++){
                int r=l+len-1;
                if(len<=2){
                    dp[l][r]=(s.charAt(l)==s.charAt(r)?0:1);
                }
                else{
                    dp[l][r]=dp[l+1][r-1]+(s.charAt(l)==s.charAt(r)?0:1);
                }
            }
        }
        memo=new int[n+1][k+1];
        for(int arr[]:memo){
            Arrays.fill(arr,-1);
        }
        return solve(n,0,k);
    }
}