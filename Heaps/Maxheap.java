import java.util.*;

class Maxheap
{
    private int[] heapArray;
    private int heapSize = 1;
    public Maxheap(int max)
    {
        heapArray = new int[max];
    }
    public void insert(int i)
    {
        heapArray[heapSize++] = i;
        swim(heapSize - 1);
    }
    public int getmax()
    {
        return heapArray[1];
    }

    public void delMax()
    {
        swap(1, heapSize-1);
        heapArray[--heapSize] = 0;
        sink(1);
        
    }
    private void swap(int i , int j)
    {
        int temp = heapArray[i];
        heapArray[i] = heapArray[j];
        heapArray[j] = temp;
    }
    private void swim(int i)
    {
        if(i <= 1)
            return;
        if(heapArray[i] > heapArray[i/2])
        {
            swap(i,i/2);
            swim(i/2);
        }
    }
    private void sink(int i)
    {
        int left = 2*i;
        int right = 2* i + 1;
        int max = i;
        if(left < heapSize && heapArray[left] > heapArray[max])
        {
            max = left;
        }
        if(right < heapSize && heapArray[right] > heapArray[max])
        {
            max = right;
        }
        if(max != i)
        {
            swap(i, max);
            sink(max);
        }
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the size of heap ");
        int n = input.nextInt();
        Maxheap h = new Maxheap(n);
        for(int i = 1 ; i < n ; i++)
        {
            int z = input.nextInt();
            h.insert(z);
        }
        System.out.println("maximum element is : "+h.getmax());
        h.delMax(); 
        System.out.println("maximum element is : "+h.getmax());
    }
}
