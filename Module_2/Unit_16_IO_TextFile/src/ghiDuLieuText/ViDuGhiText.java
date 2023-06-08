package ghiDuLieuText;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class ViDuGhiText {
    public static void main(String[] args) {

        try {
            PrintWriter pw = new PrintWriter("/Users/manhhung/hung/file.txt", "UTF-8");
            pw.println("Xin chào, mình là Hùng");
            pw.println("Du lieu: ");
            pw.print(3.14);
            pw.print(' '); //char là dấu nháy đơn
            pw.print("La so PI");
            pw.println();

            Student st = new Student(100, "ABC D");
            pw.println(st);
            pw.println();
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();


        }
    }
}
