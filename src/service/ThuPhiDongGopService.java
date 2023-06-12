/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.NhanKhau;
import model.ThuPhiDongGop;

/**
 *
 * @author phamd
 */
public class ThuPhiDongGopService {
    
   
   public static int nopPhi(String shk, String idkhoanthu, int soluong) {
       Connection conn = null;
        PreparedStatement preStatement = null;
            ResultSet resultSet = null;
            String sql;
            try {
                String dbURL = "jdbc:mysql://localhost/test";
                conn = DriverManager.getConnection(dbURL, "root", "");
                sql = "INSERT INTO thuphidonggop(sohokhau, idkhoanthu, soluong) values (?,?,?)";
                preStatement = conn.prepareStatement(sql);
                preStatement.setString(1, shk);
                preStatement.setString(2, idkhoanthu);
                preStatement.setInt(3, soluong);
                preStatement.executeUpdate();
                   
                return 1;
            }catch (SQLException e) {
                    //e.printStackTrace();
                    return 0;
                }    
   }
   
   public static ArrayList<ThuPhiDongGop> dsDaThu(){
       ArrayList<ThuPhiDongGop> tmp = new ArrayList<ThuPhiDongGop>();
       Connection conn = null;
       PreparedStatement preStatement = null;
       ResultSet resultSet = null;
       String sql; 

        try{
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            sql = "SELECT * FROM thuphidonggop;";
            preStatement=conn.prepareCall(sql);
            resultSet = preStatement.executeQuery();
            
            while(resultSet.next()){
                String idkhoanthu = resultSet.getString("idkhoanthu");
                String sohokhau = resultSet.getString("sohokhau");
                int soluong = resultSet.getInt("soluong");
                ThuPhiDongGop toAdd = new ThuPhiDongGop(idkhoanthu, sohokhau, soluong);
                tmp.add(toAdd);
            }
        }catch (SQLException ex) {
              //ex.printStackTrace();
        }   
        return tmp;
   }
   
      public static ArrayList<ThuPhiDongGop> dsDaThu1Ho(String str){
       ArrayList<ThuPhiDongGop> tmp = new ArrayList<ThuPhiDongGop>();
       Connection conn = null;
       PreparedStatement preStatement = null;
       ResultSet resultSet = null;
       String sql; 

        try{
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            sql = "SELECT * FROM thuphidonggop where sohokhau = ?;";
            preStatement=conn.prepareCall(sql);
            preStatement.setString(1,str);
            resultSet = preStatement.executeQuery();
            
            while(resultSet.next()){
                String idkhoanthu = resultSet.getString("idkhoanthu");
                String sohokhau = resultSet.getString("sohokhau");
                int soluong = resultSet.getInt("soluong");
                ThuPhiDongGop toAdd = new ThuPhiDongGop(idkhoanthu, sohokhau, soluong);
                tmp.add(toAdd);
            }
        }catch (SQLException ex) {
              //ex.printStackTrace();
        }   
        return tmp;
   }
}
