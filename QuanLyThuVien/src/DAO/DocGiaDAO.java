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

public class DocGiaDAO {
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static Connection conn = Connect.getConnect();
  
      public static boolean InsertDocGia(DocGia dg) {
        
        String sql = "insert into DOCGIA(MADOCGIA, HOTEN, NGAYSINH, LOAIDG, DIACHI, EMAIL, NGLAPTHE) values(?,?,?,?,?,?,?)";
        try
        {
            pst= conn.prepareStatement(sql);
            pst.setString(1, dg.getmADOCGIA());
            pst.setString(2, dg.gethOTEN());
            pst.setDate(3,(Date) dg.getnGAYSINH());
            pst.setString(4, dg.getlOAIDG());
            pst.setString(5, dg.getdIACHI());
            pst.setString(6, dg.geteMAIL());
            pst.setDate(7,(Date) dg.getnGAYLAPTHE());
            return pst.executeUpdate()>0; 
        } catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
   public static boolean DeleteDocGia(String madocgia) {
        
         String sql = "delete from DOCGIA where MADOCGIA=?";
        try {
            pst= conn.prepareStatement(sql);
            pst.setString(1,madocgia);
            return pst.executeUpdate()>0; 
        } catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
   public boolean UpdateDocGia(DocGia dg)  {
        String sql = "update DOCGIA set  HOTEN = ?, NGAYSINH = ?, LOAIDG = ?, DIACHI=?, EMAIL =?, nglapthe=? where MADOCGIA = ?";
        
        try
        {            
            pst= conn.prepareStatement(sql);
            pst.setString(7, dg.getmADOCGIA());
            pst.setString(1, dg.gethOTEN());
            pst.setDate(2, (Date) dg.getnGAYSINH());
            pst.setString(3, dg.getlOAIDG());
            pst.setString(4, dg.getdIACHI());
            pst.setString(5, dg.geteMAIL());
            pst.setDate(6,(Date) dg.getnGAYLAPTHE());
           
               
            return pst.executeUpdate() >0;
        }        catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
    }
}
   
}
