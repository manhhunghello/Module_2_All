package DocDuLieu_TextTuFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ViDuDocText {
    public static void main(String[] args) {
        File f =  new File("/Users/manhhung/hung/file.txt");
        /* cach 1
        try {
            BufferedReader br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
            String line = null;
            while (true){
                line = br.readLine();
                if (line==null){
                    break;
                }else {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

         */

        /* Cach 2: Sử dụng luôn hàm readallLines   */

        File f2 =  new File("/Users/manhhung/hung/file.txt");
        try {
            List<String>  allText = Files.readAllLines(f2.toPath(),StandardCharsets.UTF_8);
            for (String line: allText) {
                System.out.println(line);
                
            }

        }catch (Exception e){
            e.printStackTrace();

        }



    }
}
