public class DFS
{
    private boolean[] marked;
    private int s;
   
    DFS(Graph G, int s)
    {
        this.s = s;
        marked = new boolean[G.V()];
        dfs(G,s); 
    }     

    private void dfs(Graph G, int v)
    {
        marked[v] = true;
        for(int w : G.adj(v)) 
        {
            if(!marked[w])
            {
                dfs(G,w);
            }
        }
    }  

    public boolean isConnected(int v)
    {
        return marked[v];                    // This shows that the component is connected or not.
    }
    
    public static void main(String[] args)
    {
        Graph g = new Graph(13);
        g.addEdge(0,5); 
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,6);
        g.addEdge(5,3);
        g.addEdge(3,4);
        g.addEdge(4,6);
        g.addEdge(11,12);
        g.addEdge(9,10);
        g.addEdge(9,11);
        g.addEdge(9,12);
        g.addEdge(7,8);
        g.addEdge(5,4);

        DFS dfs = new DFS(g, 0);
        System.out.println(dfs.isConnected(3));
        System.out.println(dfs.isConnected(11));
        
    }
}
