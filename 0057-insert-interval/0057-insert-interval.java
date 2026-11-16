class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list=new ArrayList<>();
        int i=0;
        int n=intervals.length;
        while(i<n && intervals[i][1]<newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        int start=newInterval[0];
        int end=newInterval[1];
        while(i<n && end>=intervals[i][0]){
            end=Math.max(end,intervals[i][1]);
            start=Math.min(start,intervals[i][0]);
            i++;
        }
        list.add(new int[]{start,end});
        while(i<n ){
            list.add(intervals[i]);
            i++;
        }
        int arr[][]=new int[list.size()][2];
        for(int j=0;j<list.size();j++){
            arr[j]=list.get(j);
        }
        return arr;
    }
}