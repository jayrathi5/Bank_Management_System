package Bank_Management_System;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
public class SignUp extends JFrame {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JTextArea ta1;
    JRadioButton r1,r2,r3,r4;
    JDateChooser dateChooser;
    JButton b1;
    SignUp(){
        super("Application Form");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/i1.png"));
        Image i2=i1.getImage().getScaledInstance(90,90,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(30,20,90,90);
        add(image);

        l1=new JLabel("Application Form No.1");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Arial",Font.BOLD,24));
        l1.setBounds(140,25,450,30);
        add(l1);

        l2=new JLabel("Page 1: Personal Details");
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Arial",Font.BOLD,20));
        l2.setBounds(140,60,400,30);
        add(l2);

        l3=new JLabel("Name:");
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Arial",Font.BOLD,18));
        l3.setBounds(40,130,150,30);
        add(l3);

        t1=new JTextField();
        t1.setBounds(220,130,520,30);
        t1.setFont(new Font("Arial",Font.PLAIN,14));
        add(t1);

        l4=new JLabel("Father's Name:");
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Arial",Font.BOLD,18));
        l4.setBounds(40,180,150,30);
        add(l4);

        t2=new JTextField();
        t2.setBounds(220,180,520,30);
        t2.setFont(new Font("Arial",Font.PLAIN,14));
        add(t2);

        l4=new JLabel("Gender");
        l4.setBounds(40,230,150,30);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Arial",Font.BOLD,18));
        add(l4);

        r1=new JRadioButton("Male");
        r1.setBounds(220,230,90,30);
        r1.setFont(new Font("Arial",Font.BOLD,14));
        r1.setBackground(new Color(222,255,228));
        add(r1);

        r2=new JRadioButton("Female");
        r2.setBounds(320,230,110,30);
        r2.setFont(new Font("Arial",Font.BOLD,14));
        r2.setBackground(new Color(222,255,228));
        add(r2);

        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        l5=new JLabel("Date of Birth:");
        l5.setBounds(40,280,150,30);
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Arial",Font.BOLD,18));
        l5.setBackground(new Color(222,255,228));
        add(l5);

        dateChooser=new JDateChooser();
        dateChooser.setForeground(Color.BLACK);
        dateChooser.setBackground(new Color(222,255,228));
        dateChooser.setBounds(220,280,250,30);
        add(dateChooser);

        l6=new JLabel("Email Address:");
        l6.setBounds(40,330,150,30);
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Arial",Font.BOLD,18));
        add(l6);

        t3=new JTextField();
        t3.setBounds(220,330,520,30);
        t3.setFont(new Font("Arial",Font.PLAIN,14));
        add(t3);

        l7=new JLabel("Marital Status:");
        l7.setBounds(40,380,150,30);
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("Arial",Font.BOLD,18));
        add(l7);

        r3=new JRadioButton("Married");
        r3.setBounds(220,380,100,30);
        r3.setFont(new Font("Arial",Font.BOLD,14));
        r3.setBackground(new Color(222,255,228));
        add(r3);

        r4=new JRadioButton("Unmarried");
        r4.setBounds(330,380,130,30);
        r4.setFont(new Font("Arial",Font.BOLD,14));
        r4.setBackground(new Color(222,255,228));
        add(r4);

        ButtonGroup bg2=new ButtonGroup();
        bg2.add(r3);
        bg2.add(r4);

        l8=new JLabel("Address:");
        l8.setBounds(40,430,150,30);
        l8.setFont(new Font("Arial",Font.BOLD,18));
        l8.setForeground(Color.BLACK);
        add(l8);

        ta1=new JTextArea();
        ta1.setBounds(220,430,520,110);
        ta1.setFont(new Font("Arial",Font.PLAIN,14));
        add(ta1);

        l9=new JLabel("City:");
        l9.setBounds(40,560,150,30);
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("Arial",Font.BOLD,18));
        add(l9);
        t4=new JTextField();
        t4.setBounds(220,560,520,30);
        t4.setFont(new Font("Arial",Font.PLAIN,14));
        add(t4);
        l10=new JLabel("Pin Code:");
        l10.setBounds(40,610,150,30);
        l10.setFont(new Font("Arial",Font.BOLD,18));
        l10.setForeground(Color.BLACK);
        add(l10);
        t5=new JTextField();
        t5.setFont(new Font("Arial",Font.PLAIN,14));
        t5.setForeground(Color.BLACK);
        t5.setBounds(220,610,520,30);
        add(t5);
        l11=new JLabel("State:");
        l11.setBounds(40,660,150,30);
        l11.setFont(new Font("Arial",Font.BOLD,18));
        l11.setForeground(Color.BLACK);
        add(l11);
        t6=new JTextField();
        t6.setFont(new Font("Arial",Font.PLAIN,14));
        t6.setBounds(220,660,520,30);
        add(t6);
        b1=new JButton("Next Page ->");
        b1.setBounds(590,710,150,30); // right side
        b1.setBackground(new Color(0, 123, 255)); // blue
        b1.setForeground(Color.WHITE);
        add(b1);
        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(800,850);
        setLocation(360,40);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SignUp();
    }
    
}
