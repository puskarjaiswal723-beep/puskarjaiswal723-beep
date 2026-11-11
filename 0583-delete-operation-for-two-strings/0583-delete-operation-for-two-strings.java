class Solution {
    public int minDistance(String word1, String word2) {
        int r=word1.length();
        int c=word2.length();
        int dp[][]=new int[r+1][c+1];
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    //System.out.println(dp[i][j]);
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        // System.out.println(dp[r][c]);
        return (r+c-2*dp[r][c]);
    }
}