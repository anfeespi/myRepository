package co.edu.unbosque.util;

import java.io.Serializable;
import java.time.temporal.Temporal;

public class ColumnModel implements Serializable {

    private String header;
    private String property;
    private String type;
    private Class<?> klazz;

    public ColumnModel(String header, String property, Class klazz) {
        this.header = header;
        this.property = property;
        this.klazz = klazz;
    }

    public String getHeader() {
        return header;
    }

    public String getProperty() {
        return property;
    }

    public String getType() {
        return type;
    }

    public Class<?> getKlazz() {
        return klazz;
    }
}
