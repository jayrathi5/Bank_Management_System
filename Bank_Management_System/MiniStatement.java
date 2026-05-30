package Bank_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class MiniStatement extends JFrame implements ActionListener{
    String pin;
    String cardNo;
    JButton b1;

    MiniStatement(String pin, String cardNo)
    {
        this.pin = pin;
        this.cardNo = cardNo;
        getContentPane().setBackground(new Color(245, 245, 245 ));
        setLayout(null);

        JLabel heading = new JLabel("Mini Statement");
        heading.setBounds(40, 30, 300, 30);
        heading.setFont(new Font("Arial", Font.BOLD, 22));
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel cardLabel = new JLabel();
        cardLabel.setBounds(40, 70, 500, 25);
        cardLabel.setFont(new Font("Arial", Font.BOLD, 16));
        cardLabel.setForeground(Color.BLACK);
        add(cardLabel);

        String card = cardNo == null ? "" : cardNo;
        if (card.length() >= 16) {
            cardLabel.setText("Card Number: " + card.substring(0,4) + "XXXXXXXX" + card.substring(12,16));
        } else {
            cardLabel.setText("Card Number: " + card);
        }

        JLabel l1=new JLabel();
        l1.setBounds(40, 110, 700, 500);
        l1.setFont(new Font("Monospaced", Font.PLAIN, 14));
        l1.setForeground(Color.DARK_GRAY);
        add(l1);

        JLabel balanceLabel = new JLabel();
        balanceLabel.setBounds(40, 620, 400, 25);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        balanceLabel.setForeground(Color.BLACK);
        add(balanceLabel);

        try{
            Con c=new Con();
            ResultSet rs=c.statement.executeQuery("select * from bank where pin='"+pin+"'");
            int balance=0;
            while(rs.next())
            {
                l1.setText(l1.getText() + "<html>" + rs.getString("date") +
                        "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") +
                        "&nbsp;&nbsp;&nbsp;&nbsp;Rs " + rs.getString("amount") +
                        "<br><br><html>");
                if(rs.getString("type").equals("Deposit"))
                {
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
            balanceLabel.setText("Total Balance: Rs " + balance);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        b1=new JButton("Exit");
        b1.setBounds(660, 680, 100, 32);
        b1.setBackground(new Color(0, 128, 255));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.addActionListener(this);
        add(b1);

        setSize(850, 750);
        setLocation(350,20);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new MiniStatement("", "");
    }
}
