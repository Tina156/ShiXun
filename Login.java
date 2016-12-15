//登陆界面的实现
package GitHub;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.server.UID;
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	JPanel jp1, jp2, jp3, jp4 = null;
	JLabel jlb1, jlb2, jlb3 = null;
	JButton jb1, jb2, jb3 = null;
	JTextField jtf = null;
	JPasswordField jpf = null;
	JRadioButton jrb1, jrb2, jrb3 = null;
	ButtonGroup bg = null;
	protected adm_UI adm_UI;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new Login();
	}


	public Login() {
		// new button
		jb1 = new JButton("Sign in");
		jb2 = new JButton("Recovery");
		jb3 = new JButton("Sign out");

		// set listen
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String name = jtf.getText();
				String ps = new String(jpf.getPassword());

				if (!name.isEmpty() && !ps.isEmpty()) {
					GetSQL.ConnectSQL();
					if (jrb1.isSelected()) {
						int id = 3;
						String sql = "select * from users where id='" + id + "' and name='" + name + "' and password='"
								+ ps + "'";
						System.out.println("sql=" + sql);
						GetSQL gs = new GetSQL();
						ResultSet rs = gs.query(sql);
						try {
							if (rs.next()) {
								JOptionPane.showMessageDialog(null, "Success");
								stu_UI ui = new stu_UI(name);
							} else {
								JOptionPane.showMessageDialog(null, "Failed");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (jrb2.isSelected()) {
						int id = 2;
						String sql = "select * from users where id='" + id + "' and name='" + name + "' and password='"
								+ ps + "'";
						System.out.println("sql=" + sql);
						GetSQL gs = new GetSQL();
						ResultSet rs = gs.query(sql);
						try {
							if (rs.next()) {
								JOptionPane.showMessageDialog(null, "Success");
								tea_UI ui = new tea_UI(name);
							} else {
								JOptionPane.showMessageDialog(null, "Failed");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (jrb3.isSelected()) {
						int id = 1;
						String sql = "select * from users where id='" + id + "' and name='" + name + "' and password='"
								+ ps + "'";
						System.out.println("sql=" + sql);
						GetSQL gs = new GetSQL();
						ResultSet rs = gs.query(sql);
						try {
							if (rs.next()) {
								JOptionPane.showMessageDialog(null, "Success");
								adm_UI = new adm_UI(name);
							} else {
								JOptionPane.showMessageDialog(null, "Failed");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} else if (jtf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Usernaem", "Message",
							JOptionPane.WARNING_MESSAGE);
				} else if (jpf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Password", "Message",
							JOptionPane.WARNING_MESSAGE);
				}
				dispose();
			}
		});
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clear();
			}
		});
		jb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jrb1.isSelected()) {
					String name = jtf.getText();
					String ps = new String(jpf.getPassword());

					GetSQL db = new GetSQL();
					db.ConnectSQL();
					String sql = "select * from users where name='" + name + "'";
					ResultSet rs = db.query(sql);

					try {
						if (name.isEmpty() && ps.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Please Enter Usernaem or password", "Message",
									JOptionPane.WARNING_MESSAGE);
						} else if (rs.next()) {
							JOptionPane.showMessageDialog(null, "User already exists");
						} else {
							int id = 3;
							String sql2 = "insert into users" + "(name,id,password) values ('" + name + "','" + id
									+ "','" + ps + "')";
							db.insert(sql2);
							JOptionPane.showMessageDialog(null, "Registration successful");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "You have not root enter!");
				}
			}
		});

		// finishing controls and layout
		jrb1 = new JRadioButton("Student", true);
		jrb2 = new JRadioButton("Teacher");
		jrb3 = new JRadioButton("Administrator");
		bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		// jrb2.setSelected(true);

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		// new title
		jlb1 = new JLabel("Username:");
		jlb2 = new JLabel("Password");
		jlb3 = new JLabel("Root:");

		jtf = new JTextField(10);
		jpf = new JPasswordField(10);

		// join JPanel
		jp1.add(jlb1);
		jp1.add(jtf);

		jp2.add(jlb2);
		jp2.add(jpf);

		jp3.add(jlb3);
		jp3.add(jrb1);
		jp3.add(jrb2);
		jp3.add(jrb3);

		jp4.add(jb1);
		jp4.add(jb2);
		jp4.add(jb3);

		// join JFrame
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		// set Layout Anagement
		this.setLayout(new GridLayout(4, 1));// Layout is GridLayout;
		// windows title
		this.setTitle("Student Information Management System");
		// set windows size
		this.setSize(400, 200);
		// set initial position
		this.setLocation(200, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// display in relative
		this.setLocationRelativeTo(null);
		// display windows
		this.setVisible(true);
		this.setResizable(true);

		// resizable windows
		this.setResizable(false);
	}

	public void clear() {
		jtf.setText("");
		jpf.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
