//实现为管理员提供的用户管理功能
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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class user extends JFrame implements ActionListener {
	JButton jb1,jb2,jb3,jb4 = null;
	JPanel jp1, jp2, jp3, jp4, jp5, jp6 = null;
	JLabel jl1,jl2=null;

	DefaultTableModel model = null;
	JTable table = null;
	JScrollPane jsp = null;
	JTextField jtf1,jtf2 =null;

	public user() {
		jb1 = new JButton("Display");
		jb2=new JButton("Modify Password");
		jb3=new JButton("Add");
		jb4=new JButton("Delect");
		
		
		
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub

				GetSQL.ConnectSQL();

				String sql = "select * from users";

				System.out.println("sql=" + sql);
				GetSQL gs = new GetSQL();
				ResultSet rs = gs.query(sql);
				int rowCount = 0;
				
				try {
					String a="name",b="id",c="password";
					for(int i=0;rs.next();i++){
						String a1=a+i,b1=b+i,c1=c+i;
						a1 = rs.getString(1);
						b1 = rs.getString(2);
						c1 = rs.getString(3);
						
						table.setValueAt(a1, i, 0);
						table.setValueAt(b1, i, 1);
						table.setValueAt(c1, i, 2);
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
				String name=jtf1.getText();
				Modify mo=new Modify(name);
			}
		});
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String jf = new String(jtf1.getText());
				String i=new String(jtf2.getText());

				GetSQL db = new GetSQL();
				db.ConnectSQL();

				if (jf.isEmpty()||i.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter name or id", "Message",
							JOptionPane.WARNING_MESSAGE);
				} else {
					String sql="insert into users "
							+ "(name,id,password) values ('"+jf+"',"+i+",'222')";
					db.insert(sql);
					JOptionPane.showMessageDialog(null, "Add successfully", "Message",
							JOptionPane.WARNING_MESSAGE);
				}
//				dispose();
			}
		});
		
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String jf = new String(jtf1.getText());
				String i=new String(jtf2.getText());

				GetSQL db = new GetSQL();
				db.ConnectSQL();

				if (jf.isEmpty()||i.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter name or id", "Message",
							JOptionPane.WARNING_MESSAGE);
				} else {
					String sql="delete from users where name='"+jf+"' and id="+i+"";
					db.insert(sql);
					JOptionPane.showMessageDialog(null, "Delete successfully", "Message",
							JOptionPane.WARNING_MESSAGE);
				}
				dispose();
			}
		});
		String[] colnames = { "name", "id", "password" };
		model = new DefaultTableModel(colnames, 6);
		table = new JTable(model);
		jsp = new JScrollPane(table);
		
		jtf1=new JTextField(5);
		jtf2=new JTextField(2);
		
		jl1=new JLabel("Name:");
		jl2=new JLabel("Id:");

		jp1 = new JPanel();
		jp2 = new JPanel();

		jp1.add(jb1);
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp1.add(jsp);
		
		jp2.add(jl1);
		jp2.add(jtf1);
		jp2.add(jl2);
		jp2.add(jtf2);
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);

		// this.add(jp1);
		this.add(jp1);
		this.add(jp2);

		this.setLayout(new GridLayout(2, 1));
		this.setTitle("Student Information Management System");
		this.setSize(500, 500);
		this.setLocation(150, 150);
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
