/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phamd
 */
public class KhoanThu {
    private String idKhoanThu = null;
    private String tenKhoanThu = null;
    private int soTien;
    private String hinhThucThu = null;
    
    public KhoanThu(String idkhoanthu, String tenkhoanthu, int sotien, String hinhthucthu){
        this.idKhoanThu = idkhoanthu;
        this.tenKhoanThu = tenkhoanthu;
        this.soTien = sotien;
        this.hinhThucThu = hinhthucthu;
    }
    
    public String getIDKhoanThu(){
        return this.idKhoanThu;
    }
    
    public String getTenKhoanThu(){
        return this.tenKhoanThu;
    }
    
    public int getSoTien(){
        return this.soTien;
    }
    
    public String getHinhThucThu() {
        return this.hinhThucThu;
    }
    
}
