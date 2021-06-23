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

import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;

public class MusterijaProzor extends JFrame {

	private JPanel contentPane;

	
	

	
	public MusterijaProzor(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai) {
		setTitle("Musterija:");
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
		
		JMenuItem narucivanjetItem = new JMenuItem("Narucivanje voznje putem telefona");
		narucivanjetItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		VoznjeMenu.add(narucivanjetItem);
		
		JMenuItem narucivanjeaItem = new JMenuItem("Narucivanje voznje putem aplikacije");
		narucivanjeaItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		VoznjeMenu.add(narucivanjeaItem);
		
		JMenuItem voznjeItem = new JMenuItem("Istorija voznji");
		voznjeItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		VoznjeMenu.add(voznjeItem);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrijavaMusterija pm = new PrijavaMusterija(taksiSluzba,taksiSluzbai);
				pm.setVisible(true);
				MusterijaProzor.this.setVisible(false);
			}
		});
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mainMenu.add(btnClose);
	}

}
