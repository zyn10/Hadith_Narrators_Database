package pl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

import bl.HadBO;
import bl.IBLL;
import dal.HadithDAO;
import dal.Idal;

public class Had_View implements ActionListener {

	public static IBLL bo;
	private JFrame frame;
	private JButton toNarrator;
	private JButton fromNarrator;

	public Had_View() throws SQLException {
		
		frame = new JFrame("Hadith Vew");
		toNarrator = new JButton("toNarrator");
		fromNarrator = new JButton("forNarrator");
	}

	public void whichButton() {
		fromNarrator.setBounds(50, 150, 100, 50);
		fromNarrator.addActionListener(this);
		toNarrator.setBounds(150, 150, 100, 50);
		toNarrator.addActionListener(this);
		frame.add(toNarrator);
		frame.add(fromNarrator);
		frame.setSize(400, 500);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == fromNarrator) {
			frame.dispose();
			try {
				to_Narrator frame2=new to_Narrator();
				frame2.getDetails();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

//		if (e.getSource() == toNarrator) {
//		
//			frame.dispose();
//			try {
//				fromNarrator frame2=new HalfSiblings();
//				frame2.viewSibling();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}

	}
	public static void main(String[] args) throws SQLException {
		Had_View app;
		Idal dao = new HadithDAO();
		try {
			bo = new HadBO(dao);
			app = new Had_View();
			app.whichButton();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
