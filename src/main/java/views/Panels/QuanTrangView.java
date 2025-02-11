/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views.Panels;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import app.Tables;
//import entities.QuanNhan;
import entities.QuanTrang;
import utilities.views.Template;

/**
 *
 * @author ducmi
 */
public class QuanTrangView extends Template<QuanTrang> {

    /**
     * Creates new form java
     */

    public QuanTrangView() {
        super(Tables.quanTrang);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    protected void initComponents() {

        title = new JLabel();
        jScrollPane1 = new JScrollPane();
        table = new JTable();
        jLabel2 = new JLabel();
        idField = new JTextField();
        jLabel3 = new JLabel();
        maField = new JTextField();
        jLabel4 = new JLabel();
        tenField = new JTextField();
        suaBtn = new JButton();
        xoaBtn = new JButton();
        boBtn = new JButton();
        jLabel5 = new JLabel();
        nguoiField = new JTextField();
        jLabel6 = new JLabel();
        timField = new JTextField();
        themBtn = new JButton();
        xoaTkBtn = new JButton();
        timBtn = new JButton();
        jLabel7 = new JLabel();
        soLuongField = new JSpinner(new SpinnerNumberModel(1, 0, 20, 1));

        setMinimumSize(new Dimension(1000, 700));
        setLayout(new AbsoluteLayout());

        title.setFont(new Font("Segoe UI", 1, 36)); // NOI18N
        title.setText("QUÂN TRANG");
        add(title, new AbsoluteConstraints(30, 30, -1, -1));

        table.setModel(
                new DefaultTableModel(new Object[][] {},
                        new String[] { "ID", "Mã", "Tên Quân Trang", "Người Nhận", "Số Lượng" }) {
                    Class[] types = new Class[] { String.class, String.class, Integer.class, String.class,
                            String.class };
                    boolean[] canEdit = new boolean[] { false, false, false, false, false };

                    public Class getColumnClass(int columnIndex) {
                        return types[columnIndex];
                    }

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
        table.setColumnSelectionAllowed(true);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
        }

        add(jScrollPane1, new AbsoluteConstraints(440, 110, 560, 580));

        jLabel2.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("ID");
        add(jLabel2, new AbsoluteConstraints(50, 130, -1, -1));

        idField.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        idField.setEnabled(false);
        add(idField, new AbsoluteConstraints(40, 150, 380, 40));

        jLabel3.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("MÃ");
        add(jLabel3, new AbsoluteConstraints(50, 210, -1, -1));

        maField.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        add(maField, new AbsoluteConstraints(40, 230, 380, 40));

        jLabel4.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("TÊN QUÂN TRANG");
        add(jLabel4, new AbsoluteConstraints(50, 290, -1, -1));

        tenField.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        add(tenField, new AbsoluteConstraints(40, 310, 380, 40));

        suaBtn.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        suaBtn.setText("Sửa");
        add(suaBtn, new AbsoluteConstraints(250, 540, 170, 50));

        xoaBtn.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        xoaBtn.setText("Xóa");
        add(xoaBtn, new AbsoluteConstraints(40, 610, 170, 50));

        boBtn.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        boBtn.setText("Bỏ Chọn");
        add(boBtn, new AbsoluteConstraints(250, 610, 170, 50));

        jLabel5.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("NGƯỜI NHẬN");
        add(jLabel5, new AbsoluteConstraints(50, 370, -1, -1));

        nguoiField.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        add(nguoiField, new AbsoluteConstraints(40, 390, 380, 40));

        jLabel6.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tìm Kiếm Quân Trang");
        add(jLabel6, new AbsoluteConstraints(450, 30, 190, -1));

        timField.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        add(timField, new AbsoluteConstraints(440, 50, 310, 40));

        themBtn.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        themBtn.setText("Thêm");
        add(themBtn, new AbsoluteConstraints(40, 540, 170, 50));

        xoaTkBtn.setText("Xóa");
        add(xoaTkBtn, new AbsoluteConstraints(860, 50, 90, 40));

        timBtn.setText("Tìm Kiếm");
        add(timBtn, new AbsoluteConstraints(760, 50, 90, 40));

        jLabel7.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Số Lượng");
        add(jLabel7, new AbsoluteConstraints(50, 450, -1, -1));
        add(soLuongField, new AbsoluteConstraints(120, 450, 110, -1));

        initEvent();
        timBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<QuanTrang> res = new ArrayList<>();
                for (QuanTrang a : data.getData())
                    if (a.getTen().contains(timField.getText()))
                        res.add(a);
                displayData(res);
            }
        });
        xoaTkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetState();
                timField.setText("");
                displayData(data.getData());
            }
        });
    }

    // Variables declaration - do not modify
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JTextField maField;
    private JTextField tenField;
    private JTextField nguoiField;
    private JTextField timField;
    private JSpinner soLuongField;
    private JLabel title;
    private JButton xoaTkBtn;
    private JButton timBtn;

    // End of variables declaration
    @Override
    protected QuanTrang readField() {
        List<String> params = new ArrayList<>();
        params.add(idField.getText());
        params.add(maField.getText());
        params.add(tenField.getText());
        params.add(nguoiField.getText());
        params.add(String.valueOf(soLuongField.getModel().getValue()));

        return new QuanTrang(params);
    }

    @Override
    protected QuanTrang readField(List<String> list) {
        return new QuanTrang(list);
    }

    @Override
    protected void updateRemainField(List<String> list) {
        maField.setText(list.get(1));
        tenField.setText(list.get(2));
        nguoiField.setText(list.get(3));
        soLuongField.getModel().setValue(Integer.parseInt(list.get(4)));
    }

    @Override
    protected void resetFieldState() {
        maField.setText("");
        tenField.setText("");
        nguoiField.setText("");
        soLuongField.getModel().setValue(1);
    }
}
