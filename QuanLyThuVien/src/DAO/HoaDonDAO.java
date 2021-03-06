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
public class HoaDonDAO {
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static Connection conn = Connect.getConnect();
    public static boolean InsertHOADON(HoaDon hd) {
        
        String sql = "insert into HOADON(MAHD, MAPHIEUTRA, TIENNO, TIENTHU, TIENTHUA) values(?,?,?,?,?)";
        try {
            pst= conn.prepareStatement(sql); 
            pst.setString(1, hd.getmAHD());
            pst.setString(2, hd.getmAPHIEUTRA());
            pst.setString(3, hd.gettIENNO());
            pst.setString(4, hd.gettIENTHU());
            pst.setString(5, hd.gettIENTHUA());
            
            return pst.executeUpdate()>0; 
        } catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
   public static boolean DeleteHOADON(String mahd) {
        
         String sql = "delete from HOADON where MAHD=?";
        try {
            pst= conn.prepareStatement(sql); 
           pst.setString(1,mahd);
            return pst.executeUpdate()>0; 
        } catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
   public boolean UpdateHOADON(HoaDon hd)  {
        String sql = "update HOADON set  MAPHIEUTRA = ?, TIENNO = ?, TIENTHU = ?, TIENTHUA = ? where MAHD= ?";
        
        try
        {
           pst= conn.prepareStatement(sql); 
           pst.setString(5, hd.getmAHD());
           pst.setString(1, hd.getmAPHIEUTRA());
           pst.setString(2, hd.gettIENNO());
           pst.setString(3, hd.gettIENTHU());
           pst.setString(4, hd.gettIENTHUA());
               
            return pst.executeUpdate() >0;
        }        catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
    }
}
}
