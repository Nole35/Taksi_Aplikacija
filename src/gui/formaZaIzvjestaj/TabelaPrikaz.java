package gui.formaZaIzvjestaj;

import kolekcije.DoubleLinkedList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class TabelaPrikaz extends JFrame{

    private JToolBar mainToolBar = new JToolBar();
    private DefaultTableModel table_model = new DefaultTableModel();
    private JTable izvestajiTabela = new JTable();

    public TabelaPrikaz(DoubleLinkedList<IzvestajVozacaPodaci> tests) {
        setTitle("Prikaz izvestaja");
        setSize(1000, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI(tests);
    }

    private void initGUI(DoubleLinkedList<IzvestajVozacaPodaci> tests) {
        String[] zaglavlje = new String[]{"Vozac", "Ukupan broj voznji", "Ukupan broj predjenih kilometara", "Ukupno trajanje voznji", "Prosecan broj predjenih km po voznji", "Prosecno trajanje voznje", "Ukupna zarada", "Prosecna zarada"};

        add(mainToolBar, BorderLayout.SOUTH);
        izvestajiTabela.setModel(table_model);
        table_model.setColumnIdentifiers(zaglavlje);

        for(IzvestajVozacaPodaci x : tests) {
            Object[] o = new Object[8];
            o[0] = x.getIdVozaca();
            o[1] = x.getUkupanBrojVoznji();
            o[2] = x.getDuzina();
            o[3] = x.getVreme();
            o[4] = x.getProsecnaDuzina();
            o[5] = x.getProsecnoVreme();
            o[6] = x.getZarada();
            o[7] = x.getProsecnaZarad();
            table_model.addRow(o);
        }

        izvestajiTabela.setRowSelectionAllowed(true);
        izvestajiTabela.setColumnSelectionAllowed(false);
        izvestajiTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        izvestajiTabela.setDefaultEditor(Object.class, null);
        izvestajiTabela.getTableHeader().setReorderingAllowed(false);
        izvestajiTabela.setVisible(true);
        izvestajiTabela.setAutoCreateRowSorter(true);

        JScrollPane jsp = new JScrollPane(izvestajiTabela);
        add(jsp, BorderLayout.CENTER);
    }
}
