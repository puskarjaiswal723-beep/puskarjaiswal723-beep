class Solution {
    HashMap<String,Integer> map=new HashMap<>();
    int solve(int arr[],int target){
        if(target==0){
            return 1;
        }
        if(target<0){
            return 0;
        }
        if(map.containsKey(""+target)){
            return map.get(""+target);
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            int ways=solve(arr,target-arr[i]);
            count+=ways;
            
        }
        map.put(""+target,count);
        return count;

    }
    public int combinationSum4(int[] nums, int target) {
        return solve(nums,target);
        
    }
}