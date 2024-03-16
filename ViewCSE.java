//package sheet;
import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.MessageFormat;
import java.awt.SystemColor;
import java.text.*;
import java.awt.print.*;
import java.awt.Toolkit;

 class ViewCSE extends JFrame implements ActionListener
{
	JTable table;
	JLabel head;
	JButton back,download,print;
	JTextPane ta;
	JScrollPane pane;
	String filename,fullname,year,dept;
	String path="D:\\";
	Border border;
	ViewCSE(String year,String dept)
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Result_Summary\\Code\\images\\logo.png"));
		this.year=year;
		this.dept=dept;
		JFrame frame=new JFrame();
		setTitle("Department of Computer Science & Engineering");
		getContentPane().setBackground(new Color(240, 248, 255));
		getContentPane().setLayout(null);
		
		head=new JLabel("Result Summary of Acedemic Year: "+year+", Department: "+dept);
		head.setForeground(new Color(128, 0, 128));
		head.setFont(new Font("Tahoma", Font.BOLD, 27));
		head.setBounds(59,11,1035,60);
		getContentPane().add(head);
		
		
		print =new JButton("Print");
		print.setFont(new Font("Tahoma", Font.BOLD, 19));
		print.setBounds(585,65,133,32);
		print.setBackground(new Color(100, 149, 237));
		print.setForeground(Color.WHITE);
		border=BorderFactory.createLineBorder(Color.black);
		print.setBorder(border);
		getContentPane().add(print);
		print.addActionListener(this);
		print.addMouseListener(new MouseAdapter()
		{
	public void mouseEntered(MouseEvent e)
	{
		print.setForeground(Color.black);
	}
	public void mouseExited(MouseEvent e)
	{
		print.setBackground(new Color(100, 149, 237));
		print.setForeground(Color.white);
	}
		}
		);
		
		
		back =new JButton("Back");
		back.setFont(new Font("Tahoma", Font.BOLD, 19));
		back.setBounds(942,65,128,32);
		back.setBackground(new Color(100, 149, 237));
		back.setForeground(Color.WHITE);
		back.setBorder(border);
		getContentPane().add(back);
		back.addActionListener(this);
		back.addMouseListener(new MouseAdapter()
		{
	public void mouseEntered(MouseEvent e)
	{
		back.setForeground(Color.black);
	}
	public void mouseExited(MouseEvent e)
	{
		back.setBackground(new Color(100, 149, 237));
		back.setForeground(Color.white);
	}
		}
		);
		
		download =new JButton("Download");
		download.setFont(new Font("Tahoma", Font.BOLD, 19));
		download.setBounds(745,65,163,32);
		download.setBackground(new Color(100, 149, 237));
		download.setForeground(Color.WHITE);
		download.setBorder(border);
		getContentPane().add(download);
		download.addActionListener(this);
		download.addMouseListener(new MouseAdapter()
		{
	public void mouseEntered(MouseEvent e)
	{
		download.setForeground(Color.black);
	}
	public void mouseExited(MouseEvent e)
	{
		download.setBackground(new Color(100, 149, 237));
		download.setForeground(Color.white);
	}
		}
		);
		
		
		String col[]= {"Cast","Sem","Stu Add","Stu Add","Stu 1st Atpt","Stu 1st Atpt","Stu Dist","Stu Dist","Stud 1D","Stud 1D","Stu 2D","Stu 2D"};
		
		String  data[][]= {};
		DefaultTableModel model=new DefaultTableModel(data,col);
		
		JPanel panel=new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(38,108,1113,510);
		getContentPane().add(panel);
		table=new JTable(model);
		table.setEnabled(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setBackground(new Color(230, 230, 250));
		
		JTableHeader header=table.getTableHeader();
		header.setBackground(new Color(0, 0, 128));
		header.setForeground(Color.white);
		header.setFont(new Font("Tahoma", Font.BOLD, 15));
	    pane=new JScrollPane(table);
		pane.setPreferredSize(new Dimension(1100,530));
		panel.add(pane);
		model.addRow(new String[]{" "," ","'Girl'","'Boy'","'Girl'","'Boy'","'Girl'","'Boy'","'Girl'","'Boy'","'Girl'","'Boy'"});
	
		try
		{
			ConFile conn=new ConFile();
			String query="select * from general";
			ResultSet rs=conn.s.executeQuery(query);
			while(rs.next())
			{
				model.addRow(new String[] {"General",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)});
			}
			String query1="select * from sc";
			rs=conn.s.executeQuery(query1);
			while(rs.next())
			{
				model.addRow(new String[] {"SC",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)});
			}
			String query2="select * from ST";
			rs=conn.s.executeQuery(query2);
			while(rs.next())
			{
				model.addRow(new String[] {"ST",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)});
			}
			String query3="select * from OBC";
			rs=conn.s.executeQuery(query3);
			while(rs.next())
			{
				model.addRow(new String[] {"OBC",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)});
			}
		}
			
		catch(Exception ex)
		{
			System.out.print(ex);
		}
		setBounds(90,20,1207,699);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==back)
		{
			setVisible(false);	
			new HomePage();
		}
		if(e.getSource()==print)
		{
			try
			{
				MessageFormat h1=new MessageFormat("Result Summary of year: "+year+" Dept: "+dept);
				MessageFormat f1=new MessageFormat("Page End");
				table.print(JTable.PrintMode.FIT_WIDTH,h1,f1);
				
			}
			catch(Exception ex)
			{
				System.out.print(ex);
			}
		}
		
		if(e.getSource()==download)
		{
			filename=JOptionPane.showInputDialog(null,"File name: ");
			fullname=path+filename+".xls";
			System.out.print(filename);
			if(filename==null)
			{
				JOptionPane.showMessageDialog(null,"Enter this information");
				return;
			}
			else
			{
				System.out.print(fullname);
				try
				{
					BufferedWriter a=new BufferedWriter(new FileWriter(fullname));
					a.write("Result Summary of scedemic year: "+year+" Department: "+dept+"\n");
					a.write("Cast"+"\t"+"Sem"+"\t"+"Stu Add"+"\t"+"Stu Add"+"\t"+"Stu 1st Atpt"+"\t"+"Stu 1st Atpt"+"\t"+"Stu Dist"+"\t"+"Stu Dist"+"\t"+"Stud 1D"+"\t"+"Stud 1D"+"\t"+"Stu 2D"+"\t"+"Stu 2D"+"\n");
					a.write(" "+"\t"+" "+"\t"+"Girl"+"\t"+"Boy"+"\t"+"Girl"+"\t"+"Boy"+"\t"+"Girl"+"\t"+"Boy"+"\t"+"Girl"+"\t"+"Boy"+"\t"+"Girl"+"\t"+"Boy"+"\n");
					ConFile conn=new ConFile();
					String query="select * from general";
					
					ResultSet rs=conn.s.executeQuery(query);
					while(rs.next())
					{
						a.write("General"+"\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t"+rs.getString(10)+"\t"+rs.getString(11)+"\n");
					}
					
					String query1="select * from sc";
					rs=conn.s.executeQuery(query1);
					while(rs.next())
					{
						a.write("SC"+"\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t"+rs.getString(10)+"\t"+rs.getString(11)+"\n");
						
					}
					String query2="select * from st";
					rs=conn.s.executeQuery(query2);
					while(rs.next())
					{
						a.write("ST"+"\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t"+rs.getString(10)+"\t"+rs.getString(11)+"\n");
						
					}
					String query3="select * from obc";
					rs=conn.s.executeQuery(query3);
					while(rs.next())
					{
						a.write("OBC"+"\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t"+rs.getString(10)+"\t"+rs.getString(11)+"\n");
					}
					JOptionPane.showMessageDialog(null,"file download");
					a.close();
				}
				catch(Exception ex)
				{
					System.out.print(ex);
				}
				
			}
		}
	}
	public static void main(String[] args) {
	
	}

}
