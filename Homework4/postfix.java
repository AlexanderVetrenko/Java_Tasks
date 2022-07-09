package Homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class postfix {
    public double calc(List<String> list){
        Stack<Double> st = new Stack<>();
        List<String> pi = List.of("pi");
        List<String> e = List.of("e");
        List<Character> bin_op = List.of('+','-','*','/','^','%');
        List<String> pre_func = List.of("sin", "cos", "tg", "ln", "lg", "exp");

        for (String item : list) {
            if(isNumeric(item)) {
                st.push(Double.parseDouble(item));
            } else if(pi.contains(item)) {
                st.push(Math.PI);
            } else if(e.contains(item)) {
                st.push(Math.E);
            } else if(bin_op.contains(item.charAt(0))) {
                double [] arr = new double[2];
                for (int i = 1; i >= 0; i--) {
                    if(st.empty()){
                        System.out.println("Введенное вами выражение содержит ошибку");
                        System.exit(1);
                    }
                    arr[i] = st.pop();
                }
                st.push(bin_oper(arr,item.charAt(0)));
            } else if(pre_func.contains(item)) {
                st.push(func_oper(st.pop(),item));
            } else {
                System.out.println("Во введенном выражении обнаружена ошибка");
                System.exit(1);
            }
        }
        if(st.empty()){
            System.out.println("Введенное вами выражение содержит ошибку");
            System.exit(1);
        }
        return st.pop();
    }
    private double bin_oper(double [] mtrx, char c){
        if(c == '+') {
            return (mtrx[0]+mtrx[1]);
        }else if(c == '-') {
            return (mtrx[0]-mtrx[1]);
        }else if(c == '*') {
            return (mtrx[0]*mtrx[1]);
        }else if(c == '/') {
            return (mtrx[0]/mtrx[1]);
        }else if(c == '%') {
            return (mtrx[0]%mtrx[1]);
        }else if(c == '^') {
            return (Math.pow(mtrx[0], mtrx[1]));
        } else {
            return 0;
        }
    }
    private double func_oper(double a, String s){
        switch(s){
            case "sin": return Math.sin(a);
            case "cos": return Math.cos(a);
            case "tg": return Math.tan(a);
            case "ln": return Math.log(a);
            case "lg": return Math.log10(a);
            case "exp": return Math.exp(a);
            default: return 0;
        }
    }
    public List<String> in_postfix(List<String> ls){
        Stack<String> st = new Stack<>();
        List<String> res = new ArrayList<>();
        List<String> bin_op = List.of("+","-","*","/","^", "%");
        List<String> pre_func = List.of("sin", "cos", "tg", "ln", "lg", "exp");
        List<String> cnst = List.of("pi","e");

        int i = ls.size()-1;
        for (String item : ls) {
            if(isNumeric(item) || cnst.contains(item)) res.add(item);
            if(pre_func.contains(item)) st.push(item);
            if(item.charAt(0)=='(') st.push(item);
            if(item.charAt(0) == ')'){
                while(st.peek().charAt(0)!='('){
                    res.add(st.pop());
                }
                st.pop();
            }
            if(bin_op.contains(item)){
                if(!st.empty()){
                    while(pre_func.contains(st.peek()) || Prioritet(st.peek(), item)){
                        res.add(st.pop());
                        if(st.empty()) break;
                    }
                }
                st.push(item);
            }
            if(i-- == 0){
                while(!st.empty()){
                    res.add(st.pop());
                }
            } 
        }
        return res;
    }
    private static boolean isNumeric(String str) {//Проверка, является ли строковое выражение числом
        try {
          Double.parseDouble(str);
          return true;
        } catch(NumberFormatException e){
          return false;
        }
      }
    private static Boolean Prioritet(String a, String b){//метод оценки приоритета операции
        List<String> pr1 = List.of("+","-");
        List<String> pr2 = List.of("*","/","%");
        if(a.charAt(0)=='^') return true;
        if(pr2.contains(a) && (pr1.contains(b) || pr2.contains(b))) return true;
        if(pr1.contains(a) && pr1.contains(b)) return true;
        else return false;
    }
    
}
