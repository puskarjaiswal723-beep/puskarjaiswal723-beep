class Solution {
    int dp[][];
    int memo[][];
    int solve(int n,int parts,int pos){
            if(parts==0){
                return pos==n?0:Integer.MAX_VALUE;
            }
            if(n-pos<2*parts){
                return Integer.MAX_VALUE;
            }
        if(memo[pos][parts]!=-1){
            return memo[pos][parts];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=pos+1;i<n;i++){
            int min=solve(n,parts-1,i+1);
            if(min!=Integer.MAX_VALUE){
                ans=Math.min(ans,min+dp[pos][i]);
            }
        }
        memo[pos][parts]=ans;
        return ans;
    }
    public int minimumChanges(String s, int k) {
    int n=s.length();
        dp=new int[n][n];
        int cost[][] = new int[n][n];

for (int l=0;l<n;l++) {
    for (int r = l + 1; r < n; r++) {

        int len = r - l + 1;
        int ans = Integer.MAX_VALUE;

        for (int d = 1; d < len; d++) {

            if (len % d != 0) {
                continue;
            }

            int changes = 0;

            for (int j = 0; j < d; j++) {

                int left = l + j;
                int right = r-(d-1-j);

                while (left < right) {

                    if (s.charAt(left) != s.charAt(right)) {
                        changes++;
                    }

                    left += d;
                    right -= d;
                }
            }

            ans = Math.min(ans, changes);
        }

        dp[l][r] = ans;
    }
}

        memo=new int[n+1][k+1];
        for(int arr[]:memo){
            Arrays.fill(arr,-1);
        }
    return solve(n,k,0);}
}