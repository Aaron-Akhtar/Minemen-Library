package tech.akhtar.minemen;

import com.sun.javafx.binding.StringFormatter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Web {
    private static String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36";
    public static String MINEMEN_URL = "https://minemen.com";

    /***
     *
     * @param urlPath the target url path without the initial web url [example: "/home" rather than "https://minemen.com/home"]
     * @return List of Strings containing the links source code
     */
    public static List<String> getWebSourceCode(String urlPath){
        List<String> source = new ArrayList<String>();
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(MINEMEN_URL + urlPath).openConnection();
            try (AutoCloseable autoCloseable = () -> connection.disconnect()) {
                connection.addRequestProperty("User-Agent", USER_AGENT);
                connection.addRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                connection.setRequestMethod("GET");
                try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
                    String x;
                    while((x = reader.readLine()) != null){
                        source.add(x);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return source;
    }

}
