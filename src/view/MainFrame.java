package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pushService.PushService;


public class MainFrame extends JFrame{
	private Vector<String> nameList;
	private Vector<String> IMEIList;
	private PushService ps;
	private JList<String> list;
	private JScrollPane listScroll;
	private MainPanel mainPanel;
	private StatePanel state;
	
	
	
	public MainFrame(Vector<String> names, Vector<String> IMEIs) {
		this.nameList = names;
		this.IMEIList = IMEIs;

		ps = new PushService();
		list = new JList<String>();
		listScroll = new JScrollPane(list);
		mainPanel = new MainPanel(this);
		state = new StatePanel(this);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				mainPanel.selectName(list.getSelectedValue());
			}
		});
		
		
		list.setFixedCellWidth(200);
		list.setListData(nameList);	
		
		
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		getContentPane().add(state, BorderLayout.NORTH);
		getContentPane().add(listScroll, BorderLayout.WEST);
		
	}
	
	public Vector<String> getNameList() {
		return nameList;
	}

	public Vector<String> getIMEIList() {
		return IMEIList;
	}

	public void redraw(){
		list.setListData(nameList);
		list.repaint();
		mainPanel.redraw();
		this.validate();
		this.repaint();
	}

	public void push(String username, String phonename) {
		String IMEI = "";
		for(int i = 0 ; i < IMEIList.size(); i++){
			if(nameList.get(i).equals(phonename)){
				IMEI = IMEIList.get(i);
				break;
			}
		}
		if(!IMEI.equals("")){
			try {
				ps.sendMessage(username, IMEI);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}