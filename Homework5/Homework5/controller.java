package Homework5;

import java.io.IOException;
import java.util.List;

public class controller {
    public void waveAlgorythm() throws IOException {
        data_input di = new data_input();
        List<Integer> ls = di.dannye();
        System.out.println(ls);
    }
    
}
