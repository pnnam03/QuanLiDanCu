/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.TamVang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author Vu
 */
public class TamVangService {
     public static List<TamVang> layDanhSachTamVang(){
        Connection conn = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        String sql;
        List<TamVang>  danhSachTamVang = null;

        try{
            danhSachTamVang = new ArrayList<>();
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            sql = "SELECT * FROM tamvangtable where tinhtrang='Đang tạm vắng';";
            preStatement=conn.prepareCall(sql);
            resultSet = preStatement.executeQuery();
            
            while(resultSet.next()){
                TamVang tamVang = new TamVang();
                tamVang.setMaGiayTamVang(resultSet.getString("magiaytamvang"));
                tamVang.setSoHoKhau(resultSet.getString("sohokhau"));
                tamVang.setMaDinhDanh(resultSet.getString("madinhdanh"));
                tamVang.setNoiTamTru(resultSet.getString("noitamtru"));
                tamVang.setTuNgay((resultSet.getDate("tungay")));
                tamVang.setDenNgay(resultSet.getDate("denngay"));
                tamVang.setLyDo(resultSet.getString("lydo"));
                tamVang.setTinhTrang(resultSet.getString("tinhtrang"));
                danhSachTamVang.add(tamVang);
            }
        }catch (SQLException ex) {
              //ex.printStackTrace();
        }   
        return danhSachTamVang;
    }
     
     public int themTamVang(TamVang tamVang) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        String sql;
        SimpleDateFormat fmt;
        
        try{
            fmt = new SimpleDateFormat("yyyy-MM-dd");
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            sql = "INSERT INTO tamvangtable(magiaytamvang, madinhdanh, sohokhau, noitamtru, tungay, denngay, lydo, tinhtrang) VALUES (?,?,?,?,?,?,?,?)";
            preStatement=conn.prepareStatement(sql);
            try{
            preStatement.setString(1, tamVang.getMaGiayTamVang());
            preStatement.setString(2, tamVang.getMaDinhDanh());
            preStatement.setString(3, tamVang.getSoHoKhau());
            preStatement.setString(4, tamVang.getNoiTamTru());
            preStatement.setString(5, fmt.format(tamVang.getTuNgay()));
            preStatement.setString(6, fmt.format(tamVang.getDenNgay()));
            preStatement.setString(7, tamVang.getLyDo());
            preStatement.setString(8, tamVang.getTinhTrang());
            System.out.println(preStatement.toString());
            } catch(Exception e){}
            preStatement.executeUpdate();
            
            return 1;
        }catch (SQLException ex) {
              //ex.printStackTrace();
              return 0;
        }   
    }
     
    public int xoaTamVang(String magiaytamvang){
        Connection conn = null;
        PreparedStatement preStatement = null;
        String sql;
        
        try{
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            sql = "delete from tamvangtable where magiaytamvang=?";
            preStatement=conn.prepareStatement(sql);
            preStatement.setString(1,magiaytamvang);
            preStatement.executeUpdate();
            return 1;
        }catch (SQLException ex) {
              //ex.printStackTrace();
              return 0;
        }   
    }
    
     
     public int capNhatTamVang(TamVang tamVang, String magiaytamvangcu){
        Connection conn = null;
        PreparedStatement preStatement = null;
        String sql;
        SimpleDateFormat fmt;
        try{
            fmt = new SimpleDateFormat("yyyy-MM-dd");
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            sql="UPDATE tamvangtable SET magiaytamvang=?, noitamtru=?, tungay=?, denngay=?, lydo=? WHERE magiaytamvang=?";
            preStatement=conn.prepareStatement(sql);
            
            preStatement.setString(1, tamVang.getMaGiayTamVang());
            preStatement.setString(2, tamVang.getNoiTamTru());
            preStatement.setString(3, fmt.format(tamVang.getTuNgay()));
            preStatement.setString(4, fmt.format(tamVang.getDenNgay()));
            preStatement.setString(5, tamVang.getLyDo());
            preStatement.setString(6, magiaytamvangcu);
            preStatement.executeUpdate();
            return 1;
        }catch(SQLException ex){
            return 0;
        }
    }
     
    public int capNhatTinhTrang(String tinhtrang, String magiaytamvang){
        Connection conn = null;
        PreparedStatement preStatement = null;
        String sql;
        SimpleDateFormat fmt;
        try{
            fmt = new SimpleDateFormat("yyyy-MM-dd");
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            sql="UPDATE tamvangtable SET tinhtrang=? WHERE magiaytamvang=?";
            preStatement=conn.prepareStatement(sql);
            
            preStatement.setString(1, tinhtrang);
            preStatement.setString(2, magiaytamvang);
            preStatement.executeUpdate();
            return 1;
        }catch(SQLException ex){
            return 0;
        }
    }
    
    public TamVang timTamVang(String magiaytamvang){
        TamVangService tamVangService = new TamVangService();
        List<TamVang> danhSachTamVang = tamVangService.layDanhSachTamVang();
        for (TamVang i : danhSachTamVang) {
            if ( magiaytamvang.equals(i.getMaGiayTamVang())) {
                return i;
            }
        }
        return null;
    }
}