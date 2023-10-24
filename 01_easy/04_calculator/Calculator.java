public class Calculator {
    public static int sum(int a,int b){
        return a+b;
    }

    public static double sum(double a,double b){
        return a+b;
    }

    public static int diff(int a,int b){
        return a-b;
    }

    public static double diff(double a,double b){
        return a-b;
    }

    public static int molt(int a,int b){
        return a*b;
    }

    public static double molt(double a,double b){
        return a*b;
    }

    public static double div(int a,int b){
        return (double)a/b;
    }

    public static double div(double a,double b) throws ArithmeticException{
        if(b==0)
            throw new ArithmeticException();
        return a/b;
    }
}
