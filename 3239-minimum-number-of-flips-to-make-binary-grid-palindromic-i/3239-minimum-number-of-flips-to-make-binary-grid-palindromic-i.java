class Solution {
    public int minFlips(int[][] grid) {
        int rw=grid.length;
        int c=grid[0].length;
        int count1=0;
        for(int i=0;i<rw;i++){
            int l=0,r=c-1;
            while(l<r){
                if(grid[i][l]!=grid[i][r]){
                    count1++;
                }
                l++;
                r--;
            }
        }
        int count2=0;
        for(int i=0;i<c;i++){
            int l=0,r=rw-1;
            while(l<r){
                if(grid[l][i]!=grid[r][i]){
                    count2++;
                }
                l++;
                r--;
            }
        }
    return Math.min(count1,count2);}
}