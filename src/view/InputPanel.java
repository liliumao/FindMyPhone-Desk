package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputPanel extends JPanel {
	private JButton add = new JButton("add");
	private MainFrame superFrame = null;
	private JLabel phoneNameL = new JLabel("name£º");
	private JLabel phoneIMEIL = new JLabel("IMEI£º");
	private JTextField phoneNameT = new JTextField(10);
	private JTextField phoneIMEIT = new JTextField(10);
	
	public InputPanel(MainFrame mainFrame) {
		this.superFrame = mainFrame;
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.insets = new Insets(0,5,15,8);
		this.add(phoneNameL, gbc1);
		this.add(phoneNameT, gbc1);
		this.add(phoneIMEIL, gbc1);
		this.add(phoneIMEIT, gbc1);
		
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 3;
		gbc2.gridy = 2;
		this.add(add, gbc2);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addNewPhone();
				superFrame.redraw();
			}
		});
	}

	public void addNewPhone() {
		String phoneName = phoneNameT.getText();
		String phoneIMEI = phoneIMEIT.getText();
		if(! (phoneIMEI.equals("") || phoneName.equals(""))){
			superFrame.getNameList().add(phoneName);
			superFrame.getIMEIList().add(phoneIMEI);
			superFrame.redraw();
		}
	}
	
	public void redraw(){
		phoneNameT.setText("                           ");
		phoneIMEIT.setText("                           ");
		this.repaint();
	}
	
}
