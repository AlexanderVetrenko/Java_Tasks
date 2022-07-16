package Homework5;

import java.util.Map;
import java.util.TreeMap;

public class view {
    public void printTree(TreeMap<Integer,Integer> trm, int b, int h){
        for (Map.Entry<Integer, Integer> entry : trm.entrySet()) {
            if(entry.getKey()%b==0){
                System.out.printf("(%-2d, %-1d)", entry.getKey(), entry.getValue());
                System.out.println();
                if(entry.getKey()!=b*h){
                    setka(b);
                    setka(b);
                    setka(b);
                }
            }else{
                System.out.printf("(%-3d, %-2d)----", entry.getKey(), entry.getValue());
            }
       } 
    }
    private static void setka(int a){
        for (int i = 1; i < a; i++) {
            String s = "    |    ";
            System.out.printf("%-13s",s);                    
        }
        System.out.print("   |");
        System.out.println();
    }
    
}
