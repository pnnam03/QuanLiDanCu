/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.NhanKhau;
import model.TamTru;
import model.TamVang;
import service.NhanKhauService;
import service.TamTruService;
import service.TamVangService;

/**
 *
 * @author
 */
public class TamVangManagerController {
    public static String soHoKhau;
    public static String maDinhDanh;
    public static String maGiayTamVang;

    public void setSoHoKhau(String sohokhau){
        this.soHoKhau=sohokhau;
    }

    public void setMaDinhDanh(String madinhdanh){
        this.maDinhDanh=madinhdanh;
    }
    
    public void setMaGiayTamVang(String magiaytamvang){
        this.maGiayTamVang=magiaytamvang;
    }
    
    public int themTamVang(String magiaytamvang, String noitamtru, Date tungay,  Date denngay, String lydo){
        TamVangService tamVangService = new TamVangService();
        
        TamVang tamVang = new TamVang();
        tamVang.setSoHoKhau(soHoKhau);
        tamVang.setMaDinhDanh(maDinhDanh);
        tamVang.setMaGiayTamVang(magiaytamvang);
        tamVang.setNoiTamTru(noitamtru);
        tamVang.setTuNgay(tungay);
        tamVang.setDenNgay(denngay);
        tamVang.setLyDo(lydo);
        tamVang.setTinhTrang("Đang tạm vắng");
        if (tamVangService.themTamVang(tamVang) == 1) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public int xoaTamVang(String magiaytamvang){
        TamVangService tamVangService = new TamVangService();
        try {
        tamVangService.xoaTamVang(magiaytamvang);
        return 1;
        }
        catch (Exception ex){}
        return 0;
    }
    
    public void capNhatBang(JTable tamVangTable){
        TamVangService tamVangService = new TamVangService();
        NhanKhauService nhanKhauService = new NhanKhauService();
        List<TamVang> danhSachTamVang = new ArrayList<TamVang>();
        DefaultTableModel df = (DefaultTableModel)tamVangTable.getModel();
        df.setRowCount(0);
        danhSachTamVang = tamVangService.layDanhSachTamVang();
        for(TamVang i: danhSachTamVang){
            NhanKhau nhanKhau = nhanKhauService.timNhanKhau(i.getSoHoKhau(), i.getMaDinhDanh());
            df.addRow(new Object[]{i.getMaGiayTamVang(), i.getSoHoKhau(), i.getMaDinhDanh(), nhanKhau.getHoTen(), i.getTinhTrang()});
        }
    }
    
    public void hienThiChiTiet(String magiaytamvang, JLabel labelNoiTamTru, JLabel labelTuNgay, JLabel labelDenNgay, JLabel labelLyDo){
        TamVangService tamVangService = new TamVangService();
        TamVang tamVang=tamVangService.timTamVang(magiaytamvang);
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        
        labelNoiTamTru.setText(tamVang.getNoiTamTru());
        labelTuNgay.setText(fmt.format(tamVang.getTuNgay()));
        labelDenNgay.setText(fmt.format(tamVang.getDenNgay()));
        labelLyDo.setText(tamVang.getLyDo());
    }
    
    public void hienThiThongTinSua(JLabel labelSoHoKhau, JLabel labelMaDinhDanh, JLabel labelHoTen, 
                                   JTextField txtMaGiayTamVang, JTextField txtNoiTamTru, 
                                   JTextField txtTuNgay, JTextField txtDenNgay, JTextField txtLyDo){
        TamVangService tamVangService = new TamVangService();
        NhanKhauService nhanKhauService = new NhanKhauService();
        TamVang tamVang=tamVangService.timTamVang(maGiayTamVang);
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        labelSoHoKhau.setText(tamVang.getSoHoKhau());
        labelMaDinhDanh.setText(tamVang.getMaDinhDanh());
        labelHoTen.setText(nhanKhauService.timNhanKhau(tamVang.getSoHoKhau(), tamVang.getMaDinhDanh()).getHoTen());
        txtMaGiayTamVang.setText(tamVang.getMaGiayTamVang());
        txtNoiTamTru.setText(tamVang.getNoiTamTru());
        txtTuNgay.setText(fmt.format(tamVang.getTuNgay()));
        txtDenNgay.setText(fmt.format(tamVang.getDenNgay()));
        txtLyDo.setText(tamVang.getLyDo());
    }
    
    public int capNhatTamVang(String maGiayTamVangMoi, String noiTamTru, Date tuNgay, Date denNgay, String lyDo){
        TamVangService tamVangService = new TamVangService();
        TamVang tamVang=tamVangService.timTamVang(maGiayTamVang);
        tamVang.setMaGiayTamVang(maGiayTamVangMoi);
        tamVang.setNoiTamTru(noiTamTru);
        tamVang.setTuNgay(tuNgay);
        tamVang.setDenNgay(denNgay);
        tamVang.setLyDo(lyDo);
        if(tamVangService.capNhatTamVang(tamVang, maGiayTamVang)==1){
            return 1;
        }else{
            return 0;
        }
    }
    
    public int capNhatTinhTrangTamVang(String tinhTrangMoi, String maGiayTamVang){
        TamVangService tamVangService = new TamVangService();
        int i = tamVangService.capNhatTinhTrang(tinhTrangMoi, maGiayTamVang);
        if(i==1){
            return 1;
        }else{
            return 0;
        }
    }
    
     public void timKiemTamVang(JComboBox comboboxTimKiem, JTable tamVangTable, String txtKimKiem){
            TamVangService tamVangService = new TamVangService();
            NhanKhauService nhanKhauService = new NhanKhauService();
            List<TamVang> danhSachTamVang = tamVangService.layDanhSachTamVang();
            List<TamVang> ketQua=new ArrayList<TamVang>();
            String selectedRow=(String)comboboxTimKiem.getSelectedItem();
            if(selectedRow.equals("Họ tên")){
                for(TamVang i: danhSachTamVang){
                    NhanKhau nhanKhau = nhanKhauService.timNhanKhau(i.getSoHoKhau(), i.getMaDinhDanh());
                    if(nhanKhau.getHoTen().contains(txtKimKiem)){
                        ketQua.add(i);
                    }
                }
            }else if(selectedRow.equals("Mã định danh")){
                int k = txtKimKiem.length();
                for(TamVang i: danhSachTamVang){
                    NhanKhau nhanKhau = nhanKhauService.timNhanKhau(i.getSoHoKhau(), i.getMaDinhDanh());
                    char[] id = new char[k];
                    nhanKhau.getMaDinhDanh().getChars(0, k, id, 0);
                    String madinhdanh=String.copyValueOf(id);
                    if(madinhdanh.equals(txtKimKiem)){
                        ketQua.add(i);
                    }
                }
            }
            DefaultTableModel df = (DefaultTableModel)tamVangTable.getModel();
            df.setRowCount(0);
            for(TamVang i: ketQua){
                NhanKhau nhanKhau = nhanKhauService.timNhanKhau(i.getSoHoKhau(), i.getMaDinhDanh());
                df.addRow(new Object[]{i.getMaGiayTamVang(), i.getSoHoKhau(), i.getMaDinhDanh(), nhanKhau.getHoTen(), i.getTinhTrang()});
            }
        }
    
}
