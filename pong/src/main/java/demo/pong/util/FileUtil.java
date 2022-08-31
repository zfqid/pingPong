package demo.pong.util;


import java.io.*;

public class FileUtil {
    public static String getFileContent( File file) {
        StringBuffer content = new StringBuffer("");
        try {
            try (FileInputStream in = new FileInputStream(file)) {
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line = "";
                while ((line = br.readLine()) != null) {
                    content.append(line);
                }
            }
        } catch (Exception e) {
        }
        return content.toString();
    }
}
