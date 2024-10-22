package utilities.database;

import java.util.List;

public abstract class Row {
    protected String id;

    public Row() {
    }

    public Row(List<Object> row) {
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public abstract Object[] export();

    public abstract String toString();
}
