package arep.edu.eci;

import org.springframework.beans.factory.parsing.PassThroughSourceExtractor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConection {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static String GET_URL = "";
    private static final String SERVICE_ONE = "http://service1:8080/";
    private static final String SERVICE_TWO = "http://service1:8080/";

    public static void main(String[] args) throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
    }
    
    public void roundRobin(String path){
        if(GET_URL == ""){
            GET_URL = SERVICE_ONE + path;
        } else if (GET_URL.startsWith(SERVICE_ONE)) {
            GET_URL = SERVICE_TWO + path;
        }else {
            GET_URL = SERVICE_ONE + path;
        }
    }
}