/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import kidzania.ConnectorDB;
import java.sql.*;
import java.util.logging.*;

public class DataPengunjung {
    private String nama;
    private int no_kartu, saldo;
    
    public void DataPengunjung(String nama, int no_kartu, int saldo) {
        this.nama = nama;
        this.no_kartu = no_kartu;
        this.saldo = saldo;
    }
    
    public String getNama() {
        return nama;
    }
    
    public int getKartu() {
        return no_kartu;
    }
    
    public int getSaldo() {
        return saldo;
    }
    
    public void getData(int no_kartu) {
        ConnectorDB conn = new ConnectorDB();
        PreparedStatement ps;
        ResultSet rs;

        String query = "Select * from `pengunjung` WHERE No_Kartu=?";

        try {
            ps = conn.getConnection().prepareStatement(query);
            ps.setInt(1, no_kartu);
            rs = ps.executeQuery();

            if (rs.next()) {
                this.no_kartu = no_kartu;
                this.nama = rs.getString(2);
                this.saldo = rs.getInt(3);

                System.out.println(no_kartu);
                System.out.println(nama);
                System.out.println(saldo);
            }

        } catch (SQLException ex) {
            System.out.println("Data tidak ditemukan");
            Logger.getLogger(DataPengunjung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setSaldo(int Saldo) {
        this.saldo = Saldo;
    }
}
