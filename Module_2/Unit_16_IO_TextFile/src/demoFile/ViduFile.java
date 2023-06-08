package demoFile;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class ViduFile {
    File file;

    public ViduFile(String tenFile) {
        this.file = new File(tenFile);
    }

    public boolean kiemTraThucThi() {
        return this.file.canExecute();
    }

    public boolean kiemTraDoc() {
        return this.file.canRead();
    }

    public boolean kiemTraGhi() {
        return this.file.canWrite();
    }

    public void inDuongDan() {
        System.out.println(this.file.getAbsolutePath());

    }
    public void inTen(){
        System.out.println(this.file.getName());
    }
    public void kiemTraLaThuMucHoacTapTin(){
        if (this.file.isDirectory()){
            System.out.println("Day la thu muc");
        }
        else if (this.file.isFile()){
            System.out.println("day la tap tin");
        }
    }
    public void inDanhSachFileCon() {
        if (this.file.isDirectory()) {
            System.out.println("Các tập tin con/ thư mục con là:");
            File[] mangCon = this.file.listFiles();
            for (File file : mangCon) {
                System.out.println(file.getAbsolutePath() + file.getName());
            }
        } else if (this.file.isFile()) {
            System.out.println("Đây là tập tin, không có dữ liệu con bên trong.");
        }
    }

        public void inCayThuMuc() {
            this.inChiTietCayThucMuc(this.file, 1);
        }
        public void inChiTietCayThucMuc(File f, int bac) {
//		System.out.print("|");
            for (int i = 0; i < bac; i++) {
                System.out.print("\t");
            }
            System.out.print("|__");
            System.out.println(f.getName());
            if (f.canRead()&&f.isDirectory()) {
                File[] mangCon = f.listFiles();
                for (File fx: mangCon) {
                    inChiTietCayThucMuc(fx, bac+1);

                }
            }

        }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int luachon = 0;
        System.out.println("Nhap ten file:");
        String tenFile = scanner.nextLine();
        ViduFile vdf = new ViduFile(tenFile);
        do {
            System.out.println("------Menu------");
            System.out.println("1.Kiem tra file co the thuc thi");
            System.out.println("2.Kiem tra file co the đọc");
            System.out.println("3.Kiem tra file co the ghi");
            System.out.println("4.In Đường dẫn");
            System.out.println("5.In tên file");
            System.out.println("6.Kiem tra file là thu muc hay tập tin");
            System.out.println("7.In ra danh sach file con");
            System.out.println("8.In ra cây thư mục");
            System.out.println("0.Thoát");
            luachon = Integer.parseInt(scanner.nextLine());
            switch (luachon) {
                case 1:
                    System.out.println(vdf.kiemTraThucThi());
                    break;
                case 2:
                    System.out.println(vdf.kiemTraDoc());
                    break;
                case 3:
                    System.out.println(vdf.kiemTraGhi());
                    break;
                case 4:
                    vdf.inDuongDan();

                    break;
                case 5:
                    vdf.inTen();
                    break;
                case 6:
                    vdf.kiemTraLaThuMucHoacTapTin();
                    break;
                case 7:
                    vdf.inDanhSachFileCon();
                    break;
                case 8:
                    vdf.inCayThuMuc();
                    break;
                default:

            }

        } while (luachon != 0);
    }
}
