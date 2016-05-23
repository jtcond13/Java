import java.io.*;
import java.net.*;
import org.apache.http.*;

public class market {
    public static void main(String[] args) throws Exception {
      String url = "https://api.stockfighter.io/ob/api/";
      String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()
      String venue = "TESTEX";
      String stock = "FOOBAR";
      // ...

    String query = String.format("venue=%s&stock=%s",
       URLEncoder.encode(param1, charset),
       URLEncoder.encode(param2, charset));
        }

    URLConnection connection = new URL(url + "?" + query).openConnection();

}

}
