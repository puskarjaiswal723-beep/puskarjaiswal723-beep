class Solution {
    public boolean canAliceWin(int n) {
        if(n<10){
            return false;
        }
        n-=10;
        // if(n<9){
        //     return true;
        // }
        int r=9;
        while(n>=r){
            n-=r;
            r--;
        }
    return r%2!=0;
    }
}