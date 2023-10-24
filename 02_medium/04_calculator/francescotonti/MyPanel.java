import javax.swing.*;
import java.awt.event.*;

public class MyPanel extends JPanel implements ActionListener
{
    private JLabel lblOperandoUno;
    private JLabel lblOperandoDue;
    private JTextField txtOperandoUno;
    private JTextField txtOperandoDue;
    private JButton btnSomma;
    private JButton btnSottrazione;
    private JButton btnMoltiplicazione;
    private JButton btnDivisione;
    private JButton btnRad;
    private JButton btnPow;
    private JTextField txtRisultato;
    public MyPanel()
    {
        super();
        lblOperandoUno = new JLabel("Inserisci il primo numero");
        lblOperandoDue = new JLabel("Inserisci il secondo numero");
        txtOperandoUno = new JTextField();
        txtOperandoDue = new JTextField();
        btnSomma = new JButton("+");
        btnSottrazione = new JButton("-");
        btnMoltiplicazione = new JButton("*");
        btnDivisione = new JButton("/");
        btnRad = new JButton("\u221A");
        btnPow = new JButton("^");
        txtRisultato = new JTextField();
        txtRisultato.setEditable(false);
        btnSomma.addActionListener(this);
        btnSottrazione.addActionListener(this);
        btnMoltiplicazione.addActionListener(this);
        btnDivisione.addActionListener(this);
        btnRad.addActionListener(this);
        btnPow.addActionListener(this);
        add(lblOperandoUno);
        add(txtOperandoUno);
        add(lblOperandoDue);
        add(txtOperandoDue);
        add(btnSomma);
        add(btnSottrazione);
        add(btnMoltiplicazione);
        add(btnDivisione);
        add(btnRad);
        add(btnPow);
        add(txtRisultato);
    }
    public void actionPerformed(ActionEvent e)
    {
        double a = 0;
        double b = 0;
        if(txtOperandoUno.getText()!=null && txtOperandoDue.getText()!=null)
        {
            a = Double.parseDouble(txtOperandoUno.getText());
            b = Double.parseDouble(txtOperandoDue.getText());
        }
        if(e.getSource()==btnSomma)
            txtRisultato.setText(Double.toString(Calculator.somma(a,b)));
        else if(e.getSource()==btnSottrazione)
            txtRisultato.setText(Double.toString(Calculator.differenza(a,b)));
        else if(e.getSource()==btnMoltiplicazione)
            txtRisultato.setText(Double.toString(Calculator.moltiplicazione(a,b)));
        else if(e.getSource()==btnDivisione)
            txtRisultato.setText(Calculator.divisione(a,b));
        else if(e.getSource()==btnRad)
        {
            txtRisultato.setText(Calculator.radice(a, (int)b));
        }
        else if(e.getSource()==btnPow)
        {
            txtRisultato.setText(Double.toString(Calculator.pow(a,b)));
        }
    }
}
