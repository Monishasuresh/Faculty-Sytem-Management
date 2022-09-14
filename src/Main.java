package login;

import details.*;
import java.sql.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class Main extends JFrame implements ActionListener
{
	Container c;
	JLabel c_id = new JLabel("Mail Id");
   JLabel c_pass = new JLabel("Password");
   JButton login = new JButton("Login");
   JTextField cuser_id = new JTextField();
   JPasswordField cpassd = new JPasswordField();
   JLabel warn = new JLabel("Wrong username or Password");
   JLabel clogin_form = new JLabel("BMSCE Faculty Login Form");
   
   Connection con ;
   Statement stmt;
   ResultSet rs;
   
   public Main()
   {
      c = this.getContentPane();
      c.setLayout(null);
      c.setBackground(Color.YELLOW);
      
      clogin_form.setBounds(250 , 20 , 550 , 50);  
          
      c_id.setBounds(200, 140, 200 , 30);
      c_pass.setBounds(200, 180, 200 , 30);
      login.setBounds(420 , 220 , 100 , 25);
      cuser_id.setBounds(420 , 140 , 300 , 30);
      cpassd.setBounds(420 , 180 , 300 , 30);
      
      Font f = new Font("Arial" , Font.PLAIN , 20);
      
      c_id.setFont(f);
      c_pass.setFont(f);
      login.setFont(f);
      cuser_id.setFont(f);
      cpassd.setFont(f);
      
      Font f1 = new Font("Arial" , Font.BOLD , 35);
      clogin_form.setFont(f1);
      
      login.addActionListener(this);
      
      c.add(clogin_form);
      c.add(cuser_id);
      c.add(c_id);
      c.add(c_pass);
      c.add(login);
      c.add(cpassd);
   }
   
   public void actionPerformed(ActionEvent e)
   {
      if(e.getSource() == login)
      {
         String password = cpassd.getText();
         String Id = cuser_id.getText();
         String query = "select * from login where mail = \"" + Id + "\" and password = \""+ password +"\";";
         
         try {
        	 Class.forName("com.mysql.jdbc.Driver");
        	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyProject","root","Nihith@8688184950");
        	 stmt = con.createStatement();
        	 rs = stmt.executeQuery(query);
         
        	 if( rs.next())
        	 {
        		 c.setBackground(Color.ORANGE);
        		 c.remove(warn);
        		 
        		 details f = new details();
        		 f.setVisible(true);
        		 f.setTitle("Successfully Login");
        		 f.setBounds(100 , 100 , 1050 , 600);
        		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		 this.dispose();
        		 con.close();
        	 }
        	 else
        	 {
        		 c.setBackground(Color.RED);
        		 warn.setBounds(100 , 300 , 200 , 30);
        		 c.add(warn);
        		 cuser_id.setText(null);
        		 cpassd.setText(null);
        	 }
        }
        catch(Exception ex)
         {
        	System.out.println(ex);
         }
         
      }
   }
   public static void main(String [] args)
   {	   
      Main f = new Main();
      f.setVisible(true);
      f.setTitle("login form");
      f.setBounds(100 , 100 , 1000 , 600);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
   }
}