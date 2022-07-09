package Homework4;

import java.util.List;

public class controller {
    public void Postfix_notation(String[] args) {
        data_input dv = new data_input();
        List<String> ls = dv.Vvod_dannych();//получаем отформатированный список строковых значений, по результатам анализа введенного выражения
        //System.out.println(ls);
        postfix pf = new postfix();
        List<String> ls1 = pf.in_postfix(ls);//получаем список строковых значений в постфиксной нотации
        view pl = new view();
        pl.printList(ls1);//выводим на экран запись пользователя в постфиксной нотации
        double res = pf.calc(ls1);//получаем результат расчета в постфиксной нотации
        System.out.printf("Результат вычисления: %.4f",res);
    }
}
