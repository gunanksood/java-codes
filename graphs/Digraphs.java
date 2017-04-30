import java.util.*;

public class Digraphs
{
    private int V;
    private node[] adj;
    int[] marked;
    int[] marked1;
    
    Digraphs(int v)
    {
        V = v;
        adj = new node[V];
        marked = new int[V];
        marked1 = new int[V];
        for(int i = 0 ;i < V; i++)
        {
            adj[i] = null;
            marked[i] = 0;
            marked1[i] = 0;
        }
    }

    class node
    {
        int data;
        node next;
        node(int val)
        {
            data = val;
            next = null;
        }
    }
 
    public int v()
    {
        return V;
    }

    void Addedge(int v, int w)
    {
        node new_node = new node(w);
        new_node.next = adj[v];
        adj[v] = new_node;
    }
    
    void dfs(int v)
    {
        System.out.print(" "+v+" ");
        marked[v] = 1;
        node temp = adj[v];
        while(temp != null)
        {
            int i = temp.data;
            if(marked[i] == 0)
            {
                dfs(i);
            }
            temp = temp.next;
        }
    }   

    void bfs(int v)
    {
        Queue <Integer>q = new LinkedList<Integer>();
        q.add(v);
        marked1[v] = 1;
        System.out.print(" "+v+" ");
        while(!q.isEmpty())
        {
            int w = q.poll();
            node temp = adj[w];
            while(temp != null)
            {
                int i = temp.data;
                if(marked1[i] == 0)
                {
                    q.add(i);
                    System.out.print(" "+i+" ");
                    marked1[i] = 1;
                }
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args)
    {
        Digraphs d = new Digraphs(6);
        d.Addedge(1,5);
        d.Addedge(5,4);
        d.Addedge(0,4);
        d.Addedge(0,3);
        d.Addedge(3,1);
        d.Addedge(0,5);
        System.out.println("DFS is "); 
        d.dfs(0);
        System.out.println();
        System.out.println("BFS is ");
        d.bfs(0);
    /*    for(int i = 0 ;i < d.v(); i++)
        {
            
            node temp = d.adj[i];           // to print the adjecency list of graph
            while(temp != null)
            {
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
           
        }
     */
    }    
    

}
