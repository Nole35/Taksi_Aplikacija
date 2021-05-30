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

public class DispecerProzor extends JFrame {

	private JPanel contentPane;

	
	
	 
	public DispecerProzor(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai) {
		setTitle("Dispecer:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar mainMenu = new JMenuBar();
		mainMenu.setBounds(0, 0, 696, 47);
		contentPane.add(mainMenu);
		
		JMenu TaksiSluzbaMenu = new JMenu("Taksi Sluzba");
		TaksiSluzbaMenu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mainMenu.add(TaksiSluzbaMenu);
		
		JMenuItem prikazItem = new JMenuItem("Prikaz i izmena ");
		prikazItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaksiSluzbaProzor tsp = new TaksiSluzbaProzor(taksiSluzba, taksiSluzbai);
				tsp.setVisible(true);
				dispose();
			}
		});
		prikazItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		TaksiSluzbaMenu.add(prikazItem);
		
		JMenu VozaciMenu = new JMenu("Vozaci");
		VozaciMenu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mainMenu.add(VozaciMenu);
		
		JMenuItem vozaciItem = new JMenuItem("Svi vozaci");
		vozaciItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		VozaciMenu.add(vozaciItem);
		
		JMenu AutomobiliMenu = new JMenu("Automobili");
		AutomobiliMenu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mainMenu.add(AutomobiliMenu);
		
		JMenuItem automobiliItem = new JMenuItem("Svi automobili");
		automobiliItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		AutomobiliMenu.add(automobiliItem);
		
		JMenu VoznjeMenu = new JMenu("Voznje");
		VoznjeMenu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mainMenu.add(VoznjeMenu);
		
		JMenuItem voznjeItem = new JMenuItem("Sve Voznje");
		voznjeItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		VoznjeMenu.add(voznjeItem);
		
		JMenu DodelaMenu = new JMenu("Dodeljivanje voznji");
		DodelaMenu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mainMenu.add(DodelaMenu);
		
		JMenuItem kreiranjeItem = new JMenuItem("Kreirane telefonom");
		kreiranjeItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		DodelaMenu.add(kreiranjeItem);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrijavaDispecer pd = new PrijavaDispecer(taksiSluzba, taksiSluzbai);
				pd.setVisible(true);
				dispose();
			}
		});
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mainMenu.add(btnClose);
	}
}
