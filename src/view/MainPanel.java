package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	private InputPanel input;
	private PushPanel push;
	private MainFrame superFrame = null;
	
	public MainPanel(MainFrame mainFrame){
		this.superFrame = mainFrame;
		
		input = new InputPanel(mainFrame);
		push = new PushPanel(mainFrame);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.insets = new Insets(-20,0,100,0);
		this.add(input, gbc1);
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 0;
		gbc2.gridy = 1;
		this.add(push, gbc2);
	}
	
	public void selectName(String name){
		push.selectName(name);
	}

	public void redraw() {
		input.redraw();
		push.redraw();
		this.repaint();
	}

}
