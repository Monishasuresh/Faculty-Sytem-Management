package authorize;

import javax.swing.*;
import details.*;
import login.Main;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class authorize extends JFrame implements ActionListener
{
	Container c;
	JLabel label[];
	JTextField text[];
	JButton button[];
	JButton button1[];
	Connection con ,con1;
	Statement stmt , stmt1;
	ResultSet rs , rs1;
	Font f;
	int i = 3;
	int k = 90;
	JTextField t[];
	JLabel warn = new JLabel("Enter mail and password");
	JLabel warn1 = new JLabel("Enter mail and password");
	
	public authorize()
	{
		 c = this.getContentPane();
	     c.setLayout(null);
	     c.setBackground(Color.GREEN);
	      
	     f = new Font("Arial" , Font.PLAIN , 30);
	     Font f1 = new Font("Arial" , Font.BOLD , 30);
	     
	     button = new JButton[100];
	     button1 = new JButton[100];
	     text = new JTextField[100];
	     label = new JLabel[100];
	     
	     label[2] = new JLabel("hi");
	     
	     label[0] = new JLabel("MailId");
	     label[1] = new JLabel("Password");
	     
	     label[0].setFont(f1);
	     label[1].setFont(f1);
	     
	     label[0].setBounds(100 , 50 , 390 , 30);
	     label[1].setBounds(500 , 50 , 300 , 30);
	     
	     button[0] = new JButton("signout");
	     button[1] = new JButton("back");
	     button[2] = new JButton("Insert");
	     
	     button[0].setFont(f1);
	     button[1].setFont(f1);
	     button[2].setFont(f1);
	     
	     button[0].setBounds(700 , 10 , 400 , 30);
	     button[1].setBounds(10 , 10 , 400 , 30);
	     
	     try
	      {
	    	 c.remove(label[2]);
	         //Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyProject","root","Monisha@8688184950");
	         stmt = con.createStatement();
	         rs = stmt.executeQuery("select * from login ");
	         
	         while(rs.next())
	         {
	            label[i] = new JLabel(rs.getString(1));
	            text[i] = new JTextField(rs.getString(2));
	            button[i] = new JButton("Delete");
	            button1[i] = new JButton("Update");
	            
	            label[i].setFont(f);
	            text[i].setFont(f);
	            button[i].setFont(f);
	            button1[i].setFont(f);
	            
	            label[i].setBounds(10 , k , 350 , 30);
	            text[i].setBounds(400 , k , 300 , 30);
	            button[i].setBounds(800 , k , 200 , 30);
	            button1[i].setBounds(1000 , k ,200 , 30);
	            
	            i++;
	            k = k + 40;	            
	         }
	         con.close();
	      }
	      catch(Exception ex)
	      {
	    	  String st = ex.toString();
	         label[2].setText(st);
	         label[2].setFont(f);
	         label[2].setBounds(300 , 100 , 100 , 30);
	         c.add(label[2]);
	      }

	     button[2].setBounds(700 , k ,400 , 30);
	     for(int j = 0 ; j < i ; j++)
	     {
	    	 if(j == 2 )
	    	 {
	    		 continue;
	    	 }
	    	 c.add(label[j]);
	     }
	     
	     for(int j = 3 ; j < i ; j++)
	     {
	    	 c.add(text[j]);
	     }
	     
	     for(int j = 0 ; j < i ; j++)
	     {
	    	 if(j >= 3)
	    	 {
	    		 button1[j].addActionListener(this);
	    	 }
	    	 button[j].addActionListener(this);
	     }
	     
	     
	     for(int j = 0 ; j < i ; j++)
	     {
	    	 c.add(button[j]);
	     }
	     
	     
	     for(int j = 3 ; j < i ; j++)
	     {
	    	 c.add(button1[j]);
	     }
	     t = new JTextField[2];
	     t[0] = new JTextField(null);
	     t[1] = new JTextField(null);
	     t[0].setBounds(10 , k , 300 , 30);
	     t[1].setBounds(400 , k , 300 , 30);
	     
	     t[0].setFont(f);
	     t[1].setFont(f);
	     
	     c.add(t[0]);
	     c.add(t[1]);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == button[1])
		{
		   details f = new details();
		   f.setVisible(true);
		   f.setTitle("Faculty details form");
		   f.setBounds(100 , 100 , 1000 , 600);
		   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   this.dispose();
		}
		else if(e.getSource() == button[0])
		{
		   Main f = new Main();
		   f.setVisible(true);
		   f.setTitle("Successfully logout");
		   f.setBounds(100 , 100 , 1000 , 600);
		   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   this.dispose();
		}
		else if (e.getSource() == button[2])
		{
			String mail = t[0].getText();
			String passw = t[1].getText();
			if((mail != "") && (passw != ""))
			{
				try
			    {
					 c.remove(warn);
			         String query = "insert into login values ( \""+ mail + "\" ,\"" + passw + "\");";
			         //Class.forName("com.mysql.jdbc.Driver");
			         con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyProject","root","Monisha@8688184950");
			         stmt1 = con1.createStatement();
			         if(stmt1.executeUpdate(query) == 1)
			         {
			         authorize f = new authorize();
			         f.setVisible(true);
			         f.setTitle("Successfully inserted");
			         f.setBounds(100 , 100 , 1000 , 600);
			         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			         this.dispose();
			         }
			         con1.close();
			      }
			      catch(Exception ex)
			      {
			    	  String st = ex.toString();
			          warn.setText(st);
			         warn.setFont(f);
			         warn.setBounds(300 , k+40 , 1000 , 30);
			         c.add(warn);
			         t[0].setText(null);
			         t[1].setText(null);
			      }
			}
			else
			{
		        warn1.setFont(f);
		        warn1.setBounds(300 , k+40 , 100 , 30);
		        c.add(warn1);
			}
			
		}
		else
		{
			int l = 3;
			while(e.getSource() != button[l] && l < i )
			{
				l++;
			}
			if(e.getSource() == button[l])
			{
				String st = label[l].getText();
				try
			    {
					 c.remove(warn);
			         String query = "delete from login where mail = \"" + st + "\";";
			         //Class.forName("com.mysql.jdbc.Driver");
			         con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyProject","root","Monisha@8688184950");
			         stmt1 = con1.createStatement();
			         if( stmt1.executeUpdate(query) == 1)
			         {
			         authorize f = new authorize();
			         f.setVisible(true);
			         f.setTitle("Successfully inserted");
			         f.setBounds(100 , 100 , 1000 , 600);
			         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			         this.dispose();
			         }
			         con1.close();
			      }
			      catch(Exception ex)
			      {
			    	  String st1 = ex.toString();
			          warn.setText(st1);
			         warn.setFont(f);
			         warn.setBounds(300 , k +40 , 1000 , 30);
			         c.add(warn);
			      }
			}
			
			l = 3;
			while(e.getSource() != button1[l] && l < i)
			{
				l++;
			}
			if(e.getSource() == button1[l])
			{
				String str = label[l].getText();
				String new_pass = text[l].getText();
				try
			    {
					 c.remove(warn);
			         String query = "update login set password = \"" + new_pass + "\" where mail = \"" + str +  "\";" ;
			         //Class.forName("com.mysql.jdbc.Driver");
			         con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyProject","root","Monisha@8688184950");
			         stmt1 = con1.createStatement();
			         if( stmt1.executeUpdate(query) == 1)
			         {
			         authorize f = new authorize();
			         f.setVisible(true);
			         f.setTitle("Successfully inserted");
			         f.setBounds(100 , 100 , 1000 , 600);
			         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			         this.dispose();
			         }
			         con1.close();
			      }
			      catch(Exception ex)
			      {
			    	  String st = ex.toString();
			          warn.setText(st);
			         warn.setFont(f);
			         warn.setBounds(300 , k+40 , 1000 , 30);
			         c.add(warn);
			      }
			}
			
			
		}
	}
	
}
