class Solution {
    public long[] getDistances(int[] arr) {
        int n=arr.length;
        long ans[]=new long[n];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                List<Integer> curr=map.get(arr[i]);
                    curr.add(i);
                map.put(arr[i],curr);
            }
            else{
                List<Integer> curr=new ArrayList<>();
                curr.add(i);
                map.put(arr[i],curr);
            }
        }
        for(List<Integer> list:map.values()){
            int len=list.size();
                // System.out.println(len);
            long prefix[]=new long[len];
            prefix[0]=list.get(0);
            for(int i=1;i<len;i++){
                prefix[i]=prefix[i-1]+list.get(i);
                //  System.out.println("prefix "+prefix[i]);
            }
            for(int i=0;i<len;i++){
                int idx=list.get(i);
                long left=(long)idx*i-(i==0?0:prefix[i-1]);
                long right=prefix[len-1]-prefix[i]-(long)idx*(len-i-1);
                ans[(int)idx]=left+right;
            }
        }
    return ans;}
}