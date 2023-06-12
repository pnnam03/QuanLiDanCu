/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.NhanKhau;
import model.TamTru;
import model.TamVang;
import service.NhanKhauService;
import service.TamTruService;
import service.TamVangService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.HoKhau;
import model.ThuPhiDongGop;
import service.HoKhauService;
import service.KhoanThuService;
import service.ThuPhiDongGopService;

/**
 *
 * @author Minh
 */
public class ThongKeController extends javax.swing.JFrame {
    
    public void ThongKe(JTable tableJpn, JComboBox GenderJcb, JComboBox StatusJcb, JTextField tuTuoiJtf, JTextField denTuoiJtf,JLabel textCount) {
        int count = 0;
        NhanKhau nk = new NhanKhau();
        TamTru tt = new TamTru();
        TamVang tv = new TamVang();
        NhanKhauService nkdao = new NhanKhauService();
        TamTruService ttdao = new TamTruService();
        TamVangService tvdao = new TamVangService();
        List<NhanKhau> nks = new ArrayList<NhanKhau>();
        nks = nkdao.layDanhSachNhankhauAll();
        List<TamTru> tts = new ArrayList<TamTru>();
        tts = ttdao.layDanhSachTamTru();
        List<TamVang> tvs = new ArrayList<TamVang>();
        tvs = tvdao.layDanhSachTamVang();
        List<NhanKhau> res1 = new ArrayList<NhanKhau>();
        String selectedGender = (String) GenderJcb.getSelectedItem();
        String selectedStatus = (String) StatusJcb.getSelectedItem();
        int age1 = 0;
        int age2 = 5000;
        if (!tuTuoiJtf.getText().trim().isEmpty()) {
            age1 = Integer.parseInt(tuTuoiJtf.getText().trim());
        }        
        if (!denTuoiJtf.getText().trim().isEmpty()) {
            age2 = Integer.parseInt(denTuoiJtf.getText().trim());
        }
        if(selectedStatus.equalsIgnoreCase("Toàn bộ")) {
            for(NhanKhau i : nks){
                int age = tinhTuoi(i.getNgaySinh());
                if(age1 <= age && age <=age2){
                    if(selectedGender.equalsIgnoreCase(i.getGioiTinh())||selectedGender.equalsIgnoreCase("Toàn bộ")){
                        res1.add(i);
                        count++;
                    }
              }
            }
//            for(TamTru i : tts){
//               int age = tinhTuoi(i.getNgaysinh());
//                if(age1 <= age && age <=age2){
//                   if(selectedGender.equalsIgnoreCase(i.getGioitinh())||selectedGender.equalsIgnoreCase("Toàn bộ")){
//                        res2.add(i);
//                        count++;
//                   }
//                } 
//            }
        }else if(selectedStatus.equalsIgnoreCase("Thường trú")){
//            res1 = nkdao.xuatnhankhau();
            List<NhanKhau> tmp = new ArrayList<NhanKhau>();
            tmp =nkdao.layDanhSachNhankhauAll();
            
            for(int i=0; i<nks.size(); i++){
                for(int j=0; j<tvs.size(); j++){
                    if(nks.get(i).getMaDinhDanh().equals(tvs.get(j).getMaDinhDanh())){
                        tmp.remove(i);
//                        System.out.println(nks.get(i).getMaDinhDanh());
                    }
                }
            }
            for(int i=0; i<nks.size(); i++){
                for(int j=0; j<tts.size(); j++){
                    if(nks.get(i).getMaDinhDanh().equals(tts.get(j).getMaDinhDanh())){
                        tmp.remove(i);
//                        System.out.println(nks.get(i).getMaDinhDanh());
                    }
                }
            }
            for(NhanKhau i : tmp){
                int age = tinhTuoi(i.getNgaySinh());
                if(age1 <= age && age <=age2){
                    if(selectedGender.equals(i.getGioiTinh())||selectedGender.equals("Toàn bộ")){
                        res1.add(i);
                        count++;
                   }
                }
            }
            
        }else if(selectedStatus.equalsIgnoreCase("Tạm trú")) {
            List<NhanKhau> tmp = new ArrayList<NhanKhau>();
//            System.out.println(tts.size());
            for(NhanKhau i : nks) {
                
//                        System.out.print(i.getMaDinhDanh());
                for(TamTru j : tts) {
//                    if (i.getMaDinhDanh() == "NK0041")
                    if(i.getMaDinhDanh().equals(j.getMaDinhDanh())){
                        tmp.add(i);
                    }
                }
            }
            for(NhanKhau i : tmp) {
                int age = tinhTuoi(i.getNgaySinh());
                if(age1 <= age && age <=age2){
                    if(selectedGender.equalsIgnoreCase(i.getGioiTinh())||selectedGender.equalsIgnoreCase("Toàn bộ")){
                        res1.add(i);
                        count++;
                    }
                }
            }
        }else if(selectedStatus.equalsIgnoreCase("Tạm vắng")) {
            List<NhanKhau> tmp = new ArrayList<NhanKhau>();
            for(NhanKhau i : nks) {
                for(TamVang j : tvs) {
                    if(i.getMaDinhDanh().equals(j.getMaDinhDanh())){
                        tmp.add(i);
                    }
                }
            }
            for(NhanKhau i : tmp) {
                int age = tinhTuoi(i.getNgaySinh());
                if(age1 <= age && age <=age2){
                    if(selectedGender.equalsIgnoreCase(i.getGioiTinh())||selectedGender.equalsIgnoreCase("Toàn bộ")){
                        res1.add(i);
                        count++;
                    }
                }
            }
        }
        DefaultTableModel df = (DefaultTableModel)tableJpn.getModel();
        df.setRowCount(0);
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        for(NhanKhau i : res1){
            df.addRow(new Object[]{i.getMaDinhDanh(),i.getHoTen(),fmt.format(i.getNgaySinh()),i.getGioiTinh(),i.getDiaChiHienTai()});
        }
        textCount.setText(String.valueOf(count));
        
    }
    public int tinhTuoi(Date ngaysinh) {
        DateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        int d1 = Integer.parseInt(fmt.format(ngaysinh));
        Date date = new Date();
        int d2 = Integer.parseInt(fmt.format(date));
        return (d2-d1)/10000;
    }
    

}
