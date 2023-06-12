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
import model.KhoanThu;
import model.NhanKhau;
import static service.NhanKhauService.soNhanKhauTrong1Ho;

/**
 *
 * @author phamd
 */
public class KhoanThuService {
    
    public static ArrayList<KhoanThu> dsCacKhoanThu(){
        ArrayList<KhoanThu> tmp = new ArrayList<KhoanThu>();
        Connection conn = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        String sql;

        try{
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            sql = "SELECT * FROM cackhoanthu;";
            preStatement=conn.prepareCall(sql);
            resultSet = preStatement.executeQuery();
            
            while(resultSet.next()){
                String idkhoanthu = resultSet.getString("idkhoanthu");
                String tenkhoanthu = resultSet.getString("tenkhoanthu");
                int sotien = resultSet.getInt("sotien");
                String hinhthucthu = resultSet.getString("hinhthucthu");
                tmp.add(new KhoanThu(idkhoanthu, tenkhoanthu, sotien, hinhthucthu));
            }
        }catch (SQLException ex) {
              //ex.printStackTrace();
        }   
        return tmp;
   }
    
    public String getIDKhoanThu(String tenkhoanthu){
        Connection conn = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        String sql;

        try{
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            sql = "SELECT * FROM cackhoanthu where tenkhoanthu = ?;";
            preStatement=conn.prepareCall(sql);
            preStatement.setString(1,tenkhoanthu);
            resultSet = preStatement.executeQuery();
            
            while(resultSet.next()){
                String idkhoanthu = resultSet.getString("idkhoanthu");
                return idkhoanthu;
            }
        }catch (SQLException ex) {
              //ex.printStackTrace();
        }   
        return null;
    }
    
    public String getTenKhoanThu(String idkhoanthu){
        Connection conn = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        String sql;

        try{
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            sql = "SELECT * FROM cackhoanthu where idkhoanthu = ?;";
            preStatement=conn.prepareCall(sql);
            preStatement.setString(1,idkhoanthu);
            resultSet = preStatement.executeQuery();
            
            while(resultSet.next()){
                String tenkhoanthu = resultSet.getString("tenkhoanthu");
                return tenkhoanthu;
            }
        }catch (SQLException ex) {
              //ex.printStackTrace();
        }   
        return null;
    }
    
    public String getHinhThucThu(String idkhoanthu){
        Connection conn = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        String sql;

        try{
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            sql = "SELECT * FROM cackhoanthu where idkhoanthu = ?;";
            preStatement=conn.prepareCall(sql);
            preStatement.setString(1,idkhoanthu);
            resultSet = preStatement.executeQuery();
            
            while(resultSet.next()){
                String hinhthucthu = resultSet.getString("hinhthucthu");
                return hinhthucthu;
            }
        }catch (SQLException ex) {
              //ex.printStackTrace();
        }   
        return null;
    }
    
    public String getSoTien(String idkhoanthu){
        Connection conn = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        String sql;

        try{
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            sql = "SELECT * FROM cackhoanthu where idkhoanthu = ?;";
            preStatement=conn.prepareCall(sql);
            preStatement.setString(1,idkhoanthu);
            resultSet = preStatement.executeQuery();
            
            while(resultSet.next()){
                String sotien = resultSet.getString("sotien");
                return sotien;
            }
        }catch (SQLException ex) {
              //ex.printStackTrace();
        }   
        return null;
    }
    
    public int getSoTien(String idkhoanthu, int sonhankhau){
        ArrayList<KhoanThu> tmp = new ArrayList<KhoanThu>();
        Connection conn = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        String sql;

        try{
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            sql = "SELECT * FROM cackhoanthu where idkhoanthu = ?;";
            preStatement=conn.prepareCall(sql);
            preStatement.setString(1, idkhoanthu);
            resultSet = preStatement.executeQuery();
            
            while(resultSet.next()){
                int sotien = resultSet.getInt("sotien");
                String hinhthucthu = resultSet.getString("hinhthucthu");
                if ("nhankhau".equals(hinhthucthu))
                    return sonhankhau * sotien;
                return sotien;
            }
        }catch (SQLException ex) {
              //ex.printStackTrace();
        }
        
        return 0;
    }
    
    public int getSoTien1Ho(String sohokhau, String idkhoanthu) {
        int result = 0;
        Connection conn = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        String sql;

        try{
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            sql = "SELECT * FROM thuphidonggop where (sohokhau,idkhoanthu) = (?,?);";
            //System.out.println(idkhoanthu);
            preStatement=conn.prepareCall(sql);
            preStatement.setString(1, sohokhau);
            preStatement.setString(2, idkhoanthu);
            
            if ("Tất cả".equals(idkhoanthu)) {
                sql = "SELECT * FROM thuphidonggop where sohokhau = ?;";
                preStatement=conn.prepareCall(sql);
                preStatement.setString(1, sohokhau);
            }
            
            resultSet = preStatement.executeQuery();
            
            while(resultSet.next()){
                String s = resultSet.getString("idkhoanthu");
                int cnt = soNhanKhauTrong1Ho(sohokhau);
                
                result += getSoTien(s,cnt);
                result += resultSet.getInt("soluong");
            }
        }catch (SQLException ex) {
              //ex.printStackTrace();
        }
        
        return result;
    }
}
