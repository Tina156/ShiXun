//实现为管理员提供的学生管理的功能
package GitHub;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InOne extends JFrame implements ActionListener{
	
	JLabel  jl3 = null;
	JButton jb,jb3,jb4 = null;
	JPanel jp1, jp2, jp3, jp4, jp5, jp6 = null;

	DefaultTableModel model = null;
	JTable table = null;
	JScrollPane jsp = null;
	
	public InOne(String no)throws ClassNotFoundException, SQLException{
		// TODO Auto-generated constructor stub
		GetSQL db = new GetSQL();
		GetSQL.ConnectSQL();
		

		jl3 = new JLabel("Student Table:");

		jb = new JButton("Display");
		jb3=new JButton("modify");
		jb4 = new JButton("Delete");

		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
				String sql;

				String sno;
				String sname;
				String ssex;
				String classno;
				String one=no;
				System.out.println(one);

				GetSQL.ConnectSQL();
				sql = "select * from student where sno='"+no+"'";
				

				System.out.println("sql=" + sql);
				GetSQL gs = new GetSQL();
				ResultSet rs = gs.query(sql);
				try {
					if (rs.next()) {
						sno = rs.getString(1);
						sname = rs.getString(2);
						ssex = rs.getString(3);
						classno=rs.getString(4);

						table.setValueAt(sno, 0, 0);
						table.setValueAt(sname, 0, 1);
						table.setValueAt(ssex, 0, 2);
						table.setValueAt(classno, 0, 3);
						
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
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				add ad=new add(no);
			}
		});
		
		jb4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ps = new String(no);

				GetSQL db = new GetSQL();
				db.ConnectSQL();

				if (ps.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter New password", "Message",
							JOptionPane.WARNING_MESSAGE);
				} else {
					String sql = "delete from student where sno='" + no + "'";
					db.insert(sql);
					JOptionPane.showMessageDialog(null, "Modified successfully", "Message",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		// set table A
		String[] colnames = { "sno", "sname", "ssex","classno" };
		model = new DefaultTableModel(colnames, 1);
		table = new JTable(model);
		jsp = new JScrollPane(table);


		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp6 = new JPanel();
		jp5.setLayout(new BorderLayout());
		jp6.setLayout(new BorderLayout());

		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp1.setPreferredSize(new Dimension(20, 20));

		jp1.add(jb);
		jp1.add(jb4);

		jp3.setLayout(new FlowLayout(FlowLayout.LEFT));

		jp2.add(jsp);

		jp5.add(jl3, BorderLayout.SOUTH);


		this.add(jp1);
		this.add(jp5);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);

		this.setLayout(new GridLayout(6, 1));
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
