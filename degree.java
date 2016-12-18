//老师界面-实现对成绩的修改
package GitHub;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class degree extends JFrame implements ActionListener {
	JPanel jp1, jp2, jp3 = null;
	JLabel jlb1, jlb2 = null;
	JTextField jtf1, jtf2 = null;
	JButton jb = null;

	JComboBox cob = null;

	public degree(String non) throws SQLException{
		
		String sql;
		String cno1, cno2, cno3;
		String cname1, cname2, cname3;
		String degree1, degree2, degree3;

		GetSQL.ConnectSQL();
			sql = "select sc.cno,cname from course,sc where course.cno=sc.cno and sno='" + non + "'";

		System.out.println("sql=" + sql);
		GetSQL gs = new GetSQL();
		ResultSet rs = gs.query(sql);
		rs.next();
		cno1 = rs.getString(1);
		cname1 = rs.getString(2);

		rs.next();
		cno2 = rs.getString(1);
		cname2 = rs.getString(2);

		rs.next();
		cno3 = rs.getString(1);
		cname3 = rs.getString(2);

				
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jlb1=new JLabel("Please enter classno:");
		jlb2=new JLabel("Please enter data:");
		
		jtf1=new JTextField(10);
		jtf2=new JTextField(10);
		
		jb=new JButton("OK");
		
		cob=new JComboBox();
		String a=cno1+" "+cname1;
		String b=cno2+" "+cname2;
		String c=cno3+" "+cname3;
		
		cob.addItem(a);
		cob.addItem(b);
		cob.addItem(c);
		
		System.out.println((String)cob.getSelectedItem());
		
		jp1.add(jlb1);
		jp1.add(cob);
		
		jp2.add(jlb2);
		jp2.add(jtf2);
		
		jp3.add(jb);
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String j1 = (String)cob.getSelectedItem();				
				String j2=jtf2.getText();

				GetSQL db = new GetSQL();
				db.ConnectSQL();
				if(j2.isEmpty()){
					JOptionPane.showMessageDialog(null, "Please enter data!", "Message",
							JOptionPane.WARNING_MESSAGE);
				}else{
				String sql = "update sc set degree='" + j2 + "' where sno='"+non+"' and cno='" + j1.substring(0, 3) + "'";
				db.insert(sql);
				JOptionPane.showMessageDialog(null, "Modified successfully", "Message",
						JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		this.setLayout(new GridLayout(3, 1));
		
		this.setTitle("Student Information Management System");
		this.setSize(400, 300);
		this.setLocation(700, 100);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
