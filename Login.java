package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JLabel text,cardno,pin;
    JTextField cardTextField;
    JPasswordField pinTextField;
    JButton login,clear,signup;

    Login(){
        setTitle("AUTOMATED TELLER MACHINE");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200,40,450,40);
        add(text);

        cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(125,150,375,30);
        add(cardno);

        cardTextField = new JTextField(15);
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(125,220,375,30);
        add(pin);

        pinTextField = new JPasswordField(15);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        pinTextField.setBounds(300,220,230,30);
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);

        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);

        signup = new JButton("SIGN UP");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);

        setLayout(null);

        login.setFont(new Font("Arial", Font.BOLD, 14));
        login.setBounds(300,300,100,30);
        add(login);

        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setBounds(430,300,100,30);
        add(clear);

        signup.setFont(new Font("Arial", Font.BOLD, 14));
        signup.setBounds(300,350,230,30);
        add(signup);

        login.addActionListener(this);
        clear.addActionListener(this);
        signup.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(800,480);
        setLocation(550,200);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){

            if(ae.getSource() == clear){
               cardTextField.setText("");
               pinTextField.setText("");
            }else if(ae.getSource() == login){
                Conn conn = new Conn();
                String cardNumber = cardTextField.getText();
                String pinNumber = pinTextField.getText();
                String query = "SELECT * FROM login WHERE cardnumber = '" + cardNumber + "' AND pin = '" + pinNumber + "'";//we are retrieving data from db until now we were using dml queries

                try{//to handle exception
                   ResultSet rs =  conn.s.executeQuery(query);//its a DDL Command
                    if (rs.next()){//if data is true
                        setVisible(false);
                        new Transactions(pinNumber).setVisible(true);//transactions window will open
                    } else {
                        JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                    }
                } catch (Exception e) {
                    System.out.println(e);;
                }

            }else if(ae.getSource()== signup){
                setVisible(false);
                new SignupOne().setVisible(true);

            }

    }
    public static void main(String[] args){
        new Login().setVisible(true);
    }


}
