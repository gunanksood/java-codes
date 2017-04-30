import java.util.LinkedList;
public class Graph
{
    private final int V;
    private LinkedList<Integer> adj[];
    
    Graph(int V)
    {
        this.V = V;
        adj = (LinkedList<Integer> []) new LinkedList[V];
        for(int i = 0 ; i  < V ; i++)
        {
            adj[i] = new LinkedList<Integer>();
        }
    }
    public int V()
    {
        return V;
    }
    
    public void addEdge(int v, int w)
    {
        adj[v].add(w);
        adj[w].add(v);
    }
    
    public Iterable<Integer> adj(int v)
    {
        return adj[v];
    }
}
