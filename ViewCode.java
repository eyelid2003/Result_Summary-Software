//package sheet;
import java.awt.Color;

import java.io.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.text.*;
import java.awt.print.*;

 class ViewCode extends JFrame implements ActionListener
{
	JTable table;
	JLabel head,fact;
	JButton back,download,print,search;
	String fail,pass,a,b,c,d;
	String path="D:\\";
	String filename,fullname;
	JTextPane ta;
	JScrollPane pane;
	JTableHeader header;
	Border border;
	ViewCode()
	{
		JFrame frame=new JFrame();
		setTitle("Department of Computer Science & Engineering");
		getContentPane().setBackground(new Color(240, 248, 255));
		getContentPane().setLayout(null);
		
		
		border=BorderFactory.createLineBorder(Color.black);
		
		back =new JButton("Back");
		back.setFont(new Font("Tahoma", Font.BOLD, 19));
		back.setBounds(942,65,132,32);
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
		
		
		
		search =new JButton("Search by Roll No.");
		search.setFont(new Font("Tahoma", Font.BOLD, 17));
		search.setBounds(873,11,201,32);
		search.setBackground(new Color(100, 149, 237));
		search.setForeground(Color.WHITE);
		search.setBorder(border);
		//getContentPane().add(search);
		search.addActionListener(this);
		search.addMouseListener(new MouseAdapter()
		{
	public void mouseEntered(MouseEvent e)
	{
		search.setForeground(Color.black);
	}
	public void mouseExited(MouseEvent e)
	{
		search.setBackground(new Color(100, 149, 237));
		search.setForeground(Color.white);
	}
		}
		);
		
		
		
		
		print =new JButton("Print");
		print.setFont(new Font("Tahoma", Font.BOLD, 19));
		print.setBounds(591,65,132,32);
		print.setBackground(new Color(100, 149, 237));
		print.setForeground(Color.WHITE);
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
		
		
		
		download =new JButton("Download");
		download.setFont(new Font("Tahoma", Font.BOLD, 19));
		download.setBounds(758,65,145,32);
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
		
		
		String col[]= {"Paper Code","Roll Number","Name","Cast","Gender","Grade"};
		String col1[]= {"Cast","Sub Code","girl","boy","girl","boy","girl","boy","girl","boy","Both"};
		String  data[][]= {};
		DefaultTableModel model=new DefaultTableModel(data,col);
		
		JPanel panel=new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(48,108,1113,541);
		getContentPane().add(panel);
		table=new JTable(model);
		table.setSurrendersFocusOnKeystroke(true);
		table.setEnabled(false);
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(230, 230, 250));
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		header=table.getTableHeader();
		header.setBackground(new Color(0, 0, 128));
		header.setForeground(Color.white);
		header.setFont(new Font("Tahoma", Font.BOLD, 19));
		pane=new JScrollPane(table);
		pane.setPreferredSize(new Dimension(1100, 530));
		panel.add(pane);
		try
		{
			ConFile conn=new ConFile();
			String query="select * from sub ORDER BY grade ";
			ResultSet rs=conn.s.executeQuery(query);
			while(rs.next())
			{
				model.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3).toLowerCase(),rs.getString(4),rs.getString(5),rs.getString(6)});
			}
			String sql="SELECT COUNT(*) FROM sub where grade='F'";
			rs=conn.s.executeQuery(sql);
			while(rs.next())
			{
				fail=rs.getString(1);
		
			}
			String sql1="SELECT COUNT(*) FROM sub where grade='A';";
			rs=conn.s.executeQuery(sql1);
			while(rs.next())
			{
				a=rs.getString(1);
				
			}
			String sql2="SELECT COUNT(*) FROM sub where grade='B';";
			rs=conn.s.executeQuery(sql2);
			while(rs.next())
			{
				b=rs.getString(1);
				
			}
			String sql3="SELECT COUNT(*) FROM sub where grade='C';";
			rs=conn.s.executeQuery(sql3);
			while(rs.next())
			{
				c=rs.getString(1);
				
			}
			String sql4="SELECT COUNT(*) FROM sub where grade='D';";
			rs=conn.s.executeQuery(sql4);
			while(rs.next())
			{
				d=rs.getString(1);
				
			}
			String sql5="SELECT COUNT(*) FROM sub where grade='A' OR grade='B' OR grade='C' OR grade='D';";
			rs=conn.s.executeQuery(sql5);
			while(rs.next())
			{
				pass=rs.getString(1);
				
			}
			fact=new JLabel("Total Pass: "+pass+", Total Fail: "+fail);
			fact.setForeground(new Color(128, 0, 128));
			fact.setFont(new Font("Tahoma", Font.BOLD, 27));
			fact.setBounds(52,46,427,60);
			getContentPane().add(fact);
			
			head=new JLabel("A grade: "+a+", B grade: "+b+", C grade: "+c+", D grade: "+d);
			head.setForeground(new Color(128, 0, 128));
			head.setFont(new Font("Tahoma", Font.BOLD, 27));
			head.setBounds(52,11,780,43);
			getContentPane().add(head);
			
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
		if(e.getSource()==search)
		{
			setVisible(false);	
			new Search();
		}
		if(e.getSource()==print)
		{
			try
			{
				MessageFormat h1=new MessageFormat("(Grade) A: "+a+", B: "+b+", C: "+c+", D: "+d+", Fail: "+fail);
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
					//FileWriter f2 = new FileWriter(filename);
					BufferedWriter a1=new BufferedWriter(new FileWriter(fullname));
					a1.write("Total Pass: "+pass+", Total Fail: "+fail+"\n");
					a1.write("(Grade) A: "+a+", B: "+b+", C: "+c+", D: "+d+", Fail: "+fail+"\n");
					a1.write("SubCode"+"\t"+"Roll"+"\t"+"Name"+"\t"+"Cast"+"\t"+"Gender"+"\t"+"Grade"+"\n");
					String query="select * from sub ORDER BY grade ";
					ConFile conn=new ConFile();
					ResultSet rs=conn.s.executeQuery(query);
					while(rs.next())
					{
						String subcode=rs.getString(1);
						String roll=rs.getString(2);
						String name=rs.getString(3);
						String cast=rs.getString(4);
						String gender=rs.getString(5);
						String grade=rs.getString(6);
						a1.write(subcode+"\t"+roll+"\t"+name.toLowerCase()+"\t"+cast+"\t"+gender+"\t"+grade+"\n");
						//",rs.getString(2),rs.getString(4),rs.getString(5),rs.getString(6));
					}
					JOptionPane.showMessageDialog(null,"file download");
					a1.close();
				}
				catch(Exception ex)
				{
					System.out.print(ex);
				}
				
			}
		}
	}
	public static void main(String[] args) {
		new ViewCode();
	}

}
