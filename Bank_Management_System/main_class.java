package Bank_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class main_class extends JFrame implements ActionListener{
    JLabel l;
    JButton b1,b2,b3,b4,b5,b6,b7;

main_class()
{      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/atm2.png"));
       Image i2=i1.getImage().getScaledInstance(1550, 830,Image.SCALE_DEFAULT);
       JLabel l1=new JLabel(new ImageIcon(i2));
       l1.setBounds(0, 0, 1550, 830);
       add(l1);
    l=new JLabel("Please select your transaction");
    l.setFont(new Font("Arial",Font.BOLD,27));
    l.setForeground(Color.WHITE);
    l.setBounds(420, 140, 700, 40);
    l1.add(l);

    b1=new JButton("Deposit");
    b1.setBounds(420, 230, 170, 38);
    b1.setFont(new Font("Arial",Font.BOLD,14));
    b1.setBackground(new Color(0, 128, 255));
    b1.setForeground(Color.WHITE);
    b1.addActionListener(this);
    l1.add(b1);

    b2=new JButton("Cash Withdrawal");
    b2.setBounds(620, 230, 170, 38);
    b2.setFont(new Font("Arial",Font.BOLD,14));
    b2.setBackground(new Color(0, 128, 255));
    b2.setForeground(Color.WHITE);
    b2.addActionListener(this);
    l1.add(b2);

    b3=new JButton("Fast Cash");
    b3.setBounds(420, 285, 170, 38);
    b3.setFont(new Font("Arial",Font.BOLD,14));
    b3.setBackground(new Color(0, 128, 255));
    b3.setForeground(Color.WHITE);
    b3.addActionListener(this);
    l1.add(b3);

    b4=new JButton("Mini Statement");
    b4.setBounds(620, 285, 170, 38);
    b4.setFont(new Font("Arial",Font.BOLD,14));
    b4.setBackground(new Color(0, 128, 255));
    b4.setForeground(Color.WHITE);
    b4.addActionListener(this);
    l1.add(b4);

    b5=new JButton("Pin Change");
    b5.setBounds(420, 340, 170, 38);
    b5.setFont(new Font("Arial",Font.BOLD,14));
    b5.setBackground(new Color(0, 128, 255));   
    b5.setForeground(Color.WHITE);
    b5.addActionListener(this);
    l1.add(b5);

    b6=new JButton("Balance Enquiry");
    b6.setBounds(620, 340, 170, 38);
    b6.setFont(new Font("Arial",Font.BOLD,14));
    b6.setBackground(new Color(0, 128, 255));
    b6.setForeground(Color.WHITE);
    b6.addActionListener(this);
    l1.add(b6);

    b7=new JButton("Exit");
    b7.setBounds(520, 395, 170, 38); // centered below the two columns
    b7.setFont(new Font("Arial",Font.BOLD,14)); 
    b7.setBackground(new Color(0, 128, 255));
    b7.setForeground(Color.WHITE);
    b7.addActionListener(this);
    l1.add(b7);
        setLayout(null);

    setLocation(0,0);
    setSize(1550, 830);
    setVisible(true);
}
public void actionPerformed(ActionEvent e)
{
    
}
    public static void main(String[] args) {
    new main_class();
 }   
}
