import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Account extends JFrame implements ActionListener {

    private double balance;
    private String vorname;
    private String nachname;
    private int loginName;
    private String passwort;
    private int accountNumber;
    boolean geschlecht= true;

    private JMenu menu;
    private JButton buttons;
    private JTextArea tfOutput;
    public Account(double balance, String nachname, boolean geschlecht){
        super("Deposit");
        this.balance=balance;
        this.nachname=nachname;
        this.geschlecht=geschlecht;

        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); //Zentrieren
       // menu= new JMenu();
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        JPanel panel = new JPanel(new GridLayout(1,2));
        JPanel panel2=new JPanel(new GridLayout(1,1));
        JPanel panel3=new JPanel(new GridLayout(1,1));
      //  JMenu menu=new JMenu();
        cp.add(panel);
        cp.add(panel2);
        cp.add((panel3));
       // cp.add(menu);

        JButton loginBtn= new JButton("Login");
        JButton button = new JButton("Kontostand");
        JTextArea gruss=new JTextArea();
        gruss.setText("Guten Morgen " + (geschlecht? "Frau ":"Herr ")+ this.nachname);

        panel.add(loginBtn);
        panel.add(button);

        tfOutput = new JTextArea();
        panel2.add(gruss);
        panel3.add(tfOutput);


        button.addActionListener(this);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        loginBtn.setFont(new Font("Arial", Font.BOLD, 18));
        gruss.setFont(new Font("Arial", Font.BOLD, 20));
        tfOutput.setFont(new Font("Helvetica",Font.PLAIN, 20));

       // button.setBounds(100,50,100,50);
       // button.setLocation(10,10);


     //   JPanel panelDisplay = new JPanel(new FlowLayout());







        this.add(panel);


        this.setVisible(true);
    }



    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance=balance;
    }

    public void einzahlen(double geldEin){
        balance+=geldEin;
        System.out.println("Konto: " + this.balance);
    }
    public void auszahlen(double geldAus){
        if(balance-geldAus<0){
            System.out.println("Sie haben zu niedrig Geld auf Ihren Konto: " + this.balance);
        }else{
            balance-=geldAus;
            System.out.println("Sie haben " + geldAus + " Euro rausgenommen, Sie haben noch " + this.balance + " Euro auf Ihren Konto");
        }
    }

    @Override
    public String toString(){
        return "a";
    }

    public void zahlung() {

        ArrayList<LocalDate> date = new ArrayList<>();
        date.add(LocalDate.of(2024, 01, 23));
        date.add(LocalDate.of(2024, 02, 02));
        date.add(LocalDate.of(2024, 02, 12));
        date.add(LocalDate.of(2024, 02, 14));
        date.add(LocalDate.of(2024, 04, 8));
        date.add(LocalDate.of(2024, 05, 12));
        date.add(LocalDate.of(2024, 06, 2));
        date.add(LocalDate.of(2024, 06, 12));
        date.add(LocalDate.of(2024, 07, 23));
        date.add(LocalDate.of(2024, 03, 23));

        date.sort(LocalDate::compareTo);

        ArrayList<Double> summe = new ArrayList<>();
        summe.add(2550.0);
        summe.add(-137.0);
        summe.add(233.0);
        summe.add(-20.0);
        summe.add(-259.0);
        summe.add(1798.0);
        summe.add(-599.0);
        summe.add(-233.0);
        summe.add(-52.0);
        summe.add(23.0);


        int datumIndex = 0;
        double summeMitIndexOfDatum = 0;

        for (LocalDate d : date) {
            datumIndex = date.indexOf(d);
            summeMitIndexOfDatum = (double) summe.get(datumIndex);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d. MMMM yyyy");
            String tag= date.get(datumIndex).format(dtf);
            tfOutput.append(String.format("Ihre Kontostand war %.2f Euro an Tag: %-10s %n",(this.balance+ summeMitIndexOfDatum) ,(tag)));
        }


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        zahlung();


    }
}
