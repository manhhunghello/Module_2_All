package manager;

import java.io.Serializable;
import java.util.Objects;

public class SinhVien implements Comparable<SinhVien>, Serializable {
    private String hoVaTen;
    private String maSinhVien;
    private int namSinh;
    private float diemTrungBinh;

    public SinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public SinhVien(String hoVaTen, String maSinhVien, int namSinh, float diemTrungBinh) {
        this.hoVaTen = hoVaTen;
        this.maSinhVien = maSinhVien;
        this.namSinh = namSinh;
        this.diemTrungBinh = diemTrungBinh;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public float getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(float diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    @Override
    public String toString() {
        return "manager.SinhVien{" +
                "hoVaTen='" + hoVaTen + '\'' +
                ", maSinhVien='" + maSinhVien + '\'' +
                ", namSinh=" + namSinh +
                ", diemTrungBinh=" + diemTrungBinh +
                '}';
    }

    @Override
    public int compareTo(SinhVien o) {
        return this.maSinhVien.compareTo(o.maSinhVien);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinhVien sinhVien = (SinhVien) o;
        return Objects.equals(maSinhVien, sinhVien.maSinhVien);
    }

    @Override
    public int hashCode() {
        return 0;
    }


}
