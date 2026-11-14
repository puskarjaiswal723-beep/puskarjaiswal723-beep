class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int prefix[]=new int[n+1];
        for(int i=1;i<=n;i++){
            prefix[i]=nums.get(i-1)+prefix[i-1];
        }
        int min=Integer.MAX_VALUE;
        for(int len=l;len<=r;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len;
                int sum=prefix[j]-prefix[i];
                if(sum>0){
                min=Math.min(min,sum);
                }
            }
        }
   return min==Integer.MAX_VALUE?-1:min; }
}