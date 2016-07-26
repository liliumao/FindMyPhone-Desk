package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import utils.IOUtils;

public class StatePanel extends JPanel {
	private JMenuBar bar = new JMenuBar();
	private JMenu cfile = new JMenu("File");
	private JMenuItem save = new JMenuItem("Save");
	private JMenuItem exit = new JMenuItem("Exit");
	private MainFrame superFrame = null;
	
	public StatePanel(MainFrame mainFrame) {
		
		bar.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		this.setLayout(new BorderLayout(0, 0));
		
		cfile.add(save);
		cfile.add(exit);
		bar.add(cfile);
		this.add(bar, BorderLayout.CENTER);
		superFrame = mainFrame;
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        setVisible(false);
		        superFrame.dispose();
		        System.exit(0);
			}
		});
	}
	
	public void save(){
		IOUtils.writeIMEIList(superFrame.getNameList(), superFrame.getIMEIList());
	}
}
