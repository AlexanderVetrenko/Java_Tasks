import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ChessKnight {
    public static void main(String[] args) {
        int n = Razmer_Doski(); 
        //System.out.println(n);
        //System.out.println(Nomer_Polya(2, 7, n));
        //Print_Array(Koordinaty_Polya(64, n));
        //Narisovat_Dosku(n);
        List<List<Integer>> Log = new ArrayList<>();
        Log = Perviy_Chod(n);
        System.out.println(Log);
        System.out.println(Poisk_Choda(Log.get(Log.size()-1), n));
    }
    
    public static List<List<Integer>> Poisk_Choda(List<Integer> list, int m){
        List<List<Integer>> res = new ArrayList<>();
        if((list.get(0)-2)>0 && (list.get(1)-1)>0){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)-2);
            temp.add(list.get(1)-1);
            res.add(temp);
        }
        if((list.get(0)-2)>0 && (list.get(1)+1)<m){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)-2);
            temp.add(list.get(1)+1);
            res.add(temp);
        }
        if((list.get(0)-1)>0 && (list.get(1)-2)>0){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)-1);
            temp.add(list.get(1)-2);
            res.add(temp);
        }
        if((list.get(0)-1)>0 && (list.get(1)+2)<m){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)-1);
            temp.add(list.get(1)+2);
            res.add(temp);
        }
        if((list.get(0)+1)<m && (list.get(1)-2)>0){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)+1);
            temp.add(list.get(1)-2);
            res.add(temp);
        }
        if((list.get(0)+1)<m && (list.get(1)+2)<m){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)+1);
            temp.add(list.get(1)+2);
            res.add(temp);
        }
        if((list.get(0)+2)<m && (list.get(1)-1)>0){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)+2);
            temp.add(list.get(1)-1);
            res.add(temp);
        }
        if((list.get(0)+2)<m && (list.get(1)+1)<m){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)+2);
            temp.add(list.get(1)+1);
            res.add(temp);
        }
        
        return res;
    }
    public static List<List<Integer>> Perviy_Chod(int m){
        List<List<Integer>> Log = new ArrayList<>();
        List<Integer> Koord = new ArrayList<>();
        Random k = new Random();
        Koord.add(k.nextInt(m));
        Koord.add(k.nextInt(m));
        Log.add(Koord);
        return Log;
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