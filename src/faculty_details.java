package faculty_details;

import javax.swing.*;
import details.*;
import login.Main;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class faculty_details extends JFrame implements ActionListener
{
	Container c;
	JLabel faculty[] = new JLabel[10];
	JLabel bank[] = new JLabel[3];
	JLabel department[] = new JLabel[2];
	JLabel subjects[] = new JLabel[2];
	JLabel label[] = new JLabel[20];
	
	JLabel warn = new JLabel("hi");
	
	JTextField fac[] = new JTextField[10];
	JTextField ban[] = new JTextField[3];
	JTextField dep[] = new JTextField[2];
	JTextField sub[] = new JTextField[2];
	JTextField all[] = new JTextField[20];
	
	JButton button[] = new JButton[4];
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	Font f;
	Font f1;
	String str;
	int k;
	
	public faculty_details(String s)
	{
		str = s;
		c = this.getContentPane();
	    c.setLayout(null);
	    c.setBackground(Color.GREEN);
	    
	    button[0] = new JButton("Delete");
	    button[1] = new JButton("signout");
	    button[2] = new JButton("Back");
	    button[3] = new JButton("Update");
	    
	    button[0].setBounds(10 , 50 , 200 , 30);
	    button[1].setBounds(700 , 50 , 200 , 30);
	    button[2].setBounds(10 , 80 , 200 , 30);
	    button[3].setBounds(700 , 80 , 200 , 30);
	    
	    f = new Font("Arial" , Font.BOLD , 30);
	    f1 = new Font("Arial" , Font.PLAIN , 20);
	    
	    for(int i = 0 ; i < 4 ; i++)
	    {
	    	button[i].setFont(f);
	    	button[i].addActionListener(this);
	    	c.add(button[i]);
	    }
	    
	    label[0] = faculty[0] = new JLabel("Faculty id");
	    label[4] = faculty[1] = new JLabel("Home no.");
	    label[6] = faculty[2] = new JLabel("City name :");
	    label[5] = faculty[3] = new JLabel("State :");
	    label[1] = faculty[4] = new JLabel("Faculty Name:");
	    label[2] = faculty[5] = new JLabel("Mail ");
	    label[3] = faculty[6] = new JLabel("Password: ");
	    label[7] = faculty[7] = new JLabel("department id");
	    label[8] = faculty[8] = new JLabel("bank account");
	    
	    bank[0] = new JLabel("Account: ");
	    bank[1] = new JLabel("Bank Name :");
	    bank[2] = new JLabel("Salary : ");
	    
	    department[0] = new JLabel("Department Id:");
	    department[1] = new JLabel("Department Name:");
	    
	    label[9] = subjects[0] = new JLabel("course id :");
	    subjects[1] = new JLabel("course Name:");
	    
	    
	    try 
	    {
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyProject" , "root" , "Nihith@8688184950");
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("select * from faculty where fac_id = \"" + str + "\";");
			
			
			if(rs.next())
			{
				all[0] = fac[0] = new JTextField(rs.getString(1));
				all[4] = fac[1] = new JTextField(rs.getString(2));
				all[6] = fac[2] = new JTextField(rs.getString(3));
				all[5] = fac[3] = new JTextField(rs.getString(4));
				all[1] = fac[4] = new JTextField(rs.getString(5));
				all[2] = fac[5] = new JTextField(rs.getString(6));
				all[3] = fac[6] = new JTextField(rs.getString(7));
				all[7] = fac[7] = new JTextField(rs.getString(8));
				all[8] = fac[8] = new JTextField(Integer.toString(rs.getInt(9)));		
			
			}
			
			rs = stmt.executeQuery("select * from bank where bank_acc = \"" + fac[8].getText() + "\";");
						
			if(rs.next())
			{
				all[16]  = ban[0] = new JTextField(Integer.toString(rs.getInt(1)));
				all[10] = ban[1] = new JTextField(rs.getString(2));
				all[11] = ban[2] = new JTextField(Integer.toString(rs.getInt(3)));		
				label[12] = new JLabel(all[10].getText());
				label[13] = new JLabel(all[11].getText());
			
			}
			
			rs = stmt.executeQuery("select * from department where dept_id = \"" + fac[7].getText() + "\";");
			
			if(rs.next())
			{
				all[12] = dep[0] = new JTextField(rs.getString(1));
				all[13] = dep[1] = new JTextField(rs.getString(2));	
				label[10] = new JLabel(all[13].getText());
			}
			
			rs = stmt.executeQuery("select * from enrolls where fac_id = \"" + str + "\";");
			
			if(rs.next())
			{
				all[14]  = new JTextField(rs.getString(1));
				all[15]  = new JTextField(rs.getString(2));	
			}
			
			rs = stmt.executeQuery("select * from subjects where course_id = \"" + all[15].getText() + "\";");
			
			if(rs.next())
			{
				all[9]  =sub[0] = new JTextField(Integer.toString(rs.getInt(1)));
				all[17]  = sub[1] = new JTextField(rs.getString(2));	
				label[11] = new JLabel(all[17].getText());
			}
			
			con.close();
			
	    }
	    catch(SQLException ex)
	    {
	    	String st = ex.toString();
	        warn.setText(st);
	        warn.setFont(f);
	        warn.setBounds(10 , 10 , 1000 , 30);
	        c.add(warn);
	    }
	    
	    k = 120;
	    for(int i = 0 ; i <= 9 ; i++)
	    {
	    	label[i].setBounds(100 , k , 200 , 30);
	    	label[i].setFont(f1);
	    	c.add(label[i]);
	    	
	    	all[i].setBounds(400 , k , 200 , 30);
	    	all[i].setFont(f1);
	    	c.add(all[i]);
	    	k= k+40;
	    }
	    
	    department[1].setBounds(100 , k , 200 , 30);
	    label[10].setBounds(400 , k , 200 , 30);
	    
	    department[1].setFont(f1);
	    label[10].setFont(f1);
	    
	    subjects[1].setBounds(100 , k + 40 ,200 , 30 );
	    label[11].setBounds(400 , k+40 , 200 , 30);
	    
	    subjects[1].setFont(f1);
	    label[11].setFont(f1);
	    
	    bank[1].setBounds(100 , k + 80 ,200 , 30 );
	    label[12].setBounds(400 , k+80 , 200 , 30);
	    
	    bank[1].setFont(f1);
	    label[12].setFont(f1);
	    
	    bank[2].setBounds(100 , k + 120 ,200 , 30 );
	    label[13].setBounds(400 , k+120 , 200 , 30);
	    
	    bank[2].setFont(f1);
	    label[13].setFont(f1);
	    
	    c.add(department[1]);
	    c.add(label[10]);
	    c.add(subjects[1]);
	    c.add(label[11]);
	    c.add(bank[1]);
	    c.add(label[12]);
	    c.add(bank[2]);
	    c.add(label[13]);
	    
	    
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == button[0])
		{
			try
			{
				c.remove(warn);
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyProject" , "root" , "Nihith@8688184950");
				stmt = con.createStatement();
				if(stmt.executeUpdate("delete from faculty where fac_id = \"" + str + "\";" ) == 1)
				{
					details f = new details();
					f.setVisible(true);
			        f.setTitle("Successfully deleted");
			        f.setBounds(100 , 100 , 1000 , 600);
			        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        this.dispose();
				}
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
			details f = new details();
			f.setVisible(true);
	        f.setTitle("Back to Home page");
	        f.setBounds(100 , 100 , 1000 , 600);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.dispose();
		}
		
		else
		{
			try
			{
				c.remove(warn);
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyProject" , "root" , "Nihith@8688184950");
				stmt = con.createStatement();
				
				if(stmt.executeUpdate("update faculty set fac_id = \"" + all[0].getText() + "\" , home_add = \""+all[4].getText() + "\" , state = \""+ all[6].getText() + "\" , city = \"" + all[5].getText() + "\" , fac_name = \""+ all[1].getText() + "\" , fac_email = \""+ all[2].getText() + "\" , fac_pass = \"" +all[3].getText() + "\" , dept_id = \"" + all[7].getText() +"\",bank_acc = \"" + all[8].getText() + "\" where fac_id = \""+ str + "\";") == 1)
				{
					if(stmt.executeUpdate("update enrolls set course_id = \"" + all[9].getText() + "\" where fac_id = \"" + all[0].getText() + "\";" ) == 1)
					{
						faculty_details f = new faculty_details( all[0].getText() );
						f.setVisible(true);
						f.setTitle("Faculty details");
						f.setBounds(100 , 100 , 1000 , 600);
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
		        warn.setBounds(10 , k+200 , 1000 , 30);
		        c.add(warn);
			}
		}
	}
}
