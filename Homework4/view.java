package Homework4;

import java.util.List;

public class view {
    public void printList(List<String> ls){
        System.out.println("Ваше выражение в постфиксной нотации:");
        for (String item : ls) {
            System.out.printf("%s ", item );
        }
        System.out.println();
    }
}
