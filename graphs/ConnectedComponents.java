public class ConnectedComponents {
    private boolean[] marked;
    private int id[];
    private int count;

    ConnectedComponents(Graph G)
    {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for(int i = 0; i < G.V(); i++)
        {
            if(!marked[i]) {
                dfs(G, i);
               count++;
           }
        }
    }

    private void dfs(Graph G, int v)
    {
        marked[v] = true;
        id[v] = count;
        for(int w : G.adj(v))
        {
            if(!marked[w])
            {
                dfs(G, w);
            }
        }
    }

    public boolean isConnected(int v) {
        return marked[v];
    }

    public int getCount() {
        return this.count;
    }

     public int getId(int v)
     {
         return this.id[v];
     }

    public static void main(String[] args) {
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

        ConnectedComponents cc = new ConnectedComponents(g);
        System.out.println(cc.getCount());
        for (int i = 0; i < g.V(); i++)
        {
            System.out.print(cc.getId(i) + " ");
        }
    }
}
