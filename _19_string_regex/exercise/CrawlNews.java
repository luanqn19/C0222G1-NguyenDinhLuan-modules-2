package _19_string_regex.exercise;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNews {
    public static void main (String[] args) {
        try {
            URL url = new URL("https://dantri.com.vn/the-gioi.htm");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();

            // remove all new line
            content = content.replaceAll("\\n+", "");

            // regex
            Pattern p = Pattern.compile("article-title\">(.*?)</h3>");
            Matcher m = p.matcher(content);
            while (m.find()) {
                Pattern p1 = Pattern.compile("<[a][^>]*>(.+?)</[a]>");
                Matcher m1 = p1.matcher(m.group(1));
                while (m1.find()){
                    System.out.println(m1.group(1));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
