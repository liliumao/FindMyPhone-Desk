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

public class PushPanel extends JPanel {
	private JButton push = new JButton("push");
	private MainFrame superFrame = null;
	private JLabel phoneNameL = new JLabel("phone£º");
	private JLabel userNameL = new JLabel("caller£º");
	private JTextField phoneNameT = new JTextField(10);
	private JTextField userNameT = new JTextField(10);
	
	public PushPanel(MainFrame mainFrame) {
		this.superFrame = mainFrame;
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.insets = new Insets(0,5,15,8);
		this.add(phoneNameL, gbc1);
		this.add(phoneNameT, gbc1);
		this.add(userNameL, gbc1);
		this.add(userNameT, gbc1);
		
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 3;
		gbc2.gridy = 2;
		this.add(push, gbc2);
		
		push.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				push();
			}
		});
	}
	
	public void selectName(String name){
		phoneNameT.setText(name);
		this.repaint();
	}

	public void push() {
		superFrame.push(userNameT.getText(), phoneNameT.getText());
	}

	public void redraw() {
		phoneNameT.setText("                           ");
		userNameT.setText("                           ");
		this.repaint();
	}
}
