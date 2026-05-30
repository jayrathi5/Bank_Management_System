package Bank_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
public class ChangePin extends JFrame implements ActionListener {
    String pin;
    String cardno;
    JLabel l3,l4;
    JPasswordField t1,t2;
    JButton b1,b2;
    ChangePin(String pin, String cardno)
    {
        this.pin=pin;
        this.cardno=cardno;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        JLabel l1=new JLabel(new ImageIcon(i2));
        l1.setBounds(0, 0, 1550, 830);
        add(l1);

        JLabel l2=new JLabel("CHANGE YOUR PIN");
        l2.setBounds(420, 190, 400, 30);
        l2.setFont(new Font("System",Font.BOLD,20));
        l2.setForeground(new Color(255, 255, 204));
        l1.add(l2);

        l3=new JLabel("New PIN:");
        l3.setBounds(420, 250, 200, 30);
        l3.setFont(new Font("System",Font.BOLD,16));
        l3.setForeground(new Color(255, 255, 204));
        l1.add(l3);

        t1=new JPasswordField();
        t1.setBounds(580, 250, 260, 30); // reduced width
        t1.setFont(new Font("System",Font.BOLD,16));
        t1.setBackground(new Color(245, 245, 245));
        t1.setForeground(Color.BLACK);
        l1.add(t1);

        l4=new JLabel("Re-Enter PIN:");
        l4.setBounds(420, 300, 200, 30);
        l4.setFont(new Font("System",Font.BOLD,16));
        l4.setForeground(new Color(255, 255, 204));
        l1.add(l4);

        t2=new JPasswordField();
        t2.setBounds(580, 300, 260, 30); // reduced width
        t2.setFont(new Font("System",Font.BOLD,16));
        t2.setBackground(new Color(245, 245, 245));
        t2.setForeground(Color.BLACK);
        l1.add(t2);

        b1=new JButton("Change");
        b1.setBounds(575, 355, 100, 30); // moved left + smaller
        b1.setFont(new Font("System",Font.BOLD,14));
        b1.setBackground(new Color(0, 128, 255));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l1.add(b1);

        b2=new JButton("Back");
        b2.setBounds(695, 355, 100, 30); // moved left + smaller
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
    {
        Date date=new Date();
        if(e.getSource()==b1)
        {
            if(t1.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter the new PIN");
            }
            else if(t2.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please re-enter the new PIN");
            }
            else if(!t1.getText().equals(t2.getText()))
            {
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
            }
            else{
                try{
                    Con c=new Con();
                    c.statement.executeUpdate("update bank set pin='"+t2.getText()+"' where pin='"+pin+"'");
                    c.statement.executeUpdate("update login set pin='"+t2.getText()+"' where pin='"+pin+"'");
                    c.statement.executeUpdate("update signup3 set pin='"+t2.getText()+"' where pin='"+pin+"'");
                    JOptionPane.showMessageDialog(null,"PIN changed successfully");
                    setVisible(false);
                    new main_class(t2.getText(), this.cardno);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        else{
            setVisible(false);
            new main_class(this.pin, this.cardno);
        }

    }
    public static void main(String[] args) {
        new ChangePin("1234","0000000000000000");
    }

}
