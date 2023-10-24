import java.awt.*;
import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        MyFrame f = new MyFrame("Calcolatrice");
        Container c = f.getContentPane();
        MyPanel p = new MyPanel();
        p.setLayout(new BoxLayout(p,BoxLayout.PAGE_AXIS));
        c.add(p);
        f.setVisible(true);
    }
}