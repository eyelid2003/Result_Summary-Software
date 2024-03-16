//package sheet;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class Search extends JFrame implements ActionListener
{
	JLabel sem,head;
	JTextField semester,pdfneme;
	JButton start,pdf,back;
	JTextArea textArea;
	String pdfname,semm;
	Border border;
	Search()
	{
		setTitle("Department of Computer Science & Engineering");
		getContentPane().setBackground(new Color(240, 248, 255));
		getContentPane().setLayout(null);
		
		border=BorderFactory.createLineBorder(Color.black);
		
		head=new JLabel("Show Result of a particular Student");
		head.setBounds(327,0,647,60);
		head.setForeground(new Color(128, 0, 128));
		head.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		getContentPane().add(head);
		
		sem=new JLabel("Enter Roll No. ");
		sem.setBounds(327, 119, 143, 30);
		sem.setFont(new Font("Tahoma", Font.BOLD, 17));
		getContentPane().add(sem); 
		
		semester=new JTextField();
		semester.setBounds(463, 119, 149, 37);
		getContentPane().add(semester);
		
		
		pdf =new JButton("Choose PDF");
		pdf.setBounds(638, 117, 156, 37);
		pdf.setFont(new Font("Tahoma", Font.BOLD, 19));
		pdf.setBackground(Color.BLACK);
		pdf.setForeground(Color.WHITE);
		getContentPane().add(pdf);
		pdf.addActionListener(this);
		
		pdfneme=new JTextField();
		pdfneme.setEditable(false);
		pdfneme.setBounds(825, 119, 149, 37);
		getContentPane().add(pdfneme);
		
		start =new JButton("String Procesing");
		start.setBounds(509, 208, 251, 53);
		start.setFont(new Font("Tahoma", Font.BOLD, 19));
		start.setBackground(new Color(100, 149, 237));
		start.setForeground(Color.WHITE);
		getContentPane().add(start);
		start.addActionListener(this);
		start.setBorder(border);
		start.addMouseListener(new MouseAdapter()
				{
			public void mouseEntered(MouseEvent e)
			{
				start.setForeground(Color.black);
			}
			public void mouseExited(MouseEvent e)
			{
				start.setForeground(Color.white);
			}
				}
				);
		
		
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/logoo.png"));
		Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea.setBackground(new Color(240, 248, 255));
		textArea.setEditable(false);
		textArea.setBounds(420, 319, 535, 431);
		getContentPane().add(textArea);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(10, 0, 302, 750);
		getContentPane().add(panel);
		panel.setLayout(null);
		JLabel image=new JLabel(i3);
		image.setBounds(10, 161, 292, 338);
		panel.add(image);
		
		back =new JButton("Back");
		back.setBounds(61, 626, 188, 53);
		panel.add(back);
		back.setFont(new Font("Tahoma", Font.BOLD, 19));
		back.setBackground(new Color(100, 149, 237));
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		
		back.setBorder(border);
		back.addMouseListener(new MouseAdapter()
				{
			public void mouseEntered(MouseEvent e)
			{
				back.setForeground(Color.black);
			}
			public void mouseExited(MouseEvent e)
			{
				back.setForeground(Color.white);
			}
				}
				);
		
		
		setBounds(60,30,1000,800);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==pdf)
		{
			JFileChooser filechooser=new JFileChooser();
			int response=filechooser.showOpenDialog(null);
			if(response==JFileChooser.APPROVE_OPTION)
			{
				pdfname= filechooser.getSelectedFile().getAbsolutePath();
				pdfneme.setText(pdfname);
				System.out.print(pdfname);		
			}
			
		}
		if(e.getSource()==start)
		{
			semm=semester.getText();
			if(semm=="")
			{
				JOptionPane.showMessageDialog(null,"Chose Enter Code");
				return;
			}
			if(pdfname==null)
			{
				JOptionPane.showMessageDialog(null,"Chose Pdfname");
				return;
			}
			
			else
			{
				JOptionPane.showMessageDialog(null,"Calculation is strting...Please Wait...");
				try
				{
					PDDocument document = PDDocument.load(new File(pdfname));
					document.getClass();
					if (!document.isEncrypted())
					{
						
						PDFTextStripperByArea stripper = new PDFTextStripperByArea();
						stripper.setSortByPosition(true);
						PDFTextStripper Tstripper = new PDFTextStripper();
						String str = Tstripper.getText(document);
						Scanner scn = null;     
						scn = new Scanner(str);
						String line="";
						semm=semester.getText();
						while (scn.hasNextLine()) 
						{  
							line = scn.nextLine();
							if(line.contains(semm))
							{
								int k=0;
								while(k!=20)
								{
									textArea.setText(textArea.getText()+line+"\n\n");
									line = scn.nextLine();
									if(line.contains("PASS") || line.contains("FAIl"))
									{
										textArea.setText(textArea.getText()+line);
										break;	
									}
									k++;
								}
							}
						}
					}
					document.close();
				
				}
				catch(Exception ex)
				{
					System.out.print(ex);
				}
				}
				
			
		}
		if(e.getSource()==back)
		{
			setVisible(false);	
			new ViewCode();
		}
		
	}
		
	public static void main(String args[])
	{
		new Search();
	}
}
