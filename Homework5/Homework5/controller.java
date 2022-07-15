package Homework5;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

public class controller {
    public void waveAlgorythm() throws IOException {
        data_input di = new data_input();
        List<Integer> ls = di.dannye();//формируем список исходных данных: ширина, высота, начало поиска, конец поиска, количество препятствий
        System.out.println(ls);
        TreeMap<Integer,Integer> trmp = di.formiryemPole(ls);
    }
    
}
