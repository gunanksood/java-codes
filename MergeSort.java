public class MergeSort<K extends Comparable>
{
    private K[] a;

    public MergeSort(K[] a){
        this.a = a;
    }
  
    void Mergesort(int l,int r)
    { 
        if(l >= r)
            return;
        int mid = (l + r) / 2;
        Mergesort(l,mid);
        Mergesort(mid+1,r);
        Merge(l,mid,r);
    }
    
    void Merge(int l,int m,int r)
    {
        
        int s1 = m - l +1;
        int s2 = r-m;
        K b[] = (K[])new Comparable[s1];
        K c[] = (K[])new Comparable[s2];

        for(int i = 0 ; i < s1; i++)
        {
            b[i] = a[l+i];
        }
        
        for(int i = 0 ; i < s2; i++)
        {
            c[i] = a[m+1+i];
        }
 
        int i = 0, j = 0, k = l;
        while(i < s1 && j < s2)
        {
            if(b[i].compareTo(c[j]) < 0)
            {
                a[k] = b[i];
                i++;
            }
            else
            {
                a[k] = c[j];
                j++;
            }
            k++;
        }
        while(i < s1)
        {
            a[k] = b[i];
            i++;
            k++;
        }
        
        while(j < s2)
        {
            a[k] = c[j];
            j++;
            k++;
        }
    }
    void print()
    {
        for(int i = 0 ; i < a.length ; i++)
        {
            System.out.print(a[i]+" ");
        }
    }

    public static void main(String[] args)
    {
        Integer[] a = {1,5,6,3,8};
        MergeSort<Integer> obj = new MergeSort<Integer>(a);
        int m = (0+a.length)/2;   
        obj.Mergesort(0,a.length-1); 
        obj.print();
        System.out.println();        
    }
}
