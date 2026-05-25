package Bank_Management_System;
import javax.swing.*;
import java.awt.*;
public class SignUp extends JFrame {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JRadioButton r1,r2,r3;
    
    JButton b1;
    SignUp(){
        super("Application Form");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/i1.png"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(25,10,100,100 );
        add(image);
        l1=new JLabel("Application Form No.1");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Arial",Font.BOLD,24));
        l1.setBounds(230,20,400,30);
        add(l1);
    l2=new JLabel("Page 1: Personal Details");
    l2.setForeground(Color.BLACK);
    l2.setFont(new Font("Arial",Font.BOLD,20));
    l2.setBounds(230,60,400,30);
    add(l2);
    l3=new JLabel("Name:");
    l3.setForeground(Color.BLACK);
    l3.setFont(new Font("Arial",Font.BOLD,18));
    l3.setBounds(10,70,100,30);
    add(l3);
    t1=new JTextField();
    t1.setBounds(120,70,200,30);
    t1.setFont(new Font("Arial",Font.PLAIN,14));
    add(t1);
    l4=new JLabel("Father's Name:");
    l4.setForeground(Color.BLACK);
    l4.setFont(new Font("Arial",Font.BOLD,18));
    l4.setBounds(10,110,150,30);
    add(l4);
    t2=new JTextField();
    t2.setBounds(120,110,200,30);
    t2.setFont(new Font("Arial",Font.PLAIN,14));
    add(t2);
    l4=new JLabel("Gender");
    l4.setBounds(10,150,100,30);
    l4.setForeground(Color.BLACK);
    l4.setFont(new Font("Arial",Font.BOLD,18));
    add(l4);
        r1=new JRadioButton("Male");
        r1.setBounds(120,150,70,30);
        r1.setFont(new Font("Arial",Font.BOLD,14));
        r1.setBackground(new Color(222,255,228));
        add(r1);

        r2=new JRadioButton("Female");
        r2.setBounds(200,150,100,30);
        r2.setFont(new Font("Arial",Font.BOLD,14));
        r2.setBackground(new Color(222,255,228));
        add(r2);

        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

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
