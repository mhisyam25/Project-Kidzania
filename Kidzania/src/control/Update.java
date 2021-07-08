/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kidzania.ConnectorDB;

public class Update {
    public boolean UpdateWahana(pilihan_pengunjung pp){
    
    ConnectorDB conn = new ConnectorDB();
    
    PreparedStatement ps;
    
    
    String query = "UPDATE `pilihan_pengunjung` SET `Nama_Wahana`=? WHERE `Nama_Pengunjung`=?";
    
    try {
      ps = conn.getConnection().prepareStatement(query);
      ps.setString(1, pp.getWahana());
      ps.setString(2, pp.getNama());

      // jika berhasil
      if (ps.executeUpdate() > 0) {        
        return true;
      }
    } catch (SQLException ex) {
      Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
    return false;
  }
    
    public boolean UpdateSaldo(DataPengunjung data){
        
    ConnectorDB conn = new ConnectorDB();
    PreparedStatement ps;    
    
    String query = "UPDATE `pengunjung` SET `Saldo`=? WHERE `Nama`=?";
    
    try {
      ps = conn.getConnection().prepareStatement(query);
      ps.setString(1, String.valueOf(data.getSaldo()));
      ps.setString(2, data.getNama());

      // jika berhasil
      if (ps.executeUpdate() > 0) { 
          
        return true;
      }
    } catch (SQLException ex) {
      Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
    return false;
  }
    
    public boolean UpdateJumlah(pilihan_pengunjung pp){
        
    ConnectorDB conn = new ConnectorDB();
    PreparedStatement ps;    
    
    String query = "UPDATE `pilihan_pengunjung` SET Jumlah_anakA=?, Jumlah_Dewasa=? WHERE `Nama`=?";
    
    try {
      ps = conn.getConnection().prepareStatement(query);
      ps.setInt(1, pp.getJumlah_anakA());
      ps.setInt(2, pp.getJumlah_Dewasa());
      ps.setString(3, pp.getNama());

      // jika berhasil
      if (ps.executeUpdate() > 0) { 
          
        return true;
      }
    } catch (SQLException ex) {
      Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
    return false;
  }
}
