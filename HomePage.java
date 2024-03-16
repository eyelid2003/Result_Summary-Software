//package sheet;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.event.*;

public class HomePage extends JFrame implements ActionListener
{
	JButton  cal,cal1,sheet,delete,delete1,sheet1;
	Border border;
	private JLabel lblNewLabel;
	HomePage() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Result_Summary\\Code\\images\\logo.png"));
		
		setTitle("Made By-Palak Dixit(2020-23)");
		getContentPane().setBackground(new Color(240, 248, 255));
		getContentPane().setLayout(null);
		
		delete =new JButton("Delete Semester Record");
		delete.setFont(new Font("Tahoma", Font.BOLD, 19));
		delete.setBounds(77,416,302,53);
		delete.setBackground(new Color(100, 149, 237));
		delete.setForeground(Color.white);
		getContentPane().add(delete);
		delete.addActionListener(this);
		border=BorderFactory.createLineBorder(Color.black);
		delete.setBorder(border);
		delete.addMouseListener(new MouseAdapter()
				{
			public void mouseEntered(MouseEvent e)
			{
				delete.setForeground(Color.black);
			}
			public void mouseExited(MouseEvent e)
			{
				delete.setBackground(new Color(100, 149, 237));
				delete.setForeground(Color.white);
			}
				}
				);
		
		delete1 =new JButton("Delete Subject Record");
		delete1.setFont(new Font("Tahoma", Font.BOLD, 19));
		delete1.setBounds(77,526,302,53);
		delete1.setBackground(new Color(100, 149, 237));
		delete1.setForeground(Color.white);
		getContentPane().add(delete1);
		delete1.addActionListener(this);
		border=BorderFactory.createLineBorder(Color.black);
		delete1.setBorder(border);
		delete1.addMouseListener(new MouseAdapter()
				{
			public void mouseEntered(MouseEvent e)
			{
				delete1.setForeground(Color.black);
			}
			public void mouseExited(MouseEvent e)
			{
				delete1.setBackground(new Color(100, 149, 237));
				delete1.setForeground(Color.white);
			}
				}
				);
		
		
		cal =new JButton("Calculate Semester Result");
		cal.setFont(new Font("Tahoma", Font.BOLD, 19));
		cal.setBounds(77,215,302,53);
		cal.setBackground(new Color(100, 149, 237));
		cal.setForeground(Color.white);
		getContentPane().add(cal);
		cal.addActionListener(this);
		border=BorderFactory.createLineBorder(Color.black);
		cal.setBorder(border);
		cal.addMouseListener(new MouseAdapter()
				{
			public void mouseEntered(MouseEvent e)
			{
				cal.setForeground(Color.black);
			}
			public void mouseExited(MouseEvent e)
			{
				cal.setBackground(new Color(100, 149, 237));
				cal.setForeground(Color.white);
			}
				}
				);
		
		
		
		
		cal1 =new JButton("Calculate Subject Result");
		cal1.setFont(new Font("Tahoma", Font.BOLD, 19));
		cal1.setBounds(77,311,302,53);
		cal1.setBackground(new Color(100, 149, 237));
		cal1.setForeground(Color.white);
		getContentPane().add(cal1);
		cal1.addActionListener(this);
		border=BorderFactory.createLineBorder(Color.black);
		cal1.setBorder(border);
		cal1.addMouseListener(new MouseAdapter()
				{
			public void mouseEntered(MouseEvent e)
			{
				cal1.setForeground(Color.black);
			}
			public void mouseExited(MouseEvent e)
			{
				cal1.setBackground(new Color(100, 149, 237));
				cal1.setForeground(Color.white);
			}
				}
				);
		
		
		
	
		sheet =new JButton("View Semester Result Sheet");
		sheet.setFont(new Font("Tahoma", Font.BOLD, 18));
		sheet.setBounds(77,30,302,53);
		sheet.setBackground(new Color(100, 149, 237));
		sheet.setForeground(Color.white);
		getContentPane().add(sheet);
		sheet.addActionListener(this);
		sheet.setBorder(border);
		sheet.addMouseListener(new MouseAdapter()
				{
			public void mouseEntered(MouseEvent e)
			{
				sheet.setForeground(Color.black);
			}
			public void mouseExited(MouseEvent e)
			{
				sheet.setBackground(new Color(100, 149, 237));
				sheet.setForeground(Color.white);
			}
				}
				);
		
		
		
		sheet1 =new JButton("View Subject Result Sheet");
		sheet1.setFont(new Font("Tahoma", Font.BOLD, 19));
		sheet1.setBounds(77,126,302,47);
		sheet1.setBackground(new Color(100, 149, 237));
		sheet1.setForeground(Color.white);
		getContentPane().add(sheet1);
		sheet1.setBorder(border);
		sheet1.addActionListener(this);
		sheet1.addMouseListener(new MouseAdapter()
		{
	public void mouseEntered(MouseEvent e)
	{
		sheet1.setForeground(Color.black);
	}
	public void mouseExited(MouseEvent e)
	{
		sheet1.setBackground(new Color(100, 149, 237));
		sheet1.setForeground(Color.white);
	}
		}
		);
		
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/logoo.png"));
		Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(548,52,410,331);
		getContentPane().add(image);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Result_Summary\\Code\\images\\bg.jpeg"));
		lblNewLabel.setBounds(479, 11, 528, 367);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(479, 376, 528, 229);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextArea txtrPolytechnicCollegeResult = new JTextArea();
		txtrPolytechnicCollegeResult.setFont(new Font("SansSerif", Font.BOLD, 30));
		txtrPolytechnicCollegeResult.setText("Govt. Polytechnic \r\nCollege Nowgong (MP)\r\n\r\nResult Summary Project\r\nfor all branch's");
		txtrPolytechnicCollegeResult.setEditable(false);
		txtrPolytechnicCollegeResult.setBackground(new Color(230, 230, 250));
		txtrPolytechnicCollegeResult.setBounds(69, 11, 365, 209);
		panel.add(txtrPolytechnicCollegeResult);
		
		setBounds(200,20,1033,646);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==cal)
		{
			setVisible(false);	
			new Process();
		}
		if(e.getSource()==cal1)
		{
			setVisible(false);	
			new SubProcess();
		}
		if(e.getSource()==sheet)
		{
			
			String year=JOptionPane.showInputDialog(null,"Enter Year: ");
			String dept=JOptionPane.showInputDialog(null,"Enter Branch: ");
			if(year==null && dept==null)
			{
				JOptionPane.showMessageDialog(null,"Enter this information");
				return;
			}
			else
			{
				setVisible(false);
				new ViewCSE(year,dept);
			}
			
		}
		if(e.getSource()==sheet1)
		{
			setVisible(false);	
			new ViewCode();
		}
		if(e.getSource()==delete)
		{
			int a=JOptionPane.showConfirmDialog(null,"You want to delete record","Select",JOptionPane.YES_NO_OPTION);
			if(a==0)
			{
				int b=JOptionPane.showConfirmDialog(null,"You really want to delete record","Select",JOptionPane.YES_NO_OPTION);
				if(b==0)
				{
					try
					{
						ConFile conn=new ConFile();
						String query1="truncate table general ";
						String query2="truncate table sc ";
						String query3="truncate table st ";
						String query4="truncate table obc ";
						int i1=conn.s.executeUpdate(query1);
						int i2=conn.s.executeUpdate(query2);
						int i3=conn.s.executeUpdate(query3);
						int i4=conn.s.executeUpdate(query4);
						if(i1==0 && i2==0 && i3==0 && i4==0)
						{
							
							JOptionPane.showMessageDialog(null,"record deleted");
						}
						else
						{
		            	JOptionPane.showMessageDialog(null,"Something is wrong");
		            	
		   
						}
					}
					catch(Exception ex)
					{
						System.out.print(ex);
					}
				}
				
			}
			
			
			
		}
		
		if(e.getSource()==delete1)
		{
			int a=JOptionPane.showConfirmDialog(null,"You want to delete record","Select",JOptionPane.YES_NO_OPTION);
			if(a==0)
			{
				int b=JOptionPane.showConfirmDialog(null,"You really want to delete record","Select",JOptionPane.YES_NO_OPTION);
				if(b==0)
				{
					try
					{
						ConFile conn=new ConFile();
						String query1="truncate table sub ";
						
						int i1=conn.s.executeUpdate(query1);
						
						if(i1==0)
						{
							
							JOptionPane.showMessageDialog(null,"record deleted");
						}
						else
						{
		            	JOptionPane.showMessageDialog(null,"Something is wrong");
		            	
		   
						}
					}
					catch(Exception ex)
					{
						System.out.print(ex);
					}
				}
				
			}
			
			
			
		}
		
		
	}
	public static void main(String[] args) 
	{
		new HomePage();
	}
}
