class Solution {
    public long[] distance(int[] nums){
        HashMap<Integer,List<Integer> >map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                List<Integer> curr=map.get(nums[i]);
                curr.add(i);
                map.put(nums[i],curr);
            }
            else{
                List<Integer> curr=new ArrayList<>();
                curr.add(i);
                map.put(nums[i],curr);
            }
        }
        long ans[]=new long[nums.length];
        for(List<Integer> arr:map.values()){
            int n=arr.size();
            long prefix[]=new long[n+1];
            for(int i=0;i<n;i++){
                prefix[i+1]=prefix[i]+arr.get(i);
            }
            for(int i=0;i<n;i++){
            long idx=arr.get(i);
                long left=idx*i-prefix[i];
                long right=(prefix[n]-prefix[i+1])-idx*(n-i-1);
                ans[(int)idx]=left+right;
            }

        }
        return ans;
    }
}