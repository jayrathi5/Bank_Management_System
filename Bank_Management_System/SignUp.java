package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;

public class SignUp extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11, formNoLabel;
    JTextField t1,t2,t3,t4,t5,t6;
    JTextArea ta1;
    JRadioButton r1,r2,r3,r4,other;
    JDateChooser dateChooser;
    JButton b1;

    String formno;

    SignUp(){
        super("Application Form");
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/i1.png"));
        Image i2=i1.getImage().getScaledInstance(90,90,Image.SCALE_DEFAULT);
        JLabel image=new JLabel(new ImageIcon(i2));
        image.setBounds(30,20,90,90);
        add(image);

        formno = "" + (int)(Math.random() * 9000 + 1000);

        l1=new JLabel("Application Form");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Arial",Font.BOLD,24));
        l1.setBounds(140,25,220,30);
        add(l1);

        formNoLabel=new JLabel("No: " + formno);
        formNoLabel.setForeground(Color.BLACK);
        formNoLabel.setFont(new Font("Arial",Font.BOLD,24));
        formNoLabel.setBounds(370,25,220,30);
        add(formNoLabel);

        l2=new JLabel("Page 1: Personal Details");
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Arial",Font.BOLD,20));
        l2.setBounds(140,60,400,30);
        add(l2);

        l3=new JLabel("Name:");
        l3.setFont(new Font("Arial",Font.BOLD,18));
        l3.setBounds(40,130,150,30);
        add(l3);

        t1=new JTextField();
        t1.setBounds(220,130,520,30);
        t1.setFont(new Font("Arial",Font.PLAIN,14));
        add(t1);

        l4=new JLabel("Father's Name:");
        l4.setFont(new Font("Arial",Font.BOLD,18));
        l4.setBounds(40,180,150,30);
        add(l4);

        t2=new JTextField();
        t2.setBounds(220,180,520,30);
        t2.setFont(new Font("Arial",Font.PLAIN,14));
        add(t2);

        l5=new JLabel("Gender:");
        l5.setBounds(40,230,150,30);
        l5.setFont(new Font("Arial",Font.BOLD,18));
        add(l5);

        r1=new JRadioButton("Male");
        r1.setBounds(220,230,80,30);
        r1.setBackground(new Color(222,255,228));
        add(r1);

        r2=new JRadioButton("Female");
        r2.setBounds(310,230,90,30);
        r2.setBackground(new Color(222,255,228));
        add(r2);

        other=new JRadioButton("Other");
        other.setBounds(410,230,80,30);
        other.setBackground(new Color(222,255,228));
        add(other);

        ButtonGroup bg=new ButtonGroup();
        bg.add(r1); bg.add(r2); bg.add(other);

        l6=new JLabel("Date of Birth:");
        l6.setBounds(40,280,150,30);
        l6.setFont(new Font("Arial",Font.BOLD,18));
        add(l6);

        dateChooser=new JDateChooser();
        dateChooser.setBounds(220,280,250,30);
        add(dateChooser);

        l7=new JLabel("Email Address:");
        l7.setBounds(40,330,150,30);
        l7.setFont(new Font("Arial",Font.BOLD,18));
        add(l7);

        t3=new JTextField();
        t3.setBounds(220,330,520,30);
        t3.setFont(new Font("Arial",Font.PLAIN,14));
        add(t3);

        l8=new JLabel("Marital Status:");
        l8.setBounds(40,380,150,30);
        l8.setFont(new Font("Arial",Font.BOLD,18));
        add(l8);

        r3=new JRadioButton("Married");
        r3.setBounds(220,380,100,30);
        r3.setBackground(new Color(222,255,228));
        add(r3);

        r4=new JRadioButton("Unmarried");
        r4.setBounds(330,380,120,30);
        r4.setBackground(new Color(222,255,228));
        add(r4);

        ButtonGroup bg2=new ButtonGroup();
        bg2.add(r3); bg2.add(r4);

        l9=new JLabel("Address:");
        l9.setBounds(40,430,150,30);
        l9.setFont(new Font("Arial",Font.BOLD,18));
        add(l9);

        ta1=new JTextArea();
        ta1.setBounds(220,430,520,110);
        ta1.setFont(new Font("Arial",Font.PLAIN,14));
        add(ta1);

        l10=new JLabel("City:");
        l10.setBounds(40,560,150,30);
        l10.setFont(new Font("Arial",Font.BOLD,18));
        add(l10);

        t4=new JTextField();
        t4.setBounds(220,560,520,30);
        t4.setFont(new Font("Arial",Font.PLAIN,14));
        add(t4);

        l11=new JLabel("Pin Code:");
        l11.setBounds(40,610,150,30);
        l11.setFont(new Font("Arial",Font.BOLD,18));
        add(l11);

        t5=new JTextField();
        t5.setBounds(220,610,520,30);
        t5.setFont(new Font("Arial",Font.PLAIN,14));
        add(t5);

        JLabel l12=new JLabel("State:");
        l12.setBounds(40,660,150,30);
        l12.setFont(new Font("Arial",Font.BOLD,18));
        add(l12);

        t6=new JTextField();
        t6.setBounds(220,660,520,30);
        t6.setFont(new Font("Arial",Font.PLAIN,14));
        add(t6);

        b1=new JButton("Next Page ->");
        b1.setBounds(590,710,150,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        getContentPane().setBackground(new Color(222,255,228));
        setSize(800,850);
        setLocation(360,40);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name=t1.getText();
        String fathername=t2.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();

        String gender=null;
        if(r1.isSelected()) gender="Male";
        else if(r2.isSelected()) gender="Female";
        else if(other.isSelected()) gender="Other";

        String email=t3.getText();

        String marital=null;
        if(r3.isSelected()) marital="Married";
        else if(r4.isSelected()) marital="Unmarried";

        String address=ta1.getText();
        String city=t4.getText();
        String pincode=t5.getText();
        String state=t6.getText();

        try {
            if(name.equals("")) {
                JOptionPane.showMessageDialog(null,"Name is required");
            } 
            else if(fathername.equals("")){
                JOptionPane.showMessageDialog(null,"Father's Name is required");
            }
            else if(dob.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Date of Birth is required");
            }
            else if(gender==null)
            {
                JOptionPane.showMessageDialog(null,"Gender is required");
            }
            else if(email.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Email is Required");

            }
            else if(marital==null)
            {
                JOptionPane.showMessageDialog(null,"Marital Status is required");
            }
            else if(address.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Address is required");
            }
            else if(city.equals(""))
            {
                JOptionPane.showMessageDialog(null,"City is required");
            }
            else if(pincode.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Pin Code is required");
            }
            else if(state.equals(""))
            {
                JOptionPane.showMessageDialog(null,"State is required");
            }
            else {
                Con c1=new Con();
                String q="insert into signup values('"+formno+"','"+name+"','"+fathername+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                c1.statement.executeUpdate(q);
                new SignUp2(formno);
                setVisible(false);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
