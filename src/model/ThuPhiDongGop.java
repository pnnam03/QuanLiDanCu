/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phamd
 */
public class ThuPhiDongGop {
    private String idKhoanThu;
    private String soHoKhau;
    private int soLuong;
    
    public ThuPhiDongGop(String idkhoanthu, String sohokhau, int soluong){
        this.idKhoanThu = idkhoanthu;
        this.soHoKhau   = sohokhau;
        this.soLuong    = soluong;
    }
    
    public int getSoLuong(){
        return this.soLuong;
    }
    
    public String getSoHoKhau(){
        return this.soHoKhau;
    }
    
    public String getIDKhoanThu(){
        return this.idKhoanThu;
    }
}
