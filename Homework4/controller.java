package Homework4;

import java.util.List;

public class controller {
    public static void main(String[] args) {
        data_input dv = new data_input();
        List<String> ls = dv.Vvod_dannych();
        postfix pf = new postfix();
        List<String> ls1 = pf.in_postfix(ls);
        System.out.println(ls1);
    }
}
