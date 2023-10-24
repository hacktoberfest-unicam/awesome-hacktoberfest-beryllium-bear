
public class Calculator
{
    public static double somma(double a,double b)
    {
        return a+b;
    }

    public static double differenza(double a,double b)
    {
        return a-b;
    }
    public static double moltiplicazione(double a,double b)
    {
        return a*b;
    }
    public static String divisione(double a,double b)
    {
        try
        {
            return Double.toString(a/b);
        }
        catch(ArithmeticException exception)
        {
            if(a!=0)
                return "Impossibile";
            else
                return "Indeterminato";
        }
    }

    public static String radice(double a,int b){
        if(b%2!=0)
            return Double.toString(Math.pow(a,1.0/b));
        else
        {
            if(a<0)
                return "Impossibile";
            else
            return Double.toString(Math.pow(a,1.0/b));
        }
    }

    public static double pow(double a,double b)
    {
        return Math.pow(a,b);
    }
    

}