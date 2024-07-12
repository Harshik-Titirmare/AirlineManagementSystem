package airlinemanagementsystems;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener {
    
    
    public Home(){
       
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystems/icons/front.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0 , 1400 , 750);
        add(image);
        
        JLabel heading = new JLabel ("AIR INDIA WELCOME YOU"); 
        heading.setBounds(400, 40, 800, 40);
        image.add(heading);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma" , Font.PLAIN , 50));
        
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem customerDetails = new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        JMenuItem bookFlight = new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        
        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
        JMenuItem ticketCancellation = new JMenuItem("Ticket Cancellation");
        ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);
        
       JMenu ticket = new JMenu("Ticket");
       menubar.add(ticket);
        
        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        boardingPass.addActionListener(this); 
        ticket.add(boardingPass); 
        
        
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
     String text = ae.getActionCommand();
        
        if (text.equals("Add Customer Details")) {
            new AddCustomer();
        } else if (text.equals("Flight Details")) {
            new FlightInfo();
        } else if (text.equals("Book Flight")){
            new BookFlight();
        }else if (text.equals("Journey Details")){
            new JourneyDetails();
        }else if (text.equals("Ticket Cancellation")){
            new Cancel();
        }else if (text.equals("Boarding Pass")){
            new BoardingPass();
        }
        
    }
    
    public static void main(String[] arg){
        new Home();
        
       
    }
}
