package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.formaZaDodjeluIPrihvatanjeVoznje.DodjelaVoznje;
import gui.formeZaPrikaz.VozaciProzor;
import gui.formeZaPrikaz.VozilaProzor;
import gui.formeZaPrikaz.VoznjeAProzor;
import gui.formeZaPrikaz.VoznjeTDodijeljene;
import gui.formeZaPrikaz.VoznjeTProzor;
import korisnici.Dispeceri;
import taksiSluzba.TaksiSluzba;
import taksiSluzba.TaksiSluzbai;
import vozila.Automobil;

public class DispecerProzor extends JFrame {

	private JPanel contentPane;
	

	
	
	 
	public DispecerProzor(TaksiSluzba taksiSluzba, TaksiSluzbai taksiSluzbai,Dispeceri dispecer) {
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
				
			}
		});
		prikazItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		TaksiSluzbaMenu.add(prikazItem);
		
		JMenu VozaciMenu = new JMenu("Vozaci");
		VozaciMenu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mainMenu.add(VozaciMenu);
		
		JMenuItem vozaciItem = new JMenuItem("Svi vozaci");
		vozaciItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VozaciProzor vop = new VozaciProzor(taksiSluzba, taksiSluzbai);
				vop.setVisible(true);
				
			}
		});
		
		
		vozaciItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		VozaciMenu.add(vozaciItem);
		
		JMenu AutomobiliMenu = new JMenu("Automobili");
		AutomobiliMenu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mainMenu.add(AutomobiliMenu);
		
		
		JMenuItem automobiliItem = new JMenuItem("Svi automobili");
		automobiliItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Autombili prije dispecera");
				for (Automobil automobil:taksiSluzba.sviNeobrisaniAutomobili()
					 ) {
					System.out.println(automobil);

				}
				 System.out.println("automobili 16");
				
				VozilaProzor vpr = new VozilaProzor(taksiSluzba, taksiSluzbai);
				vpr.setVisible(true);
				
			}
		});
		
		automobiliItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		AutomobiliMenu.add(automobiliItem);
		
		JMenu VoznjeMenu = new JMenu("Voznje");
		VoznjeMenu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mainMenu.add(VoznjeMenu);
		
		JMenuItem voznjeItem = new JMenuItem("Voznje aplikacijom");
		voznjeItem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			VoznjeAProzor vapr = new VoznjeAProzor(taksiSluzba, taksiSluzbai);
			vapr.setVisible(true);
			
		}
	});
		
		voznjeItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		VoznjeMenu.add(voznjeItem);
		
		JMenuItem voznjetItem = new JMenuItem("Voznje telefonom");
		voznjetItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VoznjeTProzor vtpr = new VoznjeTProzor(taksiSluzba, taksiSluzbai);
				vtpr.setVisible(true);
				
			}
		});
		
		voznjetItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		VoznjeMenu.add(voznjetItem);
		
		JMenu DodelaMenu = new JMenu("Dodeljivanje voznji");
		DodelaMenu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mainMenu.add(DodelaMenu);
		
		JMenuItem kreiranjeItem = new JMenuItem("Kreirane telefonom");
		kreiranjeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 DodjelaVoznje dvoz = new  DodjelaVoznje(taksiSluzba, taksiSluzbai);
				 dvoz.setVisible(true);
			
			}
		});
		
		kreiranjeItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
		DodelaMenu.add(kreiranjeItem);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrijavaDispecer pd = new PrijavaDispecer(taksiSluzba, taksiSluzbai);
				pd.setVisible(true);
				DispecerProzor.this.setVisible(false);
			}
		});
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mainMenu.add(btnClose);
	
	    
}}


