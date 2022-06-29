import java.util.Scanner;
public class ChessKnight {
    public static void main(String[] args) {
        int n = Razmer_Doski(); 
        System.out.println(n);
    }

    public static int Razmer_Doski(){     
        int nm = Proverka_Chisla();
        while(nm<5){
            nm=Proverka_Chisla();
        }
        return nm;
    }
    public static int Proverka_Chisla(){
        Scanner sc = new Scanner(System.in);//ругается на утечку данных из-за незакрываемого сканнера.
        System.out.printf("Введите сторону шахматной доски (целые числа не менее 5): \n");
        String s = sc.nextLine();
        int nmb = 0;
        try{
            nmb = Integer.parseInt(s.trim());
        }
        catch (NumberFormatException nfe){
            nmb = 0;
        }
        //sc.close(); если сканнер закрыть, вылетает ошибка, если не закрывать - работает. Почему???
        return nmb;
    }
}