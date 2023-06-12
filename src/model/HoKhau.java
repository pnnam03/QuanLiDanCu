/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;

/**
 *
 * @author phamd
 */
public class HoKhau {
    private int idHoKhau;
    private String soHoKhau;
    private String tenChuHo;
    private String diaChi;
    private String maKhuVuc;
    private java.util.Date ngayTao;
    private java.util.Date ngayChuyenDi;
    private String liDoChuyen;
    private String nguoiThucHien;
    private String ghiChu;
    
    
    private ArrayList<NhanKhau> danhSachNhanKhau;
    
    // Assign info in model
    public HoKhau(int idHoKhau, String soHoKhau, String tenChuHo, String diaChi){
        this.idHoKhau = idHoKhau;
        this.diaChi = diaChi;
        this.soHoKhau = soHoKhau;
        this.tenChuHo = tenChuHo;
    }
    
    // Functions to get info
    public int getIDHoKhau(){
        return idHoKhau;
    }
    
    public String getSoHoKhau(){
        return soHoKhau;
    }
    
    public String getMaKhuVuc(){
        return maKhuVuc;
    }
    
    public String getTenChuHo(){
        return tenChuHo;
    }
    
    public String getDiaChi(){
        return diaChi;
    }
    
    public String getLiDoChuyen(){
        return liDoChuyen;
    }
    
    public String getNguoiThucHien(){
        return nguoiThucHien;
    }
    
    public String getGhiChu(){
        return ghiChu;
    }
       
    public java.util.Date getNgayTao(){
        
        return ngayTao;
    }
    
    public java.util.Date getNgayChuyenDi(){
        return ngayChuyenDi;
    }
    
    
    // Functions to set info
    public void setIDHoKhau(int IDHoKhau){
        this.idHoKhau = IDHoKhau;
    }
    
    public void setSoHoKhau(String str){
        this.soHoKhau = str;
    }
    
    public void setTenChuHo(String str){
        this.tenChuHo = str;
    }
    
    public void setMaKhuVuc(String str){
        this.maKhuVuc = str;
    }
    
    public void setDiaChi(String str){
        this.diaChi = str;
    }
    
    public void setLiDoChuyen(String str){
        this.liDoChuyen = str;
    }
    
    public void setNguoiThucHien(String str){
        this.nguoiThucHien = str;
    }
    
    public void setGhiChu(String str){
        this.ghiChu = str;
    }
       
    public void setNgayTao(java.util.Date date){
        this.ngayTao = date;
    }
    
    public void setNgayChuyenDi(java.util.Date date){
        this.ngayChuyenDi = date;
    }
    
}
