/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author minh
 */
import java.sql.*;
import Object.*;
public class ChiTietTraSachDAO {
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static Connection conn = Connect.getConnect();
    public static boolean InsertCTTS(ChiTietTraSach ctts) {
        
        String sql = "insert into CTTS(MAPHIEUTRA, MASACH, SONGAYTRATRE, TIENPHAT) values(?,?,?,?)";
        try {
            pst= conn.prepareStatement(sql); 
            pst.setString(1, ctts.getmAPHIEUTRA());
            pst.setString(2, ctts.getmASACH());       
            pst.setString(3, ctts.getsONGAYTRATRE());
            pst.setString(4, ctts.gettIENPHAt());
            
            return pst.executeUpdate()>0; 
        } catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
   public static boolean DeleteCTTS(String maphieutra) {
        
         String sql = "delete from CTTS where MAPHIEUTRA=?";
        try {
            pst= conn.prepareStatement(sql); 
           pst.setString(1,maphieutra);
            return pst.executeUpdate()>0; 
        } catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
   public boolean UpdateCTTS(ChiTietTraSach ctts)  {
        String sql = "update CTTS set  MASACH =  ?, SONGAYTRATRE = ?, TIENPHAT = ? where MAPHIEUTRA = ?";
        
        try
        {
           pst= conn.prepareStatement(sql); 
           pst.setString(4, ctts.getmAPHIEUTRA());
           pst.setString(1, ctts.getmASACH());       
           pst.setString(2, ctts.getsONGAYTRATRE());
           pst.setString(3, ctts.gettIENPHAt());
               
            return pst.executeUpdate() >0;
        }        catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
    }
}
}
