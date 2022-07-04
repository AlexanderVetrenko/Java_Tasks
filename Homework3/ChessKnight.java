package Homework3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
//Реализовал правило Вансдорфа. Работает не всегда стабильно.
//Поэтому, если вылетела ошибка, надо перезапустить.
//Скорее всего это связано с тем, что конь может зайти в тупик, если начинает с определенных ячеек.
//Как вариант, можно начальное положение коня было бы ограничить углами или серединой доски.
//Но делать этого не стал, поскольку и вариант с вылетом программы тоже представляет интерес.
//Программу ограничил интервалом ширины доски 5-11 клеток.
//В принципе, она работает и для 100 клеток - пробовал - но долго, минуты 3 у меня машина считала, и посчитала.

public class ChessKnight {
    public static void main(String[] args) {
        List<List<Integer>> Log = new ArrayList<>();
        List<List<Integer>> Prom_List = new ArrayList<>();
        int n = Razmer_Doski(); 
        Log = Perviy_Chod(n);
        while(Log.size()<n*n){
            Prom_List = Poisk_Choda(Log.get(Log.size()-1), n, Log);
            int min; int index=0;
            min = Poisk_Choda(Prom_List.get(0),n,Log).size();
            for (List<Integer> item : Prom_List){
                if(Poisk_Choda(item,n,Log).size()<min) {
                    min = Poisk_Choda(item,n,Log).size();
                    index = Prom_List.indexOf(item);
                }
            }
            Log.add(Prom_List.get(index));
        }
        Narisovat_Dosku(n);
        System.out.println();
        for (List<Integer> item : Log){
            System.out.printf("%d -> ",Nomer_Polya(item, n));
        }
    }
    
    public static List<List<Integer>> Poisk_Choda(List<Integer> list, int m, List<List<Integer>> big_list){
        List<List<Integer>> res1 = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        if((list.get(0)-2)>=0 && (list.get(1)-1)>=0){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)-2);
            temp.add(list.get(1)-1);
            res1.add(temp);
        }
        if((list.get(0)-2)>=0 && (list.get(1)+1)<m){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)-2);
            temp.add(list.get(1)+1);
            res1.add(temp);
        }
        if((list.get(0)-1)>=0 && (list.get(1)-2)>=0){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)-1);
            temp.add(list.get(1)-2);
            res1.add(temp);
        }
        if((list.get(0)-1)>=0 && (list.get(1)+2)<m){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)-1);
            temp.add(list.get(1)+2);
            res1.add(temp);
        }
        if((list.get(0)+1)<m && (list.get(1)-2)>=0){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)+1);
            temp.add(list.get(1)-2);
            res1.add(temp);
        }
        if((list.get(0)+1)<m && (list.get(1)+2)<m){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)+1);
            temp.add(list.get(1)+2);
            res1.add(temp);
        }
        if((list.get(0)+2)<m && (list.get(1)-1)>=0){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)+2);
            temp.add(list.get(1)-1);
            res1.add(temp);
        }
        if((list.get(0)+2)<m && (list.get(1)+1)<m){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0)+2);
            temp.add(list.get(1)+1);
            res1.add(temp);
        }
        for (List<Integer> item : res1) {
            if(big_list.contains(item)==false){
                res.add(item);
            }
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
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                System.out.printf("| %-3d",Nomer_Polya(temp, m));
            }
            System.out.print("|");
            System.out.println();
            System.out.print(k);
            System.out.println();
        }
    }
    public static int Nomer_Polya(List<Integer> list, int m){   
        return list.get(0)*m+list.get(1)+1;
    }
    public static int Razmer_Doski(){     
        int nm = Proverka_Chisla();
        while(nm<5 || nm>11){
            nm=Proverka_Chisla();
        }
        return nm;
    }
    public static int Proverka_Chisla(){
        Scanner sc = new Scanner(System.in);//ругается на утечку данных из-за незакрываемого сканнера.
        System.out.printf("Введите сторону шахматной доски (целые числа не менее 5 и не более 11): \n");
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