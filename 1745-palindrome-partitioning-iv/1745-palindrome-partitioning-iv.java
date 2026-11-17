class Solution {
    boolean dp[][];
    Boolean memo[][];
    boolean solve(int n,int parts,int pos){
        if(pos==n){
            return parts==0;
        }
        if(parts<0){
            return false;
        }
        if(memo[pos][parts]!=null){
            return memo[pos][parts];
        }
        for(int i=pos;i<n;i++){
            if(dp[pos][i] && solve(n,parts-1,i+1)){
                return memo[pos][parts]=true;
            }
        }
        return memo[pos][parts]=false;
    }
    public boolean checkPartitioning(String s) {
        int n=s.length();
        dp=new boolean[n][n];
        for(int len=1;len<=n;len++){
            for(int l=0;l<n-len+1;l++){
                int r=l+len-1;
                if(len<=2){
                    dp[l][r]=s.charAt(l)==s.charAt(r)?true:false;
                }
                else{
                    if(s.charAt(l)==s.charAt(r)){
                        dp[l][r]=dp[l+1][r-1];
                    }
                }
            }
        }
        memo=new Boolean[n+1][4];
        return solve(n,3,0);
    }
}