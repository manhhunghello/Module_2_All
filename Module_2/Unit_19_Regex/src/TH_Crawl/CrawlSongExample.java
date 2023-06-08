package TH_Crawl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSongExample {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");
            // open the stream and put it into BufferedReader
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            //Phương thức openStream() được sử dụng để mở một luồng đầu vào từ một URL
            scanner.useDelimiter("\\Z");
            // Scanner sẽ đọc toàn bộ nội dung từ đầu vào cho đến khi gặp ký tự kết thúc (\\Z),
            // tức là đọc đến hết chuỗi hoặc file.
            String content = scanner.next();
            // close scanner
            scanner.close();
            // remove all new line
            content = content.replaceAll("\\n+", "");
            // regex
            Pattern p = Pattern.compile("name_song\">(.*?)</a>");
            // </a>": Đây là một chuỗi cụ thể khác mà biểu thức regex sẽ tìm kiếm.
            // Nó đại diện cho dấu đóng thẻ </a> sau nội dung mà chúng ta quan tâm.
            Matcher m = p.matcher(content);
            while (m.find()) {
                //Sử dụng phương thức find() của đối tượng Matcher để tìm các khớp của mẫu regex
                System.out.println(m.group(1));
                //Sau đó, sử dụng phương thức group(1) để lấy nội dung được bao quanh bởi cặp ngoặc đơn trong mẫu regex, tức là tên bài hát.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
