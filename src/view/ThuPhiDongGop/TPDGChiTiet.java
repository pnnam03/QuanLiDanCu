/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.ThuPhiDongGop;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.NhanKhau;
import model.ThuPhiDongGop;
import service.KhoanThuService;
import service.NhanKhauService;
import static service.NhanKhauService.soNhanKhauTrong1Ho;
import service.ThuPhiDongGopService;

/**
 *
 * @author phamd
 */
public class TPDGChiTiet extends javax.swing.JFrame {

    /**
     * Creates new form TPDGChiTiet
     */
    
    private String shk;
    private String tch;
    
    
    public void autoUpdate() {
        ThuPhiDongGopService tpdgsv = new ThuPhiDongGopService();
        KhoanThuService ktsv = new KhoanThuService();
        ArrayList<ThuPhiDongGop> list = tpdgsv.dsDaThu1Ho(shk);
        DefaultTableModel df = (DefaultTableModel)tableDaNop.getModel();
        df.setRowCount(0);
        
        int cntnhankhau = soNhanKhauTrong1Ho(shk);
        
        for (ThuPhiDongGop i : list) {
            String s = i.getIDKhoanThu();
            String dot = ktsv.getTenKhoanThu(s);
            
            
                
            int result = 0;
            
            result += ktsv.getSoTien(s,cntnhankhau);
            result += i.getSoLuong();
            
            df.addRow(new Object[]{dot, result, ktsv.getHinhThucThu(s)});
        }
        
        labelCntNhanKhau.setText(String.valueOf(cntnhankhau));
    }
    
    
    public TPDGChiTiet(String sohokhau, String tenchuho) {
        initComponents();
        labelSoHoKhau.setText(sohokhau);
        labelTenChuHo.setText(tenchuho);
        
        shk = sohokhau;
        tch = tenchuho;
        
        autoUpdate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableDaNop = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelSoHoKhau = new javax.swing.JLabel();
        labelTenChuHo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelCntNhanKhau = new javax.swing.JLabel();
        btnNop = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chi tiết thu phí đóng góp");

        tableDaNop.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableDaNop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Đợt", "Số tiền đã nộp", "Hình thức thu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDaNop.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableDaNop);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Số hộ khẩu: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tên chủ hộ");

        labelSoHoKhau.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelSoHoKhau.setText("                                        ");

        labelTenChuHo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelTenChuHo.setText("                                           ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Số nhân khẩu trong hộ: ");

        labelCntNhanKhau.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelCntNhanKhau.setText("                             ");

        btnNop.setText("Nộp");
        btnNop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNopActionPerformed(evt);
            }
        });

        jButton1.setText("Cập nhật trạng thái ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelTenChuHo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelSoHoKhau))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelCntNhanKhau)))
                        .addGap(0, 107, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnNop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelSoHoKhau))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelTenChuHo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelCntNhanKhau))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNop)
                    .addComponent(jButton1))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNopActionPerformed
        // TODO add your handling code here:
        new NopPhiDongGop(shk,tch).setVisible(true);
    }//GEN-LAST:event_btnNopActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        autoUpdate();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TPDGChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TPDGChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TPDGChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TPDGChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TPDGChiTiet("","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNop;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCntNhanKhau;
    private javax.swing.JLabel labelSoHoKhau;
    private javax.swing.JLabel labelTenChuHo;
    private javax.swing.JTable tableDaNop;
    // End of variables declaration//GEN-END:variables
}
