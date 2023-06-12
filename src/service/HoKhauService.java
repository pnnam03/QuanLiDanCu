/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.HoKhau;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phamd
 */
public class HoKhauService {
	
        public static int themHoKhau(HoKhau hoKhau){
            Connection conn = null;
            PreparedStatement preStatement = null;
            ResultSet resultSet = null;
            String sql;
            SimpleDateFormat fmt;
            try {
                fmt = new SimpleDateFormat("yyyy-MM-dd");
                String dbURL = "jdbc:mysql://localhost/test";
                conn = DriverManager.getConnection(dbURL, "root", "");
                sql = "INSERT INTO hokhautable(sohokhau, tenchuho, makhuvuc, diachi, ngaytao, ngaychuyendi, lydochuyen, nguoithuchien, ghichu) values (?,?,?,?,?,?,?,?,?)";
                preStatement = conn.prepareStatement(sql);
                preStatement.setString(1, hoKhau.getSoHoKhau());
                preStatement.setString(2, hoKhau.getTenChuHo());
                preStatement.setString(3, hoKhau.getMaKhuVuc());
                preStatement.setString(4, hoKhau.getDiaChi());
                try{
                preStatement.setString(5, fmt.format(hoKhau.getNgayTao()));
                preStatement.setString(6, fmt.format(hoKhau.getNgayChuyenDi()));
                } catch (Exception e){
                }
                preStatement.setString(7, hoKhau.getLiDoChuyen());
                preStatement.setString(8, hoKhau.getNguoiThucHien());
                preStatement.setString(9, hoKhau.getGhiChu());
                preStatement.executeUpdate();
                   
//                System.out.println(preStatement);
                return 1;
            }catch (SQLException e) {
                    //e.printStackTrace();
                    return 0;
                }
        }
        
        public static List<HoKhau> layDanhSachHoKhau() {
		Connection conn = null;
		PreparedStatement preStatement = null;
		ResultSet resultSet = null;
		String sql;
		List<HoKhau>  danhSachHoKhau = null;
		
		try {
                    danhSachHoKhau = new ArrayList<HoKhau>();
                    String dbURL = "jdbc:mysql://localhost/test";
                    conn = DriverManager.getConnection(dbURL, "root", "");
                    sql = "SELECT * FROM hokhautable WHERE sohokhau != '0'";
                    preStatement = conn.prepareStatement(sql);
                    resultSet = preStatement.executeQuery();

                    if(resultSet.isBeforeFirst() == false) {
                        return null;
                    } else {
                        while(resultSet.next()) {
                            HoKhau hoKhau = new HoKhau(resultSet.getInt("idhokhau"), resultSet.getString("sohokhau"), resultSet.getString("tenchuho"), resultSet.getString("diachi"));
//                            hoKhau.setIdHoKhau(resultSet.getInt("idhokhau"));
//                            hoKhau.setSoHoKhau(resultSet.getString("sohokhau"));
//                            hoKhau.setTenChuHo(resultSet.getString("tenchuho"));
                            hoKhau.setMaKhuVuc(resultSet.getString("makhuvuc"));
//                            hoKhau.setDiaChi(resultSet.getString("diachi"));
                            hoKhau.setNgayTao(resultSet.getDate("ngaytao"));
                            hoKhau.setNgayChuyenDi(resultSet.getDate("ngaychuyendi"));
                            hoKhau.setLiDoChuyen(resultSet.getString("lydochuyen"));
                            hoKhau.setNguoiThucHien(resultSet.getString("nguoithuchien"));
                            hoKhau.setGhiChu(resultSet.getString("ghichu"));
//                            hoKhau.setDiemTichLuy(resultSet.getInt("diem"));
                            danhSachHoKhau.add(hoKhau);
                        }
                        resultSet.close();
                    }
		} catch (SQLException e) {
                    //e.printStackTrace();
                }
		return  danhSachHoKhau;	
	}        
        
        public static HoKhau timHoKhau(String sohokhau) {
            try {
            HoKhauService hoKhauService = new HoKhauService();
            List<HoKhau> danhSachHoKhau = hoKhauService.layDanhSachHoKhau();
            for (HoKhau i : danhSachHoKhau) {
                if ( sohokhau.equals(i.getSoHoKhau())) {
                    return i;
                }
            }}
            catch (Exception e){}
            return null;
        }       
        
        public static int capNhatHoKhau (HoKhau hoKhau, String sohokhau){
        Connection conn = null;
        PreparedStatement preStatement = null;
        String sql;
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try{
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            sql="UPDATE hokhautable SET sohokhau=? ,tenchuho=?, makhuvuc=?, diachi=?, ngaytao=?, ngaychuyendi=?, lydochuyen=?, nguoithuchien=?, ghichu=? WHERE sohokhau=?";
            preStatement=conn.prepareStatement(sql);
            preStatement.setString(1, hoKhau.getSoHoKhau());
            preStatement.setString(2, hoKhau.getTenChuHo());
            preStatement.setString(3, hoKhau.getMaKhuVuc());
            preStatement.setString(4, hoKhau.getDiaChi());
            preStatement.setString(5, fmt.format(hoKhau.getNgayTao()));
            preStatement.setString(6, fmt.format(hoKhau.getNgayChuyenDi()));
            preStatement.setString(7, hoKhau.getLiDoChuyen());
            preStatement.setString(8, hoKhau.getNguoiThucHien());
            preStatement.setString(9, hoKhau.getGhiChu());
            preStatement.setString(10, sohokhau);
            preStatement.executeUpdate();
            return 1;
        }catch (SQLException ex) {
              return 0;
        }   
    }  
    
        public static int capNhatTenChuHo(String tenChuHo, String soHoKhau){
            Connection conn = null;
            PreparedStatement preStatement = null;
            String sql;
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            try{
                String dbURL = "jdbc:mysql://localhost/test";
                conn = DriverManager.getConnection(dbURL, "root", "");
                sql="UPDATE hokhautable SET tenchuho=? WHERE sohokhau=?";
                preStatement=conn.prepareStatement(sql);

                preStatement.setString(1, tenChuHo);
                preStatement.setString(2, soHoKhau);

                preStatement.executeUpdate();
                
                return 1;
            }catch (SQLException ex) {
                return 0;
            }   
       }
        
        
}
