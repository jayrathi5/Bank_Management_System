package Bank_Management_System;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class FastCash extends JFrame implements ActionListener{
    String pin;
    String cardno;
    JButton b2,b3,b4,b5,b6,b7;
    FastCash(String pin, String cardno)
    {
        this.pin=pin;
        this.cardno=cardno;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1550, 830,Image.SCALE_DEFAULT);
        JLabel l1=new JLabel(new ImageIcon(i2));
        l1.setBounds(0, 0, 1550, 830);
        add(l1);
        JLabel l2=new JLabel("SELECT WITHDRAWL AMOUNT");
        l2.setBounds(410, 170, 520, 25);
        l2.setForeground(new Color(255, 255, 204));
        l2.setFont(new Font("System",Font.BOLD,16));
        l1.add(l2);
        b2=new JButton("Rs.100");
        b2.setFont(new Font("System",Font.BOLD,16));
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65, 125, 194));
        b2.setBounds(410, 220, 180, 40);
        b2.addActionListener(this);
        l1.add(b2);
        b3=new JButton("Rs.500");
        b3.setFont(new Font("System",Font.BOLD,16));
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65, 125, 194));
        b3.setBounds(610, 220, 180, 40);
        b3.addActionListener(this);
        l1.add(b3);
        b4=new JButton("Rs.1000");
        b4.setFont(new Font("System",Font.BOLD,16));
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65, 125, 194));
        b4.setBounds(410, 290, 180, 40);
        b4.addActionListener(this);
        l1.add(b4);
        b5=new JButton("Rs.2000");
        b5.setFont(new Font("System",Font.BOLD,16));
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65, 125, 194));
        b5.setBounds(610, 290, 180, 40);
        b5.addActionListener(this);
        l1.add(b5);
        b6=new JButton("Rs.5000");  
        b6.setFont(new Font("System",Font.BOLD,16));
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65, 125, 194));
        b6.setBounds(410, 360, 180, 40);
        b6.addActionListener(this);
        l1.add(b6);
        b7=new JButton("Back");
        b7.setFont(new Font("System",Font.BOLD,16));
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65, 125, 194));
        b7.setBounds(610, 360, 180, 40);
        b7.addActionListener(this);
        l1.add(b7);
        setLayout(null);
        setSize(1550, 830);
        setLocation(0,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {      Date date=new Date();
        String amount="";
        if(e.getSource()==b2)
        {
            amount="100";
        }
        else if(e.getSource()==b3)
        {
            amount="500";
        }
        else if(e.getSource()==b4)
        {
            amount="1000";
        }
        else if(e.getSource()==b5)
        {
            amount="2000";
        }
        else if(e.getSource()==b6)
        {
            amount="5000";
        }
        else if(e.getSource()==b7)
        {
            setVisible(false);
            new main_class(this.pin, this.cardno);
            return;
        }
        try{
            Con c=new Con();
            ResultSet rs=c.statement.executeQuery("select * from bank where pin='"+pin+"'");
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
            if(balance<Integer.parseInt(amount))
            {
                JOptionPane.showMessageDialog(null,"Insufficient Balance");
                return;
            }
            else{
                String query="insert into bank values('"+pin+"','"+date+"','Withdraw','"+amount+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs. "+amount+" Withdrawn Successfully");
              
                setVisible(false);
                  new main_class(pin, cardno);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }

    }
    public static void main(String[] args) {
        new FastCash("6513","0000000000000000");
    }
}
