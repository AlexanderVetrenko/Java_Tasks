package Homework4;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data_input {
    public List<String> Vvod_dannych(){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение.");
        System.out.println("Допустимо вводить функции (sin, cos и др.).");
        System.out.println("При необходимости использования числа Пи введите Pi.");
        System.out.println("Допускаются только круглые скобки");
        System.out.printf("Ваше выражение: ");
        String raw_s = sc.nextLine().trim();
        String s = raw_s.toLowerCase().replaceAll("\\s+", "");

        List<String> ls = new ArrayList<>();
        char [] matr = s.toCharArray();
        for (int i = 0; i < matr.length; i++) {
            //sb.append(matr[i]);
            ls.add(Character.toString(matr[i]));
            //sb.delete(0, sb.length());
        }
        sc.close();
        return ls;
    }
}
