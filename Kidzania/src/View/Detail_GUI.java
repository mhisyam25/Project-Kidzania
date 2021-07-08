/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import control.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.*;

/**
 *
 * @author ASUS
 */
public class Detail_GUI {
    pilihan_pengunjung pp = new pilihan_pengunjung();
    Update upd = new Update();
    Total tot = new Total();
    Delete del = new Delete();
    ReadTable rd = new ReadTable();
    
    JFrame window = new JFrame("Kidzania Application");
    
    JLabel lTotal = new JLabel("Total Harga");
    JLabel ltotal_a = new JLabel("Total Anak    = ");
    JLabel ltotal_b = new JLabel("Total Dewasa = ");
    JLabel lJumlah_anak = new JLabel("- X Rp.210.000");
    JLabel lJumlah_dewasa = new JLabel("- X Rp.165.000");
    
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID", "Nama ", "Jumlah Anak", "Jumlah Dewasa", "Aktivititas"};
    
    JButton btnBack = new JButton("Kembali");
    JButton btnBayar = new JButton("Pembayaran");
    
    public Detail_GUI(DataPengunjung pengunjung){
        window.setLayout(null);
        window.setSize(750, 520);
        window.setVisible(true);
        window.setLocationRelativeTo(null); // center
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE); // running program berhenti jika tombol close ditekan 
        
        //ADD COMPONENT
        window.add(btnBack);
        window.add(btnBayar);
        window.add(lTotal);
        window.add(lJumlah_anak);
        window.add(lJumlah_dewasa);
        window.add(ltotal_a);
        window.add(ltotal_b);

        String kartu = pengunjung.getNama();  
        pp.getDataPil(kartu); 
        
        if(rd.readDataPengunjung(pp)== null){
            JOptionPane.showMessageDialog(null, "Tidak Ada Data");
            tabel = new JTable(null, namaKolom); //tabel merupakan variabel untuk tabelnya dengan isi tablemodel
        }else{
            tabel = new JTable(rd.readDataPengunjung(pp), namaKolom); //tabel merupakan variabel untuk tabelnya dengan isi tablemodel
        }
        
        scrollPane = new JScrollPane(tabel);
        window.add(scrollPane);
        
        // CUSTOMIZE
        window.getContentPane().setBackground( new Color(202, 124, 216));

        btnBack.setFocusPainted(false);
        btnBayar.setFocusPainted(false);
        btnBayar.setBackground(new Color(238, 238, 238));
        btnBack.setBackground(new Color(13, 115, 119));
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
        tabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        // SETT BOUNDS
        // sett bounds(m,n,o,p) >>> (sumbu-x,sumbu-y,panjang komponen, tinggi komponen)
        btnBack.setBounds(10, 443, 215, 30);
        btnBayar.setBounds(255, 350, 210, 30);
        scrollPane.setBounds(20, 35, 500, 295);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        lTotal.setBounds(590, 80, 210, 30);
        ltotal_a.setBounds(535, 120, 410, 30);
        ltotal_b.setBounds(535, 160, 410, 30);
        
        lJumlah_anak.setBounds(630, 120, 410, 30);
        lJumlah_dewasa.setBounds(630, 160, 410, 30);
                    
        // ACTION LISTENER
        tabel.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                String dataAnak = tabel.getValueAt(tabel.getSelectedRow(), 2).toString();
                String dataDewasa = tabel.getValueAt(tabel.getSelectedRow(), 3).toString();
                String nama = pp.getNama();
                
                
                //System.out.println(dataAnak+" sad "+dataDewasa+" sadsa "+nama);
                
                pp.getDataJumlah(nama, dataAnak, dataDewasa);
                
                lJumlah_anak.setText(pp.getJumlah_anakA() + " X Rp.210.000");
                lJumlah_dewasa.setText(pp.getJumlah_Dewasa() + " X Rp.165.000");
            }
        });
        
        btnBack.addActionListener((ActionEvent arg0) -> {
            window.dispose();
            new MainMenu_GUI(pengunjung);
        });
        btnBayar.addActionListener((ActionEvent arg0) -> {
            if(tot.bayar(pengunjung, pp)){
                del.delete(pengunjung);
                window.dispose();
                new MainMenu_GUI(pengunjung);
            }
        }); 
    }
}
