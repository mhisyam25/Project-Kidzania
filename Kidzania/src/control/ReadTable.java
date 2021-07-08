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
public class ReadTable {
    public String[][] readDataPengunjung(pilihan_pengunjung pp) {
    String query = "SELECT * FROM `pilihan_pengunjung` WHERE Nama_Pengunjung=?";
    PreparedStatement ps;
    ResultSet rs;
    
    // untuk menyimpan data
    String data[][] = new String[17][5];

    try {
      ConnectorDB conn = new ConnectorDB();
      ps = conn.getConnection().prepareStatement(query);
      ps.setString(1, pp.getNama());
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
