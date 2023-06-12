/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.NhanKhau;
import java.sql.SQLException;

public class NhanKhauService {
    public static List<NhanKhau> layDanhSachNhankhauTrong1Ho(String sohokhau){
        Connection conn = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        String sql;
        List<NhanKhau>  danhSachNhanKhau = null;

        try{
            danhSachNhanKhau = new ArrayList<NhanKhau>();
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            sql = "SELECT * FROM nhankhautable WHERE sohokhau = ? AND quanhechuho!='Chủ hộ';";
            preStatement=conn.prepareCall(sql);
            preStatement.setString(1, sohokhau);
            resultSet = preStatement.executeQuery();
            
            while(resultSet.next()){
                NhanKhau nhanKhau = new NhanKhau();
                nhanKhau.setIdNhanKhau(resultSet.getInt("idnhankhau"));
                nhanKhau.setSoHoKhau(sohokhau);
                nhanKhau.setMaDinhDanh(resultSet.getString("madinhdanh"));
                nhanKhau.setHoTen(resultSet.getString("hoten"));
                nhanKhau.setBiDanh((resultSet.getString("bidanh")));
                nhanKhau.setNgaySinh(resultSet.getDate("ngaysinh"));
                nhanKhau.setNoiSinh(resultSet.getString("noisinh"));
                nhanKhau.setDiaChiHienTai(resultSet.getString("diachihientai"));
                nhanKhau.setGioiTinh(resultSet.getString("gioitinh"));
                nhanKhau.setNguyenQuan(resultSet.getString("nguyenquan"));
                nhanKhau.setDanToc(resultSet.getString("dantoc"));
                nhanKhau.setNgheNghiep(resultSet.getString("nghenghiep"));
                nhanKhau.setNoiLamViec(resultSet.getString("noilamviec"));
                nhanKhau.setSoCMND(resultSet.getString("socmnd"));
                nhanKhau.setNgayCapCMND(resultSet.getDate("ngaycapcmnd"));
                nhanKhau.setNoiCapCMND(resultSet.getString("noicapcmnd"));
                nhanKhau.setQuanHeChuHo(resultSet.getString("quanhechuho"));
                nhanKhau.setNoiThuongTruTruoc(resultSet.getString("noithuongtrutruoc"));
                nhanKhau.setNgayDangKiThuongTru(resultSet.getDate("ngaydkthuongtru"));
                nhanKhau.setGhiChu(resultSet.getString("ghichu"));
                nhanKhau.setTrangThai(resultSet.getString("trangthai"));
                danhSachNhanKhau.add(nhanKhau);
            }
        }catch (SQLException ex) {
              //ex.printStackTrace();
        }   
        return danhSachNhanKhau;
    }
    
    public static int soNhanKhauTrong1Ho(String sohokhau) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        String sql;

        try{
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            sql = "SELECT sohokhau,COUNT(*) as count FROM nhankhautable WHERE sohokhau = ?";
            preStatement=conn.prepareCall(sql);
            preStatement.setString(1, sohokhau);
            resultSet = preStatement.executeQuery();
            
            while(resultSet.next()){
                int res = resultSet.getInt("count");
                return res;
                
            }
        }catch (SQLException ex) {
            return -1;
        }   
        return 0;
    }
    public static List<NhanKhau> layDanhSachNhankhau(){
        Connection conn = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        String sql;
        List<NhanKhau>  danhSachNhanKhau = null;

        try{
            danhSachNhanKhau = new ArrayList<NhanKhau>();
            String dbURL = "jdbc:mysql://localhost/test";
                conn = DriverManager.getConnection(dbURL, "root", "");
            sql = "SELECT * FROM nhankhautable WHERE sohokhau!='0' ORDER BY sohokhau;";
            preStatement=conn.prepareCall(sql);
            resultSet = preStatement.executeQuery();
            
            while(resultSet.next()){
                NhanKhau nhanKhau = new NhanKhau();
                nhanKhau.setIdNhanKhau(resultSet.getInt("idnhankhau"));
                nhanKhau.setSoHoKhau(resultSet.getString("sohokhau"));
                nhanKhau.setMaDinhDanh(resultSet.getString("madinhdanh"));
                nhanKhau.setHoTen(resultSet.getString("hoten"));
                nhanKhau.setBiDanh((resultSet.getString("bidanh")));
                nhanKhau.setNgaySinh(resultSet.getDate("ngaysinh"));
                nhanKhau.setNoiSinh(resultSet.getString("noisinh"));
                nhanKhau.setDiaChiHienTai(resultSet.getString("diachihientai"));
                nhanKhau.setGioiTinh(resultSet.getString("gioitinh"));
                nhanKhau.setNguyenQuan(resultSet.getString("nguyenquan"));
                nhanKhau.setDanToc(resultSet.getString("dantoc"));
                nhanKhau.setNgheNghiep(resultSet.getString("nghenghiep"));
                nhanKhau.setNoiLamViec(resultSet.getString("noilamviec"));
                nhanKhau.setSoCMND(resultSet.getString("socmnd"));
                nhanKhau.setNgayCapCMND(resultSet.getDate("ngaycapcmnd"));
                nhanKhau.setNoiCapCMND(resultSet.getString("noicapcmnd"));
                nhanKhau.setQuanHeChuHo(resultSet.getString("quanhechuho"));
                nhanKhau.setNoiThuongTruTruoc(resultSet.getString("noithuongtrutruoc"));
                nhanKhau.setNgayDangKiThuongTru(resultSet.getDate("ngaydkthuongtru"));
                nhanKhau.setGhiChu(resultSet.getString("ghichu"));
                nhanKhau.setTrangThai(resultSet.getString("trangthai"));
                danhSachNhanKhau.add(nhanKhau);
            }
        }catch (SQLException ex) {
              //ex.printStackTrace();
        }   
        return danhSachNhanKhau;
    }
    
    public static List<NhanKhau> layDanhSachNhankhauAll(){
        Connection conn = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        String sql;
        List<NhanKhau>  danhSachNhanKhau = null;

        try{
            danhSachNhanKhau = new ArrayList<NhanKhau>();
            String dbURL = "jdbc:mysql://localhost/test";
                conn = DriverManager.getConnection(dbURL, "root", "");
            sql = "SELECT * FROM nhankhautable ORDER BY sohokhau;";
            preStatement=conn.prepareCall(sql);
            resultSet = preStatement.executeQuery();
            
            while(resultSet.next()){
                NhanKhau nhanKhau = new NhanKhau();
                nhanKhau.setIdNhanKhau(resultSet.getInt("idnhankhau"));
                nhanKhau.setSoHoKhau(resultSet.getString("sohokhau"));
                nhanKhau.setMaDinhDanh(resultSet.getString("madinhdanh"));
                nhanKhau.setHoTen(resultSet.getString("hoten"));
                nhanKhau.setBiDanh((resultSet.getString("bidanh")));
                nhanKhau.setNgaySinh(resultSet.getDate("ngaysinh"));
                nhanKhau.setNoiSinh(resultSet.getString("noisinh"));
                nhanKhau.setDiaChiHienTai(resultSet.getString("diachihientai"));
                nhanKhau.setGioiTinh(resultSet.getString("gioitinh"));
                nhanKhau.setNguyenQuan(resultSet.getString("nguyenquan"));
                nhanKhau.setDanToc(resultSet.getString("dantoc"));
                nhanKhau.setNgheNghiep(resultSet.getString("nghenghiep"));
                nhanKhau.setNoiLamViec(resultSet.getString("noilamviec"));
                nhanKhau.setSoCMND(resultSet.getString("socmnd"));
                nhanKhau.setNgayCapCMND(resultSet.getDate("ngaycapcmnd"));
                nhanKhau.setNoiCapCMND(resultSet.getString("noicapcmnd"));
                nhanKhau.setQuanHeChuHo(resultSet.getString("quanhechuho"));
                nhanKhau.setNoiThuongTruTruoc(resultSet.getString("noithuongtrutruoc"));
                nhanKhau.setNgayDangKiThuongTru(resultSet.getDate("ngaydkthuongtru"));
                nhanKhau.setGhiChu(resultSet.getString("ghichu"));
                nhanKhau.setTrangThai(resultSet.getString("trangthai"));
                danhSachNhanKhau.add(nhanKhau);
            }
        }catch (SQLException ex) {
              //ex.printStackTrace();
        }   
        return danhSachNhanKhau;
    }
    public int themNhanKhau(NhanKhau nhanKhau, String sohokhau) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        String sql;
        SimpleDateFormat fmt;
        System.out.println("1");
        try{
            fmt = new SimpleDateFormat("yyyy-MM-dd");
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            sql = "INSERT INTO nhankhautable(sohokhau, madinhdanh, hoten, bidanh, ngaysinh, noisinh, diachihientai, gioitinh, nguyenquan, dantoc, nghenghiep, noilamviec, socmnd, ngaycapcmnd, noicapcmnd, quanhechuho, noithuongtrutruoc, ngaydkthuongtru, ghichu, trangthai) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            preStatement=conn.prepareStatement(sql);
            preStatement.setString(1, sohokhau);
            preStatement.setString(2, nhanKhau.getMaDinhDanh());
            preStatement.setString(3, nhanKhau.getHoTen());
            preStatement.setString(4, nhanKhau.getBiDanh());
            preStatement.setString(5, fmt.format(nhanKhau.getNgaySinh()));
            preStatement.setString(6, nhanKhau.getNoiSinh());
            preStatement.setString(7, nhanKhau.getDiaChiHienTai());
            preStatement.setString(8, nhanKhau.getGioiTinh());
            preStatement.setString(9, nhanKhau.getNguyenQuan());
            preStatement.setString(10, nhanKhau.getDanToc());
            preStatement.setString(11, nhanKhau.getNgheNghiep());
            preStatement.setString(12, nhanKhau.getNoiLamViec());
            preStatement.setString(13, nhanKhau.getSoCMND());
            preStatement.setString(14, fmt.format(nhanKhau.getNgayCapCMND()));
            preStatement.setString(15, nhanKhau.getNoiCapCMND());
            preStatement.setString(16, nhanKhau.getQuanHeChuHo());
            preStatement.setString(17, nhanKhau.getNoiThuongTruTruoc());
            preStatement.setString(18, fmt.format(nhanKhau.getNgayDangKiThuongTru()));
            preStatement.setString(19, nhanKhau.getGhiChu());
            preStatement.setString(20, nhanKhau.getTrangThai());
//            System.out.println(preStatement.toString());
            preStatement.executeUpdate();
//            System.out.println("3");
            return 1;
        }catch (SQLException ex) {
              return 0;
        }   
    }
    
    public int xoaNhanKhau(String madinhdanh){
        Connection conn = null;
        PreparedStatement preStatement = null;
        String sql;
        
        try{
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            sql = "delete from nhankhautable where madinhdanh=?";
            preStatement=conn.prepareStatement(sql);
            preStatement.setString(1,madinhdanh);
            preStatement.executeUpdate();
            return 1;
        }catch (SQLException ex) {
              //ex.printStackTrace();
              return 0;
        }  
    }
    
    public int capNhatNhanKhau(NhanKhau nhanKhau, String sohokhau, String madinhdanhcu){
        Connection conn = null;
        PreparedStatement preStatement = null;
        String sql;
        SimpleDateFormat fmt;
        try{
            fmt = new SimpleDateFormat("yyyy-MM-dd");
            String dbURL = "jdbc:mysql://localhost/test";
                conn = DriverManager.getConnection(dbURL, "root", "");
            sql="UPDATE nhankhautable SET madinhdanh=?, hoten=?, bidanh=?, ngaysinh=?, noisinh=?, gioitinh=?, diachihientai=?, nguyenquan=?, dantoc=?, nghenghiep=?, noilamviec=?, socmnd=?, ngaycapcmnd=?, noicapcmnd=?, quanhechuho=?, noithuongtrutruoc=?, ngaydkthuongtru=?, ghichu=? WHERE sohokhau=? and madinhdanh=?";
            preStatement=conn.prepareStatement(sql);
            
            preStatement.setString(1, nhanKhau.getMaDinhDanh());
            preStatement.setString(2, nhanKhau.getHoTen());
            preStatement.setString(3, nhanKhau.getBiDanh());
            preStatement.setString(4, fmt.format(nhanKhau.getNgaySinh()));
            preStatement.setString(5, nhanKhau.getNoiSinh());
            preStatement.setString(6, nhanKhau.getGioiTinh());
            preStatement.setString(7, nhanKhau.getDiaChiHienTai());
            preStatement.setString(8, nhanKhau.getNguyenQuan());
            preStatement.setString(9, nhanKhau.getDanToc());
            preStatement.setString(10, nhanKhau.getNgheNghiep());
            preStatement.setString(11, nhanKhau.getNoiLamViec());
            preStatement.setString(12, nhanKhau.getSoCMND());
            preStatement.setString(13, fmt.format(nhanKhau.getNgayCapCMND()));
            preStatement.setString(14, nhanKhau.getNoiCapCMND());
            preStatement.setString(15, nhanKhau.getQuanHeChuHo());
            preStatement.setString(16, nhanKhau.getNoiThuongTruTruoc());
            preStatement.setString(17, fmt.format(nhanKhau.getNgayDangKiThuongTru()));
            preStatement.setString(18, nhanKhau.getGhiChu());
            preStatement.setString(19, sohokhau);
            preStatement.setString(20, madinhdanhcu);
            preStatement.executeUpdate();
            return 1;
        }catch(SQLException ex){
            return 0;
        }
    }
    
    public int capNhatSoHoKhau(String sohokhaucu, String sohokhaumoi){//cap nhat so ho khau cua cac nhan khau trong 1 ho neu so ho khau trong ho khau do bi thay doi
        Connection conn = null;
        PreparedStatement preStatement = null;
        String sql;
        List<NhanKhau>  danhSachNhanKhau = null;
        try{
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            danhSachNhanKhau = NhanKhauService.layDanhSachNhankhauTrong1Ho(sohokhaucu);
            for(NhanKhau i: danhSachNhanKhau){
                preStatement=conn.prepareStatement("UPDATE nhankhautable SET sohokhau = ? WHERE madinhdanh = ? AND sohokhau = ?");
                preStatement.setString(1, sohokhaumoi);
                preStatement.setString(2, i.getMaDinhDanh());
                preStatement.setString(3, i.getSoHoKhau());
                preStatement.executeUpdate();
            }
            return 1;
        }catch (SQLException ex) {
            //ex.printStackTrace();
            return 0;
        }   
    }
    
    public static NhanKhau timNhanKhau(String sohokhau, String madinhdanh) {
        Connection conn = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        String sql;
      
        try{
            String dbURL = "jdbc:mysql://localhost/test";
                conn = DriverManager.getConnection(dbURL, "root", "");
            sql = "SELECT * FROM nhankhautable WHERE madinhdanh=?;";
            
            preStatement=conn.prepareCall(sql);
            preStatement.setString(1,madinhdanh);
            resultSet = preStatement.executeQuery();
            
            resultSet.next();
            NhanKhau nhanKhau = new NhanKhau();
            nhanKhau.setIdNhanKhau(resultSet.getInt("idnhankhau"));
            nhanKhau.setSoHoKhau(resultSet.getString("sohokhau"));
            nhanKhau.setMaDinhDanh(resultSet.getString("madinhdanh"));
            nhanKhau.setHoTen(resultSet.getString("hoten"));
            nhanKhau.setBiDanh((resultSet.getString("bidanh")));
            nhanKhau.setNgaySinh(resultSet.getDate("ngaysinh"));
            nhanKhau.setNoiSinh(resultSet.getString("noisinh"));
            nhanKhau.setDiaChiHienTai(resultSet.getString("diachihientai"));
            nhanKhau.setGioiTinh(resultSet.getString("gioitinh"));
            nhanKhau.setNguyenQuan(resultSet.getString("nguyenquan"));
            nhanKhau.setDanToc(resultSet.getString("dantoc"));
            nhanKhau.setNgheNghiep(resultSet.getString("nghenghiep"));
            nhanKhau.setNoiLamViec(resultSet.getString("noilamviec"));
            nhanKhau.setSoCMND(resultSet.getString("socmnd"));
            nhanKhau.setNgayCapCMND(resultSet.getDate("ngaycapcmnd"));
            nhanKhau.setNoiCapCMND(resultSet.getString("noicapcmnd"));
            nhanKhau.setQuanHeChuHo(resultSet.getString("quanhechuho"));
            nhanKhau.setNoiThuongTruTruoc(resultSet.getString("noithuongtrutruoc"));
            nhanKhau.setNgayDangKiThuongTru(resultSet.getDate("ngaydkthuongtru"));
            nhanKhau.setGhiChu(resultSet.getString("ghichu"));
            nhanKhau.setTrangThai(resultSet.getString("trangthai"));
            return nhanKhau;
            
        }catch (SQLException ex) {
              return null;
        }   
    }  
    
    public static int capNhatTrangThai(String trangthaimoi, String sohokhau, String madinhdanh){//cap nhat trang thai tam tru, tam vang, thuong tru, qua doi
        Connection conn = null;
        PreparedStatement preStatement = null;
        String sql;
        try{
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            sql="UPDATE nhankhautable SET trangthai=? WHERE sohokhau=? and madinhdanh=?";
            preStatement=conn.prepareStatement(sql);
            preStatement.setString(1, trangthaimoi);
            preStatement.setString(2, sohokhau);
            preStatement.setString(3, madinhdanh);
            preStatement.executeUpdate();
            return 1;
        }catch(SQLException ex){
            return 0;
        }    
    }
    
    public int capNhatNhanKhauTach(String soHoKhau, List<NhanKhau> nk){//phuc vu cho tach ho khau, cap nhat lai so ho khau cho cac nhan khau duoc tach ra
        Connection conn = null;
        PreparedStatement preStatement = null;
        String sql;
        
        try{
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            for(NhanKhau i: nk){
                sql="UPDATE nhankhautable SET sohokhau = ? WHERE madinhdanh = ? AND sohokhau = ?";
                preStatement=conn.prepareStatement(sql);
                preStatement.setString(1, soHoKhau);
                preStatement.setString(2, i.getMaDinhDanh());
                preStatement.setString(3, i.getSoHoKhau());
                preStatement.executeUpdate();
            }
            return 1;
        }catch (SQLException ex) {
            return 0;
        }   
    }
    
    public void capNhatQuanHe(NhanKhau nhanKhau, String quanHe){//phuc vu cho tach ho khau, set lai quan he 
        Connection conn = null;
        PreparedStatement preStatement = null;
        String sql;
        
        try{
            String dbURL = "jdbc:mysql://localhost/test";
                conn = DriverManager.getConnection(dbURL, "root", "");
            sql="UPDATE nhankhautable SET quanhechuho = ? WHERE sohokhau = ? AND madinhdanh = ?";
            preStatement=conn.prepareStatement(sql);
            preStatement.setString(1, quanHe);
            preStatement.setString(2, nhanKhau.getSoHoKhau());
            preStatement.setString(3, nhanKhau.getMaDinhDanh());
            preStatement.executeUpdate();
        }catch (SQLException ex) {
        }   
    }
}