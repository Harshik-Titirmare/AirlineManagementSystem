package airlinemanagementsystems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener{
     
    JTable aadhartable, pnrtable1;
    JTextField pnr,tfaadhar;
    JButton btnAadhar,btnPnr;
    
    public JourneyDetails() {
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(50, 50, 100, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(160, 50, 120, 25);
        add(tfaadhar);
        
        btnAadhar = new JButton("Show Details");
        btnAadhar.setBackground(Color.BLACK);
        btnAadhar.setForeground(Color.WHITE);
        btnAadhar.setBounds(290, 50, 120, 25);
        btnAadhar.addActionListener(this);
        add(btnAadhar);
        
        aadhartable = new JTable();
        
        JScrollPane jsps = new JScrollPane(aadhartable);
        jsps.setBounds(0, 100, 800, 150);
        jsps.setBackground(Color.WHITE);
        add(jsps);
        
        
        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setBounds(50, 260, 100, 25);
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpnr);
        
        pnr = new JTextField();
        pnr.setBounds(160, 260, 120, 25);
        add(pnr);
        
        btnPnr = new JButton("Show Details");
        btnPnr.setBackground(Color.BLACK);
        btnPnr.setForeground(Color.WHITE);
        btnPnr.setBounds(290, 260, 120, 25);
        btnPnr.addActionListener(this);
        add(btnPnr);
        
        pnrtable1 = new JTable();
        
        JScrollPane jsp = new JScrollPane(pnrtable1);
        jsp.setBounds(0, 300, 800, 150);
        jsp.setBackground(Color.WHITE);
        add(jsp);
        
        setSize(815, 500);
        setLocation(350, 150);
        setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()== btnAadhar){
            try {
                Conn conn = new Conn();

                ResultSet query = conn.s.executeQuery("select * from reservation where aadhar = '"+ tfaadhar.getText()+"'");

                if(!query.isBeforeFirst()){
                    JOptionPane.showMessageDialog(null, "No Information Found");
                    
                } else {
                 aadhartable.setModel(DbUtils.resultSetToTableModel(query));
            }

            } catch(HeadlessException | SQLException e) {
                e.getStackTrace();
            }
        
       } 
        else if (ae.getSource()== btnPnr){
        
            try {
               Conn conn = new Conn();

               ResultSet rs = conn.s.executeQuery("select * from reservation where PNR = '"+ pnr.getText()+"'");

               if(!rs.isBeforeFirst()){
                   JOptionPane.showMessageDialog(null, "No Information Found");
                   
               }
               else
               {
                pnrtable1.setModel(DbUtils.resultSetToTableModel(rs));
               }

           } 
           catch(HeadlessException | SQLException e) 
           {
               e.getStackTrace();
           }

       }
             
    }

    public static void main(String[] args) {
        new JourneyDetails();
        
    }
   
}