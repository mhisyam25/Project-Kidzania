/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import model.DataPengunjung;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_GUI {
    DataPengunjung pengunjung = new DataPengunjung();
    
    //DEKLARASI KOMPONEN
    JFrame window = new JFrame("KIDZANIA");
   
    JLabel lJudul = new JLabel("Welcome to KIDZANIA");
    JLabel lJudul2 = new JLabel("Tempat Yang Paling Diidamkan Para Anak-Anak");
    JLabel lKeterangan = new JLabel(" ");
    JLabel lCard = new JLabel("ID Card");
    
    JTextField tfCard = new JTextField();

    JButton btnLogin = new JButton("Login");
    JButton btnClose = new JButton("Close");
    
    public Login_GUI() {
        window.setLayout(null);
        window.setSize(550,250);
        window.setDefaultCloseOperation(3);
        window.setVisible(false);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        window.add(lJudul);
        window.add(lJudul2);
        window.add(lCard);
        window.add(tfCard);
        
        window.add(btnLogin);
        window.add(btnClose);
        
        lJudul.setBounds(195, 10, 200, 20);
        lJudul2.setBounds(130, 30, 400, 20);
        lCard.setBounds(185, 80, 100, 30);
        
        tfCard.setBounds(250, 80,100, 25);
        
        btnClose.setBounds(170, 150, 90, 20);
        btnLogin.setBounds(270, 150, 90, 20);
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    int id = Integer.parseInt(tfCard.getText());
                    pengunjung.getData(id);
                    
                    if(getCard().equals(String.valueOf(pengunjung.getKartu()))){
                        JOptionPane.showMessageDialog(null,"Login Berhasil"); 
                        window.dispose();
                        MainMenu_GUI menu = new MainMenu_GUI(pengunjung);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Login Gagal"); 
                }  
            }
        });

        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
              System.exit(0);
            }
        });        
    };
    
    public String getCard(){
        return tfCard.getText();
    }

    public void setVisible(boolean b) {
        window.setVisible(true);    
    }
}
