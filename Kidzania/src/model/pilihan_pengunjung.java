/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import kidzania.ConnectorDB;
import java.sql.*;
import java.util.logging.*;

public class pilihan_pengunjung {
    
    private int Jumlah_anakA, Jumlah_Dewasa, id;
    private String Nama, Wahana;
    private String NULL = null;

    public void pilihan_pengunjung(int Jumlah_anakA, int Jumlah_Dewasa, String Nama, String Wahana) {
        this.Jumlah_anakA = Jumlah_anakA;
        this.Jumlah_Dewasa = Jumlah_Dewasa;
        this.Nama = Nama;
        this.Wahana = Wahana;
    }
    //public void setID(int )
    
    public int getJumlah_anakA() {
        return Jumlah_anakA;
    }
    
    public int getJumlah_Dewasa() {
        return Jumlah_Dewasa;
    }
    
    public String getNama() {
        return Nama;
    }
    
    public String getWahana() {
        return Wahana;
    }
    
    public int getId() {
        return id;
    }
    
    public void getDataPil(String nama_pengunjung) {
    ConnectorDB conn = new ConnectorDB();
    PreparedStatement ps;
    ResultSet rs;
    
    String query = "Select * from `pilihan_pengunjung` WHERE Nama_Pengunjung=?";
    
    try {
      ps = conn.getConnection().prepareStatement(query);
      ps.setString(1, nama_pengunjung);
      rs = ps.executeQuery();
      
      System.out.println("Data ditemukan");
      
      if (rs.next()) {
        this.Nama = nama_pengunjung;
        this.Jumlah_anakA = rs.getInt("Jumlah_anakA");
        this.Jumlah_Dewasa = rs.getInt("Jumlah_Dewasa");
        this.Wahana = Wahana;
        this.id = rs.getInt("Id_Pilih");
                
//        System.out.println(Nama);
//        System.out.println(Jumlah_anakA);
//        System.out.println(Jumlah_Dewasa);
      }

    } catch (SQLException ex) {
      System.out.println("Data tidak ditemukan");
      Logger.getLogger(pilihan_pengunjung.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
    
    public void getDataJumlah(String nm, String anak, String dewasa) {
    ConnectorDB conn = new ConnectorDB();
    PreparedStatement ps;
    ResultSet rs;
    
    String query = "Select * from `pilihan_pengunjung` WHERE Nama_Pengunjung=? AND Jumlah_anakA=? AND Jumlah_Dewasa=?";
    
    try {
      ps = conn.getConnection().prepareStatement(query);
      ps.setString(1, nm);
      ps.setString(2, anak);
      ps.setString(3, dewasa);
      rs = ps.executeQuery();
      
      System.out.println("Data ditemukan");
      
      if (rs.next()) {
        this.Nama = nm;
        this.Jumlah_anakA = rs.getInt("Jumlah_anakA");
        this.Jumlah_Dewasa = rs.getInt("Jumlah_Dewasa");
        this.Wahana = rs.getString("Nama_Wahana");
        this.id = rs.getInt("Id_Pilih");
                
//        System.out.println(Nama);
//        System.out.println(Jumlah_anakA);
//        System.out.println(Jumlah_Dewasa);
      }

    } catch (SQLException ex) {
      System.out.println("Data tidak ditemukan");
      Logger.getLogger(pilihan_pengunjung.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
    
    public void getDataWahana(String nama_pengunjung) {
    ConnectorDB conn = new ConnectorDB();
    PreparedStatement ps;
    ResultSet rs;
    
    String query = "Select * from `pilihan_pengunjung` WHERE Nama_Pengunjung=?";
    
    try {
      ps = conn.getConnection().prepareStatement(query);
      ps.setString(1, nama_pengunjung);
      rs = ps.executeQuery();
      
      System.out.println("Data ditemukan");
      
      if (rs.next()) {
        this.Wahana = rs.getString("Nama_Wahana");
                
//        System.out.println(Nama);
//        System.out.println(Jumlah_anakA);
//        System.out.println(Jumlah_Dewasa);
      }

    } catch (SQLException ex) {
      System.out.println("Data tidak ditemukan");
      Logger.getLogger(pilihan_pengunjung.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
    
    public void setWahana(String wahana) {
        this.Wahana = wahana;
    }
}

