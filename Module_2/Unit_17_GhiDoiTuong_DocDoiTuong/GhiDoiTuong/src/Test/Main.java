package Test;

import manager.DanhSachSinhVien;
import manager.SinhVien;

import java.io.File;
import java.util.Scanner;


// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DanhSachSinhVien dssv = new DanhSachSinhVien();
        int luachon ;
        do {
            System.out.println("-----------MENU----------");
            System.out.println("Vui lòng chọn chức năng: ");
            System.out.println(
                    """
                            1.	Thêm sinh viên vào danh sách.
                            2.	In danh sách sinh viên ra màn hình.
                            3.	Kiểm tra danh sách có rỗng hay không.
                            4.	Lấy ra số lượng sinh viên trong danh sách.
                            5.	Làm rỗng danh sách sinh viên.
                            6.	Kiểm tra sinh viên có tồn tại trong danh sách hay không, dựa trên mã sinh viên.
                            7.	Xóa một sinh viên ra khỏi danh sách dựa trên mã sinh viên.
                            8.	Tìm kiếm tất cả sinh viên dựa trên Tên được nhập từ bàn phím.
                            9.	Xuất ra danh sách sinh viên có điểm từ cao đến thấp.
                            10. lưu danh sách sinh viên xuống tập tin.
                            0.   Thoát khỏi chương trình""");


            luachon = Integer.parseInt(scanner.nextLine());
            if (luachon==1){
                System.out.println("Nhap mã Sinh Vien: "); String maSinhVien = scanner.nextLine();
                System.out.println("Nhap ho va ten: "); String hoVaTen = scanner.nextLine();
                System.out.println("Nhap nam sinh: "); int namSinh = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhap diem trung binh: "); float diemTrungBinh = Float.parseFloat(scanner.nextLine());
                SinhVien sv = new SinhVien(maSinhVien,hoVaTen,namSinh,diemTrungBinh);
                dssv.themSinhVien(sv);


            } else if (luachon==2) {
                dssv.inDanhSachSinhVien();
                
            } else if (luachon==3) {
                System.out.println("Danh sach rong: " + dssv.kiemTraDanhSachRong());
                
            } else if (luachon==4) {
                System.out.println("so luong hien tai: " + dssv.laySoLuongSinhVien());
                
            } else if (luachon==5) {
                dssv.lamRongDanhSanh();
            } else if (luachon==6) {
                System.out.println("Nhap mã Sinh Vien: "); String maSinhVien = scanner.nextLine();
                SinhVien sv = new SinhVien( maSinhVien);
                System.out.println("Kiem tra sinh vien co trong danh sach : " + dssv.kiemTraTonTai(sv));
            } else if (luachon==7) {
                System.out.println("Nhap mã Sinh Vien: "); String maSinhVien = scanner.nextLine();
                SinhVien sv = new SinhVien(maSinhVien);
                System.out.println(" Xoa Sinh vien: " + dssv.xoaSinhVien(sv));
            } else if (luachon==8) {
                System.out.println("Nhap ho va ten: "); String hoVaTen = scanner.nextLine();
                System.out.println("Ket qua tim kiem la: ");
                dssv.timSinhVien(hoVaTen);
                System.out.println();
            } else if (luachon==9) {
                dssv.sapXepSinhVienGiamDanTheoDiem();
                dssv.inDanhSachSinhVien();

            } else if (luachon == 10) {
                System.out.println("Nhập đường dẫn tên file");
               String tenFile = scanner.nextLine();
               File f = new File(tenFile);
               dssv.ghiDuLieuXuongFile(f);


            }


        }while (luachon !=0);
    }
}