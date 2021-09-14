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

import gui.FormeZaOdbijanjeIPrihvatanjeVoznje.PrihvatanjeIOdbijanjeVoznjeA;
import gui.FormeZaOdbijanjeIPrihvatanjeVoznje.PrihvatanjeIOdbijanjeVoznjeT;
import gui.IstorijaVoznji.IstorijaVozacaA;
import gui.IstorijaVoznji.IstorijaVozacaT;
import gui.formaZaZavrsavanjeVoznje.ZavrsavanjeVoznjeT;


import korisnici.Vozaci;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;

public class VozacProzor extends JFrame {

	private JPanel contentPane;

	

	
	public VozacProzor(TaksiSluzba taksiSluzba,TaksiSluzbai taksiSluzbai,Vozaci vozac) {
		setTitle("Vozac: " + vozac.getIme());
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
		
		JMenuItem voznjeItem = new JMenuItem("Istorija voznji telefonom");
		voznjeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IstorijaVozacaT ivt = new IstorijaVozacaT(taksiSluzba, taksiSluzbai,vozac);
				ivt.setVisible(true);
				
			}
		});
		
		voznjeItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		VoznjeMenu.add(voznjeItem);
		
		JMenuItem voznjeAItem = new JMenuItem("Istorija voznji aplikacijom");
		voznjeAItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IstorijaVozacaA iva = new IstorijaVozacaA(taksiSluzba, taksiSluzbai,vozac);
				iva.setVisible(true);
				
			}
		});
		
		voznjeItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		VoznjeMenu.add(voznjeAItem);
		
		JMenuItem zakazanetelItem = new JMenuItem("Prihvatanje voznje telefonom");
		zakazanetelItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrihvatanjeIOdbijanjeVoznjeT piovt = new PrihvatanjeIOdbijanjeVoznjeT(taksiSluzba, taksiSluzbai,vozac);
				piovt.setVisible(true);
				
			}
		});
		zakazanetelItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		VoznjeMenu.add(zakazanetelItem);
		
		JMenuItem dodeljeneItem = new JMenuItem("Prihvatanje voznje aplikacija");
		dodeljeneItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrihvatanjeIOdbijanjeVoznjeA piova = new PrihvatanjeIOdbijanjeVoznjeA(taksiSluzba, taksiSluzbai);
				piova.setVisible(true);
				
			}
		});
		dodeljeneItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		VoznjeMenu.add(dodeljeneItem);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Izjestaj voznji");
		mntmNewMenuItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		VoznjeMenu.add(mntmNewMenuItem);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrijavaVozac pv = new PrijavaVozac(taksiSluzba,taksiSluzbai);
				pv.setVisible(true);
				VozacProzor.this.setVisible(false);
				
			}
		});
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mainMenu.add(btnClose);
		

	}
}
