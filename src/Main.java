import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void control(List<Double> a) {
        Scanner sc = new Scanner(System.in);

        while(true){
            outHelp();
            var g = sc.nextLine();
            if(g.equals("e")) break;

            switch (g) {
                case ("h"):
                    break;
                case ("a"):
                    addListControl(a, sc);
                    break;
                case ("s"):
                    outList(a);
                    break;
                case("c"): clearList(a);
                    break;
                default:
                    System.out.println("Нет такой команды, по крайней мере пока. Читай че написано:");
                    break;


            }
        }

    }

    public static void outHelp(){
        System.out.println("Список команд: h-help, a-add, s-show, c-clear, e-esc");
    }

    public static void addListControl(List<Double> arL, Scanner sc){

        boolean f = true;

        while (true){
            System.out.println("Массив чеков, допустим Ника");
            outList(arL);
            System.out.println("_______");

            if(f) System.out.println("Введите сумму чека");
            else System.out.println("Введите еще число или команду d-done");
            var g = sc.nextLine();

            if(g.equals("d")) break;
            int j=0;
            while(j<3) {
                try {
                    arL.add(Double.parseDouble(g));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Введите число типа Double");

                    g = sc.nextLine();
                    j++;
                }
                if (j==3) {
                    System.out.println("Заебал тупить");
                    break;
                }

            }
            f = false;
        }
    }

    public static void addList(List<Double> arL, Scanner sc) {

        int j = 0;
        while (j < 3) {
            try {
                arL.add(sc.nextDouble());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Введите число типа Double");
                sc.nextLine();
                j++;
            }
            if (j == 3) System.out.println("Заебал тупить");
        }
    }

    public static void clearList(List<Double> arL){
        arL.clear();
    }

    public static void outList(List<Double> a){
        System.out.println("Размер листа"+a.size());
        if(a.size()==0) return;
        for(int i=0;i<a.size(); i++){
            System.out.println(a.get(i));
        }
    }

    public static void main(String[] args) throws IOException {

        List<Double> checksNik = new ArrayList();

        String nameNik = "Nik";

        checksNik.add((double) 10);
        checksNik.add((double) 20);
        checksNik.add((double) 30);

        Scanner scanner = new Scanner(System.in);

        control(checksNik);


        /* PrintWriter pw;

        File fileOut = new File("out.txt");
        if(!fileOut.exists()) fileOut.createNewFile();
        pw = new PrintWriter(fileOut);

        pw.close();*/
    }
}
