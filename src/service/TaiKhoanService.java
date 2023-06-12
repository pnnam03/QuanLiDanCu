package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import model.TaiKhoan;

public class TaiKhoanService {
	
    public static TaiKhoan checkTaiKhoan(String tenTaiKhoan, String matKhau) {
	TaiKhoan taiKhoan = null;
	Connection conn = null;
	PreparedStatement preStatement = null;
	ResultSet resultSet = null;
	String sql;
		
	try {
            String dbURL = "jdbc:mysql://localhost/test";
            conn = DriverManager.getConnection(dbURL, "root", "");
            sql = "SELECT * FROM taikhoantable WHERE taikhoan = ? AND matkhau = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, tenTaiKhoan);
            preStatement.setString(2, matKhau);
            resultSet = preStatement.executeQuery();
			
            if(resultSet.isBeforeFirst() == false) {
                return taiKhoan;
            } else {
                resultSet.next();
                taiKhoan = new TaiKhoan(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
            }                                                                                            
            } catch (SQLException e) {        
                    }
                    return  taiKhoan;			
	}
}