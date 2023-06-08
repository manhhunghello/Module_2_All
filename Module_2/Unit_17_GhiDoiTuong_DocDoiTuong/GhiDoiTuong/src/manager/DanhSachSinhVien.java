package manager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSinhVien {
    private ArrayList<SinhVien> danhSach;

    public DanhSachSinhVien() {
        this.danhSach = new ArrayList<SinhVien>();// <> đánh vào tên class muốn sử dụng: genary
    }

    public DanhSachSinhVien(ArrayList<SinhVien> danhSach) {
        this.danhSach = danhSach;
    }

    public void themSinhVien(SinhVien sv) {
        this.danhSach.add(sv);

    }

    // 2.	In danh sách sinh viên ra màn hình
    public void inDanhSachSinhVien() {
        for (SinhVien sinhVien : danhSach) {
            System.out.println(sinhVien);
        }
    }

    public boolean kiemTraDanhSachRong() {
        return this.danhSach.isEmpty();
    }

    public int laySoLuongSinhVien() {
        return this.danhSach.size();
    }

    public void lamRongDanhSanh() {
        this.danhSach.removeAll(danhSach);
    }

    public boolean kiemTraTonTai(SinhVien sv) {
        return this.danhSach.contains(sv);
    }

    public boolean xoaSinhVien(SinhVien sv) {
        return this.danhSach.remove(sv);
    }

    public void timSinhVien(String ten) {
        for (SinhVien sinhVien : danhSach) {
            if (sinhVien.getHoVaTen().indexOf(ten) >= 0) {
                System.out.println(sinhVien);
            }

        }
    }

    public void sapXepSinhVienGiamDanTheoDiem() {
        //Trong Java, khi sử dụng phương thức compare() trong Comparator,
        //    ta cần trả về một giá trị số nguyên để xác định quan hệ giữa hai đối tượng so sánh.
        Collections.sort(this.danhSach, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                if (sv1.getDiemTrungBinh() < sv2.getDiemTrungBinh()) {
                    return -1;
                } else if (sv1.getDiemTrungBinh() > sv2.getDiemTrungBinh()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }


    //    10. lưu danh sách sinh viên xuống tập tin.
    public void ghiDuLieuXuongFile(File  file) {
        try {

            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);

            for (SinhVien sinhVien : danhSach) {
                oos.writeObject(sinhVien);
            }
            oos.flush();
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
