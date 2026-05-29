package Bank_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp2 extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,page2,formno;
    JTextField t1,t2,t3,t4,t5,t6;
    JComboBox<String> c1,c2,c3,c4,c5;
    JRadioButton r1,r2,r3,r4;

    SignUp2(){
        super("Application Form - Page 2");
        setLayout(null);

        Color bg = new Color(255, 255, 153); // light yellow
        Color fg = Color.BLACK;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/i1.png"));
        Image i2=i1.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
        JLabel image=new JLabel(new ImageIcon(i2));
        image.setBounds(30,20,80,80);
        add(image);

        page2=new JLabel("Page 2: Additional Details");
        page2.setBounds(130,25,420,30);
        page2.setFont(new Font("Arial",Font.BOLD,24));
        page2.setForeground(fg);
        add(page2);

        SignUp s=new SignUp();
        formno=new JLabel("Form No: " + s.formno);
        formno.setBounds(520,25,300,30);
        formno.setFont(new Font("Arial",Font.BOLD,22));
        formno.setForeground(fg);
        add(formno);

        l1=new JLabel("Religion:");
        l1.setFont(new Font("Arial",Font.BOLD,16));
        l1.setForeground(fg);
        l1.setBounds(120,120,150,30);
        add(l1);

        String religion[]={"Hindu","Muslim","Sikh","Christan","Other"};
        c1=new JComboBox<>(religion);
        c1.setBounds(300,120,400,30);
        c1.setForeground(fg);
        c1.setFont(new Font("Arial",Font.PLAIN,14));
        c1.setSelectedIndex(religion.length-1);
        add(c1);

        l2=new JLabel("Category:");
        l2.setFont(new Font("Arial",Font.BOLD,16));
        l2.setForeground(fg);
        l2.setBounds(120,170,150,30);
        add(l2);

        String category[]={"General","OBC","SC","ST","Other"};
        c2=new JComboBox<>(category);
        c2.setBounds(300,170,400,30);
        c2.setFont(new Font("Arial",Font.PLAIN,14));
        c2.setForeground(fg);
        c2.setSelectedIndex(category.length-1);
        add(c2);

        l3=new JLabel("Income:");
        l3.setFont(new Font("Arial",Font.BOLD,16));
        l3.setForeground(fg);
        l3.setBounds(120,220,150,30);
        add(l3);

        String income[]={"null","<1,50,000","<2,50,000","<5,00,000",">5,00,000"};
        c3=new JComboBox<>(income);
        c3.setBounds(300,220,400,30);
        c3.setFont(new Font("Arial",Font.PLAIN,14));
        c3.setForeground(fg);
        c3.setSelectedIndex(0);
        add(c3);

        l4=new JLabel("Education:");
        l4.setBounds(120,270,150,30);
        l4.setFont(new Font("Arial",Font.BOLD,16));
        l4.setForeground(fg);
        add(l4);

        String education[]={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Other"};
        c4=new JComboBox<>(education);
        c4.setBounds(300,270,400,30);
        c4.setFont(new Font("Arial",Font.PLAIN,14));
        c4.setForeground(fg);
        c4.setSelectedIndex(education.length-1);
        add(c4);

        l5=new JLabel("Occupation:");
        l5.setBounds(120,320,150,30);
        l5.setFont(new Font("Arial",Font.BOLD,16));
        l5.setForeground(fg);
        add(l5);

        String Occupation[]={"Salaried","Self-Employed","Business","Student","Retired","Other"};
        c5=new JComboBox<>(Occupation);
        c5.setBounds(300,320,400,30);
        c5.setFont(new Font("Arial",Font.PLAIN,14));
        c5.setForeground(fg);
        c5.setSelectedIndex(Occupation.length-1);
        add(c5);

        l6= new JLabel("PAN number:");
        l6.setBounds(120,370,150,30);
        l6.setForeground(fg);
        l6.setFont(new Font("Arial",Font.BOLD,16));
        add(l6);

        t1=new JTextField();
        t1.setBounds(300,370,400,30);
        t1.setFont(new Font("Arial",Font.PLAIN,14));
        t1.setForeground(fg);
        add(t1);

        l7=new JLabel("Aadhar number:");
        l7.setBounds(120,420,150,30);
        l7.setForeground(fg);
        l7.setFont(new Font("Arial",Font.BOLD,16));
        add(l7);

        t2=new JTextField();
        t2.setBounds(300,420,400,30);
        t2.setFont(new Font("Arial",Font.PLAIN,14));
        t2.setForeground(fg);
        add(t2);

        l8=new JLabel("Senior Citizen:");
        l8.setBounds(120,470,150,30);
        l8.setFont(new Font("Arial",Font.BOLD,16));
        l8.setForeground(fg);
        add(l8);

        r1=new JRadioButton("Yes");
        r1.setBackground(bg);
        r1.setFont(new Font("Arial",Font.PLAIN,14));
        r1.setBounds(300,470,80,30);
        add(r1);

        r2=new JRadioButton("No");
        r2.setBackground(bg);
        r2.setFont(new Font("Arial",Font.PLAIN,14));
        r2.setBounds(390,470,80,30);
        add(r2);

        ButtonGroup bg1=new ButtonGroup();
        bg1.add(r1);
        bg1.add(r2);

        l9=new JLabel("Existing Account:");
        l9.setBounds(120,520,150,30);
        l9.setFont(new Font("Arial",Font.BOLD,16));
        l9.setForeground(fg);
        add(l9);

        r3=new JRadioButton("Yes");
        r3.setBackground(bg);
        r3.setFont(new Font("Arial",Font.PLAIN,14));
        r3.setBounds(300,520,80,30);
        add(r3);

        r4=new JRadioButton("No");
        r4.setBackground(bg);
        r4.setFont(new Font("Arial",Font.PLAIN,14));
        r4.setBounds(390,520,80,30);
        add(r4);

        ButtonGroup bg2=new ButtonGroup();
        bg2.add(r3);
        bg2.add(r4);

        JButton button=new JButton("Next");
        button.setBounds(610,600,100,34);
        button.setFont(new Font("Arial",Font.BOLD,14));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.addActionListener(this);
        add(button);

        getContentPane().setBackground(bg);
        setLocation(350,10);
        setSize(850,800);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {

    }

    public static void main(String[] args) {
        new SignUp2();
    }
}
