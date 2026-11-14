class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int dp[][]=new int[n][n];
        int max=1;
        for(int i=n-1;i>=0;i--){
            dp[i][i]=1;
            char ch=s.charAt(i);
            for(int j=i+1;j<n;j++){
                if(ch==s.charAt(j)){
                    dp[i][j]=2+dp[i+1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
                max=Math.max(max,dp[i][j]);
            }
        }
return max;
    }
}