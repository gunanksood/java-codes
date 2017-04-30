import java.util.*;
public class BFS
{
    private boolean[] marked;
    private int s;
     
    BFS(Graph G, int s)
    {
        this.s = s;
        marked = new boolean[G.V()];
        bfs(G, s);
    }
    
    private void bfs(Graph G, int s)
    {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        while(!q.isEmpty())
        {
            int v = q.poll();
                
            for(int w : G.adj(v))
            {
                if(!marked[w])
                {
                    marked[w] = true;
                    q.add(w);
                }
            }
        }
    }
    
    public boolean isConnected(int v)
    {
        return marked[v];
    }

    public static void main(String[] args)
    { 
       Graph g = new Graph(13);
        g.addEdge(0, 5);
        g.addEdge(4, 3);
        g.addEdge(0, 1);
        g.addEdge(9, 12);
        g.addEdge(6, 4);
        g.addEdge(5, 4);
        g.addEdge(0, 2);
        g.addEdge(11, 12);
        g.addEdge(9, 10);
        g.addEdge(0, 6);
        g.addEdge(7, 8);
        g.addEdge(9, 11);
        g.addEdge(5, 3);

        BFS bfs = new BFS(g, 0);
        System.out.println(bfs.isConnected(3));
        System.out.println(bfs.isConnected(11));  
    } 
}
