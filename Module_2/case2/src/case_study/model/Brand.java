package case_study.model;

import java.io.Serializable;

public class Brand implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    public static int idUp1;
    private String brandName;

    public Brand() {
    }

    public Brand(String brandName) {
        this.id = ++idUp1;
        this.brandName = brandName;
    }

    public Brand(int id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + "," + brandName;
    }
}
