package airlinemanagementsystems;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton reset, sumbit , close;
    JPasswordField tfpassword;
    JTextField tfusername;
    
    
    public Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("UserName");
        lblusername.setBounds(20, 20, 100, 20);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(130, 20, 200, 20);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(20, 60, 100, 20);
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(130, 60, 200, 20);
        add(tfpassword);
        
        reset = new JButton("Reset");
        reset.setBounds(40, 120, 120, 20);
        reset.addActionListener(this);
        add(reset);
        
        sumbit = new JButton("Sumbit");
        sumbit.setBounds(190, 120, 120, 20);
        sumbit.addActionListener(this);
        add(sumbit);
        
        close = new JButton("Close");
        close.setBounds(120, 160, 120, 20);
        close.addActionListener(this);
        add(close);
          
       
        
        setSize(400,250);
        setLocation(500,250);
        setVisible(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
     if (ae.getSource() == sumbit){
         String username = tfusername.getText();
         String password = tfpassword.getText();
         
         try{
             Conn c = new Conn();
             String query = "select * from login where username = '"+ username + "' AND password= '"+password + "'";
            ResultSet rs = c.s.executeQuery(query);
             
            if (rs.next()){
                new Home();
                setVisible(false);
            }else {
                JOptionPane.showMessageDialog(null, "Invalid username and password");
                
            }
         }
         catch (Exception e){
             e.printStackTrace();
         }
     }
     else if (ae.getSource() == close){
         setVisible(false);
     }
     else if (ae.getSource() == reset){
         tfpassword.setText("");
         tfusername.setText("");
     }
    }
    
    public static void main(String[] arg){
        new Login();
       
    }
}
