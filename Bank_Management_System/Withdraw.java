package Bank_Management_System;
import java.awt.*;
import java.util.Date;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Withdraw extends JFrame implements ActionListener{
   String pin;
   String cardno;
   JLabel l3;
   JTextField t1;
   JButton b1,b2;

    Withdraw(String pin, String cardno)
   {
    this.pin=pin;
    this.cardno=cardno;

    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/atm2.png"));
    Image i2=i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
    JLabel l1=new JLabel(new ImageIcon(i2));
    l1.setBounds(0, 0, 1550, 830);
    add(l1);

    JLabel l2=new JLabel("Maximum withdrawal limit is Rs. 10,000");
    l2.setBounds(410, 170, 520, 25);
    l2.setForeground(new Color(255, 255, 204));
    l2.setFont(new Font("System",Font.BOLD,16));
    l1.add(l2);

    l3=new JLabel("Please enter your amount:");
    l3.setBounds(410, 210, 520, 30);
    l3.setForeground(new Color(255, 255, 204));
    l3.setFont(new Font("System",Font.BOLD,18));
    l1.add(l3);

    t1=new JTextField();
    t1.setBounds(410, 250, 420, 32);
    t1.setFont(new Font("System",Font.PLAIN,18));
    t1.setBackground(new Color(245,245,245));
    l1.add(t1);

    b1=new JButton("Withdraw");
    b1.setBounds(430, 300, 140, 34);
    b1.setBackground(new Color(0, 128, 255));
    b1.setForeground(Color.WHITE);
    b1.setFont(new Font("System",Font.BOLD,14));
    b1.addActionListener(this);
    l1.add(b1);

    b2=new JButton("Back");
    b2.setBounds(590, 300, 140, 34);
    b2.setBackground(new Color(0, 128, 255));
    b2.setForeground(Color.WHITE);
    b2.setFont(new Font("System",Font.BOLD,14));
    b2.addActionListener(this);
    l1.add(b2);

    setLayout(null);
    setSize(1550, 830);
    setLocation(0,0);
    setVisible(true);
   }

    public void actionPerformed(ActionEvent e)
    {
        String withdrawamount=t1.getText();
        Date date=new Date();
        if(e.getSource()==b1)
        {
            if(withdrawamount.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter the amount to withdraw");

            }
            else if(Integer.parseInt(withdrawamount)>10000)
            {
                JOptionPane.showMessageDialog(null,"Maximum withdrawal limit is Rs. 10,000");
            }
            else{
                try{
                Con c=new Con();
                String query="select * from bank where pin='"+pin+"'";
                ResultSet rs=c.statement.executeQuery(query);
                int balance=0;
                while(rs.next())
                {   
                    if(rs.getString("type").equals("Deposit"))
                    {
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                    }
                    
                }
                if(balance<Integer.parseInt(withdrawamount))
                {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                else{
                    balance-=Integer.parseInt(withdrawamount);
                    String q="insert into bank values('"+pin+"','"+date+"','Withdraw','"+withdrawamount+"')";
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Rs. "+withdrawamount+" Withdrawn Successfully");
                    new main_class(pin, cardno);
                    setVisible(false);

                }
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
            }
        }
        else if(e.getSource()==b2)
        {
            setVisible(false);
            new main_class(pin, cardno);
        }
    }

    public static void main(String[] args) {
        new Withdraw("","");
    }
}
