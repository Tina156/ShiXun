//实现用户的利用学号或者职工号查询信息并在表中显示。

package GitHub;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Inquire extends JFrame implements ActionListener {

	JLabel jl, jl3, jl4 = null;
	JButton jb, jb2 = null;
	JPanel jp1, jp2, jp3, jp4, jp5, jp6 = null;

	DefaultTableModel model, model2 = null;
	JTable table, table2 = null;
	JScrollPane jsp, jsp2 = null;

	public Inquire(String no) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		GetSQL db = new GetSQL();
		GetSQL.ConnectSQL();

		String sql;
		String namex;
		if (no.length() > 9) {
			sql = "select sname from student where sno='" + no + "'";
			namex = "sname";
		} else {
			sql = "select tname from teacher where tno='" + no + "'";
			namex = "tname";
		}

		System.out.println("sql=" + sql);
		ResultSet rs = db.query(sql);
		if (rs.next()) {
			String name = rs.getString(namex);
			System.out.println(name);
			jl = new JLabel("Hello!" + "   " + name);
		}

		jl3 = new JLabel("Class Table:");
		jl4 = new JLabel("Course Table:");

		jb = new JButton("Inquire Class");
		jb2 = new JButton("Inquire Course");

		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
				String classno;
				String classname;
				String dept;

				GetSQL.ConnectSQL();
				String sql = "select classno,classname,sdept from class where classno=(select classno from student where sno='"
						+ no + "')";
				System.out.println("sql=" + sql);
				GetSQL gs = new GetSQL();
				ResultSet rs = gs.query(sql);
				try {
					if (rs.next()) {

						classno = rs.getString(1);
						classname = rs.getString(2);
						dept = rs.getString(3);

						table.setValueAt(classno, 0, 0);
						table.setValueAt(classname, 0, 1);
						table.setValueAt(dept, 0, 2);
					} else {
						JOptionPane.showMessageDialog(null, "Havenot This Studnet!", "Message",
								JOptionPane.WARNING_MESSAGE);
					}
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cno1, cno2, cno3;
				String cname1, cname2, cname3;
				String degree1, degree2, degree3;

				GetSQL.ConnectSQL();
				String sql1 = "select sc.cno,cname,degree from course,sc where course.cno=sc.cno and sno='" + no + "'";
				System.out.println("sql=" + sql1);
				GetSQL gs = new GetSQL();
				ResultSet rs = gs.query(sql1);
				try {
					if (rs.next()) {
						// 将教师的用户名和密码取出
						cno1 = rs.getString(1);
						cname1 = rs.getString(2);
						degree1 = rs.getString(3);

						rs.next();
						cno2 = rs.getString(1);
						cname2 = rs.getString(2);
						degree2 = rs.getString(3);

						rs.next();
						cno3 = rs.getString(1);
						cname3 = rs.getString(2);
						degree3 = rs.getString(3);

						table2.setValueAt(cno1, 0, 0);
						table2.setValueAt(cname1, 0, 1);
						table2.setValueAt(degree1, 0, 2);

						table2.setValueAt(cno2, 1, 0);
						table2.setValueAt(cname2, 1, 1);
						table2.setValueAt(degree2, 1, 2);

						table2.setValueAt(cno3, 2, 0);
						table2.setValueAt(cname3, 2, 1);
						table2.setValueAt(degree3, 2, 2);
					} else {
						JOptionPane.showMessageDialog(null, "Havenot This Student!", "Message", JOptionPane.WARNING_MESSAGE);
					}
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//set table A
		String[] colnames = { "classno", "classname", "dept" };
		model = new DefaultTableModel(colnames, 3);
		table = new JTable(model);
		jsp = new JScrollPane(table);
		//set table B
		String[] col = { "cno", "cname", "degree" };
		model2 = new DefaultTableModel(col, 3);
		table2 = new JTable(model2);
		jsp2 = new JScrollPane(table2);

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp6 = new JPanel();
		jp5.setLayout(new BorderLayout());
		jp6.setLayout(new BorderLayout());

		jp1.add(jl);
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp1.setPreferredSize(new Dimension(20, 20));
		jp1.add(jb);

		jp3.add(jb2);
		jp3.setLayout(new FlowLayout(FlowLayout.LEFT));

		jp2.add(jsp);
		jp4.add(jsp2);

		jp5.add(jl3, BorderLayout.SOUTH);

		jp6.add(jl4, BorderLayout.NORTH);

		this.add(jp1);
		this.add(jp5);
		this.add(jp2);
		this.add(jp3);
		this.add(jp6);
		this.add(jp4);

		this.setLayout(new GridLayout(6, 0));
		this.setTitle("Student Information Management System");
		this.setSize(500, 600);
		this.setLocation(150, 150);
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
