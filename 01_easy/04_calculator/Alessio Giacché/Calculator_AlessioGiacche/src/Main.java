
// Java program to demonstrate BufferedReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main implementation
 */
public class Main {
    public static void main(String[] args) throws Exception{
        int n1 = 10;
        int n2 = 20;

        Operation calculator = new Operation();

        System.out.println("Sum : " + calculator.sum(n1, n2));
        System.out.println("Div : " +calculator.div(n1, n2));
        System.out.println("Molt : " + calculator.molt(n1, n2));
        System.out.println("Diff" + calculator.diff(n1, n2));

    }
}