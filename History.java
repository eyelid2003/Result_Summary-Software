//package sheet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;

public class History extends JFrame implements ActionListener
{
	JButton back;
	Border border;
	History()
	{
		getContentPane().setForeground(SystemColor.activeCaptionBorder);
		setTitle("Made By Palak Dixit");
		getContentPane().setBackground(new Color(240, 248, 255));
		getContentPane().setLayout(null);
		
		back =new JButton("Back");
		back.setFont(new Font("Tahoma", Font.BOLD, 18));
		back.setBounds(563, 64, 183, 51);
		back.setBackground(new Color(100, 149, 237));
		back.setForeground(Color.white);
		getContentPane().add(back);
		back.addActionListener(this);
		border=BorderFactory.createLineBorder(Color.black);
		back.setBorder(border);
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
		
		
		JLabel lblNewLabel = new JLabel("Team Name--'hindi_madhyam'");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(94, 45, 389, 57);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1) Palak Dixit");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(94, 167, 166, 51);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("2) Indrajeet Mishra");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(94, 248, 213, 51);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("3) Mohit Vishwari");
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(94, 321, 213, 51);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("4) Khemchandra Rawat");
		lblNewLabel_1_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(88, 394, 261, 51);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		JTextArea txtrWork = new JTextArea("Starting date of this Software is 05/04/2023\r\nEnding date of this Sodtware is 09/05/2023\r\nI hope this Software will helpfull for making result summary. :)\r\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ");
		txtrWork.setEditable(false);
		txtrWork.setFont(new Font("Monospaced", Font.BOLD, 23));
		txtrWork.setBackground(new Color(240, 248, 255));
		txtrWork.setBounds(40, 517, 920, 166);
		getContentPane().add(txtrWork);
		
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/logo.png"));
		Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(454,113,398,346);
		getContentPane().add(image);
		
		setBounds(60,30,1000,800);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==back)
		{
			setVisible(false);	
			new HomePage();
		}
	}
	public static void main(String agrs[])
	{
		new History();
	}
}
