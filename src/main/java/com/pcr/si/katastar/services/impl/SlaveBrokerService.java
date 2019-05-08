package com.pcr.si.katastar.services.impl;

import com.pcr.si.katastar.services.BrokerService;
import com.pcr.si.katastar.services.dtos.HttpMethod;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SlaveBrokerService implements BrokerService {

    private final String SLAVE_BROKER_BASE_URL = "http://localhost:5000";

    @Override
    public void removeService() {
        try {
            makeRequest(HttpMethod.DELETE, "services/katastar", "");
        } catch (IOException|URISyntaxException e) {
            System.out.println("Failed to remove the service.");
            e.printStackTrace();
        }
    }

    @Override
    public void registerService() {
        try {
            Path path = Paths.get(getClass().getClassLoader()
                    .getResource("service_description.json").toURI());
            Stream<String> lines = Files.lines(path);
            String description = lines.collect(Collectors.joining("\n"));
            lines.close();
            makeRequest(HttpMethod.POST, "services", description);
        } catch (IOException|URISyntaxException e) {
            System.out.println("Failed to register the service.");
            e.printStackTrace();
        }
    }

    @Override
    public String invoke(HttpMethod method, String serviceName, String body) {
        try {
            return makeRequest(method, "services/"+serviceName, body);
        } catch (IOException|URISyntaxException e) {
            System.out.println("Failed to invoke the service.");
            e.printStackTrace();
        }
        return null;
    }

    private String makeRequest(HttpMethod method, String path, String body) throws IOException, URISyntaxException {
        URI baseUri = new URI(SLAVE_BROKER_BASE_URL);
        URI uri = baseUri.resolve("/" + path);
        URL url = uri.toURL();
        System.out.println(url.toString());
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        String methodStr = "";
        switch (method) {
            case POST: methodStr = "POST"; break;
            case GET: methodStr = "GET"; break;
            case PUT: methodStr = "PUT"; break;
            case DELETE: methodStr = "DELETE"; break;
        }
        System.out.println(methodStr);
        System.out.println(path);
        System.out.println(body);
        con.setRequestMethod(methodStr);
        con.setRequestProperty("Content-Type", "application/json");

        if (method == HttpMethod.POST || method == HttpMethod.PUT) {
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(body.getBytes());
            os.close();
        }

        int responseCode = con.getResponseCode();
        InputStream is = responseCode == 200 ? con.getInputStream() : con.getErrorStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());

        return response.toString();
    }


}
