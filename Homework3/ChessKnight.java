import java.util.Scanner;
public class ChessKnight {
    public static void main(String[] args) {
        int n = Razmer_Doski(); 
        //System.out.println(n);
        //System.out.println(Nomer_Polya(2, 7, n));
        //Print_Array(Koordinaty_Polya(64, n));
        Narisovat_Dosku(n);
    }
    public static void Narisovat_Dosku(int m){
        int [][] arr = new int[m][m];
        String k = "+----+";
        for (int index = 0; index < m-1; index++) {
            k+="----+";
        } 
        System.out.print(k);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("| %-3d",Nomer_Polya(i, j, m));
            }
            System.out.print("|");
            System.out.println();
            System.out.print(k);
            System.out.println();
        }
    }
    public static void Print_Array(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
    }
    public static int[] Koordinaty_Polya(int n, int s){
        int [] arr = new int[2];
        if(n%s == 0) arr[0] = n/s-1;
        else arr[0] = n/s;
        arr[1] = n-(arr[0]*s)-1;
        return arr;
    }
    public static int Nomer_Polya(int i,int j, int s){   
        return i*s+j+1;
    }
    public static int Razmer_Doski(){     
        int nm = Proverka_Chisla();
        while(nm<5){
            nm=Proverka_Chisla();
        }
        return nm;
    }
    public static int Proverka_Chisla(){
        Scanner sc = new Scanner(System.in);//ругается на утечку данных из-за незакрываемого сканнера.
        System.out.printf("Введите сторону шахматной доски (целые числа не менее 5): \n");
        String s = sc.nextLine();
        int nmb;
        try{
            nmb = Integer.parseInt(s.trim());
        }
        catch (NumberFormatException nfe){
            nmb = 0;
        }
        //sc.close(); если сканнер закрыть, вылетает ошибка, если не закрывать - работает. Почему???
        return nmb;
    }
}