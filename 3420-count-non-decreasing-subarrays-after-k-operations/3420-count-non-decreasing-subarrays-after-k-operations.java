class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        long count=0;
        long sub=0;
        int n=nums.length;
        int j=n-1;
        for(int i=n-1;i>=0;i--){
            //System.out.println(dq.toString());
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                int l=dq.pollLast();
                int r=!dq.isEmpty()?dq.peekLast():j+1;
                count+=(long)(r-l)*(nums[i]-nums[l]);
            }
            //System.out.println(i+"#");
            dq.offerLast(i);
            while(count>k){
                count-=nums[dq.peekFirst()]-nums[j];
                if(j==dq.peekFirst()){
                    dq.pollFirst();
                }
                j--;
            }
            sub+=j-i+1;
        }
    return sub;}
}