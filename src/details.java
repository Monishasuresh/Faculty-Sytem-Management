package details;

import create_new.*;
import authorize.*;
import faculty_details.*;
import login.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class details extends JFrame implements ActionListener
{
   Container c;
   JButton button[];
   int i = 0;
   Connection con;
   Statement stmt;
   ResultSet rs;
   int prevLast;
   int last;
   int last3;
   
   public details()
   {
      c = this.getContentPane();
      c.setLayout(null);
      c.setBackground(Color.GREEN);
      
      Font f = new Font("Arial" , Font.PLAIN , 30);
     
      button = new JButton[100];
      try
      {
         //Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyProject","root","Nihith@8688184950");
         stmt = con.createStatement();
         rs = stmt.executeQuery("select fac_id from faculty ");
         while(rs.next())
         {
            button[i] = new JButton(rs.getString(1));
            i++;
         }
         last3 = i;
         button[i++] = new JButton("Add new Authorizer");
         prevLast = i;
         button[i++] = new JButton("Add new faculty");
         last = i;
         button[i++] = new JButton("Sign out");
      }
      catch(SQLException ex)
      {
         System.out.println(ex);
      }
      
      int k = 100;
      int j;
      for(j = 0 ; j < i-3 ; j++)
      {
         button[j].setBounds(100 , k , 300 ,  30);
         k = k + 40;
      }
      button[j++].setBounds(600 , 100 , 300 , 30 );
      button[j++].setBounds(600 , 130 , 300 , 30 );
      button[j++].setBounds(600 , 160 , 300 ,30); 
      
      
      for(j = 0 ; j < i ; j++)
      {
         button[j].setFont(f);
      }  
      
      for(j = 0 ; j < i ; j++)
      {
         button[j].addActionListener(this);
      }  
      
      for(j = 0 ; j < i ; j++)
      {
         c.add(button[j]);
      }
   }
   
   public void actionPerformed(ActionEvent e)
   {
	   if(e.getSource() == button[last3])
	   {
		   authorize f = new authorize();
		   f.setVisible(true);
		   f.setTitle("Authorize form");
		   f.setBounds(100 , 100 , 1000 , 600);
		   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   this.dispose();
	   }
	   else if(e.getSource() == button[last])
	   {
		   Main f = new Main();
		   f.setVisible(true);
		   f.setTitle("Successfully logout");
		   f.setBounds(100 , 100 , 1000 , 600);
		   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   this.dispose();
	   }
	   else if (e.getSource() == button[prevLast] )
	   {
		   create_new f = new create_new();
		   f.setVisible(true);
		   f.setTitle("Enrollment form");
		   f.setBounds(100 , 100 , 1000 , 800);
		   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   this.dispose();
	   }
	   else
	   {
		   int l = 0;
		   while(l < i-2)
		   {
			   if(e.getSource() == button[l])
			   {
				   faculty_details f = new faculty_details( button[l].getText() );
				   f.setVisible(true);
				   f.setTitle("Faculty details");
				   f.setBounds(100 , 100 , 1000 , 600);
				   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				   this.dispose();
				   break;
			   }
			   l++;
		   }
	   }
   }
}