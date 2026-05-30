package Bank_Management_System;
import java.awt.*;
import java.util.Date;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class Balance extends JFrame implements ActionListener {
    JLabel bgLabel;
    JLabel balanceLabel;
    JButton b1;
    String pin;
    String cardno;
    Balance(String pin, String cardno)
    {
        this.pin=pin;
        this.cardno=cardno;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        bgLabel=new JLabel(new ImageIcon(i2));
        bgLabel.setBounds(0, 0, 1550, 830);
        add(bgLabel);

        JLabel tmp=new JLabel("MAXIMUM WITHDRAWAL LIMIT IS RS. 10,000");
        tmp.setBounds(410, 170, 520, 25);
        tmp.setForeground(new Color(255, 255, 204));
        tmp.setFont(new Font("System",Font.BOLD,16));
        bgLabel.add(tmp);

        balanceLabel=new JLabel();
        balanceLabel.setBounds(410, 210, 520, 30);
        balanceLabel.setForeground(new Color(255, 255, 204));
        balanceLabel.setFont(new Font("System",Font.BOLD,18));
        bgLabel.add(balanceLabel);

        b1=new JButton("Back");
        b1.setBounds(410, 300, 140, 34);
        b1.setBackground(new Color(0, 128, 255));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("System",Font.BOLD,14));
        b1.addActionListener(this);
        bgLabel.add(b1);

        int balance=0;
        try{
            Con c=new Con();
            String query="select * from bank where pin='"+pin+"'";
            ResultSet rs=c.statement.executeQuery(query);
            while(rs.next())
            {
                if(rs.getString("type").equals("Deposit"))
                {
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                else
                {
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
            balanceLabel.setText("Balance: " + balance);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        setLayout(null);
        setSize(1550, 830);
        setLocation(0,0);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e)
    {   
        if(e.getSource()==b1)
        {
            setVisible(false);
            new main_class(this.pin, this.cardno);
        }
    }

    public static void main(String[] args) {
        new Balance("6513","0000000000000000");
    }
}
