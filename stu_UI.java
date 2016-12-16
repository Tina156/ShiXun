//学生界面的实现
package GitHub;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class stu_UI extends JFrame implements ActionListener {
	// set controls
	JButton jb1, jb2 = null;
	JPanel jp1, jp2, jp3 = null;
	JLabel jlb1, jlb2 = null;
	JTextField jtf = null;

	public stu_UI(String name) {// never return Void!
		// new controls
		jtf = new JTextField(10);

		jb1 = new JButton("Modify Password");
		jb2 = new JButton("Search");

		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Modify my = new Modify(name);
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
				} else
					JOptionPane.showMessageDialog(null, "Failed");
			}
		});
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();

		jlb1 = new JLabel("Hello!" + "   " + name);
		jlb2 = new JLabel("School Number:");

		jp1.add(jlb1);

		jp2.add(jb1);

		jp3.add(jlb2);
		jp3.add(jtf);
		jp3.add(jb2);

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);

		this.setLayout(new GridLayout(3, 1));
		this.setTitle("Student Information Management System");
		this.setSize(400, 300);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
