/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kidzania.ConnectorDB;
import model.pilihan_pengunjung;
/**
 *
 * @author ASUS
 */
public class CountRow {
    pilihan_pengunjung pp = new pilihan_pengunjung();
    
    private int CountRow() {
    String query = "SELECT * FROM `Pilihan_pengunjung`";
    PreparedStatement ps;
    ResultSet rs;

    int n = 0;
    try {
        ConnectorDB conn = new ConnectorDB();
        ps = conn.getConnection().prepareStatement(query);
        rs = ps.executeQuery();

        while (rs.next()) {
            n++;
        }
        return n;

    } catch (SQLException ex) {
        Logger.getLogger(CountRow.class.getName()).log(Level.SEVERE, null, ex);
    }
    return -4;
  }
  
  public String[][] readDataPengunjung() {
    String query = "SELECT * FROM `pilihan_pengunjung`";
    PreparedStatement ps;
    ResultSet rs;
    
    // untuk menghitung jumlah baris
    int cr = CountRow();
    
    // untuk menyimpan data
    String data[][] = new String[cr][5];

    try {
      ConnectorDB conn = new ConnectorDB();
      ps = conn.getConnection().prepareStatement(query);
      rs = ps.executeQuery();

      int n = 0; // untuk menjumahkan baris(row)
      while (rs.next()) { //konversi tabel ke string
        data[n][0] = rs.getString(1);
        data[n][1] = rs.getString(2);
        data[n][2] = rs.getString(3);
        data[n][3] = rs.getString(4);
        data[n][4] = rs.getString(5);
        n++;
      }
      return data;
    } catch (SQLException ex) {
        System.out.println("Read Data Gagal");
        Logger.getLogger(CountRow.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    } 
  }
}
