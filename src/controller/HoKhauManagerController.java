package controller;

//import java.sql.Date;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.HoKhau;
import model.NhanKhau;
import service.HoKhauService;
import service.NhanKhauService;

public class HoKhauManagerController extends javax.swing.JFrame{
	ArrayList<HoKhau> danhSachHoKhau;
	
	public HoKhauManagerController() {
		danhSachHoKhau = new ArrayList<>();
        }
        
        public int themHoKhau(String soHoKhau, String tenChuHo, String maKhuVuc, String diaChi, Date ngayTao, 
                               Date ngayChuyenDi, String lyDoChuyen, String nguoiThucHien, String ghiChu){
     
            HoKhauService hoKhauService = new HoKhauService();
            HoKhau hoKhau = new HoKhau(0, soHoKhau, tenChuHo, diaChi);
//            hoKhau.setSoHoKhau(soHoKhau);
//            hoKhau.setTenChuHo(tenChuHo);
            hoKhau.setMaKhuVuc(maKhuVuc);
//            hoKhau.setDiaChi(diaChi);
            hoKhau.setNgayTao(ngayTao);
            hoKhau.setNgayChuyenDi(ngayChuyenDi);
            hoKhau.setLiDoChuyen(lyDoChuyen);
            hoKhau.setNguoiThucHien(nguoiThucHien);
            hoKhau.setGhiChu(ghiChu);
//            hoKhau.setDiemTichLuy(0);
            if(hoKhauService.themHoKhau(hoKhau)==1){
                return 1;
            }else{
                return 0;
            }
        }
        
        public void capNhatBang(JTable hoKhauTable){
            HoKhauService hoKhauService = new HoKhauService();
            List<HoKhau> danhSachHoKhau = new ArrayList<HoKhau>();
            DefaultTableModel df = (DefaultTableModel)hoKhauTable.getModel();
            df.setRowCount(0);
            danhSachHoKhau = hoKhauService.layDanhSachHoKhau();
            for(HoKhau i: danhSachHoKhau){
                df.addRow(new Object[]{i.getSoHoKhau(), i.getTenChuHo(), i.getDiaChi()});
            }
        }
        
        public void hienThiChiTiet(String sohokhau, JTextField txtTenChuHo, JTextField txtSoHoKhau, JTextField txtDiaChi,
                                   JTextField txtMaKhuVuc, JTextField txtNgayTao, JTextField txtNguoiThucHien,
                                   JTextField txtLyDoChuyen, JTextField txtNgayChuyenDi, JTextField txtGhiChu){
            try{
            HoKhauService hoKhauService = new HoKhauService();
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            HoKhau hoKhau = hoKhauService.timHoKhau(sohokhau);
            
            txtSoHoKhau.setText(hoKhau.getSoHoKhau());
            txtTenChuHo.setText(hoKhau.getTenChuHo());
            txtDiaChi.setText(hoKhau.getDiaChi());
            txtMaKhuVuc.setText(hoKhau.getMaKhuVuc());
            txtNgayTao.setText(fmt.format(hoKhau.getNgayTao()));
            txtNguoiThucHien.setText(hoKhau.getNguoiThucHien());
            txtLyDoChuyen.setText(hoKhau.getLiDoChuyen());
            
                txtNgayChuyenDi.setText(fmt.format(hoKhau.getNgayChuyenDi()));
            
            
            txtGhiChu.setText(hoKhau.getGhiChu());
            } catch(Exception e){}
        }
        
        public int capNhatHoKhau (String soHoKhauMoi, String tenChuHo, String maKhuVuc, String diaChi, 
                                  Date ngayTao, Date ngayChuyenDi, String lyDoChuyen, 
                                  String nguoiThucHien, String ghiChu, String soHoKhauCu){
            HoKhauService hoKhauService = new HoKhauService();
            NhanKhauService nhanKhauService = new NhanKhauService();
            HoKhau hoKhau = new HoKhau(0,"0","0","0");
            hoKhau.setSoHoKhau(soHoKhauMoi);
            hoKhau.setTenChuHo(tenChuHo);
            hoKhau.setMaKhuVuc(maKhuVuc);
            hoKhau.setDiaChi(diaChi);
            hoKhau.setNgayTao(ngayTao);
            hoKhau.setNgayChuyenDi(ngayChuyenDi);
            hoKhau.setLiDoChuyen(lyDoChuyen);
            hoKhau.setNguoiThucHien(nguoiThucHien);
            hoKhau.setGhiChu(ghiChu);
            if((hoKhauService.capNhatHoKhau(hoKhau, soHoKhauCu)==1)&&(nhanKhauService.capNhatSoHoKhau(soHoKhauCu, soHoKhauMoi)==1)){
                return 1;
            }else {
                return 0;
            }
        }
        
       public void timKiemHokhau(JComboBox comboboxTimKiem, JTable hoKhauTable, String txtKimKiem){
            HoKhauService hoKhauService = new HoKhauService();
            List<HoKhau> danhSachHoKhau = hoKhauService.layDanhSachHoKhau();
            List<HoKhau> ketQua=new ArrayList<HoKhau>();
            String selectedRow=(String)comboboxTimKiem.getSelectedItem();
            if(selectedRow.equals("Họ tên")){
                for(HoKhau i: danhSachHoKhau){
                    if(i.getTenChuHo().contains(txtKimKiem)){
                        ketQua.add(i);
                    }
                }
            }else if(selectedRow.equals("Địa chỉ")){
                for(HoKhau i: danhSachHoKhau){
                    if(i.getDiaChi().contains(txtKimKiem)){
                        ketQua.add(i);
                    }
                }
            }else if(selectedRow.equals("Số hộ khẩu")){
                int k = txtKimKiem.length();
                for(HoKhau i: danhSachHoKhau){
                    char[] id = new char[k];
                    i.getSoHoKhau().getChars(0, k, id, 0);
                    String sohokhau=String.copyValueOf(id);
                    if(sohokhau.equals(txtKimKiem)){
                        ketQua.add(i);
                    }
                }
            }
            DefaultTableModel df = (DefaultTableModel)hoKhauTable.getModel();
            df.setRowCount(0);
            for(HoKhau i: ketQua){
                df.addRow(new Object[]{i.getSoHoKhau(), i.getTenChuHo(), i.getDiaChi()});
            }
        }
}
