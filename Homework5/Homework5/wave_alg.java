package Homework5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.TreeMap;

public class wave_alg {
    private static List<Integer> dostupnyeUzli(int n, int b, int h, int str, TreeMap<Integer,Integer> tm){
        List<Integer> ls = new ArrayList<>();
        if(n-1>0 && (n-b-1)%b!=0 && (n-1)!=str){//проверяем возможность добавления предущего узла в расчет
            ls.add(n-1);
        }
        if(n%b!=0 && (n+1)!=str){//проверяем возможность добавления следующего узла в расчет
            ls.add(n+1);
        }
        if((n-b)>0 && (n-b)!=str){//проверяем возможность добавления верхнего узла в расчет
            ls.add(n-b);
        }
        if((n+b)<=b*h && (n+b)!=str){//проверяем возможность добавления нижнего узла в расчет
            ls.add(n+b);
        }
        return ls;
    }
    public TreeMap<Integer, Integer> waveAlg(TreeMap<Integer, Integer> tm, int st, int b, int h, int kon){
        List<Integer> ls = dostupnyeUzli(st, b, h, st, tm);//определяем первичные доступные узлы от стартового узла
        int wave = 0;
        while(!ls.isEmpty() && tm.get(kon) == 0){
            wave+=1;
            for (Integer item : ls) {
                if(tm.get(item)==0) tm.put(item,wave);//помечаем все доступные непомеченные узлы номером волны
            }
            List<Integer> tmp = new ArrayList<>();
            for (Integer item : ls) {
                List<Integer> lst=dostupnyeUzli(item, b, h, st, tm);//определяем доступные узлы от каждого из текущих узлов
                for (Integer itm : lst) {
                    if(!tmp.contains(itm)) tmp.add(itm); 
                }
            }
            ls.clear();
            ls.addAll(tmp);
        }
        return tm;
    }
    public Stack<Integer> poiskXoda(TreeMap<Integer, Integer> tm, int st, int b, int h, int kon){
        Stack<Integer> stk = new Stack<>();
        stk.push(kon);
        List<Integer> tmp = new ArrayList<>();
        List<Integer> ls = dostupnyeUzli(kon, b, h, kon, tm);//определяем первичные доступные узлы от конечного узла
        int f = 0;
        int count = 0;
        for (Integer it : ls) {
            f+=tm.get(it); 
        }
        if(Math.abs(f)==ls.size()){
            System.out.println("Невозможно найти путь.");
            System.exit(1);
        }
        int n = kon;
        while(n!=st){
            for (Integer item : ls) {
                if(tm.get(n)-tm.get(item) == 1) tmp.add(item);
            }
            if(tmp.isEmpty()){
                n=kon;
                stk.clear();
                count+=1;
                if(count>100){
                    System.out.println("Невозможно найти путь.");
                    System.exit(1);
                }
            }else if(tmp.size()>1){
                Random k = new Random();
                int choice = k.nextInt(tmp.size());
                n=tmp.get(choice);
            }else {
                n=tmp.get(0);
            }
            tmp.clear();
            stk.push(n);
            ls = dostupnyeUzli(n, b, h, kon, tm);
        }
        return stk;
    }
}
