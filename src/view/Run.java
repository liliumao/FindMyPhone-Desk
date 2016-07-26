package view;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;

import utils.IOUtils;


public class Run {
	public static void main(String argv[]){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vector<String> names = new Vector<>();
					Vector<String> IMEIs = new Vector<>();
					IOUtils.readIMEIList(names, IMEIs);
					
					MainFrame window = new MainFrame(names, IMEIs);
					window.setBounds(100, 100, 800, 500);
					window.setTitle("Relationship Analyzer");
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.setVisible(true);
					window.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
