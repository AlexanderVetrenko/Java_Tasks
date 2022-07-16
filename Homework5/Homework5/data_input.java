package Homework5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class data_input{
    public List<Integer> dannye() throws IOException{
        List<Integer> list = new ArrayList<>();
        int b = tryCatchIt("Введите ширину поля (целое число от 5 до 12) \n",5,12);
        while(b==-1 || b<5 || b>12){
            b=tryCatchIt("Введите корректное значение: \n",5,12);
        }
        list.add(b);
        int h = tryCatchIt("Введите высоту поля (целое число от 2 до 12) \n",2,12);
        while(h==-1 || h<2 || h>12){
            h=tryCatchIt("Введите корректное значение: \n",2,12);
        }
        list.add(h);
        String soob1 = "Введите номер начального узла (от 1 до "+Integer.toString(b*h)+")"+"\n";
        int strt = tryCatchIt(soob1,1,b*h);
        while(strt==-1 || strt<1 || strt>b*h){
            strt=tryCatchIt("Введите корректное значение: \n",1,b*h);
        }
        list.add(strt);
        String soob2 = "Введите номер конечного узла (от 1 до "+Integer.toString(b*h)+")"+"\n";
        int kon = tryCatchIt(soob2,1,b*h);
        while(kon==-1 || kon<1 || kon>b*h){
            kon=tryCatchIt("Введите корректное значение: \n",1,b*h);
        }
        if(strt==kon){
            System.out.println("Конечный узел не может быть равен начальному.");
            System.exit(1);
        }
        list.add(kon);

        String soob3 = "Введите количество препятствий (от 0 до "+Integer.toString(b*h/10)+")"+"\n";
        int stena = tryCatchIt(soob3,0,b*h/10);
        while(stena<=-1 || stena>(b*h/10)){
            stena=tryCatchIt("Введите корректное значение: \n",0,b*h/10);
        }
        list.add(stena);
        System.in.close();
        return list;
    }
    public TreeMap<Integer,Integer> formiryemPole(List<Integer> ls){
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        //распаковываем список:
        int b=ls.get(0); int h=ls.get(1);int strt=ls.get(2);       
        int kon = ls.get(3);int r = ls.get(4);
        //создаем начальное поле при помощи treemap:
        for (int i = 1; i <= b*h; i++) {
            tm.put(i,0);
        }
        //добавляем препятствия:
        if(r!=0){
            Random k = new Random();
            int pr = k.nextInt(b*h);
            for (int i = 0; i < r; i++) {
                while( pr==0 || pr==strt || pr==kon || tm.get(pr)==-1){
                    pr=k.nextInt(b*h);
                }
                tm.put(pr,-1);
                pr=k.nextInt(b*h);
            }
        }
         /* for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
       } */
        return tm;
    }
    private static int tryCatchIt(String s, int min, int max){
        Scanner sc = new Scanner(System.in);
        System.out.printf(s,"\n");
        String s1 = sc.nextLine();
        
        int n;
        try{
            n = Integer.parseInt(s1.trim());
        }
        catch (NumberFormatException nfe){
            n = -1;
        }
        return n;
    }
}