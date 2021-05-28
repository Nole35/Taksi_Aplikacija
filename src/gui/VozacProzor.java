package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VozacProzor extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VozacProzor frame = new VozacProzor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public VozacProzor() {
		setTitle("Vozac:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar mainMenu = new JMenuBar();
		mainMenu.setBounds(0, 0, 696, 60);
		contentPane.add(mainMenu);
		
		JMenu VoznjeMenu = new JMenu("Voznje");
		VoznjeMenu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mainMenu.add(VoznjeMenu);
		
		JMenuItem voznjeItem = new JMenuItem("Istorija voznji");
		voznjeItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		VoznjeMenu.add(voznjeItem);
		
		JMenuItem zakazanetelItem = new JMenuItem("Voznje telefonom zakazane");
		zakazanetelItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		VoznjeMenu.add(zakazanetelItem);
		
		JMenuItem dodeljeneItem = new JMenuItem("Dodeljene voznje");
		dodeljeneItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		VoznjeMenu.add(dodeljeneItem);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrijavaVozac pv = new PrijavaVozac();
				pv.setVisible(true);
				dispose();
				
			}
		});
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mainMenu.add(btnClose);
		

	}
}
