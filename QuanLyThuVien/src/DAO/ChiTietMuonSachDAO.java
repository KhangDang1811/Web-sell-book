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
public class ChiTietMuonSachDAO {
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static Connection conn = Connect.getConnect();
  
      public static boolean InsertCTMS(ChiTietMuonSach ctms) {
        
        String sql = "insert into CTMS(MAPHIEUMUONSACH, MASACH) values(?,?)";
        try {
            pst= conn.prepareStatement(sql); 
            pst.setString(1, ctms.getmAPHIEUMUONSACH());
            pst.setString(2, ctms.getmASACH());         
            
            return pst.executeUpdate()>0; 
        } catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
   public static boolean DeleteCTMS(String maphieumuonsach) {
        
         String sql = "delete from CTMS where MAPHIEUMUONSACH=?";
        try {
            pst= conn.prepareStatement(sql); 
           pst.setString(1,maphieumuonsach);
            return pst.executeUpdate()>0; 
        } catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
   public boolean UpdateCTMS(ChiTietMuonSach ctms)  {
        String sql = "update CTMS set  MASACH =  ? where MAPHIEUMUONSACH = ?";
        
        try
        {
           pst= conn.prepareStatement(sql); 
           pst.setString(2, ctms.getmAPHIEUMUONSACH());
           pst.setString(1, ctms.getmASACH()); 
               
            return pst.executeUpdate() >0;
        }        catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
    }
}
}
