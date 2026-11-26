class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n=nums.length;
        long prefix[]=new long[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        List<Long> list=new ArrayList<>();
        for(int x:queries){
           
            int idx=Arrays.binarySearch(nums,x);
            //System.out.println("idx "+idx);
            if(idx<0){
                idx=-(idx+1);
            }
                long left=idx==0?0:prefix[idx-1];
               // System.out.println("left "+left);
                long right=prefix[n-1]-left;
                long change=(long)idx*x-left+right-(long)(n-idx)*x;
            
            list.add(change);
        }

        return list;
    }
}