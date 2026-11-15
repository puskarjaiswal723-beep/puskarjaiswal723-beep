class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod=1000000007;
        int count=0,o=0,sum=0;
        int e=1;
        for(int x:arr){
            sum+=x;
            if(sum%2==0){
                count=(count+o)%mod;
                e++;
            }
            else{
                count=(count+e)%mod;
                o++;
            }
        }
return count;
    }
}