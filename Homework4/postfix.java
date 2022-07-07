package Homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class postfix {
    
    public List<String> in_postfix(List<String> ls){
        Stack<String> st = new Stack<>();
        List<String> res = new ArrayList<>();
        List<String> operands = List.of("+","-","*","/","^", "sin", "cos", "tg", "ctg");
        int i = ls.size()-1;
        for (String item : ls) {
            if(isNumeric(item) || item=="pi") res.add(item);
            if(operands.contains(item)){
                if(st.empty() || st.peek()=="(") st.push(item);
                if(Prioritet(item,st.peek())) st.push(item);
                if(!Prioritet(item,st.peek())){
                    System.out.println(st.peek());
                    System.out.println(res);
                    System.out.println(item);
                    while(st.peek()!="(" || !Prioritet(item, st.peek()) || !st.empty()){
                    res.add(st.pop());
                    }
                    
                    st.push(item);
                }
            }
            if(item=="(") st.push(item);
            if(item==")"){
                while(st.peek()!="("){
                    res.add(st.pop());
                }
                st.pop();
            }
            if(i-- == 0){
                while(!st.empty()){
                    res.add(st.pop());
                }
            }
        }
        return res;
    }
    private static boolean isNumeric(String str) {//Проверка, является ли строковое выражение целым числом
        try {
          Integer.parseInt(str);
          return true;
        } catch(NumberFormatException e){
          return false;
        }
      }
    private static Boolean Prioritet(String a, String b){//метод оценки приоритета операции
        List<String> pr1 = List.of("sin","cos","tg","ctg","^");
        List<String> pr2 = List.of("*","/");
        List<String> pr3 = List.of("+","-");

        if(pr1.contains(a) && pr2.contains(b)) return true;
        if(pr1.contains(a) && pr3.contains(b)) return true;
        if(pr2.contains(a) && pr3.contains(b)) return true;
        else return false;
    }
    
}
