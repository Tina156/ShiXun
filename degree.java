//实现对成绩的修改
package GitHub;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class degree extends JFrame implements ActionListener{
	JPanel jp1,jp2,jp3=null;
	JLabel jlb1,jlb2=null;
	JTextField jtf1,jtf2=null;
	JButton jb=null;

	public degree(String non){
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jlb1=new JLabel("Please enter classno:");
		jlb2=new JLabel("Please enter data:");
		
		jtf1=new JTextField(10);
		jtf2=new JTextField(10);
		
		jb=new JButton("OK");
		
		jp1.add(jlb1);
		jp1.add(jtf1);
		
		jp2.add(jlb2);
		jp2.add(jtf2);
		
		jp3.add(jb);
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setLayout(new GridLayout(3, 1));
		
		this.setTitle("Student Information Management System");
		this.setSize(400, 300);
		this.setLocation(200, 200);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
