class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int l1=0,l2=0;
        int max1=0,max2=0;
        int prev1=-1,prev2=-1;
        for(int i=0;i<nums.length;i++){
            if(prev1==-1 || prev1<nums[i]){
                max1=Math.max(i-l1+1,max1);
            }
            else{
                l1=i;
            }
            if(prev2==-1 || prev2>nums[i]){
                max2=Math.max(max2,i-l2+1);
            }
            else{
                l2=i;
            }
            prev1=nums[i];
            prev2=nums[i];
        }
    return Math.max(max1,max2);}
}