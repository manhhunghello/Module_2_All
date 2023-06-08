import java.io.File;
import java.io.IOException;

public class demo {
    public static void main(String[] args) {
        // lưu ý:
        // Trên hệ điều hành window: \ -> \\ | Ví dụ: "C:\\Thu muc 1 \\ thu muc \\ten tap tin.xxx";
        // Linux, Macos: / | Ví dụ /thu muc 1/thu muc 2/ten tap tin.xxx"

        // Kiểm tra thư mục hoặc tập tinh có tồn tại hay không
        File folder1 = new File("/Users/manhhung");
        File folder2 = new File("/Users/manhhung/ABC.ext");
        System.out.println(" kiểm tra folder1 có tồn tại hay không: " + folder1.exists());
        System.out.println(" kiểm tra folder1 có tồn tại hay không: " + folder2.exists());

        // Tạo thư mục
        // Phương thức mkdir()
        File d1 = new File("/Users/manhhung/hung/Directory_1");
        d1.mkdir();

        // Phương thưc mkdir() -> Tạo nhiều thư mục cùng lúc
        File d2 = new File("/Users/manhhung/hung/Directory_1/Directory_2/Directory_3");
        d2.mkdirs();

        // Tạo tập tin ( có phần mở rộng: exe, .txt,.doc,.xls... )
        File file1 = new File("/Users/manhhung/hung/Directory_1/Vidu.txt");
        File file2 = new File("\\Users\\manhhung\\hung\\Directory_1\\Vidu2.txt");
        try {
            file1.createNewFile();
            file2.createNewFile();
        } catch (IOException e) {
            // không có quyền tạo tập tin:
            // Ổ cứng bị đầy
            // Đường dẫn lỗi

            e.printStackTrace();
//            throw new RuntimeException(e);
        }


    }
}
