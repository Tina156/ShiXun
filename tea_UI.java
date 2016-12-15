//教师界面的实现
package GitHub;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class tea_UI extends JFrame implements ActionListener {
	JPanel jp1, jp2, jp3, jp4 = null;
	JLabel jl1 = null;
	JButton jb1, jb2, jb3, jb4 = null;
	JTextField jtf = null;

	public tea_UI(String name) {
		// TODO Auto-generated constructor stub
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jl1 = new JLabel("Hello!" + name);
		jb1 = new JButton("Modify Password");
		jb2 = new JButton("Search");
		jb3 = new JButton("Degree Search");
		jtf = new JTextField(10);

		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Modify mo = new Modify(name);
			}
		});
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String no = jtf.getText();

				if (no.length() > 9) {
					String sql = "select * from student where sno='" + no + "'";
					System.out.println("sql=" + sql);
					GetSQL gs = new GetSQL();
					ResultSet rs = gs.query(sql);
					try {
						if (rs.next()) {
							JOptionPane.showMessageDialog(null, "Success");
							Inquire iq = new Inquire(no);
						} else {
							JOptionPane.showMessageDialog(null, "Failed");
						}
					} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (no.length() > 2) {
					String sql = "select * from teacher where tno='" + no + "'";
					System.out.println("sql=" + sql);
					GetSQL gs = new GetSQL();
					ResultSet rs = gs.query(sql);
					try {
						if (rs.next()) {
							JOptionPane.showMessageDialog(null, "Success");
							Inquire iq = new Inquire(no);
						} else {
							JOptionPane.showMessageDialog(null, "Failed");
						}
					} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else
					JOptionPane.showMessageDialog(null, "Failed");
			}
		});
		jb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		jp1.add(jl1);

		jp2.add(jb1);

		jp3.add(jtf);
		jp3.add(jb2);

		jp4.add(jb3);

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);

		this.setLayout(new GridLayout(6, 1));
		this.setTitle("Student Information Management System");
		this.setSize(400, 300);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
