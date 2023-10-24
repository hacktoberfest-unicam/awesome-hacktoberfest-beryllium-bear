import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Inserisci il primo numero: \n");
        int a = input.nextInt();
        System.out.println("Inserisci il secondo numero: \n");
        int b = input.nextInt();

        System.out.println("Inserisci l'operazione da eseguire: \n " +
                "addizione \n sottrazione \n moltiplicazione \n divisione \n");
        String op = input.next();

        switch (op) {
            case "addizione" -> System.out.println(a + b);
            case "sottrazione" -> System.out.println(a - b);
            case "moltiplicazione" -> System.out.println(a * b);
            case "divisione" -> System.out.println(a / b);
        }
    }
}