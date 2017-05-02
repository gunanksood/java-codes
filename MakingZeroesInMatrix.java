public class MakingZeroesInMatrix
{

    public static void main(String[] args)
    {

        int a[][] = { {3,4,5},
                      {6,8,0},
                      {9,4,3},
                      {0,6,8}, };
         int b[][] =  { {3,4,5},
                       {6,8,0},
                        {9,4,3},
                       {0,6,8}, };


        int r1[] = new int [4];
        int c1[] = new int [3];
//        int b[][] = new int [4][3];
        for(int i = 0 ; i < 4;i++)
        {
            r1[i] = 0;
        }        
        
        for(int i = 0 ; i < 3;i++)
        {
            c1[i] = 0;
        }        
        int i , j, r = 4, c = 3 ;
      //  b = a;
       
       for(i = 0; i < r; i++)
        {
            for(j = 0; j < c; j++)
            {
            /*    System.out.println(" a i j = "+a[i][j]);
                if(a[i][j] == 0)
                {
                    for(int k = 0; k < r; k++)
                    {
                        b[k][j] = 0;
                    }
                    for(int k = 0; k < c; k++)
                    { 
                      b[i][k] = 0;
                        System.out.println("hello");
                    }
                }
                else
                {
        //            b[i][j] = a[i][j];
                }
            */
                if(a[i][j] == 0)
                {
                    r1[i] = 1;
                    c1[j] = 1;
                }
            }
        }
         
         for(i = 0; i < r; i++)
         {
            for(j = 0; j < c ; j++)
            {
               if(r1[i] == 1 || c1[j] == 1)
               {
                   System.out.print(0+" ");
               }
               else
                System.out.print(a[i][j] + " ");
            //    System.out.print(a[i][j] + " ");
            }
            System.out.println();
         }
    }

}
