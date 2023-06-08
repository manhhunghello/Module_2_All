package manager;

import java.io.*;

public class ViDuGhiDoiTuong {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/manhhung/hung/file.data");
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);

            SinhVien st = new SinhVien("HUNG","01", 1998, 10.5f );
            oos.writeObject(st);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
