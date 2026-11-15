class Solution {
    public String smallestSubsequence(String s) {
       int arr[]=new int[26];
       int n=s.length();
       for(int i=0;i<n;i++){
            arr[s.charAt(i)-'a']=i;
       }
       boolean visit[]=new boolean[26];
       Stack<Character> stck=new Stack<>();
       for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(visit[ch-'a']){
                continue;
            }
            while(!stck.isEmpty() && stck.peek()>ch && arr[stck.peek()-'a']>i){
                visit[stck.pop()-'a']=false;
            }
            stck.push(ch);
            visit[ch-'a']=true;
       }
       StringBuilder str=new StringBuilder();
       for(char ch:stck){
        str.append(ch);
       }
       return str.toString();
    }
}