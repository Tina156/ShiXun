//管理员界面的实现
package GitHub;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class adm_UI extends JFrame implements ActionListener {
	
	JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6=null;
	JPanel jp1,jp2,jp3,jp4,jp5,jp6=null;
	JButton jb1,jb2,jb3,jb4,jb41,jb5,jb51=null;
	JTextField jtf,jtf2=null;
	
	public adm_UI(String name) {
		// TODO Auto-generated constructor stub
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		jp5=new JPanel();
		jp6=new JPanel();
		
		jlb1 = new JLabel("Hello!	Administrator"+name);
		jlb2 = new JLabel("plesae enter School Number:");
		jlb3 = new JLabel("Degree Statistics ");
		jlb4 = new JLabel("Users Infromation Management:");
		jlb5=new JLabel("Student Infromation Management:");
		jlb6=new JLabel("Course Infromation Management:");
		
		jb1=new JButton("Open");
		jb2=new JButton("Open");
		jb3=new JButton("Open");
		jb4=new JButton("Open");
		jb41=new JButton("Add");
		jb5=new JButton("Open");
		jb51=new JButton("Add");
		
		jtf=new JTextField(10);
		jtf2=new JTextField(10);
		
		jp1.add(jlb1);
		
		jp2.add(jlb2);
		jp2.add(jtf);
		jp2.add(jb1);
		
		jp3.add(jlb3);
		jp3.add(jb2);
		
		jp4.add(jlb4);
		jp4.add(jb3);
		
		jp5.add(jlb5);
		jp5.add(jtf);
		jp5.add(jb4);
		jp5.add(jb41);
		
		jp6.add(jlb6);
		jp6.add(jtf2);
		jp6.add(jb5);
		jp6.add(jb51);
		
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
		this.add(jp6);
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String no=jtf.getText();
				if(no.isEmpty()){
					JOptionPane.showMessageDialog(null, "please enter number!", "Message",
							JOptionPane.WARNING_MESSAGE);
				}else{
					try {
						Inquire in=new Inquire(no);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("aaaaaaaaaa");
				try {
					table tt=new table();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				user us=new user();
			}
		});
		
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					try {
						String non=jtf2.getText();
						InOne io=new InOne(non);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		jb41.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String no=jtf.getText();
				add ad=new add(no);
			}
		});
		
		jb5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					String no=jtf2.getText();
					InTwe it=new InTwe(no);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		jb51.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String no=jtf2.getText();
				add ad=new add(no);
			}
		});
		this.setLayout(new GridLayout(6, 1));
		this.setTitle("Student Information Management System");
		this.setSize(500, 400);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
