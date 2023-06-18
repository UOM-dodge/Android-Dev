package com.example.curemeapp;

import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpHandler {

    public OkHttpHandler() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }



    String setPatientRequest(String url) throws Exception{
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        RequestBody body = RequestBody.create(" ", MediaType.parse("text/plain"));
        Request request = new Request.Builder().url(url).method("POST", body).build();
        Response response = client.newCall(request).execute();
        String data = response.body().string();
        System.out.println("My response: " + data);

        return data;
    }

    public List<Event> requestUpcomingVisits(String url) throws Exception{
        List<Event> events = new ArrayList<>();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        RequestBody body = RequestBody.create(" ", MediaType.parse("text/plain"));
        Request request = new Request.Builder().url(url).method("POST", body).build();
        Response response = client.newCall(request).execute();
        String data = response.body().string();
        System.out.println("My response: " + data);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {
            JSONArray jsonArray = new JSONArray(data);

            for (int i=0; i<jsonArray.length(); i++){
                JSONObject json = jsonArray.getJSONObject(i);

                String serviceName = json.getString("service_name");
                String price = json.getString("service_price");
                LocalDateTime dateTime = LocalDateTime.parse(json.getString("visit_date"), f);
                String itemID = json.getString("visit_id");
                String doctorName = json.getString("doctor_name");
                String physioCenterName = json.getString("physio_center_name");
                String status = json.getString("status");
                events.add(new Event(serviceName, price, itemID, doctorName, physioCenterName, dateTime, status));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return events;

    }
}
