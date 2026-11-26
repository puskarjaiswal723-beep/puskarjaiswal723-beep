class Solution {
    class Pair{
        char ch;
        int count;
        Pair(char ch,int count){
            this.ch=ch;
            this.count=count;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->y.count-x.count);
        if(a!=0){
        pq.add(new Pair('a',a));
        }
        if(b!=0){
        pq.add(new Pair('b',b));
        }
        if(c!=0){
        pq.add(new Pair('c',c));
        }
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            int n=sb.length();
            if(n>=2 && curr.ch==sb.charAt(n-1) && curr.ch==sb.charAt(n-2)){
                if(pq.isEmpty()){
                    break;
                }
                Pair nx=pq.remove();
                sb.append(nx.ch);
                nx.count--;
                if(nx.count>0){
                    pq.add(nx);
                }
                sb.append(curr.ch);
                curr.count--;
                if(curr.ch>0){
                    pq.add(curr);
                }
            }
            else{
                sb.append(curr.ch);
                curr.count--;
                if(curr.count>0){
                    pq.add(curr);
                }
            }
        }
    return sb.toString();}
}