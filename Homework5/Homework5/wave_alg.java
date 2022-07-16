package Homework5;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class wave_alg {
    private static List<Integer> dostupnyeUzli(int n, int b, int h, int str, TreeMap<Integer,Integer> tm){
        List<Integer> ls = new ArrayList<>();
        if(n-1>0 && (n-b-1)%b!=0 && tm.get(n-1)!=str){//проверяем возможность добавления предущего узла в расчет
            ls.add(n-1);
        }
        if(n%b!=0 && tm.get(n+1)!=str){//проверяем возможность добавления следующего узла в расчет
            ls.add(n+1);
        }
        if((n-b)>0 && tm.get(n-b)!=str){//проверяем возможность добавления верхнего узла в расчет
            ls.add(n-b);
        }
        if((n+b)<=b*h && tm.get(n+b)!=str){//проверяем возможность добавления нижнего узла в расчет
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
                if(tm.get(item)==0 && item!=st) tm.put(item,wave);//помечаем все доступные непомеченные узлы номером волны
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
}
