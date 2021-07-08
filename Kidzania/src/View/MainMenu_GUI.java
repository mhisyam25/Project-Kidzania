/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import control.Update;
import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MainMenu_GUI {
    pilihan_pengunjung pil = new pilihan_pengunjung();
    Update update = new Update();
    
    JFrame window = new JFrame("Kidzania Application");
    
    JButton btnInput = new JButton("Input Data");
    JButton btnNext = new JButton("Next");
    JButton btnW1 = new JButton("");
    JButton btnW2 = new JButton("");
    JButton btnW3 = new JButton("");
    JButton btnW4 = new JButton("");
    JButton btnW5 = new JButton("");
    JLabel lTitle1 = new JLabel("KIDZANIA PUNYA PAK MAMAT");
    JLabel lTitle2 = new JLabel("Acting Academy");
    JLabel lTitle3 = new JLabel("Fire Station");
    JLabel lTitle4 = new JLabel("Dental Clinic");
    JLabel lTitle5 = new JLabel("Mini Market");
    JLabel lTitle6 = new JLabel("Tattoo Shop");
    
    public MainMenu_GUI(DataPengunjung pengunjung){
        window.setLayout(null);
        window.setSize(1000, 520);
        window.setVisible(true);
        window.setLocationRelativeTo(null); // center
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE); // running program berhenti jika tombol close ditekan 
        
        // Fancy
        ImageIcon W1 = new ImageIcon("C:\\Users\\ASUS\\OneDrive\\Documents\\NetBeansProjects\\Kidzania\\img\\1.png");
        ImageIcon W2 = new ImageIcon("C:\\Users\\ASUS\\OneDrive\\Documents\\NetBeansProjects\\Kidzania\\img\\2.png");
        ImageIcon W3 = new ImageIcon("C:\\Users\\ASUS\\OneDrive\\Documents\\NetBeansProjects\\Kidzania\\img\\3.png");
        ImageIcon W4 = new ImageIcon("C:\\Users\\ASUS\\OneDrive\\Documents\\NetBeansProjects\\Kidzania\\img\\4.png");
        ImageIcon W5 = new ImageIcon("C:\\Users\\ASUS\\OneDrive\\Documents\\NetBeansProjects\\Kidzania\\img\\5.png");
   
        // NEW 
        btnW1 = new JButton(W1);
        btnW2 = new JButton(W2);
        btnW3 = new JButton(W3);
        btnW4 = new JButton(W4);
        btnW5 = new JButton(W5);
        
        // SET DATA
        btnNext.setVisible(false);
  
        // ADD COMPONENT
        window.add(btnInput);
        window.add(btnNext);
        window.add(lTitle1);
        window.add(lTitle2);
        window.add(lTitle3);
        window.add(lTitle4);
        window.add(lTitle5);    
        window.add(lTitle6);
        window.add(btnW1);
        window.add(btnW2);
        window.add(btnW3);
        window.add(btnW4);
        window.add(btnW5);
          
        // CUSTOMIZE
        window.getContentPane().setBackground( new Color(202, 124, 216));

        btnInput.setFocusPainted(false);
        btnNext.setFocusPainted(false);
        btnNext.setBackground(new Color(238, 238, 238));
        btnInput.setBackground(new Color(13, 115, 119));
        btnInput.setForeground(Color.WHITE);
        btnInput.setFont(new Font("Tahoma", Font.BOLD, 12));
        lTitle1.setForeground(Color.WHITE);
        lTitle1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lTitle2.setForeground(Color.WHITE);
        lTitle2.setFont(new Font("Calibri", Font.BOLD, 18));
        lTitle3.setForeground(Color.WHITE);
        lTitle3.setFont(new Font("Calibri", Font.BOLD, 18));
        lTitle4.setForeground(Color.WHITE);
        lTitle4.setFont(new Font("Calibri", Font.BOLD, 18));
        lTitle5.setForeground(Color.WHITE);
        lTitle5.setFont(new Font("Calibri", Font.BOLD, 18));
        lTitle6.setForeground(Color.WHITE);
        lTitle6.setFont(new Font("Calibri", Font.BOLD, 18));
              
        // SETT BOUNDS
        // sett bounds(m,n,o,p) >>> (sumbu-x,sumbu-y,panjang komponen, tinggi komponen)
        lTitle1.setBounds(350, 35, 400, 30);
        btnInput.setBounds(280, 430, 215, 30);
        btnNext.setBounds(500, 430, 215, 30);
        btnW1.setBounds(30, 100, 180, 200);
        btnW2.setBounds(215, 100, 180, 200);
        btnW3.setBounds(400, 100, 180, 200);
        btnW4.setBounds(585, 100, 180, 200);
        btnW5.setBounds(770, 100, 180, 200);
        lTitle2.setBounds(55, 315, 215, 30);
        lTitle3.setBounds(270, 315, 215, 30);
        lTitle4.setBounds(445, 315, 215, 30);
        lTitle5.setBounds(635, 315, 215, 30);
        lTitle6.setBounds(815, 315, 215, 30);
                
        // ACTION LISTENER
        btnW1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wahana = "Acting Academy";
                pil.setWahana(wahana);  
                btnNext.setVisible(true);
            }
        });
        
        btnW2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wahana = "Fire Station";
                pil.setWahana(wahana);  
                btnNext.setVisible(true);
            }
        });
        
        btnW3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wahana = "Dental Clinic";
                pil.setWahana(wahana);  
                btnNext.setVisible(true);
            }
        });
        
        btnW4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wahana = "Mini Market";
                pil.setWahana(wahana);  
                btnNext.setVisible(true);
            }
        });
        
        btnW5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wahana = "Tattoo Shop";
                pil.setWahana(wahana);  
                btnNext.setVisible(true);
            }
        });
        
        btnInput.addActionListener((ActionEvent arg0) -> {
            new Input_GUI(pengunjung);
            window.dispose();
        });
        
        btnNext.addActionListener((ActionEvent arg0) -> {
            String kartu = pengunjung.getNama();
            
            pil.getDataPil(kartu);  

            if(update.UpdateWahana(pil)){         
                System.out.println("Update Berhasil");
            }else{
                System.out.println("Update Gagal");
            }
            
            window.dispose();
            new Detail_GUI(pengunjung);
        }); 
    }
}
