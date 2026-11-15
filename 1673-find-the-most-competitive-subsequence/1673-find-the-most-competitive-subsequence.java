class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stck=new Stack<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            while(!stck.isEmpty() && stck.peek()>nums[i] && stck.size()+n-i-1>=k){
                stck.pop();
            }
            stck.push(nums[i]);
        }
        int arr[]=new int[k];
        int idx=0;
        for(int x:stck){
            arr[idx++]=x;
            if(idx==k){
                return arr;
            }
        }
    return arr;}
}