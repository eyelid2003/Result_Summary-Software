//package sheet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;

public class SubProcess extends JFrame implements ActionListener
{
	JLabel sem,head;
	JTextField semester,txtname,pdfneme;
	JButton start,pdf,txt,back;
	Border border;
	String filename,pdfname,semm;
	private JLabel lblSelectSome;
	
	SubProcess()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Result_Summary\\Code\\images\\logo.png"));
		setTitle("Department of Computer Science & Engineering");
		getContentPane().setBackground(new Color(240, 248, 255));
		getContentPane().setLayout(null);
		
		sem=new JLabel("Enter Sub Code :");
		sem.setBounds(536, 150, 178, 53);
		sem.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(sem); 
		
		semester=new JTextField();
		semester.setBounds(768, 150, 197, 48);
		getContentPane().add(semester);
		
		
		txt =new JButton("Chose FIle");
		txt.setBounds(530, 270, 197, 53);
		txt.setFont(new Font("Tahoma", Font.BOLD, 19));
		txt.setBackground(Color.BLACK);
		txt.setForeground(Color.WHITE);
		getContentPane().add(txt);
		txt.addActionListener(this);
		
		txtname=new JTextField();
		txtname.setBackground(Color.WHITE);
		txtname.setEditable(false);
		txtname.setBounds(768, 274, 197, 53);
		getContentPane().add(txtname);
		
		pdf =new JButton("Choose PDF");
		pdf.setBounds(530, 393, 197, 53);
		pdf.setFont(new Font("Tahoma", Font.BOLD, 19));
		pdf.setBackground(Color.BLACK);
		pdf.setForeground(Color.WHITE);
		getContentPane().add(pdf);
		pdf.addActionListener(this);
		
		pdfneme=new JTextField();
		pdfneme.setBackground(Color.WHITE);
		pdfneme.setEditable(false);
		pdfneme.setBounds(768, 397, 197, 52);
		getContentPane().add(pdfneme);
		
		start =new JButton("Start Procesing");
		start.setBounds(609, 526, 281, 53);
		start.setFont(new Font("Tahoma", Font.BOLD, 19));
		start.setBackground(new Color(100, 149, 237));
		start.setForeground(Color.white);
		getContentPane().add(start);
		start.addActionListener(this);
		border=BorderFactory.createLineBorder(Color.black);
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(10, 0, 462, 649);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblSelectSome = new JLabel("Select some ");
		lblSelectSome.setForeground(new Color(128, 0, 128));
		lblSelectSome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblSelectSome.setBounds(240, 40, 234, 43);
		panel.add(lblSelectSome);
		JLabel image=new JLabel(i3);
		image.setBounds(40, 152, 341, 367);
		panel.add(image);
		
		back =new JButton("Back");
		back.setBounds(62, 530, 281, 53);
		panel.add(back);
		back.setFont(new Font("Tahoma", Font.BOLD, 19));
		back.setBackground(new Color(100, 149, 237));
		back.setForeground(Color.white);
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
				back.setForeground(Color.white);
			}
				}
				);
		
		head=new JLabel("Information ");
		head.setBounds(471, 42, 269, 43);
		getContentPane().add(head);
		head.setForeground(new Color(128, 0, 128));
		head.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		
		setBounds(150,20,1033,646);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==txt)
		{
			JFileChooser filechooser=new JFileChooser();
			int response=filechooser.showOpenDialog(null);
			if(response==JFileChooser.APPROVE_OPTION)
			{
				filename= filechooser.getSelectedFile().getAbsolutePath();
				txtname.setText(filename);
				System.out.print(filename);		
			}
			
		}
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
			if(filename==null)
			{
				JOptionPane.showMessageDialog(null,"Chose Filename");
				return ;
			}
			if(pdfname==null)
			{
				JOptionPane.showMessageDialog(null,"Chose Pdfname");
				return;
			}
			
			else
			{
				JOptionPane.showMessageDialog(null,"Calculation is strting...Please Wait...");
				setVisible(false);
				if(filename.contains(".txt"))
				{
					new ThirdFile(filename,pdfname,semm);
				}
				if(filename.contains(".xlsx"))
				{
					new Forth(filename,pdfname,semm);
				}
				
			}
			
		}
		if(e.getSource()==back)
		{
			setVisible(false);	
			new HomePage();
		}
		
	}
		
	public static void main(String args[])
	{
		new SubProcess();
	}
}
