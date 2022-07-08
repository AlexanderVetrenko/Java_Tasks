package Homework4;

import java.util.List;

public class controller {
    public void Postfix_notation(String[] args) {
        data_input dv = new data_input();
        List<String> ls = dv.Vvod_dannych();
        System.out.println(ls);
        postfix pf = new postfix();
        List<String> ls1 = pf.in_postfix(ls);
        System.out.println(ls1);
        double res = pf.calc(ls1);
        System.out.printf("%.4f",res);
    }
}
