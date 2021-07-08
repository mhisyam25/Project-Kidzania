/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kidzania.ConnectorDB;
import model.pilihan_pengunjung;

/**
 *
 * @author ASUS
 */
public class Input {
    public boolean input(pilihan_pengunjung pp){
    
    ConnectorDB conn = new ConnectorDB();
    PreparedStatement ps;    
    
    String query = "INSERT INTO `pilihan_pengunjung`(`Nama_Pengunjung`,`Jumlah_anakA`,`Jumlah_Dewasa`) VALUES (?,?,?)";
    
    try {
      ps = conn.getConnection().prepareStatement(query);
      ps.setString(1, pp.getNama());
      ps.setInt(2, pp.getJumlah_anakA());
      ps.setInt(3, pp.getJumlah_Dewasa());

      // jika berhasil
      if (ps.executeUpdate() > 0) {        
        System.out.println("Input berhasil");
        return true;
      }
    } catch (SQLException ex) {
      Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
    return false;
  } 
}
