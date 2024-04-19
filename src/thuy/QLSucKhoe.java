/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package thuy;

import dao.danhsachdongvatDao;
import dao.quanlysuckhoeDao;
import entity.danhsachdongvat;
import entity.lichsutiemphong;
import entity.quanlysuckhoe;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import uliti.Dialog;

/**
 *
 * @author Hieu
 */
public class QLSucKhoe extends javax.swing.JDialog {
    int row = -1;
    boolean isvalidate = false;
    List<quanlysuckhoe> lstql;
    List<danhsachdongvat> lstds;
    quanlysuckhoeDao daoql;
    danhsachdongvatDao daods;

    /**
     * Creates new form quanlysuckhoeJDialog
     */
    public QLSucKhoe(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        setTitle("QL Sức Khoẻ");
        setLocationRelativeTo(null);
        daoql = new quanlysuckhoeDao();
        daods = new danhsachdongvatDao();
        filltable();
        fillCbb();
    }

    public void moi() {
        txt_maQL.setText("");
        txt_TinhTrang.setText("");
        txt_Thuocsd.setText("");
        txt_ngaytao.setText("");
        txt_ghiChu.setText("");
        cbb_Dv.setSelectedIndex(0);
        row = -1;
    }

    public void fillCbb() {
        lstds = daods.getAllData();
        cbb_Dv.removeAllItems();
        for (danhsachdongvat object : lstds) {
            cbb_Dv.addItem(object.getTendv());
        }
    }

    public int getIDDv() {
        int index = cbb_Dv.getSelectedIndex();
        lstds = daods.getAllData();
        danhsachdongvat a = lstds.get(index);
        return a.getId();
    }

    public void add()  {
        quanlysuckhoe a = getForm();
        if (!isvalidate) {
            return;
        }
        daoql.addData(a);
        filltable();
    }
//

    public void sua()  {
        if (row < 0) {
            Dialog.mess("Vui Lòng Chọn Trường Dữ Liệu Để Thao Tác");
            return;
        }
        quanlysuckhoe a = getForm();
        if (!isvalidate) {
            return;
        }
        daoql.updateData(a);
        filltable();
    }
//

    public void xoa() {
        if (row < 0) {
            Dialog.mess("Vui Lòng Chọn Trường Dữ Liệu Để Thao Tác");
            return;
        }
        quanlysuckhoe a = getForm();
        daoql.deleteData(a);
        filltable();
    }
//

    public quanlysuckhoe getForm()  {
        row = tbl_SucKhoe.getSelectedRow();
        quanlysuckhoe a = new quanlysuckhoe();
        if (row != -1) {
            int id = (int) tbl_SucKhoe.getValueAt(row, 0);
            a.setId(id);
        }
        String maql = txt_maQL.getText();
        String Id_dongvat = String.valueOf(getIDDv());
        String Tinhtrangsuckhoe = txt_TinhTrang.getText();
        String Thuocdasudung = txt_Thuocsd.getText();
        String Ghichu = txt_ghiChu.getText();
        String Ngaytao = txt_ngaytao.getText();
        String[] strs = {maql,Tinhtrangsuckhoe,Thuocdasudung,Ghichu,Ngaytao};
        isvalidate = uliti.validate.Validate(strs, strs.length);
        a.setMaql(maql);
        a.setId_dongvat(getIDDv());
        a.setTinhtrangsuckhoe(Tinhtrangsuckhoe);
        a.setThuocdasudung(Thuocdasudung);
        a.setGhichu(Ghichu);
        try {
            a.setNgaytao(uliti.DateUliti.stringToDate(Ngaytao, "dd/MM/yyyy"));
        } catch (Exception e) {
        }
        return a;
    }
//

    public void setForm(int index) {
        lstql = daoql.getAllData();
        if (lstql.isEmpty()) {
            System.out.println("Danh Sách Trống");
            return;
        }
        quanlysuckhoe a = lstql.get(index);
        txt_maQL.setText(a.getMaql());
        txt_TinhTrang.setText(a.getTinhtrangsuckhoe());
        txt_Thuocsd.setText(a.getThuocdasudung());
        txt_ghiChu.setText(a.getGhichu());
        txt_ngaytao.setText(uliti.DateUliti.dateToString(a.getNgaytao(), "dd/MM/yyyy"));
        cbb_Dv.setSelectedItem(a.getTendv());
    }

    public void filltable() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tbl_SucKhoe.getModel();
        defaultTableModel.setRowCount(0);
        lstql = daoql.getAllData();
        if (lstql.isEmpty()) {
            System.out.println("Danh Sách Trống");
            return;
        }
        int i = 0;
        for (quanlysuckhoe object : lstql) {
            i++;
            Object[] row = {
                object.getId(),
                object.getMaql(),
                object.getTendv(),
                object.getTinhtrangsuckhoe(),
                object.getThuocdasudung(),
                object.getNgaytao(),
                object.getTrangthai() == 1 ? "Tạm Chưa Nghĩ Ra" : "aa"
            };
            defaultTableModel.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_maQL = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_TinhTrang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_Thuocsd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_ghiChu = new javax.swing.JTextArea();
        txt_ngaytao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_SucKhoe = new javax.swing.JTable();
        btn_Them = new javax.swing.JButton();
        btn_moi = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        cbb_Dv = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Mã QL");

        jLabel2.setText("Tình Trạng Sức Khoẻ");

        jLabel3.setText("Thuốc Đã Sử Dụng");

        jLabel4.setText("Ghi Chú");

        txt_ghiChu.setColumns(20);
        txt_ghiChu.setRows(5);
        jScrollPane1.setViewportView(txt_ghiChu);

        jLabel5.setText("Ngày Tạo");

        tbl_SucKhoe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã QL", "Tên DV", "Tình Trạng", "Thuốc Sd", "Ngày Tạo", "Trạng Thái"
            }
        ));
        tbl_SucKhoe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SucKhoeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_SucKhoe);

        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        btn_moi.setText("Mới");
        btn_moi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moiActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xoá");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        cbb_Dv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Tên ĐV");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(txt_maQL)
                        .addComponent(jLabel2)
                        .addComponent(txt_TinhTrang, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addComponent(txt_Thuocsd, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txt_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Them)
                        .addGap(18, 18, 18)
                        .addComponent(btn_sua)
                        .addGap(18, 18, 18)
                        .addComponent(btn_xoa))
                    .addComponent(btn_moi)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbb_Dv, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_maQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_TinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Thuocsd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbb_Dv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Them)
                            .addComponent(btn_sua)
                            .addComponent(btn_xoa))
                        .addGap(18, 18, 18)
                        .addComponent(btn_moi))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed

            // TODO add your handling code here:
            add();
    
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_moiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moiActionPerformed
        // TODO add your handling code here:
        moi();
    }//GEN-LAST:event_btn_moiActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed

            // TODO add your handling code here:
            sua();

    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
 
            // TODO add your handling code here:
            xoa();

    }//GEN-LAST:event_btn_xoaActionPerformed

    private void tbl_SucKhoeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SucKhoeMouseClicked
        // TODO add your handling code here:
        row = tbl_SucKhoe.getSelectedRow();
        setForm(row);
    }//GEN-LAST:event_tbl_SucKhoeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_moi;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cbb_Dv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_SucKhoe;
    private javax.swing.JTextField txt_Thuocsd;
    private javax.swing.JTextField txt_TinhTrang;
    private javax.swing.JTextArea txt_ghiChu;
    private javax.swing.JTextField txt_maQL;
    private javax.swing.JTextField txt_ngaytao;
    // End of variables declaration//GEN-END:variables
}
