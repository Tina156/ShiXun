//实现管理员进行对学生或课程信息的修改及添加
package GitHub;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class add extends JFrame implements ActionListener{

	JPanel jp1,jp2,jp3,jp4,jp5=null;
	JTextField jtf1,jtf2,jtf3=null;
	JLabel jl1,jl2,jl3,jl4=null;
	JButton jb=null;
	
	public add(String no){
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		jp5=new JPanel();
		
		
		jl1=new JLabel("sno OR cno:"+no);
		jl2=new JLabel("sname OR cname:");
		jl3=new JLabel("sex OR cterm:");
		jl4=new JLabel("classno OR null:");
		
		jtf1=new JTextField(10);
		jtf2=new JTextField(10);
		jtf3=new JTextField(10);
		
		jb=new JButton("OK");
		
		jp1.add(jl1);
		
		jp2.add(jl2);
		jp2.add(jtf1);
		
		jp3.add(jl3);
		jp3.add(jtf2);
		
		jp4.add(jl4);
		jp4.add(jtf3);
		
		jp5.add(jb);
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
		
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=jtf1.getText();
				String sex=jtf2.getText();
				String classno=jtf3.getText();
				
				GetSQL db = new GetSQL();
				db.ConnectSQL();
				if (name.isEmpty()||sex.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter New password", "Message",
							JOptionPane.WARNING_MESSAGE);
				} else {
					String sql1,sql2;
					String sql = "select sno from student where sno='"+no+"'";
					System.out.println("sql=" + sql);
					GetSQL gs = new GetSQL();
					ResultSet rs = gs.query(sql);
					try {
						if (rs.next()) {
							if(no.length()>9){
								sql1="update student set sname='"+name+"',ssex='"+sex+"',classno='"+classno+"' where sno="+no+"";
							}else{
								sql1="update course set cname='"+name+"',cterm='"+sex+"' where cno="+no+"";
							}
							db.insert(sql1);
							JOptionPane.showMessageDialog(null, "Success");
						} else {
							if(no.length()>9){
								sql2="insert into student "
										+ "(sno,sname,ssex,classno)values ('"+no+"','"+name+"','"+sex+"','"+classno+"')";
							}else{
								sql2="insert into course "
										+ "(cno,cname,cterm)values ('"+no+"','"+name+"','"+sex+"')";
							}
								db.insert(sql2);
						}
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				dispose();
			}
		});
		
		this.setLayout(new GridLayout(5, 1));
		this.setTitle("Student Information Management System");
		this.setSize(470, 450);
		this.setLocation(700, 200);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
