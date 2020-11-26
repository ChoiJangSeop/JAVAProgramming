package week12;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


class MyFrame extends JFrame {
	String id = "test";
	String password = "12345678";
	JTextField textField1 = new JTextField(15);
	JTextField textField2 = new JTextField(15);
	
	
	
	MyFrame() {
		
		Dimension dim = new Dimension(300, 150);
		setTitle("Login");
		
		//setSize(800, 1000);
		setPreferredSize(dim);
		pack();
		//setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		JLabel ID = new JLabel("Id");
		JLabel pw = new JLabel("Password    ");
		JButton log = new JButton("login");
		addComponent(gbl, gbc, ID, 0, 0, 1, 1, 0, 0);
		addComponent(gbl, gbc, textField1, 1, 0, 1, 1, 0, 0);
		addComponent(gbl, gbc, pw, 0, 1, 1, 1, 0, 0);
		addComponent(gbl, gbc, textField2, 1, 1, 1, 1, 0, 0);
		addComponent(gbl, gbc, log, 0, 2, 2, 1, 0, 0);
		
		log.addActionListener(new buttonClickListener());
		
		setVisible(true);
	}
	
	
	
	
	void addComponent(GridBagLayout gbl, GridBagConstraints gbc, Component c, int gx, int gy, int gw, int gh, double wx, double wy) {
		gbc.gridx = gx;
		gbc.gridy = gy;
		gbc.gridwidth = gw;
		gbc.gridheight = gh;
		gbc.weightx = wx;
		gbc.weighty = wy;
		gbl.setConstraints(c, gbc);
		add(c);
	}
	
	class buttonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String tempId = textField1.getText();
			String tempPassword = textField2.getText();
			
			if (tempId.equals(id) && tempPassword.contentEquals(password)) {
				JOptionPane.showMessageDialog(null, "Success");
			}
			else {
				JOptionPane.showMessageDialog(null, "Fail");
			}
		}
	}
	

}




public class GUI {
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();	
		
	}
}
