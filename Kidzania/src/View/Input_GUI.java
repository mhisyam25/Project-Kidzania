/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import control.Input;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import model.*;

/**
 *
 * @author ASUS
 */
public class Input_GUI extends JFrame{
    pilihan_pengunjung pil = new pilihan_pengunjung();
    Input inputpil = new Input();
    
    //DEKLARASI KOMPONEN
    JFrame window = new JFrame("Berapa Anak");
    JLabel lNama = new JLabel("Nama");
    JLabel lBanyakA = new JLabel("Jumlah Anak");
    JLabel lBanyakD = new JLabel("Jumlah Dewasa");
    JLabel linfonama = new JLabel(" ");
    
    JTextField tfBanyak_anak = new JTextField();
    JTextField tfBanyak_dewasa = new JTextField();

    JButton btnSubmit = new JButton("Tambah");
    JButton btnReset = new JButton("Reset");
    JButton btnBack = new JButton("Kembali");
   
    //ControlBarang inputBarang = new ControlBarang();
    public Input_GUI(DataPengunjung pengunjung) {
        window.setLayout(null);
        window.setSize(380, 270);
        window.setVisible(true);
        window.setLocationRelativeTo(null); // center
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE); // running program berhenti jika tombol close ditekan
        
        //ADD COMPONENT
        window.add(lNama);
        window.add(lBanyakA);
        window.add(lBanyakD);
        window.add(linfonama);
        window.add(tfBanyak_anak);
        window.add(tfBanyak_dewasa);
        window.add(btnSubmit);
        window.add(btnReset);
        window.add(btnBack);

        // SETT BOUNDS
        // sett bounds(m,n,o,p) >>> (sumbu-x,sumbu-y,panjang komponen, tinggi komponen)
        lNama.setBounds(60, 35, 70, 30);
        lBanyakA.setBounds(60, 75, 90, 30);
        lBanyakD.setBounds(60, 115, 100, 30);
        
        linfonama.setBounds(170, 35, 120, 30);
        
        tfBanyak_anak.setBounds(170, 75, 120, 30);
        tfBanyak_dewasa.setBounds(170, 115, 120, 30);

        btnSubmit.setBounds(240, 175, 80, 30);
        btnReset.setBounds(150, 175, 80, 30);
        btnBack.setBounds(60, 175, 80, 30);
        
        linfonama.setText(pengunjung.getNama()); 

        // CUSTOMIZE
        btnBack.setBackground(new Color(249, 237, 105) );
        lBanyakA.setForeground(Color.WHITE);
        lBanyakD.setForeground(Color.WHITE);
        lNama.setForeground(Color.WHITE);
        linfonama.setForeground(Color.WHITE);
        window.getContentPane().setBackground( new Color(50, 50, 50) );   
        btnSubmit.setBackground(new Color(13, 115, 119));
        btnSubmit.setForeground(Color.WHITE);
        btnReset.setBackground(new Color(232, 69, 69));
    
        // sett mouse pointer
        lNama.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lBanyakA.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lBanyakD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // ACTION LISTENER
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String nama = pengunjung.getNama();
                    int jml_anak = Integer.parseInt(tfBanyak_anak.getText());
                    int jml_dewasa = Integer.parseInt(tfBanyak_dewasa.getText());

                    if(jml_anak < 0 || jml_dewasa < 0){
                        throw new ArithmeticException("Jumlah Dilarang Negatif");      
                    }
                    
                    pil.pilihan_pengunjung(jml_anak, jml_dewasa, nama, " ");
                    
                    if(inputpil.input(pil)){
                        window.dispose();
                        new MainMenu_GUI(pengunjung);            
                        JOptionPane.showMessageDialog(null, "Input Berhasil");
                    }else{
                        JOptionPane.showMessageDialog(null, "Input Gagal");
                    }

                }catch(Exception ex){
                    System.out.print(ex.getMessage());
                    if (tfBanyak_anak.getText().equals("")||tfBanyak_anak.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Harus diisi");
                    }else if ("Bilangan Harus Positif".equals(ex.getMessage())) {
                        JOptionPane.showMessageDialog(null,ex.getMessage()); 
                    }else{
                        JOptionPane.showMessageDialog(null,"harus bilangan breeeeeeeeeeeeeeee");
                    }
                    tfBanyak_anak.setText("");
                    tfBanyak_anak.setText("");
                }
            }
        });
        
        btnReset.addActionListener((ActionEvent arg0) -> {
            tfBanyak_anak.setText("");
            tfBanyak_dewasa.setText("");
        });
        
        btnBack.addActionListener((ActionEvent arg0) -> {
            window.dispose();
            new MainMenu_GUI(pengunjung);
        });
    }
}
