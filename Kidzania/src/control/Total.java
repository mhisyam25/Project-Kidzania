/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.JOptionPane;
import model.*;

public class Total {
   public boolean bayar(DataPengunjung data, pilihan_pengunjung pp){
        Update update = new Update();
        Rekap rekap = new Rekap();
        
        int saldo = data.getSaldo();
        
//        String datanama = data.getNama();  
//        pp.getDataPil(datanama); 
        
        int jumlah_anak = pp.getJumlah_anakA();
        int jumlah_dewasa = pp.getJumlah_Dewasa();
        int total = (jumlah_anak*210000)+(jumlah_dewasa*165000);
        int total2 = saldo - total;

        if(saldo>=total){
            data.setSaldo(total2);
            update.UpdateSaldo(data);     
            rekap.rekap(data, total);
            JOptionPane.showMessageDialog(null, "Pembayaran Berhasil");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Duit Kurang");
            return false;
        }
    }
}