package utilities.views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import utilities.Randoms;
import utilities.database.BangDuLieu;
import utilities.database.Row;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

public abstract class Template<T extends Row> extends JPanel {
    protected JTextField idField;
    protected JButton suaBtn;
    protected JButton themBtn;
    protected JButton xoaBtn;
    protected JButton boBtn;
    protected JTable table;
    protected JScrollPane jScrollPane1;

    protected T temp = null;

    protected BangDuLieu<T> data;

    public Template(BangDuLieu<T> data) {
        this.data = data;
    }

    protected abstract T readField();

    protected abstract T readField(List<String> list);

    protected abstract void updateRemainField(List<String> list);

    protected abstract void resetFieldState();

    private void updateField(List<String> list) {
        idField.setText(list.get(0));
        updateRemainField(list);
    }

    protected void initEvent() {
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setBtnState(false);
                List<String> result = getSelectedRow(e);
                if (result == null)
                    return;

                updateField(result);
                temp = readField(result);
            }
        });
        themBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themBtnActionPerformed(e);
            }
        });
        boBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boBtnActionPerformed(e);
            }
        });
        suaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suaBtnActionPerformed(e);
            }
        });
        xoaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoaBtnActionPerformed(e);
            }
        });

    }

    protected void setBtnState(boolean state) {
        themBtn.setEnabled(state);
        suaBtn.setEnabled(!state);
        xoaBtn.setEnabled(!state);
        boBtn.setEnabled(!state);
    }

    protected List<String> getSelectedRow(MouseEvent e) {
        JTable target = (JTable) e.getSource();
        int row = target.getSelectedRow();
        if (row == -1)
            return null;

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        List<String> x = new ArrayList<>();
        for (int i = 0; i < model.getColumnCount(); ++i)
            x.add(String.valueOf(model.getValueAt(row, i)));

        return x;
    }

    @SuppressWarnings("unchecked")
    public void displayData(List<T> data) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        model.setRowCount(0);

        for (Row a : data) {
            if (a != null)
                model.addRow(((T) a).export());

        }

    }

    protected void resetState() {
        temp = null;
        setBtnState(true);
        idField.setText(Randoms.randString(10));
        resetFieldState();
        displayData(data.getData());
    }

    public T getTemp() {
        return temp;
    }

    protected void boBtnActionPerformed(ActionEvent evt) {
        resetState();
    }

    protected void suaBtnActionPerformed(ActionEvent evt) {
        data.sua(readField());
        resetState();
    }

    protected void themBtnActionPerformed(ActionEvent evt) {
        data.them(readField());
        resetState();
    }

    protected void xoaBtnActionPerformed(ActionEvent evt) {
        data.xoa(temp.getID());
        resetState();
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b == true)
            resetState();
    }
}
