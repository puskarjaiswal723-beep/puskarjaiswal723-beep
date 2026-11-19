class Solution {
    public boolean isBipartite(int[][] graph) {
        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();
        Queue<Integer> q=new  LinkedList<>();
        boolean visit[]=new boolean[graph.length];
        for(int src=0;src<graph.length;src++){
            if(visit[src]){
                continue;
            }
            q.add(src);
            set1.add(src);
            visit[src]=true;
            boolean first=false;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr=q.poll();
                for(int j=0;j<graph[curr].length;j++){
                    if(!first){
                        if(set1.contains(graph[curr][j])){
                            //System.out.println("%");
                            return false;
                        }
                        if(!visit[graph[curr][j]]){
                        set2.add(graph[curr][j]);
                        q.add(graph[curr][j]);
                        visit[graph[curr][j]]=true;
                        }
                    }
                    else{
                        if(set2.contains(graph[curr][j])){
                            //System.out.println("#");
                            return false;
                        }
                        if(!visit[graph[curr][j]]){
                        set1.add(graph[curr][j]);
                        q.add(graph[curr][j]);
                        visit[graph[curr][j]]=true;}
                    }
                }
                // if(set1.size()+set2.size()==graph.length-1){

                //     return true;
                // }
            }
                first=!first;
        }}
        return true;
 }   //return set1.size()+set2.size()==graph.length;}
}