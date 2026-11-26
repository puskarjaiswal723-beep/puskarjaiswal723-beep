class Solution {
    class Pair{
        char ch;
        int count;
        Pair(char ch,int count){
            this.ch=ch;
            this.count=count;
        }
    }
    public String reorganizeString(String s) {
        int freq[]=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.count-a.count);
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                pq.add(new Pair((char)('a'+i),freq[i]));
            }
        }
         StringBuilder sb=new StringBuilder();
         while(pq.size()>=2){
            Pair curr1=pq.remove();        
            Pair curr2=pq.remove();
            sb.append(curr1.ch);
            sb.append(curr2.ch);
            curr1.count--;
            curr2.count--;
            if(curr1.count>0){
                pq.add(curr1);
            } 
            if(curr2.count>0){
                pq.add(curr2);
            }
            }
        if(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(curr.count>1){
                return "";
            }
            if(sb.length()>0 && sb.charAt(sb.length()-1)==curr.ch){
                return "";
            }
            sb.append(curr.ch);
    }
    return sb.toString();
        }
}