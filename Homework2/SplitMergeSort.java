public class SplitMergeSort {
    public static int [] SplitArr(int [] matrix) {
        if (matrix.length < 2){
            return matrix;
        }
        int l = (matrix.length/2);
        int r = matrix.length - (matrix.length/2);
        
        int [] matrL = new int[l];
        int [] matrR = new int[r];

        System.arraycopy(matrix, 0, matrL, 0, l);
        System.arraycopy(matrix, l, matrR, 0, r);

        SplitArr(matrL);
        SplitArr(matrR);
        MergeArr(matrix, matrL, matrR);
        return matrix;
    }

    public static void MergeArr(int [] matr, int [] matrixL, int [] matrixR) {

        int posL = 0;
        int posR = 0;
        
        for (int i = 0; i < matr.length; i++) {
            if (posL == matrixL.length){
            matr[i] = matrixR[posR];
            posR++;
            } 
            else if (posR == matrixR.length) {
            matr[i] = matrixL[posL];
            posL++;
            } 
            else if (matrixL[posL] < matrixR[posR]) {
            matr[i] = matrixL[posL];
            posL++;
            } 
            else {
            matr[i] = matrixR[posR];
            posR++;
            }
        }
    }

    public static void main(String[] args) {
    int [] Arr = new int[] {9,4,5,3,1,6,8,7,2};
    Arr = SplitArr(Arr);
    for (int i = 0; i < Arr.length; i++) {
        System.out.print(Arr[i] + " ");
    }
    }
}
