class Solution {
    public int minFlipsMonoIncr(String s) {
        int max=0;
        int count1=0;
        for(char ch:s.toCharArray()){
            if(ch=='1'){
                count1++;
            }
            else{
                if(count1>0){
                    max++;
                count1--;
                }
            }}

       return max; }
    }
