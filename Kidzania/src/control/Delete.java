/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import kidzania.ConnectorDB;
import model.pilihan_pengunjung;
import java.sql.*;
import java.util.logging.*;
import static java.lang.Integer.parseInt;
import model.DataPengunjung;

public class Delete {
    public boolean delete(DataPengunjung data){
    
        String query = "DELETE FROM `pilihan_pengunjung`";
        PreparedStatement ps;

        try {
            ConnectorDB conn = new ConnectorDB();
            ps = conn.getConnection().prepareStatement(query);

            int i = ps.executeUpdate();

            return i == 1; // jika change pin success

       } catch (SQLException ex) {
            Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
            return false;
       }
    }
}
