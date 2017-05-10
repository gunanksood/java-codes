import java.util.*;
class Minheap
{
    private int[] heapArray;
    private int heapSize = 1;
    Minheap(int size)
    {
        heapArray = new int[size];

    }
    public void insert(int i)
    {
        heapArray[heapSize++] = i;
        swim(heapSize - 1);
    }
    public int getmin()
    {
        return heapArray[1];
    }
    public void delmin()
    {
        swap(1,heapSize - 1);
        heapArray[--heapSize] = 0;
        sink(1);
    }
    public void swap(int i , int j)
    {
        int temp = heapArray[i];
        heapArray[i] = heapArray[j];
        heapArray[j] = temp;
    }
    
    private void swim(int i)
    {
        if(i <= 1)
            return;

        if(heapArray[i] < heapArray[i/2])
        {
            swap(i , i/2);
            swim(i/2);
        }
    }
    
    public void sink(int i)
    {
        int left = 2 * i;
        int right = 2 * i +1;
        int min = i;
        if(left < heapSize && heapArray[left] < heapArray[min])
        {
            min = left;
        }
        if(right < heapSize && heapArray[right] < heapArray[min])
        {
            min = right;
        }
        if(min != i)
        {
            swap(i , min);
            sink(min);
        }
    }



public static void main(String[] args)
{
    System.out.println("enter the size of heap");
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    Minheap g= new Minheap(n);
    for(int i = 1 ;i < n ; i++)
    {
        int z = in.nextInt();
        g.insert(z);
    }
    System.out.println("Minimum element in heap is "+g.getmin());
    g.delmin(); 
    System.out.println("Minimum element in heap is "+g.getmin());
}
}

