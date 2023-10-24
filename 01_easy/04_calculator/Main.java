import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        boolean flag;
        boolean ex = false;
        double a,b;
        int op;
        double r = 0;
        //while(true){
            System.out.println("Inserisci il primo numero");
            a = s.nextDouble();
            System.out.println("Inserisci il secondo numero");
            b = s.nextDouble();
            do{
                flag = false;
                System.out.println("Inserisci l'operazione tra le seguenti:\n1) SOMMA\n2) DIFFERENZA\n3) MOLTIPLICAZIONE\n4) DIVISIONE");
                op = s.nextInt();
                switch(op)
                {
                    case 1:
                        r = Calculator.sum(a,b);
                        break;
                    case 2:
                        r = Calculator.diff(a,b);
                        break;
                    case 3:
                        r = Calculator.molt(a,b);
                        break;
                    case 4:
                        try{
                            r = Calculator.div(a,b);
                        }
                        catch(ArithmeticException e)
                        {
                            ex = true;
                        }
                        break;
                    default:
                        System.out.println("Inserisci una delle quattro operazioni:\n1) SOMMA\n2) DIFFERENZA\n3) MOLTIPLICAZIONE\n4) DIVISIONE");
                        flag = true;
                }
            }while(flag);
            if(!ex)
                System.out.println(r);
            else
                System.out.println("Impossibile");
        //}
    }
}
