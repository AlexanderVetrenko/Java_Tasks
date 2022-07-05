package Homework4;

import java.util.List;

/* import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack; */

public class postfix {
    public static void main(String[] args) {
        //List<Character> arif_dos = List.of('+','-','*','/','^','(',')');
        //System.out.println(arif_dos);
        Data_input dv = new Data_input();
        List<String> ls = dv.Vvod_dannych();
        System.out.println(ls);
        
        /* String s = "5*6+(2-9)";
        char [] arr = s.toCharArray();
        Queue<Character> chisla = new LinkedList<Character>();
        Stack<Character> operatory = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
              if(Character.isDigit(arr[i])){
                chisla.add(arr[i]);
              }
              if(arif_dos.contains(arr[i])){
                if(operatory.isEmpty() || operatory.peek()=='('){
                    operatory.push(arr[i]);
                }
              } 
        }*/


    }
}
