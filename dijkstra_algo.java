class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        boolean vis[] = new boolean[V+1];
        
        int ans[] = new int[V];
        
        Arrays.fill(ans,Integer.MIN_VALUE);
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b)->(a.w-b.w));
        
        pq.add(new Pair(S,0));
        
        while(!pq.isEmpty())
        {
            Pair p = pq.remove();
            
            if(vis[p.v]==true)
            {
                continue;
            }
            
            vis[p.v] = true;
            
            for(ArrayList<Integer> list:adj.get(p.v))
            {
                Pair t = new Pair(list.get(0),list.get(1)+p.w);
                if(vis[t.v]==true)
                {
                    continue;
                }
                pq.add(t);
            }
            
            ans[p.v] = p.w;
        }
        
        return ans;
    }
    
    static class Pair{
        int v;
        int w;
        Pair(int v,int w)
        {
            this.v = v;
            this.w = w;
        }
    }
}


