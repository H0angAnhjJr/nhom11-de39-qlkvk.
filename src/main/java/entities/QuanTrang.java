package entities;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import utilities.database.Row;

@XmlAccessorType(XmlAccessType.FIELD)
public class QuanTrang extends Row {
    String ma;
    String ten;
    String nguoiNhan;
    int soLuong;

    public QuanTrang() {
    }

    public QuanTrang(List<String> params) {
        this.id = params.get(0);
        this.ma = params.get(1);
        this.ten = params.get(2);
        this.nguoiNhan = params.get(3);
        this.soLuong = Integer.parseInt(params.get(4));
    }

    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public void setMa(String maMon) {
        this.ma = maMon;
    }

    public void setTen(String tenMon) {
        this.ten = tenMon;
    }

    @Override
    public Object[] export() {
        return new Object[] { id, ma, ten, nguoiNhan, soLuong };
    }

    @Override
    public String toString() {
        return ten;
    }
}
