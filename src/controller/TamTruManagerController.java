package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.NhanKhau;
import model.TamTru;
import service.NhanKhauService;
import service.TamTruService;
import java.text.SimpleDateFormat;

public class TamTruManagerController {
    public static String maGiayTamTru;
    public static String maDinhDanh;
    public void setMaGiayTamTru(String magiaytamtru){
        this.maGiayTamTru=magiaytamtru;
    }
    public void setMaDinhDanh(String madinhdanh){
        this.maDinhDanh=madinhdanh;
    }
    
    TamTruService tamTruService = new TamTruService();
    public int themTamTru(String maGiayTamTru, String maDinhDanh, String soDienThoai,
                          Date tuNgay, Date denNgay, String lyDo){
        
        TamTru tamTru = new TamTru();
        tamTru.setMaGiayTamTru(maGiayTamTru);
        tamTru.setMaDinhDanh(maDinhDanh);
        tamTru.setSoDienThoai(soDienThoai);
        tamTru.setTuNgay(tuNgay);
        tamTru.setDenNgay(denNgay);
        tamTru.setLyDo(lyDo);
        tamTru.setTinhTrang("Đang tạm trú");
        if(tamTruService.themTamTru(tamTru)==1){
            return 1;
        }else{
            return 0;
        }
    }
    
    public int xoaTamTru(String mgtt, String mdd) {
       int i = tamTruService.xoaTamTru(mgtt,mdd);
       return i;
    }
    public void capNhatBang(JTable tamTruTable){
        
        TamTruService tamTruService = new TamTruService();
        NhanKhauService nhanKhauService = new NhanKhauService();
        List<TamTru> danhSachTamTru = new ArrayList<TamTru>();
        DefaultTableModel df = (DefaultTableModel)tamTruTable.getModel();
        df.setRowCount(0);
        danhSachTamTru = tamTruService.layDanhSachTamTru();
//        System.out.println(danhSachTamTru.size());
        for(TamTru i: danhSachTamTru){
            
            NhanKhau nhanKhau = nhanKhauService.timNhanKhau("0", i.getMaDinhDanh());
            df.addRow(new Object[]{i.getMaGiayTamTru(), nhanKhau.getHoTen(), nhanKhau.getDiaChiHienTai(), i.getSoDienThoai(), i.getTinhTrang()});
        }
    }
    public void timKiemTamTru(JComboBox comboboxTimKiem, JTable tamTruTable, String txtKimKiem){
            TamTruService tamTruService = new TamTruService();
            NhanKhauService nhanKhauService = new NhanKhauService();
            List<TamTru> danhSachTamTru = tamTruService.layDanhSachTamTru();
            List<TamTru> ketQua=new ArrayList<TamTru>();
            String selectedRow=(String)comboboxTimKiem.getSelectedItem();
            if(selectedRow.equals("Họ tên")){
                for(TamTru i: danhSachTamTru){
                    NhanKhau nhanKhau = nhanKhauService.timNhanKhau("0", i.getMaDinhDanh());
                    if(nhanKhau.getHoTen().contains(txtKimKiem)){
                        ketQua.add(i);
                    }
                }
            }else if(selectedRow.equals("Tình trạng")){
                for(TamTru i: danhSachTamTru){
                    if(i.getTinhTrang().contains(txtKimKiem)){
                        ketQua.add(i);
                    }
                }
            }else if(selectedRow.equals("Mã định danh")){
                int k = txtKimKiem.length();
                for(TamTru i: danhSachTamTru){
                    NhanKhau nhanKhau = nhanKhauService.timNhanKhau("0", i.getMaDinhDanh());
                    char[] id = new char[k];
                    nhanKhau.getMaDinhDanh().getChars(0, k, id, 0);
                    String madinhdanh=String.copyValueOf(id);
                    if(madinhdanh.equals(txtKimKiem)){
                        ketQua.add(i);
                    }
                }
            }
            DefaultTableModel df = (DefaultTableModel)tamTruTable.getModel();
            df.setRowCount(0);
            for(TamTru i: ketQua){
                NhanKhau nhanKhau = nhanKhauService.timNhanKhau("0", i.getMaDinhDanh());
                df.addRow(new Object[]{i.getMaGiayTamTru(), nhanKhau.getHoTen(), nhanKhau.getDiaChiHienTai(), i.getSoDienThoai(), i.getTinhTrang()});
            }
        }

    public void hienThiChiTiet(JTextField txtMaDinhDanh, JTextField txtHoTen, JTextField txtNgaySinh,
                               JComboBox comboboxGioiTinh, JTextField txtDiaChiHienTai, JTextField txtNgheNghiep,
                               JTextField txtNoiLamViec, JTextField txtSoCMND, JTextField txtNoiThuongTruTruoc,
                               JTextField txtGhiChu, JTextField txtMaGiayTamTru,JTextField txtSoDienThoai,
                               JTextField txtTuNgay, JTextField txtDenNgay, JTextField txtLyDo, JTextField txtTinhTrang){
        TamTruService tamTruService = new TamTruService();
        NhanKhauService nhanKhauService = new NhanKhauService();
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        TamTru tamTru = tamTruService.timTamTru(maGiayTamTru);
        NhanKhau nhanKhau = nhanKhauService.timNhanKhau("0", tamTru.getMaDinhDanh());
        txtMaDinhDanh.setText(nhanKhau.getMaDinhDanh());
        txtHoTen.setText(nhanKhau.getHoTen());
        txtNgaySinh.setText(fmt.format(nhanKhau.getNgaySinh()));
        comboboxGioiTinh.setSelectedItem(nhanKhau.getGioiTinh());
        txtDiaChiHienTai.setText(nhanKhau.getDiaChiHienTai());
        txtNgheNghiep.setText(nhanKhau.getNgheNghiep());
        txtNoiLamViec.setText(nhanKhau.getNoiLamViec());
        txtSoCMND.setText(nhanKhau.getSoCMND());
        txtNoiThuongTruTruoc.setText(nhanKhau.getNoiThuongTruTruoc());
        txtGhiChu.setText(nhanKhau.getGhiChu());
        txtMaGiayTamTru.setText(maGiayTamTru);
        txtSoDienThoai.setText(tamTru.getSoDienThoai());
        txtTuNgay.setText(fmt.format(tamTru.getTuNgay()));
        txtDenNgay.setText(fmt.format(tamTru.getDenNgay()));
        txtLyDo.setText(tamTru.getLyDo());
        txtTinhTrang.setText(tamTru.getTinhTrang());
    }
    public int capNhatTamTru(String maGiayTamTruMoi, String soDienThoai, Date tuNgay, Date denNgay, String lyDo){
        TamTruService tamTruService = new TamTruService();
        TamTru tamTru=tamTruService.timTamTru(maGiayTamTru);
        tamTru.setMaGiayTamTru(maGiayTamTruMoi);
        tamTru.setSoDienThoai(soDienThoai);
        tamTru.setTuNgay(tuNgay);
        tamTru.setDenNgay(denNgay);
        tamTru.setLyDo(lyDo);
        if(tamTruService.capNhatTamTru(tamTru, maGiayTamTru)==1){
            return 1;
        }else{
            return 0;
        }
    }
}
