package arep.edu.eci.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class ProxyService {

    private static final String USER_AGENT = "Mozilla/5.0";
    private String firstService;
    private String secondService;
    private String currentService;

    @Autowired
    public ProxyService() {
        this.firstService = "http://localhost:8081/";
        this.secondService = "http://localhost:8082/";
        this.currentService = firstService;
    }

    public String sendGetRequest(String path) throws IOException {
        //RoundRobin();
        String requestUrl = currentService + path;
        URL url = new URL(requestUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                return response.toString();
            }
        } else {
            throw new IOException("GET request failed with response code: " + responseCode);
        }
    }

    private void RoundRobin() {
        if (currentService.equals(firstService)) {
            currentService = secondService;
        } else {
            currentService = firstService;
        }
    }
}