package utilities.database;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * ForeignKey
 */
// @XmlAccessorType(XmlAccessType.FIELD)
public class ForeignKey<T extends Row> {
    String id;

    @XmlTransient
    BangDuLieu<T> data;

    public ForeignKey(String id, BangDuLieu<T> data) {
        this.id = id;
        this.data = data;
    }

    public void set(String id) {
        this.id = id;
    }

    public T get() {
        for (T item : data.getData())
            if (item.getID().equals(id))
                return item;
        return null;
    }

    @Override
    public String toString() {
        return get().toString();
    }
}