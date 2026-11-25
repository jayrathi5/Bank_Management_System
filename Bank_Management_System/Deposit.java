package Bank_Management_System;
import java.awt.*;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Deposit extends JFrame implements ActionListener {
    String pin;
    String cardno;
    JLabel l;
    JTextField t;
    JButton b1,b2;
    Deposit(String pin, String cardno) {
        this.pin = pin;
        this.cardno = cardno;
        // Constructor for Deposit class
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1550, 830,Image.SCALE_DEFAULT);
        JLabel l1=new JLabel(new ImageIcon(i2));
        l1.setBounds(0, 0, 1550, 830);
        add(l1);

        l=new JLabel("Enter the amount you want to deposit:");
        l.setBounds(410, 210, 520, 30);
        l.setFont(new Font("System",Font.BOLD,18));
        l.setForeground(new Color(255, 255, 204));
        l1.add(l);

        t= new JTextField();
        t.setBounds(410, 250, 420, 32);
        t.setFont(new Font("System",Font.PLAIN,18));
        t.setForeground(Color.BLACK);
        t.setBackground(new Color(245, 245, 245));
        l1.add(t);

        b1=new JButton("Deposit");
        b1.setBounds(430, 300, 140, 34);
        b1.setFont(new Font("System",Font.BOLD,14));
        b1.setBackground(new Color(0, 128, 255));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l1.add(b1);

        b2=new JButton("Back");
        b2.setBounds(590, 300, 140, 34);
        b2.setFont(new Font("System",Font.BOLD,14));
        b2.setBackground(new Color(0, 128, 255));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l1.add(b2);
        setLayout(null);
        setSize(1550, 830);
        setLocation(0,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {  String amount=t.getText();
        Date date=new Date();
        if(e.getSource()==b1)
        {   
              if(amount.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please enter the amount to deposit");

        }else{
            try{
            Con c=new Con();
            String query="insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')";
            c.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposited Successfully");
            setVisible(false);
            new main_class(pin, this.cardno);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
        }
        else{
            setVisible(false);
            new main_class(pin, cardno);
        }
        }
    public static void main(String[] args) {
        new Deposit("",""); 
    }
}
