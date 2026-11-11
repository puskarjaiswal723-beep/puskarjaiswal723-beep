class Solution {
    class Edge{
        int src;
        int dst;
        Edge(int src,int dst){
            this.src=src;
            this.dst=dst;
        }
    }
    boolean check(String str1,String str2){
        int count=0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                count++;
            }
        }
    return count==1;}
int bfs(List<Edge> graph[],String arr[],String target,int n){
        boolean visit[]=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        visit[0]=true;
        int stp=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr=q.poll();
               // System.out.println(arr[curr]);
                if(curr!=0 && arr[curr-1].equals(target)){
                    return stp;
                }
                for(Edge e:graph[curr]){
                    if(!visit[e.dst]){
                        visit[e.dst]=true;
                        q.add(e.dst);
                    }
                }
            }
            stp++;
        }
        return -1;
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        if(startGene.equals(endGene)){
            return 0;
        }
        List<Edge> graph[]=new ArrayList[bank.length+1];
        int n=graph.length;
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            if(check(startGene,bank[i])){
                graph[0].add(new Edge(0,i+1));
                graph[i+1].add(new Edge(i+1,0));
            }
        }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n-1;j++){
                if(check(bank[i],bank[j])){
                    graph[i+1].add(new Edge(i+1,j+1));
                    graph[j+1].add(new Edge(j+1,i+1));
                }
            }
        }
    return bfs(graph,bank,endGene,n);
    
    }
}