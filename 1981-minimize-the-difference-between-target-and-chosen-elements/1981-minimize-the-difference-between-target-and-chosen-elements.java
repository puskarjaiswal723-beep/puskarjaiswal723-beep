class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        boolean prev[]=new boolean[4901];
        int r=mat.length;
        int c=mat[0].length;
        prev[0]=true;
        for(int i=0;i<r;i++){
            boolean curr[]=new boolean[4901];
            for(int j=0;j<c;j++){
                for(int k=0;k<=4900;k++){
                    if(prev[k]){
                        curr[k+mat[i][j]]=true;
                    }
                }
            }
            prev=curr;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<4901;i++){
            if(prev[i]){
                min=Math.min(min,Math.abs(target-i));
            }
        }
    return min;}
}