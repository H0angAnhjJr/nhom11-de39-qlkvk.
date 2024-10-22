package utilities.database;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import entities.*;
//import entities.deprecated.CapBac;

public class BangDuLieu<T extends Row> {
    String src;
    Wrapper<T> data;

    public BangDuLieu(String prefix) {
        this.src = String.format("database/%s.xml", this.getClass().getSimpleName() + prefix);
        FileUtils.CreateFile(src);
        read();
    }

    public T getById(String id) {
        for (T item : data.getData())
            if (item.getID().equals(id))
                return item;
        return null;
    }

    @SuppressWarnings("unchecked")
    public void read() {
        data = (Wrapper<T>) FileUtils.readXMLFile(src, Wrapper.class);
        if (data == null)
            data = new Wrapper<>(null);
    }

    public void write() {
        FileUtils.writeXMLtoFile(src, data);
    }

    public List<T> getData() {
        return data.getData();
    }

    public void them(T item) {
        data.getData().add(item);
        write();
    }

    public void sua(T item) {
        for (int i = 0; i < data.data.size(); ++i) {
            if (data.data.get(i).getID().equals(item.getID())) {
                data.data.set(i, item);
                break;
            }
        }
        write();
    }

    public void xoa(String id) {
        for (int i = 0; i < data.data.size(); ++i) {
            if (id.equals(data.data.get(i).getID())) {
                data.data.remove(i);
                break;
            }
        }
        write();
    }
}

@XmlRootElement(name = "wrapper")
@XmlAccessorType(XmlAccessType.FIELD)
class Wrapper<T extends Row> {
    @XmlElementWrapper(name = "data")
    @XmlElements({
            @XmlElement(name = "TrangBi", type = QuanTrang.class),
    })
    List<T> data;

    public Wrapper() {
    }

    public Wrapper(Object obj) {
        this.data = new ArrayList<>();
    }

    public List<String> getStringVals() {
        List<String> a = new ArrayList<>();
        for (T i : data)
            a.add(i.toString());

        return a;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
