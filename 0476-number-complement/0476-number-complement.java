class Solution {
    public int findComplement(int num) {
        StringBuilder str=new StringBuilder();
        while(num!=0){
            str.append(num%2);
            num/=2;
        }
        str.reverse();
        str.toString();
        int n=0;
        //System.out.println(str);
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='1'){
                n=n*2+0;
            }
            else{
                n=n*2+1;
            }
        }
    return n;}
}