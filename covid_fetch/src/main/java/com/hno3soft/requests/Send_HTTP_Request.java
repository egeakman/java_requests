package com.hno3soft.requests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Send_HTTP_Request {
    public static void main(String[] args) {
        try {
            Send_HTTP_Request.fetch_data();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fetch_data() throws Exception {
        String url = "http://httpbin.org/ip";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // define method
        con.setRequestMethod("GET");

        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // print without json
        System.out.println(response.toString());

        // read JSON response
        JSONObject jsonResponse = new JSONObject(response.toString());

    }
}