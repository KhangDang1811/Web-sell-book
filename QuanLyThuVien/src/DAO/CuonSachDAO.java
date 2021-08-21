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
import Object.CuonSach;
import java.sql.*;
public class CuonSachDAO {

    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static Connection conn = Connect.getConnect();
    
    public static boolean InsertCuonSach(CuonSach cs) {
        
        String sql = "insert into CUONSACH(MASACH, MADAUSACH, TINHTRANG ) values(?,?,?)";
        try {
            
            pst= conn.prepareStatement(sql); 
            pst.setString(1, cs.getmASACH());
            pst.setString(2, cs.getmADAUSACH());
            pst.setString(3, cs.gettINHTRANG());
            
            return pst.executeUpdate()>0; 
        } catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
   public static boolean DeleteCuonSach(String masach) {
        
         String sql = "delete from CUONSACH where MASACH=?";
        try {
            pst= conn.prepareStatement(sql); 
           pst.setString(1,masach);
            return pst.executeUpdate()>0; 
        } catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
   public boolean UpdateCuonSach(CuonSach cs)  {
        String sql = "update CUONSACH set  MADAUSACH = ?, TINHTRANG = ? where MASACH = ?";
        
        try
        {
            pst= conn.prepareStatement(sql); 
            pst.setString(3, cs.getmASACH());
            pst.setString(1, cs.getmADAUSACH());
            pst.setString(2, cs.gettINHTRANG());
          
            return pst.executeUpdate() >0;
        }        catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
    }
}
}