public class HeapSort {
    public static void sort(int matr[])
    {
        int n = matr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(matr, n, i);
   
        for (int i=n-1; i>=0; i--)
        {
            int temp = matr[0];
            matr[0] = matr[i];
            matr[i] = temp;

            heapify(matr, i, 0);
        }
    }
    public static void heapify(int arr[], int m, int k)
    {
        int biggest = k;
        int lft = 2*k + 1;
        int rght = 2*k + 2;

        if (lft < m && arr[lft] > arr[biggest])
            biggest = lft;

        if (rght < m && arr[rght] > arr[biggest])
            biggest = rght;

        if (biggest != k)
        {
            int s = arr[k];
            arr[k] = arr[biggest];
            arr[biggest] = s;

            heapify(arr, m, biggest);
        }
    }
    public static void printArray(int arr[])
    {
        int ln = arr.length;
        for (int i=0; i<ln; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        int [] Arr = new int[] {9,4,5,3,1,6,8,7,2};
        sort(Arr);
        printArray(Arr);
    }
}
