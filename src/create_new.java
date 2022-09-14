package create_new;

import javax.swing.*;

import details.*;
import login.Main;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class create_new extends JFrame implements ActionListener
{
	Container c;
	JLabel label[];
	JTextField text[];
	JLabel l = new JLabel("Enrollment Form");
	
	JComboBox<String> d[] = new JComboBox[100];
	String s[] = new String[100];
	JLabel warn = new JLabel("hi");
	
	JButton button[];
	Connection con;
	Statement stmt;
	ResultSet rs;
	int prevLast;
	
	int k;
	int j;
	
	Font f;
	Font f1;
	
	int b = 0;
	int ci = 0;
	int dt = 0;
	
	public create_new()
	{
		 c = this.getContentPane();
	     c.setLayout(null);
	     c.setBackground(Color.GREEN);
	      
	     f = new Font("Arial" , Font.PLAIN , 30);
	     f1 = new Font("Arial", Font.BOLD , 40);
	     
	     l.setFont(f1);
	     l.setBounds(100 , 50 , 500 , 40);
	     c.add(l);
	     
	     button = new JButton[100];
	     label = new JLabel[100];
	     text = new JTextField[100];
	     
	    label[0] = new JLabel("Faculty id");
		label[4] = new JLabel("Home no.");
		label[6] = new JLabel("City name :");
		label[5] = new JLabel("State :");
		label[1] = new JLabel("Faculty Name:");
		label[2] = new JLabel("Mail ");
		label[3] = new JLabel("Password: ");
		label[7] = new JLabel("department id");
		label[8] = new JLabel("bank account");
		label[9] = new JLabel("Course Id: ");
	    
		text[0] = new JTextField(null);
		text[1] = new JTextField(null);
		text[2] = new JTextField(null);
		text[3] = new JTextField(null);
		text[4] = new JTextField(null);
		text[5] = new JTextField(null);
		text[6] = new JTextField(null);
		
	     try
	     {
	    	c.remove(warn);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyProject" , "root" , "Nihith@8688184950");
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("select dept_id from department;");
			while(rs.next())
			{
				s[dt++] = rs.getString(1);
			}
			d[0] = new JComboBox<String>(s);
			 
			s = new String[100];
			
			rs = stmt.executeQuery("select bank_acc from bank ;");
			while(rs.next())
			{
				s[b++] = Integer.toString(rs.getInt(1)); 
			}
			d[1] = new JComboBox<String>(s);
			
			s = new String[100];
			
			rs = stmt.executeQuery("select course_id from subjects;");
			while(rs.next())
			{
				s[ci++] = rs.getString(1);
			}
			d[2] = new JComboBox<String>(s);

			con.close();
			
	    }
	    catch(SQLException ex)
		{
			String st = ex.toString();
		    warn.setText(st);
		    warn.setFont(f);
		    warn.setBounds(10 , k+200 , 1000 , 30);
		    c.add(warn);
		}	
	     
	     button[3] = new JButton("Other");
	     button[4] = new JButton("Other");
	     button[5] = new JButton("Other");
	     
	     k = 120;
		 for(int i = 0 ; i <= 9 ; i++)
		 {
		   	label[i].setBounds(100 , k , 200 , 30);
		   	label[i].setFont(f);
		   	c.add(label[i]);
		   	
		   	if(i<7)
		   	{
		   		text[i].setBounds(400 , k , 200 , 30);
		   		text[i].setFont(f);
		   		c.add(text[i]);
		   	}
		   	else
		   	{
		   		d[i-7].setBounds(400 , k , 200 , 30);
		   		d[i-7].setFont(f);
		   		c.add(d[i-7]);
		   		
		   		button[i-4].setBounds(700 , k , 200 , 30);
		   		button[i-4].setFont(f);
		   		c.add(button[i-4]);
		   	}
		  	k= k+40;
		 }
		    
	     button[0] = new JButton("Back");
	     button[1] = new JButton("signout");
	     button[2] = new JButton("Submit");
	     
	     button[0].setBounds(10 , 10 , 200 , 30);
	     button[1].setBounds(700 , 10 , 200 , 30);
	     button[2].setBounds(300 , k , 200 , 30);
	     
	     for(int i = 0 ; i <=5 ; i++)
	     {
	    	 button[i].setFont(f);
	    	 button[i].addActionListener(this);
	    	 c.add(button[i]);
	     }
	     
	     label[10] = new JLabel("Department Id");
	     label[11] = new JLabel("Department Name");
	     label[12] = new JLabel("Bank Account");
	     label[13] = new JLabel("Bank Name");
	     label[14] = new JLabel("Salary");
	     label[15] = new JLabel("Course Id");
	     label[16] = new JLabel("Course Name");
	     
	     j = k;
	     
	     label[10].setBounds(10 , j+40 , 200 , 30);
	     label[11].setBounds(10 , j+80 , 200 , 30);
	     label[12].setBounds(10 , j+40 , 200 , 30);
	     label[13].setBounds(10 , j+80 , 200 , 30);
	     label[14].setBounds(10 , j+120 , 200 , 30);
	     label[15].setBounds(10 , j+40 , 200 , 30);
	     label[16].setBounds(10 , j+80 , 200 , 30);
	     
	     text[7] = new JTextField(null);
	     text[8] = new JTextField(null);
	     text[9] = new JTextField(null);
	     text[10] = new JTextField(null);
	     text[11] = new JTextField(null);
	     text[12] = new JTextField(null);
	     text[13] = new JTextField(null);
	     
	     text[7].setBounds(220 , j+40 , 200 , 30);
	     text[8].setBounds(220 , j+80 , 200 , 30);
	     text[9].setBounds(220 , j+40 , 200 , 30);
	     text[10].setBounds(220 , j+80 , 200 , 30);
	     text[11].setBounds(220 , j+120 , 200 , 30);
	     text[12].setBounds(220 , j+40 , 200 , 30);
	     text[13].setBounds(220 , j+80 , 200 , 30);
	     
	     for(int i = 10 ; i <= 16 ; i++)
	     {
	    	 label[i].setVisible(false);
	    	 label[i].setFont(f);
	    	 c.add(label[i]);
	    	 
	    	 text[i - 3].setVisible(false);
	    	 text[i-3].setFont(f);
	    	 c.add(text[i-3]);
	     }
	     
	     button[6] = new JButton("Add");
	     button[7] = new JButton("Add");
	     button[8] = new JButton("Add");
	     
	     for(int i = 6 ; i <= 8 ; i++)
	     {
	    	 button[i].setVisible(false);
	    	 button[i].setBounds(500 , j +80 , 200 , 30);
	    	 button[i].setFont(f);
	    	 button[i].addActionListener(this);
	    	 c.add(button[i]);
	     }
	     
	     

	}
	public void actionPerformed(ActionEvent e)
	{
	   if(e.getSource() == button[0])
	   {
		   details f = new details();
		   f.setVisible(true);
		   f.setTitle("Faculty details");
		   f.setBounds(100 , 100 , 1000 , 600);
		   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   this.dispose();
	   }
	   else if(e.getSource() == button[1])
	   {
		   Main f = new Main();
		   f.setVisible(true);
		   f.setTitle("Successfully logout");
		   f.setBounds(100 , 100 , 1000 , 600);
		   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   this.dispose();
	   }
	   else if(e.getSource() == button[2])
	   {
		   try
		   {
			   c.remove(warn);
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyProject" , "root" , "Nihith@8688184950");
				stmt = con.createStatement();
				if(stmt.executeUpdate("insert into faculty values ( \"" + text[0].getText() + "\",\"" + text[4].getText() + "\", \"" + text[6].getText() + "\",\"" + text[5].getText() + "\", \"" + text[1].getText() + "\" , \""+ text[2].getText() + "\",\""+ text[3].getText() +"\",\"" + d[0].getItemAt(d[0].getSelectedIndex()) + "\" ,\"" + d[1].getItemAt(d[1].getSelectedIndex()) + "\");") == 1)
				{
					if(stmt.executeUpdate("insert into enrolls values ( \"" + text[0].getText() + "\" , \"" + d[2].getItemAt(d[2].getSelectedIndex()) + "\" );") == 1)
					{
						create_new f = new create_new();
						f.setVisible(true);
						f.setTitle("created successfully");
						f.setBounds(100 , 100 , 1000 , 800);
						f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						this.dispose();
					}
				}
				con.close();
				
		   }
		   catch(SQLException ex)
			{
				String st = ex.toString();
		        warn.setText(st);
		        warn.setFont(f);
		        warn.setBounds(10 , j+10 , 1000 , 30);
		        c.add(warn);
			}
	   }
	   else if(e.getSource() == button[3] )
	   {
		   label[10].setVisible(true);
		   label[11].setVisible(true);
		   text[7].setVisible(true);
		   text[8].setVisible(true);
		   button[6].setVisible(true);
	   }
	   else if(e.getSource() == button[4] )
	   {
		   label[12].setVisible(true);
		   label[13].setVisible(true);
		   label[14].setVisible(true);
		   text[9].setVisible(true);
		   text[10].setVisible(true);
		   text[11].setVisible(true);
		   button[7].setVisible(true);
	   }
	   else if(e.getSource() == button[5] )
	   {
		   label[15].setVisible(true);
		   label[16].setVisible(true);
		   text[12].setVisible(true);
		   text[13].setVisible(true);
		   button[8].setVisible(true);
	   }
	   else if(e.getSource() == button[6])
	   {
		   try
		   {
			   c.remove(warn);
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyProject" , "root" , "Nihith@8688184950");
				stmt = con.createStatement();
				if(stmt.executeUpdate("insert into department values ( \"" + text[7].getText() + "\",\"" + text[8].getText() + "\");") == 1)
				{
					label[10].setVisible(false);
					label[11].setVisible(false);
					text[7].setVisible(false);
				    text[8].setVisible(false);
				    button[6].setVisible(false);
				}
				con.close();
				create_new f = new create_new();
				f.setVisible(true);
				f.setTitle("created successfully");
				f.setBounds(100 , 100 , 1000 , 800);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.dispose();
		   }
		   catch(SQLException ex)
			{
				String st = ex.toString();
		        warn.setText(st);
		        warn.setFont(f);
		        warn.setBounds(10 , j+150 , 1000 , 30);
		        c.add(warn);
			}
	   }
	   else if(e.getSource() == button[7])
	   {
		   try
		   {
			   c.remove(warn);
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyProject" , "root" , "Nihith@8688184950");
				stmt = con.createStatement();
				if(stmt.executeUpdate("insert into bank values ( \"" + text[9].getText() + "\",\"" + text[10].getText() + "\",\""+ text[11].getText()+ "\");") == 1)
				{
					label[12].setVisible(false);
					label[13].setVisible(false);
					label[14].setVisible(false);
					text[9].setVisible(false);
				    text[10].setVisible(false);
				    text[11].setVisible(false);
				    button[7].setVisible(false);
				}
				con.close();
				create_new f = new create_new();
				f.setVisible(true);
				f.setTitle("created successfully");
				f.setBounds(100 , 100 , 1000 , 800);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.dispose();
		   }
		   catch(SQLException ex)
			{
				String st = ex.toString();
		        warn.setText(st);
		        warn.setFont(f);
		        warn.setBounds(10 , j+150 , 1000 , 30);
		        c.add(warn);
			}
	   }
	   else if(e.getSource() == button[8])
	   {
		   try
		   {
			   c.remove(warn);
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyProject" , "root" , "Nihith@8688184950");
				stmt = con.createStatement();
				if(stmt.executeUpdate("insert into subjects values ( \"" + text[12].getText() + "\",\"" + text[13].getText() + "\");") == 1)
				{
					label[15].setVisible(false);
					label[16].setVisible(false);
					text[12].setVisible(false);
				    text[13].setVisible(false);
				    button[8].setVisible(false);
				}
				con.close();
				create_new f = new create_new();
				f.setVisible(true);
				f.setTitle("created successfully");
				f.setBounds(100 , 100 , 1000 , 800);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.dispose();
		   }
		   catch(SQLException ex)
			{
				String st = ex.toString();
		        warn.setText(st);
		        warn.setFont(f);
		        warn.setBounds(10 , j+150 , 1000 , 30);
		        c.add(warn);
			}
	   }
	}	
}
