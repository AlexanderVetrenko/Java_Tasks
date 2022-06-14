//Написать программу вычисления n-ого треугольного числа

import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Введите порядковый номер треугольного числа: \n");
        String s = sc.nextLine();
        try{
            int nm = Integer.parseInt(s.trim());
            System.out.printf("Треугольное число с порядковым номером %d равно %d \n", nm, Triangle_Nmb(nm));
        }
        catch (NumberFormatException nfe){
            System.out.println("Ошибка формата числа: " + nfe.getMessage());
        }
        sc.close();
    }

    public static int Triangle_Nmb(int m){
        return (int) (0.5*m*(m+1));
    } 
}