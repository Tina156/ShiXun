//实现用户的密码修改

package GitHub;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class Modify extends JFrame implements ActionListener {
	JPanel jp1, jp2 = null;
	JLabel jl = null;
	JButton jb = null;
	JTextField jtf = null;

	public Modify(String name) {
		// TODO Auto-generated constructor stub
		jb = new JButton("OK");

		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ps = new String(jtf.getText());

				GetSQL db = new GetSQL();
				db.ConnectSQL();

				if (ps.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter New password", "Message",
							JOptionPane.WARNING_MESSAGE);
				} else {
					String sql = "update users set password='" + ps + "' where name='" + name + "'";
					db.insert(sql);
					JOptionPane.showMessageDialog(null, "Modified successfully", "Message",
							JOptionPane.WARNING_MESSAGE);
				}
				dispose();
			}

		});
		jtf = new JTextField(10);
		jl = new JLabel("New Password:");
		jp1 = new JPanel();
		jp2 = new JPanel();

		jp1.add(jl);
		jp1.add(jtf);
		jp2.add(jb);

		this.add(jp1);
		this.add(jp2);
		this.setLayout(new GridLayout(2, 1));

		this.setTitle("Student Information Management System");
		this.setSize(200, 300);
		this.setLocation(200, 200);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
