package Bank_Management_System;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SignUp3 extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6;
    JButton b1,b2;

    private final String formNoValue;

    SignUp3(String formNoValue) {
        super("Application Form - Page 3");
        this.formNoValue = formNoValue;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/i1.png"));
        Image i2=i1.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);
        l1=new JLabel(new ImageIcon(i2));
        l1.setBounds(30,20,90,90);
        add(l1);

        l2=new JLabel("Page 3: Account Details");
        l2.setBounds(140,25,420,30);
        l2.setFont(new Font("Arial",Font.BOLD,24));
        l2.setForeground(Color.BLACK);
        add(l2);

        l3=new JLabel("Form No: " + formNoValue);
        l3.setBounds(560,25,250,30);
        l3.setFont(new Font("Arial",Font.BOLD,22));
        l3.setForeground(Color.BLACK);
        add(l3);

        l4=new JLabel("Account type:");
        l4.setBounds(80,120,200,30);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Arial",Font.BOLD,22));
        add(l4);

        r1=new JRadioButton("Saving Account");
        r1.setBounds(80,160,220,30);
        r1.setFont(new Font("Arial",Font.PLAIN,16));
        r1.setBackground(new Color(173, 216, 230));
        add(r1);

        r2=new JRadioButton("Fixed Deposit Account");
        r2.setBounds(360,160,260,30);
        r2.setFont(new Font("Arial",Font.PLAIN,16));
        r2.setBackground(new Color(173, 216, 230));
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setBounds(80,195,220,30);
        r3.setFont(new Font("Arial",Font.PLAIN,16));
        r3.setBackground(new Color(173, 216, 230));
        add(r3);

        r4=new JRadioButton("Recurring Deposit Account");
        r4.setBounds(360,195,280,30);
        r4.setFont(new Font("Arial",Font.PLAIN,16));
        r4.setBackground(new Color(173, 216, 230));
        add(r4);

        ButtonGroup bg=new ButtonGroup();
        bg.add(r1); bg.add(r2); bg.add(r3); bg.add(r4);

        l5=new JLabel("Card Number:");
        l5.setBounds(80,250,200,30);
        l5.setFont(new Font("Arial",Font.BOLD,22));
        l5.setForeground(Color.BLACK);
        add(l5);

        l6=new JLabel("XXXX-XXXX-XXXX-4184");
        l6.setBounds(300,250,320,30);
        l6.setFont(new Font("Arial",Font.BOLD,22));
        l6.setForeground(Color.BLACK);
        add(l6);

        JLabel tmp=new JLabel("(It would appear on ATM card, cheque book and statements)");
        tmp.setBounds(300,285,520,18); // moved under card number value
        tmp.setForeground(Color.BLACK);
        tmp.setFont(new Font("Arial",Font.PLAIN,13));
        add(tmp);

        l9=new JLabel("(Your 16-digit card number)");
        l9.setBounds(80,305,260,18);
        l9.setFont(new Font("Arial",Font.PLAIN,13));
        l9.setForeground(Color.BLACK);
        add(l9);

        l7=new JLabel("PIN:");
        l7.setBounds(80,335,200,30);
        l7.setFont(new Font("Arial",Font.BOLD,22));
        l7.setForeground(Color.BLACK);
        add(l7);

        l8=new JLabel("XXXX");
        l8.setBounds(300,335,100,30);
        l8.setFont(new Font("Arial",Font.BOLD,22));
        l8.setForeground(Color.BLACK);
        add(l8);

        l10=new JLabel("(4-digit password)");
        l10.setBounds(80,370,200,18);
        l10.setFont(new Font("Arial",Font.PLAIN,13));
        l10.setForeground(Color.BLACK);
        add(l10);

        l11=new JLabel("Services Required:");
        l11.setBounds(80,410,240,30);
        l11.setFont(new Font("Arial",Font.BOLD,22));
        l11.setForeground(Color.BLACK);
        add(l11);

        c1=new JCheckBox("ATM Card");
        c1.setBounds(80,450,200,30);
        c1.setFont(new Font("Arial",Font.PLAIN,16));
        c1.setBackground(new Color(173, 216, 230));
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBounds(360,450,220,30);
        c2.setFont(new Font("Arial",Font.PLAIN,16));
        c2.setBackground(new Color(173, 216, 230));
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBounds(80,485,200,30);
        c3.setFont(new Font("Arial",Font.PLAIN,16));
        c3.setBackground(new Color(173, 216, 230));
        add(c3);

        c4=new JCheckBox("Email Alerts");
        c4.setBounds(360,485,200,30);
        c4.setFont(new Font("Arial",Font.PLAIN,16));
        c4.setBackground(new Color(173, 216, 230));
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setBounds(80,520,200,30);
        c5.setFont(new Font("Arial",Font.PLAIN,16));
        c5.setBackground(new Color(173, 216, 230));
        add(c5);

        c6=new JCheckBox("E-Statement");
        c6.setBounds(360,520,200,30);
        c6.setFont(new Font("Arial",Font.PLAIN,16));
        c6.setBackground(new Color(173, 216, 230));
        add(c6);

        b1=new JButton("Submit");
        b1.setBounds(300,585,110,32);
        b1.setFont(new Font("Arial",Font.BOLD,14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(430,585,110,32);
        b2.setFont(new Font("Arial",Font.BOLD,14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        getContentPane().setBackground(new Color(173, 216, 230));
        setLocation(350,10);
        setSize(850,700);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String accountType = null;
        if (r1.isSelected()) accountType = "Saving Account";
        else if (r2.isSelected()) accountType = "Fixed Deposit Account";
        else if (r3.isSelected()) accountType = "Current Account";
        else if (r4.isSelected()) accountType = "Recurring Deposit Account";

        String cardNumber = "XXXX-XXXX-XXXX-4184";
        String pin = "XXXX";
        String services = "";
        if (c1.isSelected()) services += "ATM Card, ";
        if (c2.isSelected()) services += "Internet Banking, ";
        if (c3.isSelected()) services += "Mobile Banking, ";
        if (c4.isSelected()) services += "Email Alerts, ";
        if (c5.isSelected()) services += "Cheque Book, ";
        if (c6.isSelected()) services += "E-Statement, ";
        if (!services.isEmpty()) services = services.substring(0, services.length() - 2);

        try{
            Con c=new Con();
            String query="insert into account_details values('"+formNoValue+"','"+accountType+"','"+cardNumber+"','"+pin+"','"+services+"')";
            c.statement.executeUpdate(query);
            setVisible(false);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUp3("1234");
    }
}
