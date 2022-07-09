package Homework4;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class data_input {
    public List<String> Vvod_dannych(){
        //Выводим минимум правил на экран
        System.out.println("Введите арифметическое выражение.");
        System.out.println("Допустимы только целые числа. Дробные могут быть введены как отношение целых в выражении.");
        System.out.println("Например, число 0,25 это 1/4.");
        System.out.println("Допустимы бинарные операции: +, -, *, /, %, ^.");
        System.out.println("Допустимо вводить функции sin(), cos(), tg(), ln(), lg(), exp().");
        System.out.println("Вычисление функций sin(), cos(), tg(), ведется из предположения, что аргумент передан в радианах.");
        System.out.println("При необходимости ввода числа Пи введите pi, числа e - введите e (лат.).");
        System.out.println("Допускаются только круглые скобки.");
        System.out.printf("Ваше выражение: ");
        //считываем, что ввел пользователь
        Scanner sc = new Scanner(System.in);
        String raw_s = sc.nextLine().trim();
        String s = raw_s.toLowerCase().replaceAll("\\s+", "");//убираем пробелы везде
        
        Queue<String> chisla = new LinkedList<>();//очередь для хранения чисел
        Queue<String> func = new LinkedList<>();//очередь для хранения функций
        Stack<String> skobki = new Stack<>();//Стэк для обработки скобок
        List<Character> operands = List.of('+','-','*','/','^', '%');//хранилище операторов
        List<Character> mist = List.of('[',']','{','}','<','>');//неправильные скобки
        
        List<String> ls = new ArrayList<>();
        char [] arr = s.toCharArray();//переводим в массив строку с выражением
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == ')' && skobki.empty()){//если встретили закрывающую скобку, при этом не было открывающей - бросаем ошибку
                System.out.println("Введенное выражение содержит ошибку. Проверьте скобки.");
                System.exit(1);
            } else if(mist.contains(arr[i])){//если пользователь ввел неправильную скобку
                System.out.println("Введенное выражение содержит ошибку. Проверьте скобки.");
                System.exit(1);
            } else if(arr[i] == ')' && !skobki.empty()){//встретил закрывающую скобку, но стэк скобок не пуст
                String ch = Sergant_Mnogonozhko(chisla);
                String f = Sergant_Mnogonozhko(func);
                if(ch!="") ls.add(ch);
                if(f!="") ls.add(f);
                ls.add(Character.toString(arr[i]));
                skobki.pop();
            }else if(arr[i]=='('){//встретили открывающую скобку
                String ch = Sergant_Mnogonozhko(chisla);
                String f = Sergant_Mnogonozhko(func);
                if(ch!="") ls.add(ch);
                if(f!="") ls.add(f);
                ls.add(Character.toString(arr[i]));
                skobki.push(Character.toString(arr[i]));
            }else if(operands.contains(arr[i])){//встретили оператор
                String ch = Sergant_Mnogonozhko(chisla);
                String f = Sergant_Mnogonozhko(func);
                if(ch!="") ls.add(ch);
                if(f!="") ls.add(f);
                ls.add(Character.toString(arr[i]));
            }else if(Character.isDigit(arr[i])){//встретили число
                chisla.add(Character.toString(arr[i]));
            }else if(Character.isAlphabetic(arr[i])){//встретили надпись
                func.add(Character.toString(arr[i]));
            }
        }
        //если в очередях остались значения, их нужно добавить в выражение
        String ch1 = Sergant_Mnogonozhko(chisla);
        String f1 = Sergant_Mnogonozhko(func);
        if(ch1!="") ls.add(ch1);
        if(f1!="") ls.add(f1);
        //если стек скобок не пуст, значит бросаем ошибку
        if(!skobki.empty()){
            System.out.println("Введенное выражение содержит ошибку. Проверьте скобки.");
            System.exit(1);
        }
        sc.close();
        if(ls.isEmpty()){
            System.out.println("Введенное выражение содержит ошибку.");
            System.exit(1);
        }
        return ls;
    }
    private String Sergant_Mnogonozhko(Queue<String> bronetransporter){//позволяет обрабатывать многозначные числа и функции
        String res="";
        if(!bronetransporter.isEmpty()){
            while(!bronetransporter.isEmpty()){
                res+=bronetransporter.poll();
            }
        }
        return res;
    }
}
