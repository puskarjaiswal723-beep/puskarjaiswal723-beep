class Solution {
    public String largestPalindromic(String num) {
        int freq[]=new int[10];
        for(char ch:num.toCharArray()){
            freq[ch-'0']++;
        }
        StringBuilder str1=new StringBuilder();
        StringBuilder str2=new StringBuilder();
        for(int i=9;i>=0;i--){
            if(i==0 && str1.length()==0){
                freq[0]=0;
                continue;
            }
            if(freq[i]>1){
                int n1=freq[i]/2;
                int n2=n1;
                for(int j=0;j<n1;j++){
                    str1.append((char)('0'+i));
                }
                for(int j=0;j<n2;j++){
                    str2.append((char)('0'+i));
                }
               freq[i]-=n1+n2;
            }
        }
        for(int i=9;i>=0;i--){
            if(freq[i]%2!=0){
                str1.append(i);
                break;
            }
        }
        str1.append(str2.reverse());
        return str1.length()==0?"0":str1.toString();
    }
}