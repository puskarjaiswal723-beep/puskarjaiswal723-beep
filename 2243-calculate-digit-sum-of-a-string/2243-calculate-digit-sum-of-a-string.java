class Solution {
    int get_sum(String str){
        int sum=0;
        for(int i=0;i<str.length();i++){
            sum+=str.charAt(i)-'0';
    }
        return sum;
    }
    public String digitSum(String s, int k) {
        if(s.length()<=k){
            return s;
        }
        boolean found=true;
        while(found){
        StringBuilder str=new StringBuilder();
        int n=s.length();
        for(int i=0;i<n;i+=k){
            if(i+k>n){
                str.append(get_sum(s.substring(i,n)));
            }
            else{
                str.append(get_sum(s.substring(i,i+k)));
            }
        }
        if(str.length()<=k){
            return str.toString();
        }
        else{
            s=str.toString();
        }
        }
        return "";}}
    
