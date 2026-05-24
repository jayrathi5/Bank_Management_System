package Bank_Management_System;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
public class Login extends JFrame {
    JLabel label1,label2,label3;
    JTextField textfield1;
    JPasswordField passwordfield1;
    JButton button1,button2,button3;
    Login(){
        super("Bank Management System");//it should be always the first line of constructor
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/i1.png"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("Images/i2.png"));
        Image i5=i4.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image2=new JLabel(i6);
        image2.setBounds(630,350,100,100);
        add(image2);

        label1=new JLabel("Welcome To ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde",Font.BOLD,38));
        label1.setBounds(230,125,450,40);
        add(label1);

 
        label2=new JLabel("Card Number:");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Arial",Font.BOLD,28));
        label2.setBounds(110,190,240,30);
        add(label2);

        textfield1=new JTextField(15);
        textfield1.setBounds(310,190,300,30);
        textfield1.setFont(new Font("Arial",Font.BOLD,14));
        add(textfield1);


        label3=new JLabel("PIN:");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Arial",Font.BOLD,28));
        label3.setBounds(150,250,375,30);
        add(label3);

        passwordfield1=new JPasswordField(15);
        passwordfield1.setBounds(325,250,230,30);
        passwordfield1.setFont(new Font("Arial",Font.BOLD,14));
        add(passwordfield1);

        button1=new JButton("Sign in");
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(325,300,100,30);
        add(button1);
        button2=new JButton("Clear");
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(455,300,100,30);
        add(button2);
        button3=new JButton("Sign up");
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(325,350,100,30);
        add(button3);

        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("Images/i3.png")); //This backgorund image should be added at last because it will overlap the other two images if we add it before them
        Image i8=i7.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        JLabel image3=new JLabel(i9);
        image3.setBounds(0,0,850,480);
        add(image3);

        setLayout(null);
       setSize(850,480);
        setLocation(450,200);
        setVisible(true);//It should be always the last line of constructor
    }
    public static void main(String[] args) {
        new Login();
    }
    
}
