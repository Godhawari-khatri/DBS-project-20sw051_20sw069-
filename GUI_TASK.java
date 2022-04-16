package com.company;
////////////////////////////////////E BOOK READING CORNER/////////////////////////////////////////////////////////

import javax.swing.*;
import java.io.File;
import java.sql.*;
import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.*;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;

public class GUI_TASK {
    public JLabel NAME;
    public JLabel PASSWORD;
    public JLabel GENDER;
    public JLabel CITY;
    public JLabel EMAIL;
    public JLabel PHONENO;

    ButtonGroup bg;
    JCheckBox jc;
    JButton jb, b,JB2;
    JLabel lb;
    JTextField tf, t;
    JPasswordField ps;
    JRadioButton jr, r1;
    JComboBox bx;
    JPasswordField p;
    JTextField F_user;
    JPasswordField F_pass;

    public void clearfield() {
        tf.setText(null);
        ps.setText(null);
        jr.setSelected(false);
        r1.setSelected(false);
        bg.clearSelection();
        t.setText(null);
        bx.setSelectedIndex(0);
        lb.setText(null);
        jc.setSelected(false);


    }


    GUI_TASK() {





        JFrame first_f=new JFrame("WELLCOME");
        first_f.setSize(3000,3000);
        JLabel lb=new JLabel("E-BOOK READING CORNER");
        lb.setFont(new Font("Algerian",Font.ROMAN_BASELINE,40));
        lb.setBounds(350,0,800,300);
        first_f.getContentPane().add(lb);
        first_f.setLocationRelativeTo(null);
        first_f.setLayout(null);

        first_f.setLayout(new FlowLayout());
        JLabel label=new JLabel(new ImageIcon("E:\\Project Stuff\\file.png"));
        // first_f.setResizable(false);

        first_f.add(label);
        label.setLayout(new FlowLayout());

        JButton signin_btn=new JButton("SignUp");
        signin_btn.setBounds(600,300,150,50);
        label.add(signin_btn);
        signin_btn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame("Sign Up");
                f.setSize(500, 800);
                f.getContentPane().setBackground(Color.pink);
                f.setVisible(true);
                f.setLocationRelativeTo(null);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setLayout(null);


                JLabel l1 = new JLabel("Sign Up!");
                l1.setBounds(150, 0, 400, 300);
                l1.setFont(new Font("Arial", Font.BOLD, 30));
                JLabel L = new JLabel("It's Quick And Easy.");
                L.setBounds(150, 20, 400, 300);
                f.getContentPane().add(L);

                f.getContentPane().add(l1);
                JLabel l2 = new JLabel("NAME: ");
                l2.setBounds(120, 350, 100, 30);
                f.getContentPane().add(l2);
                t = new JTextField();
                t.setBounds(250, 350, 150, 30);
                f.getContentPane().add(t);
                JLabel l3 = new JLabel("PASSWORD: ");
                l3.setBounds(120, 400, 100, 30);
                f.getContentPane().add(l3);
                p = new JPasswordField();
                p.setBounds(250, 400, 150, 30);
                f.getContentPane().add(p);
                JLabel l4 = new JLabel("GENDER: ");
                l4.setBounds(120, 450, 100, 30);
                f.getContentPane().add(l4);

                JRadioButton r = new JRadioButton("MALE");
                r.setBounds(250, 450, 100, 30);


                JRadioButton r1 = new JRadioButton("FEMALE");
                r1.setBounds(350, 450, 100, 30);
                ButtonGroup bg = new ButtonGroup();
                bg.add(r);
                bg.add(r1);

                f.getContentPane().add(r);
                f.getContentPane().add(r1);


                JLabel l5 = new JLabel("CITY: ");
                l5.setBounds(120, 500, 100, 30);
                f.getContentPane().add(l5);
                String Select[] = {"None", "Hyderabad", "Lahore", "Karachi"};
                JComboBox jc = new JComboBox(Select);
                jc.setBounds(250, 500, 100, 30);
                f.getContentPane().add(jc);




                JLabel l6 = new JLabel("Email: ");
                l6.setBounds(120, 550, 100, 30);
                f.getContentPane().add(l6);
                JTextField tf = new JTextField();

                tf.setBounds(250, 550, 150, 30);
                f.getContentPane().add(tf);

                JButton jb = new JButton("Sign Up");
                jb.setBounds(250, 650, 100, 30);
                f.getContentPane().add(jb);
                JLabel l7 = new JLabel("");
                l7.setBounds(650, 700, 300, 30);
                f.getContentPane().add(l7);
                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                        String Name = t.getText(); //Store username entered by the user in the variable "username"
                        String password = p.getText(); //Store password entered by the user in the variable "password"
                        // String Email = tf.getText();
                        String email = tf.getText();
                        String value = jc.getSelectedItem().toString();
                        String gender ="Male";

                        boolean actualValue = r.isSelected();
                        boolean Value = r1.isSelected();
                        int i = 0;






                        if (Name.equals("")) //If username is null
                        {
                            JOptionPane.showMessageDialog(null, "Please enter username", "Error Message", JOptionPane.ERROR_MESSAGE); //Display dialog box with the message
                        } else if (password.equals("")) //If password is null
                        {
                            JOptionPane.showMessageDialog(null, "Please enter password", "Error Message", JOptionPane.ERROR_MESSAGE); //Display dialog box with the message
                        } else if (email.equals("")) {
                            JOptionPane.showMessageDialog(null, "Please enter Email", "Error Message", JOptionPane.ERROR_MESSAGE);
                        } else if (email.equals(i)) {
                            JOptionPane.showMessageDialog(null, "Characters Required");
                        } else if (e.getSource() == r) {

                        } else if (e.getSource() == r1) {

                        } else if (actualValue == false && Value == false) {
                            JOptionPane.showMessageDialog(null, "Select Gender");

                        }
                        else if (!email.contains("@")){

                            JOptionPane.showMessageDialog(null, "Invalid Email");


                        }
                        else {

                            if(r.isSelected())
                                gender="Male";
                            else if(r1.isSelected())
                                gender="Female";



                            try {
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                System.out.println("ok");
                                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                if (connect != null) {
                                    System.out.println("connected");

                                    Statement st = connect.createStatement();
                                    String sql = "INSERT INTO signup2 (Name,Password,Gender, city,Email) VALUES( '" + t.getText() + "','" + p.getText() + "','" + gender + "','" + value + "','" + tf.getText() + "')";
                                    //  PreparedStatement preparedStatement=connect.prepareStatement();

                                    int x = st.executeUpdate(sql);

                                    if (x == 0) {
                                        JOptionPane.showMessageDialog(jb, "this already exists");
                                    } else {
                                        JOptionPane.showMessageDialog(jb, "welcome," + "you are successfully login");
                                    }
                                    String sql1 = "select city from signup2";
                                    java.sql.Statement stat = connect.createStatement();
                                    ResultSet res1 = stat.executeQuery(sql);
                                    while (res1.next()) {
                                        Object[] ob = new Object[4];
                                        ob[0] = res1.getString(1);

                                        jc.addItem((String) ob[0]);
                                    }
                                    connect.close();



                                }
                            } catch (Exception ee) {
                                System.out.println(ee);

                            }


                            JFrame frame = new JFrame("LOG IN");
                            frame.setSize(500, 800);
                            JLabel l1, l2;
                            frame.setLocationRelativeTo(null);
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame.setLayout(null);
                            //JPanel panel = new JPanel();
                            l1 = new JLabel("Username");  //Create label Username
                            l1.setBounds(80, 250, 60, 30); //x axis, y axis, width, height
                            frame.add(l1);

                            F_user = new JTextField(); //Create text field for username
                            F_user.setBounds(150, 250, 150, 30);
                            frame.add(F_user);


                            l2 = new JLabel("Password");  //Create label Password
                            l2.setBounds(80, 350, 60, 30);
                            frame.add(l2);

                            F_pass = new JPasswordField(); //Create text field for password
                            F_pass.setBounds(150, 350, 150, 30);
                            frame.getContentPane().add(F_pass);

                            JButton login_but = new JButton("Login");//creating instance of JButton for Login Button
                            login_but.setBounds(130, 500, 100, 30);
                            frame.add(login_but);
                            login_but.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String username = F_user.getText(); //Store username entered by the user in the variable "username"
                                    String password = F_pass.getText(); //Store password entered by the user in the variable "password"
                                    try {
                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                        System.out.println("ok");
                                        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                        if (connect != null) {
                                            System.out.println("connected");

                                            Statement st = connect.createStatement();

                                            String sql = "select * from signup2 where name ='" +F_user.getText() + "'and password= '" + F_pass.getText()+ "'";
                                            //  PreparedStatement preparedStatement=connect.prepareStatement();
                                            ResultSet RS=  st.executeQuery(sql);
                                            if(RS.next()){
                                                JOptionPane.showMessageDialog(null,"you are sucessfully IN \n enjoy with the books ");
                                                JFrame log = new JFrame("BOOKS LIST");
                                                JLabel log_label = new JLabel("Available Books");
                                                log_label.setFont(new Font("Brittney", Font.BOLD, 30));
                                                log_label.setBounds(100, 30, 250, 30);
                                                log.setSize(500, 800);
                                                log.add(log_label);
                                                log.setLayout(null);
                                                log.setLocationRelativeTo(null);
                                                log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                JLabel jLabel = new JLabel(new ImageIcon("E:\\Project Stuff\\pic.png"));
                                                log.add(jLabel);
                                                jLabel.setLayout(new FlowLayout());

                                                JButton bk1 = new JButton("C++");
                                                bk1.setBounds(170, 100, 120, 40);
                                                log.add(bk1);
                                                bk1.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        JFrame cpp_b=new JFrame("C++");
                                                        cpp_b.setSize(500,800);
                                                        cpp_b.setLayout(null);
                                                        cpp_b.setLocationRelativeTo(null);
                                                        JLabel label = new JLabel("Our most read book Is, Book 3..");
                                                        label.setBounds(70,50,500,50);
                                                        label.setForeground(Color.green);
                                                        label.setFont(new Font("Copperplate Gothic Bold",Font.ROMAN_BASELINE,20));
                                                        cpp_b.add(label);
                                                        final Runnable updater = new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                label.setVisible(!label.isVisible());
                                                            }
                                                        };
                                                        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                                                        executorService.scheduleAtFixedRate(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                SwingUtilities.invokeLater(updater);
                                                            }
                                                        }, 1, 1, TimeUnit.SECONDS);
                                                        JButton cpp1=new JButton(" Cpp Book1");

                                                        cpp1.setBounds(170,100,120,40);
                                                        cpp_b.add(cpp1);

                                                        JLabel rat_l1=new JLabel("Rating");
                                                        rat_l1.setBounds(250,150,120,20);
                                                        cpp_b.add(rat_l1);


                                                        JTextField rat1=new JTextField();
                                                        rat1.setBounds(300,150,120,20);
                                                        cpp_b.add(rat1);
                                                        rat1.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat1.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat1.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat1.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat1, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });

                                                        cpp1.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\bk1.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }
                                                            }
                                                        });
                                                        JButton cpp2=new JButton("Cpp Book2");
                                                        cpp2.setBounds(170, 250, 120, 40);
                                                        cpp_b.add(cpp2);
                                                        JLabel rat_l2=new JLabel("Rating");
                                                        rat_l2.setBounds(250,300,120,20);
                                                        cpp_b.add(rat_l2);


                                                        JTextField rat2=new JTextField();
                                                        rat2.setBounds(300,300,120,20);
                                                        cpp_b.add(rat2);
                                                        rat2.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat2.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat2.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat2.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat2, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        cpp2.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\cpp buk2.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }





                                                            }
                                                        });
                                                        JButton cpp3=new JButton("Cpp Book3");
                                                        cpp3.setBounds(170, 400, 120, 40);
                                                        cpp_b.add(cpp3);

                                                        JLabel rat_l3=new JLabel("Rating");
                                                        rat_l3.setBounds(250,450,120,20);
                                                        cpp_b.add(rat_l3);


                                                        JTextField rat3=new JTextField();
                                                        rat3.setBounds(300,450,120,20);
                                                        cpp_b.add(rat3);
                                                        rat3.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat3.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat3.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat3.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat3, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        cpp3.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\buk3.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }


                                                            }
                                                        });

                                                        cpp_b.setVisible(true);
                                                        JButton submit_btn=new JButton("submit");
                                                        submit_btn.setBounds(170, 600, 120, 40);
                                                        cpp_b.add(submit_btn);
                                                        submit_btn.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {
                                                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                                                    System.out.println("ok");
                                                                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                                                    if (connect != null) {
                                                                        System.out.println("connected");

                                                                        Statement st = connect.createStatement();
                                                                        String sql = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +cpp1.getText()+ "','" +rat1.getText() +"')";
                                                                        String sql1 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +cpp2.getText()+ "','" +rat2.getText() +"')";
                                                                        String sql3 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +cpp3.getText()+ "','" +rat3.getText() +"')";


                                                                        //  PreparedStatement preparedStatement=connect.prepareStatement();

                                                                        int x = st.executeUpdate(sql);
                                                                        int y = st.executeUpdate(sql1);
                                                                        int z= st.executeUpdate(sql3);


                                                                        if (x == 0) {
                                                                            JOptionPane.showMessageDialog(jb, "this already exists");
                                                                        } else {
                                                                            JOptionPane.showMessageDialog(jb, "Thank You for using our Application");
                                                                        }

                                                                        connect.close();



                                                                    }
                                                                } catch (Exception ee) {
                                                                    System.out.println(ee);

                                                                }

                                                            }
                                                        });
                                                    }
                                                });

                                                JButton bk2 = new JButton("JAVA");
                                                bk2.setBounds(170, 150, 120, 40);
                                                log.add(bk2);
                                                bk2.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        JFrame java_b=new JFrame("JAVA");
                                                        java_b.setSize(500,800);
                                                        java_b.setLayout(null);
                                                        java_b.setLocationRelativeTo(null);
                                                        JLabel label = new JLabel("Our most read book Is, Book 1..");
                                                        label.setBounds(70,50,500,50);
                                                        label.setForeground(Color.green);
                                                        label.setFont(new Font("Copperplate Gothic Bold",Font.ROMAN_BASELINE,20));
                                                        java_b.add(label);
                                                        final Runnable updater = new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                label.setVisible(!label.isVisible());
                                                            }
                                                        };
                                                        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                                                        executorService.scheduleAtFixedRate(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                SwingUtilities.invokeLater(updater);
                                                            }
                                                        }, 1, 1, TimeUnit.SECONDS);
                                                        JButton java1=new JButton("JAVA Book1");
                                                        java1.setBounds(170, 100, 120, 40);
                                                        java_b.add(java1);
                                                        JLabel rat_l1=new JLabel("Rating");
                                                        rat_l1.setBounds(250,150,120,20);
                                                        java_b.add(rat_l1);


                                                        JTextField rat1=new JTextField();
                                                        rat1.setBounds(300,150,120,20);
                                                        java_b.add(rat1);
                                                        rat1.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat1.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat1.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat1.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat1, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        java1.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\bk2.pdf");
                                                                    Desktop.getDesktop().open(f);

                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });
                                                        JButton java2=new JButton("JAVA Book2");
                                                        java2.setBounds(170, 250, 120, 40);
                                                        java_b.add(java2);
                                                        JLabel rat_l2=new JLabel("Rating");
                                                        rat_l2.setBounds(250,300,120,20);
                                                        java_b.add(rat_l2);


                                                        JTextField rat2=new JTextField();
                                                        rat2.setBounds(300,300,120,20);
                                                        java_b.add(rat2);
                                                        rat2.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat2.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat2.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat2.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat2, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        java2.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\js bk2.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });
                                                        JButton java3=new JButton("JAVA Book3");
                                                        java3.setBounds(170, 400, 120, 40);
                                                        java_b.add(java3);

                                                        JLabel rat_l3=new JLabel("Rating");
                                                        rat_l3.setBounds(250,450,120,20);
                                                        java_b.add(rat_l3);


                                                        JTextField rat3=new JTextField();
                                                        rat3.setBounds(300,450,120,20);
                                                        java_b.add(rat3);
                                                        rat3.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat3.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat3.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat3.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat3, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        java3.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\bok4.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });

                                                        java_b.setVisible(true);
                                                        JButton submit_btn=new JButton("submit");
                                                        submit_btn.setBounds(170, 600, 120, 40);
                                                        java_b.add(submit_btn);
                                                        submit_btn.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {
                                                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                                                    System.out.println("ok");
                                                                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                                                    if (connect != null) {
                                                                        System.out.println("connected");

                                                                        Statement st = connect.createStatement();
                                                                        String sql = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +java1.getText()+ "','" +rat1.getText() +"')";
                                                                        String sql1 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +java2.getText()+ "','" +rat2.getText() +"')";
                                                                        String sql3 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +java3.getText()+ "','" +rat3.getText() +"')";


                                                                        //  PreparedStatement preparedStatement=connect.prepareStatement();

                                                                        int x = st.executeUpdate(sql);
                                                                        int y = st.executeUpdate(sql1);
                                                                        int z= st.executeUpdate(sql3);


                                                                        if (x == 0) {
                                                                            JOptionPane.showMessageDialog(jb, "this already exists");
                                                                        } else {
                                                                            JOptionPane.showMessageDialog(jb, "Thank You for using our Application");
                                                                        }

                                                                        connect.close();



                                                                    }
                                                                } catch (Exception ee) {
                                                                    System.out.println(ee);

                                                                }

                                                            }
                                                        });

                                                    }
                                                });

                                                JButton bk3 = new JButton("PHP");
                                                bk3.setBounds(170, 200, 120, 40);
                                                log.add(bk3);
                                                bk3.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        JFrame php_b=new JFrame("PHP");
                                                        php_b.setSize(500,800);
                                                        php_b.setLayout(null);
                                                        php_b.setLocationRelativeTo(null);
                                                        JLabel label = new JLabel("Our most read book Is, Book 2..");
                                                        label.setBounds(70,50,500,50);
                                                        label.setForeground(Color.green);
                                                        label.setFont(new Font("Copperplate Gothic Bold",Font.ROMAN_BASELINE,20));
                                                        php_b.add(label);
                                                        final Runnable updater = new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                label.setVisible(!label.isVisible());
                                                            }
                                                        };
                                                        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                                                        executorService.scheduleAtFixedRate(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                SwingUtilities.invokeLater(updater);
                                                            }
                                                        }, 1, 1, TimeUnit.SECONDS);

                                                        JButton php1=new JButton("php Book1");
                                                        php1.setBounds(170, 100, 120, 40);
                                                        php_b.add(php1);
                                                        JLabel rat_l1=new JLabel("Rating");
                                                        rat_l1.setBounds(250,150,120,20);
                                                        php_b.add(rat_l1);


                                                        JTextField rat1=new JTextField();
                                                        rat1.setBounds(300,150,120,20);
                                                        php_b.add(rat1);
                                                        rat1.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat1.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat1.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat1.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat1, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        php1.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\bk3.pdf");
                                                                    Desktop.getDesktop().open(f);

                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });
                                                        JButton php2=new JButton("php Book2");
                                                        php2.setBounds(170, 250, 120, 40);
                                                        php_b.add(php2);
                                                        JLabel rat_l2=new JLabel("Rating");
                                                        rat_l2.setBounds(250,300,120,20);
                                                        php_b.add(rat_l2);


                                                        JTextField rat2=new JTextField();
                                                        rat2.setBounds(300,300,120,20);
                                                        php_b.add(rat2);
                                                        rat2.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat2.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat2.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat2.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat2, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        php2.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\php bk 2.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });
                                                        JButton php3=new JButton("php Book3");
                                                        php3.setBounds(170, 400, 120, 40);
                                                        php_b.add(php3);

                                                        JLabel rat_l3=new JLabel("Rating");
                                                        rat_l3.setBounds(250,450,120,20);
                                                        php_b.add(rat_l3);


                                                        JTextField rat3=new JTextField();
                                                        rat3.setBounds(300,450,120,20);
                                                        php_b.add(rat3);
                                                        rat3.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat3.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat3.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat3.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat3, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        php3.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\php bk3.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });

                                                        php_b.setVisible(true);
                                                        JButton submit_btn=new JButton("submit");
                                                        submit_btn.setBounds(170, 600, 120, 40);
                                                        php_b.add(submit_btn);
                                                        submit_btn.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {
                                                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                                                    System.out.println("ok");
                                                                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                                                    if (connect != null) {
                                                                        System.out.println("connected");

                                                                        Statement st = connect.createStatement();
                                                                        String sql = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +php1.getText()+ "','" +rat1.getText() +"')";
                                                                        String sql1 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +php2.getText()+ "','" +rat2.getText() +"')";
                                                                        String sql3 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +php3.getText()+ "','" +rat3.getText() +"')";


                                                                        //  PreparedStatement preparedStatement=connect.prepareStatement();

                                                                        int x = st.executeUpdate(sql);
                                                                        int y = st.executeUpdate(sql1);
                                                                        int z= st.executeUpdate(sql3);


                                                                        if (x == 0) {
                                                                            JOptionPane.showMessageDialog(jb, "this already exists");
                                                                        } else {
                                                                            JOptionPane.showMessageDialog(jb, "Thank You for using our Application");
                                                                        }

                                                                        connect.close();



                                                                    }
                                                                } catch (Exception ee) {
                                                                    System.out.println(ee);

                                                                }

                                                            }
                                                        });

                                                    }
                                                });

                                                JButton bk4 = new JButton("HTML");
                                                bk4.setBounds(170, 250, 120, 40);
                                                log.add(bk4);
                                                bk4.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        JFrame html_b=new JFrame("HTML");
                                                        html_b.setSize(500,800);
                                                        html_b.setLayout(null);
                                                        html_b.setLocationRelativeTo(null);
                                                        JLabel label = new JLabel("Our most read book Is, Book 3..");
                                                        label.setBounds(70,50,500,50);
                                                        label.setForeground(Color.green);
                                                        label.setFont(new Font("Copperplate Gothic Bold",Font.ROMAN_BASELINE,20));
                                                        html_b.add(label);
                                                        final Runnable updater = new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                label.setVisible(!label.isVisible());
                                                            }
                                                        };
                                                        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                                                        executorService.scheduleAtFixedRate(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                SwingUtilities.invokeLater(updater);
                                                            }
                                                        }, 1, 1, TimeUnit.SECONDS);
                                                        JButton html1=new JButton("HTML Book1");
                                                        html1.setBounds(170, 100, 120, 40);
                                                        html_b.add(html1);
                                                        JLabel rat_l1=new JLabel("Rating");
                                                        rat_l1.setBounds(250,150,120,20);
                                                        html_b.add(rat_l1);


                                                        JTextField rat1=new JTextField();
                                                        rat1.setBounds(300,150,120,20);
                                                        html_b.add(rat1);
                                                        rat1.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat1.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat1.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat1.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat1, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        html1.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\bk4.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });
                                                        JButton html2=new JButton("HTML Book2");
                                                        html2.setBounds(170, 250, 120, 40);
                                                        html_b.add(html2);
                                                        JLabel rat_l2=new JLabel("Rating");
                                                        rat_l2.setBounds(250,300,120,20);
                                                        html_b.add(rat_l2);


                                                        JTextField rat2=new JTextField();
                                                        rat2.setBounds(300,300,120,20);
                                                        html_b.add(rat2);
                                                        rat2.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat2.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat2.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat2.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat2, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        html2.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\html bk2.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });
                                                        JButton html3=new JButton("HTML Book3");
                                                        html3.setBounds(170, 400, 120, 40);
                                                        html_b.add(html3);
                                                        JLabel rat_l3=new JLabel("Rating");
                                                        rat_l3.setBounds(250,450,120,20);
                                                        html_b.add(rat_l3);


                                                        JTextField rat3=new JTextField();
                                                        rat3.setBounds(300,450,120,20);
                                                        html_b.add(rat3);
                                                        rat3.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat3.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat3.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat3.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat3, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        html3.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\html bk3.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });

                                                        html_b.setVisible(true);
                                                        JButton submit_btn=new JButton("submit");
                                                        submit_btn.setBounds(170, 600, 120, 40);
                                                        html_b.add(submit_btn);
                                                        submit_btn.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {
                                                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                                                    System.out.println("ok");
                                                                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                                                    if (connect != null) {
                                                                        System.out.println("connected");

                                                                        Statement st = connect.createStatement();
                                                                        String sql = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +html1.getText()+ "','" +rat1.getText() +"')";
                                                                        String sql1 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +html2.getText()+ "','" +rat2.getText() +"')";
                                                                        String sql3 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +html3.getText()+ "','" +rat3.getText() +"')";


                                                                        //  PreparedStatement preparedStatement=connect.prepareStatement();

                                                                        int x = st.executeUpdate(sql);
                                                                        int y = st.executeUpdate(sql1);
                                                                        int z= st.executeUpdate(sql3);


                                                                        if (x == 0) {
                                                                            JOptionPane.showMessageDialog(jb, "this already exists");
                                                                        } else {
                                                                            JOptionPane.showMessageDialog(jb, "Thank You for using our Application");
                                                                        }

                                                                        connect.close();



                                                                    }
                                                                } catch (Exception ee) {
                                                                    System.out.println(ee);

                                                                }

                                                            }
                                                        });

                                                    }
                                                });

                                                JButton bk5 = new JButton("CSS");
                                                bk5.setBounds(170, 300, 120, 40);
                                                log.add(bk5);
                                                bk5.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        JFrame css_b=new JFrame("CSS");
                                                        css_b.setSize(500,800);
                                                        css_b.setLayout(null);
                                                        css_b.setLocationRelativeTo(null);
                                                        JLabel label = new JLabel("Our most read book Is, Book 1..");
                                                        label.setBounds(70,50,500,50);
                                                        label.setForeground(Color.green);
                                                        label.setFont(new Font("Copperplate Gothic Bold",Font.ROMAN_BASELINE,20));
                                                        css_b.add(label);
                                                        final Runnable updater = new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                label.setVisible(!label.isVisible());
                                                            }
                                                        };
                                                        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                                                        executorService.scheduleAtFixedRate(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                SwingUtilities.invokeLater(updater);
                                                            }
                                                        }, 1, 1, TimeUnit.SECONDS);
                                                        JButton css1=new JButton("CSS Book1");
                                                        css1.setBounds(170, 100, 120, 40);
                                                        css_b.add(css1);
                                                        JLabel rat_l1=new JLabel("Rating");
                                                        rat_l1.setBounds(250,150,120,20);
                                                        css_b.add(rat_l1);


                                                        JTextField rat1=new JTextField();
                                                        rat1.setBounds(300,150,120,20);
                                                        css_b.add(rat1);
                                                        rat1.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat1.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat1.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat1.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat1, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        css1.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\bk5.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });
                                                        JButton css2=new JButton("CSS Book2");
                                                        css2.setBounds(170, 250, 120, 40);
                                                        css_b.add(css2);
                                                        JLabel rat_l2=new JLabel("Rating");
                                                        rat_l2.setBounds(250,300,120,20);
                                                        css_b.add(rat_l2);


                                                        JTextField rat2=new JTextField();
                                                        rat2.setBounds(300,300,120,20);
                                                        css_b.add(rat2);
                                                        rat2.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat2.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat2.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat2.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat2, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        css2.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\css bk2.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });
                                                        JButton css3=new JButton("CSS Book3");
                                                        css3.setBounds(170, 400, 120, 40);
                                                        css_b.add(css3);

                                                        JLabel rat_l3=new JLabel("Rating");
                                                        rat_l3.setBounds(250,450,120,20);
                                                        css_b.add(rat_l3);


                                                        JTextField rat3=new JTextField();
                                                        rat3.setBounds(300,450,120,20);
                                                        css_b.add(rat3);
                                                        rat3.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat3.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat3.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat3.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat3, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        css3.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\css bk3.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });

                                                        css_b.setVisible(true);
                                                        JButton submit_btn=new JButton("submit");
                                                        submit_btn.setBounds(170, 600, 120, 40);
                                                        css_b.add(submit_btn);
                                                        submit_btn.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {
                                                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                                                    System.out.println("ok");
                                                                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                                                    if (connect != null) {
                                                                        System.out.println("connected");

                                                                        Statement st = connect.createStatement();
                                                                        String sql = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +css1.getText()+ "','" +rat1.getText() +"')";
                                                                        String sql1 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +css2.getText()+ "','" +rat2.getText() +"')";
                                                                        String sql3 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +css3.getText()+ "','" +rat3.getText() +"')";


                                                                        //  PreparedStatement preparedStatement=connect.prepareStatement();

                                                                        int x = st.executeUpdate(sql);
                                                                        int y = st.executeUpdate(sql1);
                                                                        int z= st.executeUpdate(sql3);


                                                                        if (x == 0) {
                                                                            JOptionPane.showMessageDialog(jb, "this already exists");
                                                                        } else {
                                                                            JOptionPane.showMessageDialog(jb, "Thank You for using our Application");
                                                                        }

                                                                        connect.close();



                                                                    }
                                                                } catch (Exception ee) {
                                                                    System.out.println(ee);

                                                                }

                                                            }
                                                        });


                                                    }
                                                });

                                                JButton bk6 = new JButton("JAVASCRIPT");
                                                bk6.setBounds(170, 350, 120, 40);
                                                log.add(bk6);
                                                bk6.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        JFrame jscp_b=new JFrame("JAVASCRIPT");
                                                        jscp_b.setSize(500,800);
                                                        jscp_b.setLayout(null);
                                                        jscp_b.setLocationRelativeTo(null);
                                                        JLabel label = new JLabel("Our most read book Is, Book 2..");
                                                        label.setBounds(70,50,500,50);
                                                        label.setForeground(Color.green);
                                                        label.setFont(new Font("Copperplate Gothic Bold",Font.ROMAN_BASELINE,20));
                                                        jscp_b.add(label);
                                                        final Runnable updater = new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                label.setVisible(!label.isVisible());
                                                            }
                                                        };
                                                        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                                                        executorService.scheduleAtFixedRate(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                SwingUtilities.invokeLater(updater);
                                                            }
                                                        }, 1, 1, TimeUnit.SECONDS);
                                                        JButton jscp1=new JButton("JS Book1");
                                                        jscp1.setBounds(170, 100, 120, 40);
                                                        jscp_b.add(jscp1);
                                                        JLabel rat_l1=new JLabel("Rating");
                                                        rat_l1.setBounds(250,150,120,20);
                                                        jscp_b.add(rat_l1);


                                                        JTextField rat1=new JTextField();
                                                        rat1.setBounds(300,150,120,20);
                                                        jscp_b.add(rat1);
                                                        rat1.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat1.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat1.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat1.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat1, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        jscp1.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\bk6.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });
                                                        JButton jscp2=new JButton("JS Book2");
                                                        jscp2.setBounds(170, 250, 120, 40);
                                                        jscp_b.add(jscp2);
                                                        JLabel rat_l2=new JLabel("Rating");
                                                        rat_l2.setBounds(250,300,120,20);
                                                        jscp_b.add(rat_l2);


                                                        JTextField rat2=new JTextField();
                                                        rat2.setBounds(300,300,120,20);
                                                        jscp_b.add(rat2);
                                                        rat2.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat2.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat2.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat2.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat2, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        jscp2.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\bok3.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });
                                                        JButton jscp3=new JButton("JS Book3");
                                                        jscp3.setBounds(170, 400, 120, 40);
                                                        jscp_b.add(jscp3);

                                                        JLabel rat_l3=new JLabel("Rating");
                                                        rat_l3.setBounds(250,450,120,20);
                                                        jscp_b.add(rat_l3);


                                                        JTextField rat3=new JTextField();
                                                        rat3.setBounds(300,450,120,20);
                                                        jscp_b.add(rat3);
                                                        rat3.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat3.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat3.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat3.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat3, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        jscp3.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\js bk3.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });

                                                        jscp_b.setVisible(true);
                                                        JButton submit_btn=new JButton("submit");
                                                        submit_btn.setBounds(170, 600, 120, 40);
                                                        jscp_b.add(submit_btn);
                                                        submit_btn.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {
                                                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                                                    System.out.println("ok");
                                                                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                                                    if (connect != null) {
                                                                        System.out.println("connected");

                                                                        Statement st = connect.createStatement();
                                                                        String sql = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +jscp1.getText()+ "','" +rat1.getText() +"')";
                                                                        String sql1 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +jscp2.getText()+ "','" +rat2.getText() +"')";
                                                                        String sql3 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +jscp3.getText()+ "','" +rat3.getText() +"')";


                                                                        //  PreparedStatement preparedStatement=connect.prepareStatement();

                                                                        int x = st.executeUpdate(sql);
                                                                        int y = st.executeUpdate(sql1);
                                                                        int z= st.executeUpdate(sql3);


                                                                        if (x == 0) {
                                                                            JOptionPane.showMessageDialog(jb, "this already exists");
                                                                        } else {
                                                                            JOptionPane.showMessageDialog(jb, "Thank You for using our Application");
                                                                        }

                                                                        connect.close();



                                                                    }
                                                                } catch (Exception ee) {
                                                                    System.out.println(ee);

                                                                }

                                                            }
                                                        });


                                                    }
                                                });

                                                JButton bk7 = new JButton("SQL");
                                                bk7.setBounds(170, 400, 120, 40);
                                                log.add(bk7);
                                                bk7.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        JFrame sql_b=new JFrame("SQL");
                                                        sql_b.setSize(500,800);
                                                        sql_b.setLayout(null);
                                                        sql_b.setLocationRelativeTo(null);
                                                        JLabel label = new JLabel("Our most read book Is, Book 3..");
                                                        label.setBounds(70,50,500,50);
                                                        label.setForeground(Color.green);
                                                        label.setFont(new Font("Copperplate Gothic Bold",Font.ROMAN_BASELINE,20));
                                                        sql_b.add(label);
                                                        final Runnable updater = new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                label.setVisible(!label.isVisible());
                                                            }
                                                        };
                                                        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                                                        executorService.scheduleAtFixedRate(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                SwingUtilities.invokeLater(updater);
                                                            }
                                                        }, 1, 1, TimeUnit.SECONDS);
                                                        JButton sql1=new JButton("SQL Book1");
                                                        sql1.setBounds(170, 100, 120, 40);
                                                        sql_b.add(sql1);
                                                        JLabel rat_l1=new JLabel("Rating");
                                                        rat_l1.setBounds(250,150,120,20);
                                                        sql_b.add(rat_l1);


                                                        JTextField rat1=new JTextField();
                                                        rat1.setBounds(300,150,120,20);
                                                        sql_b.add(rat1);
                                                        rat1.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat1.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat1.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat1.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat1, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        sql1.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\bk7.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });
                                                        JButton sql2=new JButton("SQL Book2");
                                                        sql2.setBounds(170, 250, 120, 40);
                                                        sql_b.add(sql2);
                                                        JLabel rat_l2=new JLabel("Rating");
                                                        rat_l2.setBounds(250,300,120,20);
                                                        sql_b.add(rat_l2);


                                                        JTextField rat2=new JTextField();
                                                        rat2.setBounds(300,300,120,20);
                                                        sql_b.add(rat2);
                                                        rat2.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat2.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat2.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat2.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat2, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        sql2.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\sql bk2.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });
                                                        JButton sql3=new JButton("SQL Book3");
                                                        sql3.setBounds(170, 400, 120, 40);
                                                        sql_b.add(sql3);

                                                        JLabel rat_l3=new JLabel("Rating");
                                                        rat_l3.setBounds(250,450,120,20);
                                                        sql_b.add(rat_l3);


                                                        JTextField rat3=new JTextField();
                                                        rat3.setBounds(300,450,120,20);
                                                        sql_b.add(rat3);
                                                        rat3.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat3.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat3.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat3.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat3, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        sql3.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\sql bk3.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });

                                                        sql_b.setVisible(true);
                                                        JButton submit_btn=new JButton("submit");
                                                        submit_btn.setBounds(170, 600, 120, 40);
                                                        sql_b.add(submit_btn);
                                                        submit_btn.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {
                                                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                                                    System.out.println("ok");
                                                                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                                                    if (connect != null) {
                                                                        System.out.println("connected");

                                                                        Statement st = connect.createStatement();
                                                                        String sql = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +sql1.getText()+ "','" +rat1.getText() +"')";
                                                                        String sql1 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +sql2.getText()+ "','" +rat2.getText() +"')";
                                                                        String sql4 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +sql3.getText()+ "','" +rat3.getText() +"')";


                                                                        //  PreparedStatement preparedStatement=connect.prepareStatement();

                                                                        int x = st.executeUpdate(sql);
                                                                        int y = st.executeUpdate(sql1);
                                                                        int z= st.executeUpdate(sql4);


                                                                        if (x == 0) {
                                                                            JOptionPane.showMessageDialog(jb, "this already exists");
                                                                        } else {
                                                                            JOptionPane.showMessageDialog(jb, "Thank You for using our Application");
                                                                        }

                                                                        connect.close();



                                                                    }
                                                                } catch (Exception ee) {
                                                                    System.out.println(ee);

                                                                }

                                                            }
                                                        });

                                                    }
                                                });

                                                JButton bk8 = new JButton("C#");
                                                bk8.setBounds(170, 450, 120, 40);
                                                log.add(bk8);
                                                bk8.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        JFrame C_b=new JFrame("C#");
                                                        C_b.setSize(500,800);
                                                        C_b.setLayout(null);
                                                        C_b.setLocationRelativeTo(null);
                                                        JLabel label = new JLabel("Our most read book Is, Book 1..");
                                                        label.setBounds(70,50,500,50);
                                                        label.setForeground(Color.green);
                                                        label.setFont(new Font("Copperplate Gothic Bold",Font.ROMAN_BASELINE,20));
                                                        C_b.add(label);
                                                        final Runnable updater = new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                label.setVisible(!label.isVisible());
                                                            }
                                                        };
                                                        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                                                        executorService.scheduleAtFixedRate(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                SwingUtilities.invokeLater(updater);
                                                            }
                                                        }, 1, 1, TimeUnit.SECONDS);
                                                        JButton c1=new JButton("C# Book1");
                                                        c1.setBounds(170, 100, 120, 40);
                                                        C_b.add(c1);
                                                        JLabel rat_l1=new JLabel("Rating");
                                                        rat_l1.setBounds(250,150,120,20);
                                                        C_b.add(rat_l1);


                                                        JTextField rat1=new JTextField();
                                                        rat1.setBounds(300,150,120,20);
                                                        C_b.add(rat1);
                                                        rat1.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat1.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat1.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat1.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat1, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        c1.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\bk8.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });
                                                        JButton c2=new JButton("C# Book2");
                                                        c2.setBounds(170, 250, 120, 40);
                                                        C_b.add(c2);
                                                        JLabel rat_l2=new JLabel("Rating");
                                                        rat_l2.setBounds(250,300,120,20);
                                                        C_b.add(rat_l2);


                                                        JTextField rat2=new JTextField();
                                                        rat2.setBounds(300,300,120,20);
                                                        C_b.add(rat2);
                                                        rat2.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat2.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat2.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat2.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat2, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        c2.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\c# bk2.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });
                                                        JButton c3=new JButton("C# Book3");
                                                        c3.setBounds(170, 400, 120, 40);
                                                        C_b.add(c3);

                                                        JLabel rat_l3=new JLabel("Rating");
                                                        rat_l3.setBounds(250,450,120,20);
                                                        C_b.add(rat_l3);


                                                        JTextField rat3=new JTextField();
                                                        rat3.setBounds(300,450,120,20);
                                                        C_b.add(rat3);
                                                        rat3.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat3.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat3.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat3.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat3, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        c3.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\c# bk3.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });

                                                        C_b.setVisible(true);
                                                        JButton submit_btn=new JButton("submit");
                                                        submit_btn.setBounds(170, 600, 120, 40);
                                                        C_b.add(submit_btn);
                                                        submit_btn.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {
                                                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                                                    System.out.println("ok");
                                                                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                                                    if (connect != null) {
                                                                        System.out.println("connected");

                                                                        Statement st = connect.createStatement();
                                                                        String sql = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +c1.getText()+ "','" +rat1.getText() +"')";
                                                                        String sql1 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +c2.getText()+ "','" +rat2.getText() +"')";
                                                                        String sql3 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +c3.getText()+ "','" +rat3.getText() +"')";


                                                                        //  PreparedStatement preparedStatement=connect.prepareStatement();

                                                                        int x = st.executeUpdate(sql);
                                                                        int y = st.executeUpdate(sql1);
                                                                        int z= st.executeUpdate(sql3);


                                                                        if (x == 0) {
                                                                            JOptionPane.showMessageDialog(jb, "this already exists");
                                                                        } else {
                                                                            JOptionPane.showMessageDialog(jb, "Thank You for using our Application");
                                                                        }

                                                                        connect.close();



                                                                    }
                                                                } catch (Exception ee) {
                                                                    System.out.println(ee);

                                                                }

                                                            }
                                                        });

                                                    }
                                                });

                                                JButton bk9 = new JButton("PYTHON");
                                                bk9.setBounds(170, 500, 120, 40);
                                                log.add(bk9);
                                                bk9.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        JFrame pyt_b=new JFrame("PYTHON");
                                                        pyt_b.setSize(500,800);
                                                        pyt_b.setLayout(null);
                                                        pyt_b.setLocationRelativeTo(null);
                                                        JLabel label = new JLabel("Our most read book Is, Book 2..");
                                                        label.setBounds(70,50,500,50);
                                                        label.setForeground(Color.green);
                                                        label.setFont(new Font("Copperplate Gothic Bold",Font.ROMAN_BASELINE,20));
                                                        pyt_b.add(label);
                                                        final Runnable updater = new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                label.setVisible(!label.isVisible());
                                                            }
                                                        };
                                                        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                                                        executorService.scheduleAtFixedRate(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                SwingUtilities.invokeLater(updater);
                                                            }
                                                        }, 1, 1, TimeUnit.SECONDS);
                                                        JButton pyt1=new JButton("PYTHON Book1");
                                                        pyt1.setBounds(170, 100, 120, 40);
                                                        pyt_b.add(pyt1);
                                                        JLabel rat_l1=new JLabel("Rating");
                                                        rat_l1.setBounds(250,150,120,20);
                                                        pyt_b.add(rat_l1);


                                                        JTextField rat1=new JTextField();
                                                        rat1.setBounds(300,150,120,20);
                                                        pyt_b.add(rat1);
                                                        rat1.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat1.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat1.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat1.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat1, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        pyt1.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\bk9.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });
                                                        JButton pyt2=new JButton("PYTHON Book2");
                                                        pyt2.setBounds(170, 250, 120, 40);
                                                        pyt_b.add(pyt2);
                                                        JLabel rat_l2=new JLabel("Rating");
                                                        rat_l2.setBounds(250,300,120,20);
                                                        pyt_b.add(rat_l2);


                                                        JTextField rat2=new JTextField();
                                                        rat2.setBounds(300,300,120,20);
                                                        pyt_b.add(rat2);
                                                        rat2.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat2.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat2.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat2.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat2, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        pyt2.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\python bk2.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }

                                                            }
                                                        });
                                                        JButton pyt3=new JButton("PYTHON Book3");
                                                        pyt3.setBounds(170, 400, 120, 40);
                                                        pyt_b.add(pyt3);

                                                        JLabel rat_l3=new JLabel("Rating");
                                                        rat_l3.setBounds(250,450,120,20);
                                                        pyt_b.add(rat_l3);


                                                        JTextField rat3=new JTextField();
                                                        rat3.setBounds(300,450,120,20);
                                                        pyt_b.add(rat3);
                                                        rat3.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat3.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat3.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat3.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat3, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        pyt3.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\python bk3.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }


                                                            }
                                                        });

                                                        pyt_b.setVisible(true);
                                                        JButton submit_btn=new JButton("submit");
                                                        submit_btn.setBounds(170, 600, 120, 40);
                                                        pyt_b.add(submit_btn);
                                                        submit_btn.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {
                                                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                                                    System.out.println("ok");
                                                                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                                                    if (connect != null) {
                                                                        System.out.println("connected");

                                                                        Statement st = connect.createStatement();
                                                                        String sql = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +pyt1.getText()+ "','" +rat1.getText() +"')";
                                                                        String sql1 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +pyt2.getText()+ "','" +rat2.getText() +"')";
                                                                        String sql3 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +pyt3.getText()+ "','" +rat3.getText() +"')";


                                                                        //  PreparedStatement preparedStatement=connect.prepareStatement();

                                                                        int x = st.executeUpdate(sql);
                                                                        int y = st.executeUpdate(sql1);
                                                                        int z= st.executeUpdate(sql3);


                                                                        if (x == 0) {
                                                                            JOptionPane.showMessageDialog(jb, "this already exists");
                                                                        } else {
                                                                            JOptionPane.showMessageDialog(jb, "Thank You for using our Application");
                                                                        }

                                                                        connect.close();



                                                                    }
                                                                } catch (Exception ee) {
                                                                    System.out.println(ee);

                                                                }

                                                            }
                                                        });



                                                    }
                                                });

                                                JButton bk10 = new JButton("LARAVEL");
                                                bk10.setBounds(170, 550, 120, 40);
                                                log.add(bk10);
                                                bk10.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        JFrame lara_b=new JFrame("LARAVEL");
                                                        lara_b.setSize(500,800);
                                                        lara_b.setLayout(null);
                                                        lara_b.setLocationRelativeTo(null);
                                                        JLabel label = new JLabel("Our most read book Is, Book 3..");
                                                        label.setBounds(70,50,500,50);
                                                        label.setForeground(Color.green);
                                                        label.setFont(new Font("Copperplate Gothic Bold",Font.ROMAN_BASELINE,20));
                                                        lara_b.add(label);
                                                        final Runnable updater = new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                label.setVisible(!label.isVisible());
                                                            }
                                                        };
                                                        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                                                        executorService.scheduleAtFixedRate(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                SwingUtilities.invokeLater(updater);
                                                            }
                                                        }, 1, 1, TimeUnit.SECONDS);
                                                        JButton lara1=new JButton("LAR Book1");
                                                        lara1.setBounds(170, 100, 120, 40);
                                                        lara_b.add(lara1);
                                                        JLabel rat_l1=new JLabel("Rating");
                                                        rat_l1.setBounds(250,150,120,20);
                                                        lara_b.add(rat_l1);


                                                        JTextField rat1=new JTextField();
                                                        rat1.setBounds(300,150,120,20);
                                                        lara_b.add(rat1);
                                                        rat1.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat1.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat1.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat1.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat1, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        lara1.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\bk10.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }


                                                            }
                                                        });
                                                        JButton lara2=new JButton("LAR Book2");
                                                        lara2.setBounds(170, 250, 120, 40);
                                                        lara_b.add(lara2);
                                                        JLabel rat_l2=new JLabel("Rating");
                                                        rat_l2.setBounds(250,300,120,20);
                                                        lara_b.add(rat_l2);


                                                        JTextField rat2=new JTextField();
                                                        rat2.setBounds(300,300,120,20);
                                                        lara_b.add(rat2);
                                                        rat2.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat2.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat2.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat2.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat2, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        lara2.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\laravel bk2.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }


                                                            }
                                                        });
                                                        JButton lara3=new JButton("LAR Book3");
                                                        lara3.setBounds(170, 400, 120, 40);
                                                        lara_b.add(lara3);

                                                        JLabel rat_l3=new JLabel("Rating");
                                                        rat_l3.setBounds(250,450,120,20);
                                                        lara_b.add(rat_l3);


                                                        JTextField rat3=new JTextField();
                                                        rat3.setBounds(300,450,120,20);
                                                        lara_b.add(rat3);
                                                        rat3.addKeyListener(new KeyAdapter() {
                                                            public void keyPressed(KeyEvent ke) {
                                                                JLabel msg= new JLabel("");
                                                                msg.setBounds(200,600,100,30);
                                                                f.getContentPane().add(msg);
                                                                String value = rat3.getText();
                                                                int l = value.length();
                                                                if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                                    rat3.setEditable(true);
                                                                    msg.setText("");
                                                                } else {
                                                                    rat3.setEditable(false);
                                                                    JOptionPane.showMessageDialog(rat3, "Please Enter Only Numbers From 1-5");
                                                                }
                                                            }
                                                        });
                                                        lara3.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {

                                                                    File f = new File("E:\\Project Stuff\\laravel bk2.pdf");
                                                                    Desktop.getDesktop().open(f);


                                                                } catch (Exception ex) {
                                                                    ex.printStackTrace();
                                                                }
                                                            }
                                                        });

                                                        lara_b.setVisible(true);
                                                        JButton submit_btn=new JButton("submit");
                                                        submit_btn.setBounds(170, 600, 120, 40);
                                                        lara_b.add(submit_btn);
                                                        submit_btn.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                try {
                                                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                                                    System.out.println("ok");
                                                                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                                                    if (connect != null) {
                                                                        System.out.println("connected");

                                                                        Statement st = connect.createStatement();
                                                                        String sql = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +lara1.getText()+ "','" +rat1.getText() +"')";
                                                                        String sql1 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +lara2.getText()+ "','" +rat2.getText() +"')";
                                                                        String sql3 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + t.getText() + "','" +lara3.getText()+ "','" +rat3.getText() +"')";


                                                                        //  PreparedStatement preparedStatement=connect.prepareStatement();

                                                                        int x = st.executeUpdate(sql);
                                                                        int y = st.executeUpdate(sql1);
                                                                        int z= st.executeUpdate(sql3);


                                                                        if (x == 0) {
                                                                            JOptionPane.showMessageDialog(jb, "this already exists");
                                                                        } else {
                                                                            JOptionPane.showMessageDialog(jb, "Thank You for using our Application");
                                                                        }

                                                                        connect.close();



                                                                    }
                                                                } catch (Exception ee) {
                                                                    System.out.println(ee);

                                                                }

                                                            }
                                                        });


                                                    }
                                                });


                                                log.setLayout(null);
                                                log.setLocationRelativeTo(null);
                                                log.setVisible(true);


                                            }
                                            else{
                                                JOptionPane.showMessageDialog(null,"invalid username and password ");
                                            }
                                        }
                                    } catch (Exception ee) {
                                        System.out.println(ee);

                                    }


                                    if (username.equals("")) //If username is null
                                    {
                                        JOptionPane.showMessageDialog(null, "Please enter username"); //Display dialog box with the message
                                    } else if (password.equals("")) //If password is null
                                    {
                                        JOptionPane.showMessageDialog(null, "Please enter password"); //Display dialog box with the message
                                    } else if (!password.equals(F_pass.getText())) {
                                        JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "warn", JOptionPane.WARNING_MESSAGE);
                                    } else if (!username.equals(F_user.getText())) {
                                        JOptionPane.showMessageDialog(null, "incorrect user name )R Password", "warning", JOptionPane.ERROR_MESSAGE);
                                    } else {


                                    }

                                }
                            });
                            frame.setVisible(true);
                        }


                    }
                });


            }
        });

/////////////////////////////////login button of the main interface//////////////////////////////////////////////

        JButton login_btn=new JButton("LogIn");
        login_btn.setBounds(1000,300,150,50);
        label.add(login_btn);
        login_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("LOG IN");
                frame.setSize(500, 800);
                JLabel l1, l2;
                frame.setLayout(null);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //JPanel panel = new JPanel();
                l1 = new JLabel("Username");  //Create label Username
                l1.setBounds(80, 100, 60, 30); //x axis, y axis, width, height
                frame.add(l1);

                F_user = new JTextField(); //Create text field for username
                F_user.setBounds(150, 100, 150, 30);
                frame.add(F_user);


                l2 = new JLabel("Password");  //Create label Password
                l2.setBounds(80, 250, 60, 30);
                frame.add(l2);

                F_pass = new JPasswordField(); //Create text field for password
                F_pass.setBounds(150, 250, 150, 30);
                frame.getContentPane().add(F_pass);

                JButton login_but = new JButton("Login");//creating instance of JButton for Login Button
                login_but.setBounds(130, 400, 100, 30);
                frame.add(login_but);
                login_but.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username = F_user.getText(); //Store username entered by the user in the variable "username"
                        String password = F_pass.getText(); //Store password entered by the user in the variable "password"



                        try {


                            Class.forName("com.mysql.cj.jdbc.Driver");
                            System.out.println("ok");
                            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                            if (connect != null) {
                                System.out.println("connected");

                                Statement st = connect.createStatement();

                                String sql = "select * from signup2 where name ='" +F_user.getText() + "'and password= '" + F_pass.getText()+ "'";
                                //  PreparedStatement preparedStatement=connect.prepareStatement();
                                ResultSet RS=  st.executeQuery(sql);
                                if(RS.next()){
                                    JOptionPane.showMessageDialog(null,"you are sucessfully IN \n enjoy with the books ");
                                    JFrame log = new JFrame("BOOKS LIST");
                                    JLabel log_label = new JLabel("Available Books");
                                    log_label.setFont(new Font("Brittney", Font.BOLD, 30));
                                    log_label.setBounds(100, 30, 250, 30);
                                    log.setSize(500, 800);
                                    log.add(log_label);
                                    log.setLayout(null);
                                    log.setLocationRelativeTo(null);
                                    log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    JLabel jLabel = new JLabel(new ImageIcon("E:\\Project Stuff\\pic.png"));
                                    log.add(jLabel);
                                    jLabel.setLayout(new FlowLayout());

                                    JButton bk1 = new JButton("C++");
                                    bk1.setBounds(170, 100, 120, 40);
                                    log.add(bk1);
                                    bk1.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            JFrame cpp_b=new JFrame("C++");
                                            cpp_b.setSize(500,800);
                                            cpp_b.setLayout(null);
                                            cpp_b.setLocationRelativeTo(null);

                                            JLabel label = new JLabel("Our most read book Is, Book 3..");
                                            label.setBounds(70,50,500,50);
                                            label.setForeground(Color.green);
                                            label.setFont(new Font("Copperplate Gothic Bold",Font.ROMAN_BASELINE,20));
                                            cpp_b.add(label);
                                            final Runnable updater = new Runnable() {
                                                @Override
                                                public void run() {
                                                    label.setVisible(!label.isVisible());
                                                }
                                            };
                                            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                                            executorService.scheduleAtFixedRate(new Runnable() {
                                                @Override
                                                public void run() {
                                                    SwingUtilities.invokeLater(updater);
                                                }
                                            }, 1, 1, TimeUnit.SECONDS);


                                            JButton cpp1=new JButton(" Cpp Book1");
                                            cpp1.setBounds(170,100,120,40);
                                            cpp_b.add(cpp1);

                                            JLabel rat_l1=new JLabel("Rating");
                                            rat_l1.setBounds(250,150,120,20);
                                            cpp_b.add(rat_l1);


                                            JTextField rat1=new JTextField();
                                            rat1.setBounds(300,150,120,20);
                                            cpp_b.add(rat1);
                                            rat1.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat1.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat1.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat1.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat1, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            cpp1.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\bk1.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                }
                                            });
                                            JButton cpp2=new JButton("Cpp Book2");
                                            cpp2.setBounds(170, 250, 120, 40);
                                            cpp_b.add(cpp2);

                                            JLabel rat_l2=new JLabel("Rating");
                                            rat_l2.setBounds(250,300,120,20);
                                            cpp_b.add(rat_l2);


                                            JTextField rat2=new JTextField();
                                            rat2.setBounds(300,300,120,20);
                                            cpp_b.add(rat2);
                                            rat2.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat2.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat2.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat2.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat2, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            cpp2.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\cpp buk2.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }





                                                }
                                            });
                                            JButton cpp3=new JButton("Cpp Book3");
                                            cpp3.setBounds(170, 400, 120, 40);
                                            cpp_b.add(cpp3);

                                            JLabel rat_l3=new JLabel("Rating");
                                            rat_l3.setBounds(250,450,120,20);
                                            cpp_b.add(rat_l3);


                                            JTextField rat3=new JTextField();
                                            rat3.setBounds(300,450,120,20);
                                            cpp_b.add(rat3);
                                            rat3.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat3.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat3.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat3.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat3, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            cpp3.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\buk3.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }


                                                }


                                            });



                                            cpp_b.setVisible(true);
                                            JButton submit_btn=new JButton("submit");
                                            submit_btn.setBounds(170, 600, 120, 40);
                                            cpp_b.add(submit_btn);
                                            submit_btn.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {
                                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                                        System.out.println("ok");
                                                        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                                        if (connect != null) {
                                                            System.out.println("connected");

                                                            Statement st = connect.createStatement();
                                                            String sql = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +cpp1.getText()+ "','" +rat1.getText() +"')";
                                                            String sql1 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +cpp2.getText()+ "','" +rat2.getText() +"')";
                                                            String sql3 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +cpp3.getText()+ "','" +rat3.getText() +"')";


                                                            //  PreparedStatement preparedStatement=connect.prepareStatement();

                                                            int x = st.executeUpdate(sql);
                                                            int y = st.executeUpdate(sql1);
                                                            int z= st.executeUpdate(sql3);


                                                            if (x == 0) {
                                                                JOptionPane.showMessageDialog(jb, "this already exists");
                                                            } else {
                                                                JOptionPane.showMessageDialog(jb, "Thank You for using our Application");
                                                            }

                                                            connect.close();



                                                        }
                                                    } catch (Exception ee) {
                                                        System.out.println(ee);

                                                    }

                                                }
                                            });

                                        }


                                    });

                                    JButton bk2 = new JButton("JAVA");
                                    bk2.setBounds(170, 150, 120, 40);
                                    log.add(bk2);

                                    bk2.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            JFrame java_b=new JFrame("JAVA");
                                            java_b.setSize(500,800);
                                            java_b.setLayout(null);
                                            java_b.setLocationRelativeTo(null);
                                            JLabel label = new JLabel("Our most read book Is, Book 2..");
                                            label.setBounds(70,50,500,50);
                                            label.setForeground(Color.green);
                                            label.setFont(new Font("Copperplate Gothic Bold",Font.ROMAN_BASELINE,20));
                                            java_b.add(label);
                                            final Runnable updater = new Runnable() {
                                                @Override
                                                public void run() {
                                                    label.setVisible(!label.isVisible());
                                                }
                                            };
                                            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                                            executorService.scheduleAtFixedRate(new Runnable() {
                                                @Override
                                                public void run() {
                                                    SwingUtilities.invokeLater(updater);
                                                }
                                            }, 1, 1, TimeUnit.SECONDS);
                                            JButton java1=new JButton("JAVA Book1");
                                            java1.setBounds(170, 100, 120, 40);
                                            java_b.add(java1);

                                            JLabel rat_l1=new JLabel("Rating");
                                            rat_l1.setBounds(250,150,120,20);
                                            java_b.add(rat_l1);


                                            JTextField rat1=new JTextField();
                                            rat1.setBounds(300,150,120,20);
                                            java_b.add(rat1);
                                            rat1.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat1.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat1.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat1.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat1, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            java1.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\bk2.pdf");
                                                        Desktop.getDesktop().open(f);

                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });
                                            JButton java2=new JButton("JAVA Book2");
                                            java2.setBounds(170, 250, 120, 40);
                                            java_b.add(java2);

                                            JLabel rat_l2=new JLabel("Rating");
                                            rat_l2.setBounds(250,300,120,20);
                                            java_b.add(rat_l2);


                                            JTextField rat2=new JTextField();
                                            rat2.setBounds(300,300,120,20);
                                            java_b.add(rat2);
                                            rat2.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat2.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat2.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat2.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat2, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });



                                            java2.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\js bk2.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });
                                            JButton java3=new JButton("JAVA Book3");
                                            java3.setBounds(170, 400, 120, 40);
                                            java_b.add(java3);

                                            JLabel rat_l3=new JLabel("Rating");
                                            rat_l3.setBounds(250,450,120,20);
                                            java_b.add(rat_l3);


                                            JTextField rat3=new JTextField();
                                            rat3.setBounds(300,450,120,20);
                                            java_b.add(rat3);
                                            rat3.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat3.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat3.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat3.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat3, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            java3.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\bok4.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });

                                            java_b.setVisible(true);
                                            JButton submit_btn=new JButton("submit");
                                            submit_btn.setBounds(170, 600, 120, 40);
                                            java_b.add(submit_btn);
                                            submit_btn.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {
                                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                                        System.out.println("ok");
                                                        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                                        if (connect != null) {
                                                            System.out.println("connected");

                                                            Statement st = connect.createStatement();
                                                            String sql = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +java1.getText()+ "','" +rat1.getText() +"')";
                                                            String sql1 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +java2.getText()+ "','" +rat2.getText() +"')";
                                                            String sql3 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +java3.getText()+ "','" +rat3.getText() +"')";


                                                            //  PreparedStatement preparedStatement=connect.prepareStatement();

                                                            int x = st.executeUpdate(sql);
                                                            int y = st.executeUpdate(sql1);
                                                            int z= st.executeUpdate(sql3);


                                                            if (x == 0) {
                                                                JOptionPane.showMessageDialog(jb, "this already exists");
                                                            } else {
                                                                JOptionPane.showMessageDialog(jb, "Thank You for using our Application");
                                                            }

                                                            connect.close();



                                                        }
                                                    } catch (Exception ee) {
                                                        System.out.println(ee);

                                                    }

                                                }
                                            });

                                        }
                                    });

                                    JButton bk3 = new JButton("PHP");
                                    bk3.setBounds(170, 200, 120, 40);
                                    log.add(bk3);
                                    bk3.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            JFrame php_b=new JFrame("PHP");
                                            php_b.setSize(500,800);
                                            php_b.setLayout(null);
                                            php_b.setLocationRelativeTo(null);
                                            JLabel label = new JLabel("Our most read book Is, Book 1..");
                                            label.setBounds(70,50,500,50);
                                            label.setForeground(Color.green);
                                            label.setFont(new Font("Copperplate Gothic Bold",Font.ROMAN_BASELINE,20));
                                            php_b.add(label);
                                            final Runnable updater = new Runnable() {
                                                @Override
                                                public void run() {
                                                    label.setVisible(!label.isVisible());
                                                }
                                            };
                                            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                                            executorService.scheduleAtFixedRate(new Runnable() {
                                                @Override
                                                public void run() {
                                                    SwingUtilities.invokeLater(updater);
                                                }
                                            }, 1, 1, TimeUnit.SECONDS);

                                            JButton php1=new JButton("php Book1");
                                            php1.setBounds(170, 100, 120, 40);
                                            php_b.add(php1);

                                            JLabel rat_l1=new JLabel("Rating");
                                            rat_l1.setBounds(250,150,120,20);
                                            php_b.add(rat_l1);


                                            JTextField rat1=new JTextField();
                                            rat1.setBounds(300,150,120,20);
                                            php_b.add(rat1);
                                            rat1.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat1.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat1.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat1.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat1, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            php1.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\bk3.pdf");
                                                        Desktop.getDesktop().open(f);

                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });
                                            JButton php2=new JButton("php Book2");
                                            php2.setBounds(170, 250, 120, 40);
                                            php_b.add(php2);

                                            JLabel rat_l2=new JLabel("Rating");
                                            rat_l2.setBounds(250,300,120,20);
                                            php_b.add(rat_l2);


                                            JTextField rat2=new JTextField();
                                            rat2.setBounds(300,300,120,20);
                                            php_b.add(rat2);
                                            rat2.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat2.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat2.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat2.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat2, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            php2.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\php bk 2.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });
                                            JButton php3=new JButton("php Book3");
                                            php3.setBounds(170, 400, 120, 40);
                                            php_b.add(php3);

                                            JLabel rat_l3=new JLabel("Rating");
                                            rat_l3.setBounds(250,450,120,20);
                                            php_b.add(rat_l3);


                                            JTextField rat3=new JTextField();
                                            rat3.setBounds(300,450,120,20);
                                            php_b.add(rat3);
                                            rat3.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat3.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat3.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat3.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat3, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            php3.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\php bk3.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });

                                            php_b.setVisible(true);
                                            JButton submit_btn=new JButton("submit");
                                            submit_btn.setBounds(170, 600, 120, 40);
                                            php_b.add(submit_btn);
                                            submit_btn.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {
                                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                                        System.out.println("ok");
                                                        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                                        if (connect != null) {
                                                            System.out.println("connected");

                                                            Statement st = connect.createStatement();
                                                            String sql = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +php1.getText()+ "','" +rat1.getText() +"')";
                                                            String sql1 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +php2.getText()+ "','" +rat2.getText() +"')";
                                                            String sql3 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +php3.getText()+ "','" +rat3.getText() +"')";


                                                            //  PreparedStatement preparedStatement=connect.prepareStatement();

                                                            int x = st.executeUpdate(sql);
                                                            int y = st.executeUpdate(sql1);
                                                            int z= st.executeUpdate(sql3);


                                                            if (x == 0) {
                                                                JOptionPane.showMessageDialog(jb, "this already exists");
                                                            } else {
                                                                JOptionPane.showMessageDialog(jb, "Thank You for using our Application");
                                                            }

                                                            connect.close();



                                                        }
                                                    } catch (Exception ee) {
                                                        System.out.println(ee);

                                                    }

                                                }
                                            });

                                        }
                                    });

                                    JButton bk4 = new JButton("HTML");
                                    bk4.setBounds(170, 250, 120, 40);
                                    log.add(bk4);
                                    bk4.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            JFrame html_b=new JFrame("HTML");
                                            html_b.setSize(500,800);
                                            html_b.setLayout(null);
                                            html_b.setLocationRelativeTo(null);
                                            JLabel label = new JLabel("Our most read book Is, Book 3..");
                                            label.setBounds(70,50,500,50);
                                            label.setForeground(Color.green);
                                            label.setFont(new Font("Copperplate Gothic Bold",Font.ROMAN_BASELINE,20));
                                            html_b.add(label);
                                            final Runnable updater = new Runnable() {
                                                @Override
                                                public void run() {
                                                    label.setVisible(!label.isVisible());
                                                }
                                            };
                                            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                                            executorService.scheduleAtFixedRate(new Runnable() {
                                                @Override
                                                public void run() {
                                                    SwingUtilities.invokeLater(updater);
                                                }
                                            }, 1, 1, TimeUnit.SECONDS);
                                            JButton html1=new JButton("HTML Book1");
                                            html1.setBounds(170, 100, 120, 40);
                                            html_b.add(html1);

                                            JLabel rat_l1=new JLabel("Rating");
                                            rat_l1.setBounds(250,150,120,20);
                                            html_b.add(rat_l1);


                                            JTextField rat1=new JTextField();
                                            rat1.setBounds(300,150,120,20);
                                            html_b.add(rat1);
                                            rat1.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat1.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat1.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat1.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat1, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            html1.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\bk4.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });
                                            JButton html2=new JButton("HTML Book2");
                                            html2.setBounds(170, 250, 120, 40);
                                            html_b.add(html2);

                                            JLabel rat_l2=new JLabel("Rating");
                                            rat_l2.setBounds(250,300,120,20);
                                            html_b.add(rat_l2);


                                            JTextField rat2=new JTextField();
                                            rat2.setBounds(300,300,120,20);
                                            html_b.add(rat2);
                                            rat2.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat2.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat2.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat2.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat2, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            html2.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\html bk2.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });
                                            JButton html3=new JButton("HTML Book3");
                                            html3.setBounds(170, 400, 120, 40);
                                            html_b.add(html3);

                                            JLabel rat_l3=new JLabel("Rating");
                                            rat_l3.setBounds(250,450,120,20);
                                            html_b.add(rat_l3);


                                            JTextField rat3=new JTextField();
                                            rat3.setBounds(300,450,120,20);
                                            html_b.add(rat3);
                                            rat3.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat3.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat3.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat3.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat3, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            html3.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\html bk3.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });

                                            html_b.setVisible(true);
                                            JButton submit_btn=new JButton("submit");
                                            submit_btn.setBounds(170, 600, 120, 40);
                                            html_b.add(submit_btn);
                                            submit_btn.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {
                                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                                        System.out.println("ok");
                                                        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                                        if (connect != null) {
                                                            System.out.println("connected");

                                                            Statement st = connect.createStatement();
                                                            String sql = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +html1.getText()+ "','" +rat1.getText() +"')";
                                                            String sql1 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +html2.getText()+ "','" +rat2.getText() +"')";
                                                            String sql3 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +html3.getText()+ "','" +rat3.getText() +"')";


                                                            //  PreparedStatement preparedStatement=connect.prepareStatement();

                                                            int x = st.executeUpdate(sql);
                                                            int y = st.executeUpdate(sql1);
                                                            int z= st.executeUpdate(sql3);


                                                            if (x == 0) {
                                                                JOptionPane.showMessageDialog(jb, "this already exists");
                                                            } else {
                                                                JOptionPane.showMessageDialog(jb, "Thank You for using our Application");
                                                            }

                                                            connect.close();



                                                        }
                                                    } catch (Exception ee) {
                                                        System.out.println(ee);

                                                    }

                                                }
                                            });

                                        }
                                    });

                                    JButton bk5 = new JButton("CSS");
                                    bk5.setBounds(170, 300, 120, 40);
                                    log.add(bk5);
                                    bk5.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            JFrame css_b=new JFrame("CSS");
                                            css_b.setSize(500,800);
                                            css_b.setLayout(null);
                                            css_b.setLocationRelativeTo(null);
                                            JLabel label = new JLabel("Our most read book Is, Book 2..");
                                            label.setBounds(70,50,500,50);
                                            label.setForeground(Color.green);
                                            label.setFont(new Font("Copperplate Gothic Bold",Font.ROMAN_BASELINE,20));
                                            css_b.add(label);
                                            final Runnable updater = new Runnable() {
                                                @Override
                                                public void run() {
                                                    label.setVisible(!label.isVisible());
                                                }
                                            };
                                            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                                            executorService.scheduleAtFixedRate(new Runnable() {
                                                @Override
                                                public void run() {
                                                    SwingUtilities.invokeLater(updater);
                                                }
                                            }, 1, 1, TimeUnit.SECONDS);
                                            JButton css1=new JButton("CSS Book1");
                                            css1.setBounds(170, 100, 120, 40);
                                            css_b.add(css1);

                                            JLabel rat_l1=new JLabel("Rating");
                                            rat_l1.setBounds(250,150,120,20);
                                            css_b.add(rat_l1);


                                            JTextField rat1=new JTextField();
                                            rat1.setBounds(300,150,120,20);
                                            css_b.add(rat1);
                                            rat1.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat1.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat1.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat1.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat1, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            css1.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\bk5.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });
                                            JButton css2=new JButton("CSS Book2");
                                            css2.setBounds(170, 250, 120, 40);
                                            css_b.add(css2);

                                            JLabel rat_l2=new JLabel("Rating");
                                            rat_l2.setBounds(250,300,120,20);
                                            css_b.add(rat_l2);


                                            JTextField rat2=new JTextField();
                                            rat2.setBounds(300,300,120,20);
                                            css_b.add(rat2);
                                            rat2.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat2.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat2.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat2.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat2, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            css2.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\css bk2.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });
                                            JButton css3=new JButton("CSS Book3");
                                            css3.setBounds(170, 400, 120, 40);
                                            css_b.add(css3);

                                            JLabel rat_l3=new JLabel("Rating");
                                            rat_l3.setBounds(250,450,120,20);
                                            css_b.add(rat_l3);


                                            JTextField rat3=new JTextField();
                                            rat3.setBounds(300,450,120,20);
                                            css_b.add(rat3);
                                            rat3.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat3.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat3.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat3.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat3, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            css3.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\css bk3.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });

                                            css_b.setVisible(true);
                                            JButton submit_btn=new JButton("submit");
                                            submit_btn.setBounds(170, 600, 120, 40);
                                            css_b.add(submit_btn);
                                            submit_btn.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {
                                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                                        System.out.println("ok");
                                                        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                                        if (connect != null) {
                                                            System.out.println("connected");

                                                            Statement st = connect.createStatement();
                                                            String sql = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +css1.getText()+ "','" +rat1.getText() +"')";
                                                            String sql1 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +css2.getText()+ "','" +rat2.getText() +"')";
                                                            String sql3 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +css3.getText()+ "','" +rat3.getText() +"')";


                                                            //  PreparedStatement preparedStatement=connect.prepareStatement();

                                                            int x = st.executeUpdate(sql);
                                                            int y = st.executeUpdate(sql1);
                                                            int z= st.executeUpdate(sql3);


                                                            if (x == 0) {
                                                                JOptionPane.showMessageDialog(jb, "this already exists");
                                                            } else {
                                                                JOptionPane.showMessageDialog(jb, "Thank You for using our Application");
                                                            }

                                                            connect.close();



                                                        }
                                                    } catch (Exception ee) {
                                                        System.out.println(ee);

                                                    }

                                                }
                                            });


                                        }
                                    });

                                    JButton bk6 = new JButton("JAVASCRIPT");
                                    bk6.setBounds(170, 350, 120, 40);
                                    log.add(bk6);
                                    bk6.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            JFrame jscp_b=new JFrame("JAVASCRIPT");
                                            jscp_b.setSize(500,800);
                                            jscp_b.setLayout(null);
                                            jscp_b.setLocationRelativeTo(null);
                                            JLabel label = new JLabel("Our most read book Is, Book 1..");
                                            label.setBounds(70,50,500,50);
                                            label.setForeground(Color.green);
                                            label.setFont(new Font("Copperplate Gothic Bold",Font.ROMAN_BASELINE,20));
                                            jscp_b.add(label);
                                            final Runnable updater = new Runnable() {
                                                @Override
                                                public void run() {
                                                    label.setVisible(!label.isVisible());
                                                }
                                            };
                                            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                                            executorService.scheduleAtFixedRate(new Runnable() {
                                                @Override
                                                public void run() {
                                                    SwingUtilities.invokeLater(updater);
                                                }
                                            }, 1, 1, TimeUnit.SECONDS);
                                            JButton jscp1=new JButton("JS Book1");
                                            jscp1.setBounds(170, 100, 120, 40);
                                            jscp_b.add(jscp1);

                                            JLabel rat_l1=new JLabel("Rating");
                                            rat_l1.setBounds(250,150,120,20);
                                            jscp_b.add(rat_l1);


                                            JTextField rat1=new JTextField();
                                            rat1.setBounds(300,150,120,20);
                                            jscp_b.add(rat1);
                                            rat1.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat1.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat1.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat1.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat1, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            jscp1.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\bk6.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });
                                            JButton jscp2=new JButton("JS Book2");
                                            jscp2.setBounds(170, 250, 120, 40);
                                            jscp_b.add(jscp2);

                                            JLabel rat_l2=new JLabel("Rating");
                                            rat_l2.setBounds(250,300,120,20);
                                            jscp_b.add(rat_l2);


                                            JTextField rat2=new JTextField();
                                            rat2.setBounds(300,300,120,20);
                                            jscp_b.add(rat2);
                                            rat2.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat2.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat2.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat2.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat2, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            jscp2.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\bok3.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });
                                            JButton jscp3=new JButton("JS Book3");
                                            jscp3.setBounds(170, 400, 120, 40);
                                            jscp_b.add(jscp3);

                                            JLabel rat_l3=new JLabel("Rating");
                                            rat_l3.setBounds(250,450,120,20);
                                            jscp_b.add(rat_l3);


                                            JTextField rat3=new JTextField();
                                            rat3.setBounds(300,450,120,20);
                                            jscp_b.add(rat3);
                                            rat3.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat3.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat3.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat3.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat3, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            jscp3.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\js bk3.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });

                                            jscp_b.setVisible(true);
                                            JButton submit_btn=new JButton("submit");
                                            submit_btn.setBounds(170, 600, 120, 40);
                                            jscp_b.add(submit_btn);
                                            submit_btn.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {
                                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                                        System.out.println("ok");
                                                        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                                        if (connect != null) {
                                                            System.out.println("connected");

                                                            Statement st = connect.createStatement();
                                                            String sql = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +jscp1.getText()+ "','" +rat1.getText() +"')";
                                                            String sql1 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +jscp2.getText()+ "','" +rat2.getText() +"')";
                                                            String sql3 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +jscp3.getText()+ "','" +rat3.getText() +"')";


                                                            //  PreparedStatement preparedStatement=connect.prepareStatement();

                                                            int x = st.executeUpdate(sql);
                                                            int y = st.executeUpdate(sql1);
                                                            int z= st.executeUpdate(sql3);


                                                            if (x == 0) {
                                                                JOptionPane.showMessageDialog(jb, "this already exists");
                                                            } else {
                                                                JOptionPane.showMessageDialog(jb, "Thank You for using our Application");
                                                            }

                                                            connect.close();



                                                        }
                                                    } catch (Exception ee) {
                                                        System.out.println(ee);

                                                    }

                                                }
                                            });


                                        }
                                    });

                                    JButton bk7 = new JButton("SQL");
                                    bk7.setBounds(170, 400, 120, 40);
                                    log.add(bk7);
                                    bk7.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            JFrame sql_b=new JFrame("SQL");
                                            sql_b.setSize(500,800);
                                            sql_b.setLayout(null);
                                            sql_b.setLocationRelativeTo(null);
                                            JLabel label = new JLabel("Our most read book Is, Book 3..");
                                            label.setBounds(70,50,500,50);
                                            label.setForeground(Color.green);
                                            label.setFont(new Font("Copperplate Gothic Bold",Font.ROMAN_BASELINE,20));
                                            sql_b.add(label);
                                            final Runnable updater = new Runnable() {
                                                @Override
                                                public void run() {
                                                    label.setVisible(!label.isVisible());
                                                }
                                            };
                                            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                                            executorService.scheduleAtFixedRate(new Runnable() {
                                                @Override
                                                public void run() {
                                                    SwingUtilities.invokeLater(updater);
                                                }
                                            }, 1, 1, TimeUnit.SECONDS);
                                            JButton sql1=new JButton("SQL Book1");
                                            sql1.setBounds(170, 100, 120, 40);
                                            sql_b.add(sql1);

                                            JLabel rat_l1=new JLabel("Rating");
                                            rat_l1.setBounds(250,150,120,20);
                                            sql_b.add(rat_l1);


                                            JTextField rat1=new JTextField();
                                            rat1.setBounds(300,150,120,20);
                                            sql_b.add(rat1);
                                            rat1.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat1.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat1.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat1.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat1, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            sql1.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\bk7.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });
                                            JButton sql2=new JButton("SQL Book2");
                                            sql2.setBounds(170, 250, 120, 40);
                                            sql_b.add(sql2);

                                            JLabel rat_l2=new JLabel("Rating");
                                            rat_l2.setBounds(250,300,120,20);
                                            sql_b.add(rat_l2);


                                            JTextField rat2=new JTextField();
                                            rat2.setBounds(300,300,120,20);
                                            sql_b.add(rat2);
                                            rat2.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat2.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat2.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat2.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat2, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            sql2.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\sql bk2.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });
                                            JButton sql3=new JButton("SQL Book3");
                                            sql3.setBounds(170, 400, 120, 40);
                                            sql_b.add(sql3);

                                            JLabel rat_l3=new JLabel("Rating");
                                            rat_l3.setBounds(250,450,120,20);
                                            sql_b.add(rat_l3);


                                            JTextField rat3=new JTextField();
                                            rat3.setBounds(300,450,120,20);
                                            sql_b.add(rat3);
                                            rat3.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat3.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat3.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat3.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat3, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            sql3.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\sql bk3.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });

                                            sql_b.setVisible(true);
                                            JButton submit_btn=new JButton("submit");
                                            submit_btn.setBounds(170, 600, 120, 40);
                                            sql_b.add(submit_btn);
                                            submit_btn.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {
                                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                                        System.out.println("ok");
                                                        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                                        if (connect != null) {
                                                            System.out.println("connected");

                                                            Statement st = connect.createStatement();
                                                            String sql = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +sql1.getText()+ "','" +rat1.getText() +"')";
                                                            String sql1 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +sql2.getText()+ "','" +rat2.getText() +"')";
                                                            String sql4 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +sql3.getText()+ "','" +rat3.getText() +"')";


                                                            //  PreparedStatement preparedStatement=connect.prepareStatement();

                                                            int x = st.executeUpdate(sql);
                                                            int y = st.executeUpdate(sql1);
                                                            int z= st.executeUpdate(sql4);


                                                            if (x == 0) {
                                                                JOptionPane.showMessageDialog(jb, "this already exists");
                                                            } else {
                                                                JOptionPane.showMessageDialog(jb, "Thank You for using our Application");
                                                            }

                                                            connect.close();



                                                        }
                                                    } catch (Exception ee) {
                                                        System.out.println(ee);

                                                    }

                                                }
                                            });

                                        }
                                    });

                                    JButton bk8 = new JButton("C#");
                                    bk8.setBounds(170, 450, 120, 40);
                                    log.add(bk8);
                                    bk8.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            JFrame C_b=new JFrame("C#");
                                            C_b.setSize(500,800);
                                            C_b.setLayout(null);
                                            C_b.setLocationRelativeTo(null);
                                            JLabel label = new JLabel("Our most read book Is, Book 2..");
                                            label.setBounds(70,50,500,50);
                                            label.setForeground(Color.green);
                                            label.setFont(new Font("Copperplate Gothic Bold",Font.ROMAN_BASELINE,20));
                                            C_b.add(label);
                                            final Runnable updater = new Runnable() {
                                                @Override
                                                public void run() {
                                                    label.setVisible(!label.isVisible());
                                                }
                                            };
                                            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                                            executorService.scheduleAtFixedRate(new Runnable() {
                                                @Override
                                                public void run() {
                                                    SwingUtilities.invokeLater(updater);
                                                }
                                            }, 1, 1, TimeUnit.SECONDS);
                                            JButton c1=new JButton("C# Book1");
                                            c1.setBounds(170, 100, 120, 40);
                                            C_b.add(c1);

                                            JLabel rat_l1=new JLabel("Rating");
                                            rat_l1.setBounds(250,150,120,20);
                                            C_b.add(rat_l1);


                                            JTextField rat1=new JTextField();
                                            rat1.setBounds(300,150,120,20);
                                            C_b.add(rat1);
                                            rat1.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat1.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat1.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat1.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat1, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            c1.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\bk8.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });
                                            JButton c2=new JButton("C# Book2");
                                            c2.setBounds(170, 250, 120, 40);
                                            C_b.add(c2);

                                            JLabel rat_l2=new JLabel("Rating");
                                            rat_l2.setBounds(250,300,120,20);
                                            C_b.add(rat_l2);


                                            JTextField rat2=new JTextField();
                                            rat2.setBounds(300,300,120,20);
                                            C_b.add(rat2);
                                            rat2.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat2.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat2.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat2.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat2, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            c2.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\c# bk2.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });
                                            JButton c3=new JButton("C# Book3");
                                            c3.setBounds(170, 400, 120, 40);
                                            C_b.add(c3);

                                            JLabel rat_l3=new JLabel("Rating");
                                            rat_l3.setBounds(250,450,120,20);
                                            C_b.add(rat_l3);


                                            JTextField rat3=new JTextField();
                                            rat3.setBounds(300,450,120,20);
                                            C_b.add(rat3);
                                            rat3.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat3.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat3.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat3.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat3, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            c3.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\c# bk3.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });

                                            C_b.setVisible(true);
                                            JButton submit_btn=new JButton("submit");
                                            submit_btn.setBounds(170, 600, 120, 40);
                                            C_b.add(submit_btn);
                                            submit_btn.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {
                                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                                        System.out.println("ok");
                                                        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                                        if (connect != null) {
                                                            System.out.println("connected");

                                                            Statement st = connect.createStatement();
                                                            String sql = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +c1.getText()+ "','" +rat1.getText() +"')";
                                                            String sql1 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +c2.getText()+ "','" +rat2.getText() +"')";
                                                            String sql3 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +c3.getText()+ "','" +rat3.getText() +"')";


                                                            //  PreparedStatement preparedStatement=connect.prepareStatement();

                                                            int x = st.executeUpdate(sql);
                                                            int y = st.executeUpdate(sql1);
                                                            int z= st.executeUpdate(sql3);


                                                            if (x == 0) {
                                                                JOptionPane.showMessageDialog(jb, "this already exists");
                                                            } else {
                                                                JOptionPane.showMessageDialog(jb, "Thank You for using our Application");
                                                            }

                                                            connect.close();



                                                        }
                                                    } catch (Exception ee) {
                                                        System.out.println(ee);

                                                    }

                                                }
                                            });

                                        }
                                    });

                                    JButton bk9 = new JButton("PYTHON");
                                    bk9.setBounds(170, 500, 120, 40);
                                    log.add(bk9);
                                    bk9.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            JFrame pyt_b=new JFrame("PYTHON");
                                            pyt_b.setSize(500,800);
                                            pyt_b.setLayout(null);
                                            pyt_b.setLocationRelativeTo(null);
                                            JLabel label = new JLabel("Our most read book Is, Book 1..");
                                            label.setBounds(70,50,500,50);
                                            label.setForeground(Color.green);
                                            label.setFont(new Font("Copperplate Gothic Bold",Font.ROMAN_BASELINE,20));
                                            pyt_b.add(label);
                                            final Runnable updater = new Runnable() {
                                                @Override
                                                public void run() {
                                                    label.setVisible(!label.isVisible());
                                                }
                                            };
                                            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                                            executorService.scheduleAtFixedRate(new Runnable() {
                                                @Override
                                                public void run() {
                                                    SwingUtilities.invokeLater(updater);
                                                }
                                            }, 1, 1, TimeUnit.SECONDS);
                                            JButton pyt1=new JButton("PYTHON Book1");
                                            pyt1.setBounds(170, 100, 120, 40);
                                            pyt_b.add(pyt1);

                                            JLabel rat_l1=new JLabel("Rating");
                                            rat_l1.setBounds(250,150,120,20);
                                            pyt_b.add(rat_l1);


                                            JTextField rat1=new JTextField();
                                            rat1.setBounds(300,150,120,20);
                                            pyt_b.add(rat1);
                                            rat1.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat1.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat1.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat1.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat1, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            pyt1.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\bk9.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });
                                            JButton pyt2=new JButton("PYTHON Book2");
                                            pyt2.setBounds(170, 250, 120, 40);
                                            pyt_b.add(pyt2);

                                            JLabel rat_l2=new JLabel("Rating");
                                            rat_l2.setBounds(250,300,120,20);
                                            pyt_b.add(rat_l2);


                                            JTextField rat2=new JTextField();
                                            rat2.setBounds(300,300,120,20);
                                            pyt_b.add(rat2);
                                            rat2.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat2.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat2.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat2.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat2, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            pyt2.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\python bk2.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                }
                                            });
                                            JButton pyt3=new JButton("PYTHON Book3");
                                            pyt3.setBounds(170, 400, 120, 40);
                                            pyt_b.add(pyt3);

                                            JLabel rat_l3=new JLabel("Rating");
                                            rat_l3.setBounds(250,450,120,20);
                                            pyt_b.add(rat_l3);


                                            JTextField rat3=new JTextField();
                                            rat3.setBounds(300,450,120,20);
                                            pyt_b.add(rat3);
                                            rat3.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat3.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat3.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat3.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat3, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            pyt3.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\python bk3.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }


                                                }
                                            });

                                            pyt_b.setVisible(true);
                                            JButton submit_btn=new JButton("submit");
                                            submit_btn.setBounds(170, 600, 120, 40);
                                            pyt_b.add(submit_btn);
                                            submit_btn.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {
                                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                                        System.out.println("ok");
                                                        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                                        if (connect != null) {
                                                            System.out.println("connected");

                                                            Statement st = connect.createStatement();
                                                            String sql = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +pyt1.getText()+ "','" +rat1.getText() +"')";
                                                            String sql1 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +pyt2.getText()+ "','" +rat2.getText() +"')";
                                                            String sql3 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +pyt3.getText()+ "','" +rat3.getText() +"')";


                                                            //  PreparedStatement preparedStatement=connect.prepareStatement();

                                                            int x = st.executeUpdate(sql);
                                                            int y = st.executeUpdate(sql1);
                                                            int z= st.executeUpdate(sql3);


                                                            if (x == 0) {
                                                                JOptionPane.showMessageDialog(jb, "this already exists");
                                                            } else {
                                                                JOptionPane.showMessageDialog(jb, "Thank You for using our Application");
                                                            }

                                                            connect.close();



                                                        }
                                                    } catch (Exception ee) {
                                                        System.out.println(ee);

                                                    }

                                                }
                                            });

                                        }
                                    });

                                    JButton bk10 = new JButton("LARAVEL");
                                    bk10.setBounds(170, 550, 120, 40);
                                    log.add(bk10);
                                    bk10.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            JFrame lara_b=new JFrame("LARAVEL");
                                            lara_b.setSize(500,800);
                                            lara_b.setLayout(null);
                                            lara_b.setLocationRelativeTo(null);
                                            JLabel label = new JLabel("Our most read book Is, Book 1..");
                                            label.setBounds(70,50,500,50);
                                            label.setForeground(Color.green);
                                            label.setFont(new Font("Copperplate Gothic Bold",Font.ROMAN_BASELINE,20));
                                            lara_b.add(label);
                                            final Runnable updater = new Runnable() {
                                                @Override
                                                public void run() {
                                                    label.setVisible(!label.isVisible());
                                                }
                                            };
                                            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                                            executorService.scheduleAtFixedRate(new Runnable() {
                                                @Override
                                                public void run() {
                                                    SwingUtilities.invokeLater(updater);
                                                }
                                            }, 1, 1, TimeUnit.SECONDS);
                                            JButton lara1=new JButton("LAR Book1");
                                            lara1.setBounds(170, 100, 120, 40);
                                            lara_b.add(lara1);

                                            JLabel rat_l1=new JLabel("Rating");
                                            rat_l1.setBounds(250,150,120,20);
                                            lara_b.add(rat_l1);


                                            JTextField rat1=new JTextField();
                                            rat1.setBounds(300,150,120,20);
                                            lara_b.add(rat1);
                                            rat1.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat1.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat1.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat1.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat1, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            lara1.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\bk10.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }


                                                }
                                            });
                                            JButton lara2=new JButton("LAR Book2");
                                            lara2.setBounds(170, 250, 120, 40);
                                            lara_b.add(lara2);

                                            JLabel rat_l2=new JLabel("Rating");
                                            rat_l2.setBounds(250,300,120,20);
                                            lara_b.add(rat_l2);


                                            JTextField rat2=new JTextField();
                                            rat2.setBounds(300,300,120,20);
                                            lara_b.add(rat2);
                                            rat2.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat2.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat2.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat2.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat2, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            lara2.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\laravel bk2.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }


                                                }
                                            });
                                            JButton lara3=new JButton("LAR Book3");
                                            lara3.setBounds(170, 400, 120, 40);
                                            lara_b.add(lara3);
                                            JLabel rat_l3=new JLabel("Rating");
                                            rat_l3.setBounds(250,450,120,20);
                                            lara_b.add(rat_l3);


                                            JTextField rat3=new JTextField();
                                            rat3.setBounds(300,450,120,20);
                                            lara_b.add(rat3);
                                            rat3.addKeyListener(new KeyAdapter() {
                                                public void keyPressed(KeyEvent ke) {
                                                    JLabel msg= new JLabel("");
                                                    msg.setBounds(200,600,100,30);
                                                    frame.getContentPane().add(msg);
                                                    String value = rat3.getText();
                                                    int l = value.length();
                                                    if (ke.getKeyChar() >= '1' && ke.getKeyChar() <= '5') {
                                                        rat3.setEditable(true);
                                                        msg.setText("");
                                                    } else {
                                                        rat3.setEditable(false);
                                                        JOptionPane.showMessageDialog(rat3, "Please Enter Only Numbers From 1-5");
                                                    }
                                                }
                                            });
                                            lara3.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {

                                                        File f = new File("E:\\Project Stuff\\laravel bk2.pdf");
                                                        Desktop.getDesktop().open(f);


                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                }
                                            });

                                            lara_b.setVisible(true);
                                            JButton submit_btn=new JButton("submit");
                                            submit_btn.setBounds(170, 600, 120, 40);
                                            lara_b.add(submit_btn);
                                            submit_btn.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {
                                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                                        System.out.println("ok");
                                                        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_book_reading", "root", "Mysql@12");

                                                        if (connect != null) {
                                                            System.out.println("connected");

                                                            Statement st = connect.createStatement();
                                                            String sql = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +lara1.getText()+ "','" +rat1.getText() +"')";
                                                            String sql1 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +lara2.getText()+ "','" +rat2.getText() +"')";
                                                            String sql3 = "INSERT INTO rating (user,Book,rating1) VALUES( '" + F_user.getText() + "','" +lara3.getText()+ "','" +rat3.getText() +"')";


                                                            //  PreparedStatement preparedStatement=connect.prepareStatement();

                                                            int x = st.executeUpdate(sql);
                                                            int y = st.executeUpdate(sql1);
                                                            int z= st.executeUpdate(sql3);


                                                            if (x == 0) {
                                                                JOptionPane.showMessageDialog(jb, "this already exists");
                                                            } else {
                                                                JOptionPane.showMessageDialog(jb, "Thank You for using our Application");
                                                            }

                                                            connect.close();



                                                        }
                                                    } catch (Exception ee) {
                                                        System.out.println(ee);

                                                    }

                                                }
                                            });

                                        }
                                    });


                                    log.setLayout(null);
                                    log.setLocationRelativeTo(null);
                                    log.setVisible(true);


                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"invalid username and password ");
                                }
//                                int x = st.executeUpdate(sql);
//
//                                if (x == 0) {
//                                    JOptionPane.showMessageDialog(login_but, "this is already exist");
//                                } else {
//                                    JOptionPane.showMessageDialog(login_but, "welcome," + "you are successfully login");
//                                }
                                connect.close();


                            }
                        } catch (Exception ee) {
                            System.out.println(ee);

                        }



                        if (username.equals("")) //If username is null
                        {
                            JOptionPane.showMessageDialog(null, "Please enter username"); //Display dialog box with the message
                        } else if (password.equals("")) //If password is null
                        {
                            JOptionPane.showMessageDialog(null, "Please enter password"); //Display dialog box with the message
                        } else if (!password.equals(F_pass.getText())) {
                            JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "warn", JOptionPane.WARNING_MESSAGE);
                        } else if (!username.equals(F_user.getText())) {
                            JOptionPane.showMessageDialog(null, "incorrect user name )R Password", "warning", JOptionPane.ERROR_MESSAGE);
                        } else {

                        }

                    }
                });
                frame.setVisible(true);

            }
        });


        first_f.setVisible(true);
        first_f.setSize(600,600);




    }
    /////////////////////////////////////////MAIN////////////////////////////////////////////////////////








    public static void main(String[] args) {

        GUI_TASK g = new GUI_TASK();

    }


}
