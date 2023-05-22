package pl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import bl.HadBO;
import dal.Idal;
import dal.HadithDAO;
import to.Hadees;

public class to_Narrator implements ActionListener {

	private JFrame frame;
	private JTextField name;
	private JButton button;
	private JTextArea result;
	public HadBO bo;
	Idal dao= new HadithDAO();
	
	public to_Narrator() throws SQLException {
		
		bo = new HadBO(dao);
		frame = new JFrame("Narrator Check");
		button = new JButton("Search");
		name = new JTextField("");
		result = new JTextArea();

	}

	public void getDetails() {
		name.setBounds(50, 50, 200, 50);
		button.setBounds(50, 100, 100, 50);
		button.addActionListener(this);
		result.setBounds(50, 150, 300, 200);
		frame.add(name);
		frame.add(result);
		frame.add(button);
		frame.setSize(600, 500);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String searchName = name.getText();
		ArrayList<String> names =  new ArrayList<String>();
		names = bo.narrateHadithsToGivenNarrator(searchName);


			result.setText("Name");
			result.append("  ");
			result.append("Father");
			result.append("  ");
			result.append("Mother");
			result.append("  ");
			result.append("CNIC");
			result.append("\r\n");
//
//			result.append(person.getName());
//			result.append("   ");
//			result.append(Integer.toString(person.getFatherCnic()));
//			result.append("     ");
//			result.append(Integer.toString(person.getMotherCnic()));
//			result.append("      ");
//			result.append(Integer.toString(person.getCnic()));
//			result.append("\r\n");


	}
}
