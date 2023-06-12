package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.NhanKhau;
import service.HoKhauService;
import service.NhanKhauService;
import service.TamVangService;

public class NhanKhauManagerController {
	/*private ArrayList<NhanKhau> danhSachNhanKhau;
	
	public NhanKhauManagerController() {
		danhSachNhanKhau = new ArrayList<NhanKhau>();
	}
	
	public void themNhanKhau(NhanKhau nhanKhau) {
		danhSachNhanKhau.add(nhanKhau);
	}
	
	public void thayDoiNhanKhau(NhanKhau nhanKhau, String ngayChuyen, String noiChuyen, String ghiChu) {
		nhanKhau.setNgayChuyen(ngayChuyen);
		nhanKhau.setNoiChuyen(noiChuyen);
		nhanKhau.setGhiChu(ghiChu);
	}
	
	public void thayDoiNhanKhau(NhanKhau nhanKhau) {
		nhanKhau.setGhiChu("Đã qua đời!");
	}*/
    
        public static String soHoKhau;
        public static String maDinhDanh;
        
        public void setSoHoKhau(String sohokhau){
            this.soHoKhau=sohokhau;
        }
        
        public void setMaDinhDanh(String madinhdanh){
            this.maDinhDanh=madinhdanh;
        }
        
        /*
        List<Nhankhau> nk = new ArrayList<Nhankhau>();
        List<Nhankhau> nhankhautach = new ArrayList<Nhankhau>();
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        LichsuController controllichsu = new LichsuController();
        */
        public int themNhanKhauThuongTru (String madinhdanh, String hoten, String bidanh, Date ngaysinh, String noisinh,
                                 String diachihientai, String gioitinh, String nguyenquan, String dantoc, 
                                 String nghenghiep, String noilamviec, String socmnd, Date ngaycapcmnd, 
                                 String noicapcmnd, String quanhechuho, String noithuongtrucu, Date ngaydkthuongtru, 
                                 String ghichu, String trangthai){
        NhanKhauService nhanKhauService = new NhanKhauService();
        
        NhanKhau nhanKhau = new NhanKhau();
        nhanKhau.setSoHoKhau(soHoKhau);
        nhanKhau.setMaDinhDanh(madinhdanh);
        nhanKhau.setHoTen(hoten);
        nhanKhau.setBiDanh(bidanh);
        nhanKhau.setNgaySinh(ngaysinh);
        nhanKhau.setNoiSinh(noisinh);
        nhanKhau.setDiaChiHienTai(diachihientai);
        nhanKhau.setGioiTinh(gioitinh);
        nhanKhau.setNguyenQuan(nguyenquan);
        nhanKhau.setDanToc(dantoc);
        nhanKhau.setNgheNghiep(nghenghiep);
        nhanKhau.setNoiLamViec(noilamviec);
        nhanKhau.setSoCMND(socmnd);
        nhanKhau.setNgayCapCMND(ngaycapcmnd);
        nhanKhau.setNoiCapCMND(noicapcmnd);
        nhanKhau.setQuanHeChuHo(quanhechuho);
        nhanKhau.setNoiThuongTruTruoc(noithuongtrucu);
        nhanKhau.setNgayDangKiThuongTru(ngaydkthuongtru);
        nhanKhau.setGhiChu(ghichu);
        nhanKhau.setTrangThai("Thường trú");
        if (nhanKhauService.themNhanKhau(nhanKhau, soHoKhau) == 1) {
            return 1;
        } else {
            return 0;
        }
    }
        public int xoaNhanKhau(String madinhdanh){
        NhanKhauService nhanKhauService = new NhanKhauService();
        try {
           nhanKhauService.xoaNhanKhau(madinhdanh);
        return 1;
        }
        catch (Exception ex){}
        return 0;
    }
        public void capNhatBangNhanKhau1Ho(JTable nhanKhauTable){
            NhanKhauService nhanKhauService = new NhanKhauService();
            List<NhanKhau> danhSachNhanKhau = new ArrayList<NhanKhau>();
            DefaultTableModel df = (DefaultTableModel)nhanKhauTable.getModel();
            df.setRowCount(0);
            danhSachNhanKhau = nhanKhauService.layDanhSachNhankhauTrong1Ho(soHoKhau);
            for(NhanKhau i: danhSachNhanKhau){
                df.addRow(new Object[]{i.getMaDinhDanh(), i.getHoTen(), i.getQuanHeChuHo(), i.getTrangThai()});
            }
        }

        public void capNhatBang(JTable nhanKhauTable){
            NhanKhauService nhanKhauService = new NhanKhauService();
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            List<NhanKhau> danhSachNhanKhau = new ArrayList<NhanKhau>();
            DefaultTableModel df = (DefaultTableModel)nhanKhauTable.getModel();
            df.setRowCount(0);
            danhSachNhanKhau = nhanKhauService.layDanhSachNhankhauAll();
            for(NhanKhau i: danhSachNhanKhau){
                df.addRow(new Object[]{i.getMaDinhDanh(), i.getSoHoKhau(), i.getHoTen(), fmt.format(i.getNgaySinh()), i.getGioiTinh(), i.getDiaChiHienTai()});
            }
        }
        
        public void timKiemNhankhau(JComboBox comboboxTimKiem, JTable nhanKhauTable, String txtKimKiem){
            NhanKhauService nhanKhauService = new NhanKhauService();
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            List<NhanKhau> danhSachNhanKhau = nhanKhauService.layDanhSachNhankhau();
            List<NhanKhau> ketQua=new ArrayList<NhanKhau>();
            String selectedRow=(String)comboboxTimKiem.getSelectedItem();
            if(selectedRow.equals("Họ tên")){
                for(NhanKhau i: danhSachNhanKhau){
                    if(i.getHoTen().contains(txtKimKiem)){
                        ketQua.add(i);
                    }
                }
            }else if(selectedRow.equals("Mã định danh")){
                for(NhanKhau i: danhSachNhanKhau){
                    int k = txtKimKiem.length();
                    char[] id = new char[k];
                    i.getMaDinhDanh().getChars(0, k, id, 0);
                    String madinhdanh=String.copyValueOf(id);
                    if(madinhdanh.equals(txtKimKiem)){
                        ketQua.add(i);
                    }
                }
            }else if(selectedRow.equals("Số hộ khẩu")){
                int k = txtKimKiem.length();
                for(NhanKhau i: danhSachNhanKhau){
                    char[] id = new char[k];
                    i.getSoHoKhau().getChars(0, k, id, 0);
                    String sohokhau=String.copyValueOf(id);
                    if(sohokhau.equals(txtKimKiem)){
                        ketQua.add(i);
                    }
                }
            }
            DefaultTableModel df = (DefaultTableModel)nhanKhauTable.getModel();
            df.setRowCount(0);
            for(NhanKhau i: ketQua){
                df.addRow(new Object[]{i.getMaDinhDanh(), i.getSoHoKhau(), i.getHoTen(), fmt.format(i.getNgaySinh()), i.getGioiTinh(), i.getDiaChiHienTai()});
            }
        }
        
        public void hienThiChiTiet(JTextField txtMaDinhDanh, JTextField txtHoTen, JTextField txtBiDanh, 
                                   JTextField txtNgaySinh, JTextField txtNoiSinh, JComboBox comboboxGioiTinh, 
                                   JTextField txtDiaChiHienTai, JTextField txtNguyenQuan, JTextField txtDanToc, 
                                   JTextField txtNgheNghiep, JTextField txtNoiLamViec, JTextField txtSoCMND, 
                                   JTextField txtNgayCapCMND, JTextField txtNoiCapCMND, JTextField txtQuanHeChuHo, 
                                   JTextField txtNoiThuongTruTruoc, JTextField txtNgayDkThuongTru, JTextField txtGhiChu, 
                                   JTextField txtTrangThai){
        NhanKhauService nhanKhauService = new NhanKhauService();
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        NhanKhau nhanKhau= nhanKhauService.timNhanKhau(soHoKhau, maDinhDanh);
        
        txtMaDinhDanh.setText(nhanKhau.getMaDinhDanh());
        txtHoTen.setText(nhanKhau.getHoTen());
        txtBiDanh.setText(nhanKhau.getBiDanh());
        txtNgaySinh.setText(fmt.format(nhanKhau.getNgaySinh()));
        txtNoiSinh.setText(nhanKhau.getNoiSinh());
        comboboxGioiTinh.setSelectedItem(nhanKhau.getGioiTinh());
        txtDiaChiHienTai.setText(nhanKhau.getDiaChiHienTai());
        txtNguyenQuan.setText(nhanKhau.getNguyenQuan());
        txtDanToc.setText(nhanKhau.getDanToc());
        txtNgheNghiep.setText(nhanKhau.getNgheNghiep());
        txtNoiLamViec.setText(nhanKhau.getNoiLamViec());
        
        String soCMND = nhanKhau.getSoCMND();
        if (soCMND != null) {
            txtSoCMND.setText(soCMND);
            txtNgayCapCMND.setText(fmt.format(nhanKhau.getNgayCapCMND()));
            txtNoiCapCMND.setText(nhanKhau.getNoiCapCMND());
        }
        
        txtQuanHeChuHo.setText(nhanKhau.getQuanHeChuHo());
        txtNoiThuongTruTruoc.setText(nhanKhau.getNoiThuongTruTruoc());
        txtNgayDkThuongTru.setText(fmt.format(nhanKhau.getNgayDangKiThuongTru()));
        txtGhiChu.setText(nhanKhau.getGhiChu());
        txtTrangThai.setText(nhanKhau.getTrangThai());
    }
        
        public int capNhatNhanKhauThuongTru(String madinhdanh, String hoten, String bidanh, Date ngaysinh, String noisinh,
                                 String diachihientai, String gioitinh, String nguyenquan, String dantoc, 
                                 String nghenghiep, String noilamviec, String socmnd, Date ngaycapcmnd, 
                                 String noicapcmnd, String quanhechuho, String noithuongtrucu, Date ngaydkthuongtru, 
                                 String ghichu){
            NhanKhauService nhanKhauService = new NhanKhauService();
        
            NhanKhau NhanKhau = new NhanKhau();
            
            NhanKhau.setMaDinhDanh(madinhdanh);
            NhanKhau.setHoTen(hoten);
            NhanKhau.setBiDanh(bidanh);
            NhanKhau.setNgaySinh(ngaysinh);
            NhanKhau.setNoiSinh(noisinh);
            NhanKhau.setDiaChiHienTai(diachihientai);
            NhanKhau.setGioiTinh(gioitinh);
            NhanKhau.setNguyenQuan(nguyenquan);
            NhanKhau.setDanToc(dantoc);
            NhanKhau.setNgheNghiep(nghenghiep);
            NhanKhau.setNoiLamViec(noilamviec);
            NhanKhau.setSoCMND(socmnd);
            NhanKhau.setNgayCapCMND(ngaycapcmnd);
            NhanKhau.setNoiCapCMND(noicapcmnd);
            NhanKhau.setQuanHeChuHo(quanhechuho);
            NhanKhau.setNoiThuongTruTruoc(noithuongtrucu);
            NhanKhau.setNgayDangKiThuongTru(ngaydkthuongtru);
            NhanKhau.setGhiChu(ghichu);
            NhanKhau.setTrangThai("");
            if (nhanKhauService.capNhatNhanKhau(NhanKhau, soHoKhau, maDinhDanh)== 1) {
                return 1;
            } else {
                return 0;
            }
        }
        
        public int themNhanKhauTamTru (String madinhdanh, String hoten, Date ngaysinh, String diachihientai,
                                       String gioitinh, String nghenghiep, String noilamviec, String socmnd, 
                                       String noithuongtrucu, String ghichu){
            try{
                NhanKhauService nhanKhauService = new NhanKhauService();
                SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

                NhanKhau nhanKhau = new NhanKhau();
                nhanKhau.setMaDinhDanh(madinhdanh);
                nhanKhau.setHoTen(hoten);
                nhanKhau.setNgaySinh(ngaysinh);
                nhanKhau.setDiaChiHienTai(diachihientai);
                nhanKhau.setGioiTinh(gioitinh);
                nhanKhau.setNgheNghiep(nghenghiep);
                nhanKhau.setNoiLamViec(noilamviec);
                nhanKhau.setSoCMND(socmnd);
                nhanKhau.setNoiThuongTruTruoc(noithuongtrucu);
                nhanKhau.setGhiChu(ghichu);
                nhanKhau.setNgayCapCMND(fmt.parse("0/0/0"));
                nhanKhau.setNgayDangKiThuongTru(fmt.parse("0/0/0"));
                nhanKhau.setTrangThai("Tạm trú");
                if (nhanKhauService.themNhanKhau(nhanKhau, "0") == 1) {
                    return 1;
                } else {
                    return 0;
                }
            }catch(Exception ex){
                ex.printStackTrace();
                return 0;
            }
        
    }
        
     public int capNhatNhanKhauTamTru(String madinhdanh, String hoten, Date ngaysinh, String diachihientai,
                                      String gioitinh, String nghenghiep, String noilamviec, String socmnd, 
                                      String noithuongtrucu, String ghichu, String maDinhDanh){
            try{
                NhanKhauService nhanKhauService = new NhanKhauService();
                SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                NhanKhau nhanKhau = new NhanKhau();

                nhanKhau.setMaDinhDanh(madinhdanh);
                nhanKhau.setHoTen(hoten);
                nhanKhau.setNgaySinh(ngaysinh);
                nhanKhau.setDiaChiHienTai(diachihientai);
                nhanKhau.setGioiTinh(gioitinh);
                nhanKhau.setNgheNghiep(nghenghiep);
                nhanKhau.setNoiLamViec(noilamviec);
                nhanKhau.setSoCMND(socmnd);
                nhanKhau.setNoiThuongTruTruoc(noithuongtrucu);
                nhanKhau.setGhiChu(ghichu);
                nhanKhau.setNgayCapCMND(fmt.parse("0/0/0"));
                nhanKhau.setNgayDangKiThuongTru(fmt.parse("0/0/0"));

                if (nhanKhauService.capNhatNhanKhau(nhanKhau, "0", maDinhDanh)== 1) {
                    return 1;
                } else {
                    return 0;
                }
            }catch(Exception ex){
                ex.printStackTrace();
                return 0;
            }
        }    
     
     public void capNhatBangTachHo(JTable nhanKhauTable){
            NhanKhauService nhanKhauService = new NhanKhauService();
            List<NhanKhau> danhSachNhanKhau = new ArrayList<NhanKhau>();
            DefaultTableModel df = (DefaultTableModel)nhanKhauTable.getModel();
            df.setRowCount(0);
            danhSachNhanKhau = nhanKhauService.layDanhSachNhankhauTrong1Ho(soHoKhau);
            for(NhanKhau i: danhSachNhanKhau){
                df.addRow(new Object[]{i.getMaDinhDanh(), i.getHoTen(), i.getQuanHeChuHo(),false});
            }
        }
     
     public int capNhatNhanKhauTach(JTable tachHoTable, String sohokhaumoi, String tenchuho){//them nhan khau moi vao ho moi dc tach ra
         DefaultTableModel df = (DefaultTableModel)tachHoTable.getModel();
         NhanKhauService nhanKhauService = new NhanKhauService();
         List<NhanKhau> nhanKhauTach = new ArrayList<NhanKhau>(); 
         int size = tachHoTable.getRowCount();
         for(int k=0; k<size; k++){
             if((Boolean)df.getValueAt(k, 3)==true){
                 NhanKhau nhanKhau = nhanKhauService.timNhanKhau(soHoKhau, (String)df.getValueAt(k, 0));
                 nhanKhauTach.add(nhanKhau);
             }
         }
         for(NhanKhau i: nhanKhauTach){
             if(i.getHoTen().equals(tenchuho)){
                 nhanKhauService.capNhatQuanHe(i, "Chủ hộ");
                 break;
             }
         }
        return nhanKhauService.capNhatNhanKhauTach(sohokhaumoi, nhanKhauTach);
     }
     
     public void capNhatBangCapNhatQuanHe(JTable nhanKhauTable){
            NhanKhauService nhanKhauService = new NhanKhauService();
            List<NhanKhau> danhSachNhanKhau = new ArrayList<NhanKhau>();
            DefaultTableModel df = (DefaultTableModel)nhanKhauTable.getModel();
            df.setRowCount(0);
            danhSachNhanKhau = nhanKhauService.layDanhSachNhankhauTrong1Ho(soHoKhau);
            for(NhanKhau i: danhSachNhanKhau){
                df.addRow(new Object[]{i.getMaDinhDanh(), i.getHoTen(), ""});
            }
        }
     
     public int capNhatQuanHe(JTable hoTachTable){
         try{
            NhanKhauService nhanKhauService = new NhanKhauService();
            HoKhauService hoKhauService = new HoKhauService();
            DefaultTableModel df = (DefaultTableModel)hoTachTable.getModel();
            int size = hoTachTable.getRowCount();
            for(int k=0; k<=size; k++){
                if(k==size){
                    break;
                }
                nhanKhauService.capNhatQuanHe(nhanKhauService.timNhanKhau(soHoKhau, (String)df.getValueAt(k, 0)), (String)df.getValueAt(k, 2));
            }
            return 1;
         }catch(Exception ex){
            ex.printStackTrace();
            return 0;
         }   
    }
    
}
