import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo {
    public static void main(String[] args) {
        boolean a = "Java is fun".matches("Java.*");
        boolean b = "Java is cool".matches("Java.*");
        boolean c = "Java is powerful".matches("Java.*");

        System.out.println("a:" +  a);
        System.out.println("b:" +  b);
        System.out.println("c:" +  c);

        System.out.println("-------------------------------------------\n");



        String text1 = "Hello java regex 2-12-2018, hello world 12/12/2018";

        Pattern pattern = Pattern.compile("\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}");

        Matcher matcher = pattern.matcher(text1);

        System.out.println("Ngày tháng trong chuỗi text1: " + text1);

        while (matcher.find()) {
            //  matcher.start() và matcher.end() để lấy vị trí bắt đầu và kết thúc
            //Sau đó, chúng ta sử dụng phương thức substring() để trích xuất chuỗi con từ chuỗi gốc
            // bằng cách truyền vào vị trí bắt đầu và kết thúc.
            System.out.println(text1.substring(matcher.start(), matcher.end()));

        }


        String text2 = "2/12/2018";

        String text3 = "12/12/aaaa";

        pattern = Pattern.compile("^\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}$");
        // kiểm tra xem một chuỗi nhất định có khớp với định dạng ngày tháng không.
        // Nếu chuỗi khớp với mẫu Regex, matcher.matches() sẽ trả về true, ngược lại
        // sẽ trả về false.

        System.out.println("\nChuỗi " + text2 + " có định dạng ngày tháng: "

                + pattern.matcher(text2).matches());


        System.out.println("Chuỗi " + text3 + " có định dạng ngày tháng: "

                + pattern.matcher(text3).matches());



        System.out.println("-------------------------------------------\n");
        System.out.println("-------------------------------------------\n");



        /////////////////   Thay thế và tách chuỗi ////////////////////

        System.out.println("Java Java Java".replaceAll("v\\w", "wi"));


        System.out.println("Java Java Java".replaceFirst("v\\w", "wi"));

        System.out.println("-------------------------------------------\n");
        System.out.println("-------------------------------------------\n");


        /////////////////   Tạo động tượng Stirng bằng Literal và Từ Khoá New ////////////////////
        // write your code here
        String s1 = "java";//Tạo chuỗi bằng string literal
        char ch[] = { 's', 't', 'r', 'i', 'n', 'g', 's' };
        String s2 = new String(ch);//convert mảng char thành chuỗi
        String s3 = new String("example");//Tạo chuỗi bằng từ khóa new
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

    }
}
