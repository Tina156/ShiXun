//实现成绩统计功能

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
	

public class table extends JFrame implements ActionListener{
	JButton  jb1 = null;
	JPanel jp1, jp2= null;
	
	DefaultTableModel model = null;
	JTable table = null;
	JScrollPane jsp = null;
	
	public table()throws ClassNotFoundException, SQLException{
		
		jb1 = new JButton("Display");
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub

				GetSQL.ConnectSQL();

					String sql = "SELECT a.cno,b.cname,avg(a.degree) FROM sc a,course b where a.cno=b.cno group by cno";

				System.out.println("sql=" + sql);
				GetSQL gs = new GetSQL();
				ResultSet rs = gs.query(sql);
				try {
					String a="cno",b="cname",c="AVG-degree";
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
		
		// set table A
		String[] colnames = { "cno", "cname", "avg-degree" };
		model = new DefaultTableModel(colnames, 6);
		table = new JTable(model);
		jsp = new JScrollPane(table);

		jp1 = new JPanel();
		jp2 = new JPanel();


		jp1.add(jb1);
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));

		jp1.add(jsp);

		this.add(jp1);
		this.add(jp1);

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
