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
import model.DataPengunjung;
import model.pilihan_pengunjung;

public class Rekap {
    public boolean rekap(DataPengunjung dp, int total){
        pilihan_pengunjung pp = new pilihan_pengunjung();
        ConnectorDB conn = new ConnectorDB();
        PreparedStatement ps;   
        
        String nama = dp.getNama();  
        pp.getDataWahana(nama); 

        String query = "INSERT INTO `rekap`(`No_Kartu`,`Nama_Wahana`,`Total`) VALUES (?,?,?)";

        try {
          ps = conn.getConnection().prepareStatement(query);
          ps.setInt(1, dp.getKartu());
          ps.setString(2, pp.getWahana());
          ps.setInt(3, total);

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
