package com.example.curemeapp;

import android.os.StrictMode;

import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import okhttp3.*;
public class R4_OkHttpHandler {
    public R4_OkHttpHandler() {
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
    ArrayList<R4_Visit> cure(String url) throws Exception {
        ArrayList<R4_Visit> visits = new ArrayList<R4_Visit>();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        RequestBody body = RequestBody.create("",
                MediaType.parse("text/plain"));
        Request request = new Request.Builder().url(url).method("POST",
                body).build();
        String data;

        Response response = client.newCall(request).execute();
        data = response.body().string();
        System.out.println("My Response: " + data);
        DateTimeFormatter formatter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        }
        try {
            JSONArray jsonArray = new JSONArray(data);

            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);
                LocalDateTime date_time = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    date_time = LocalDateTime.parse(json.getString("date_time"), formatter);
                }
                String patient_amka = json.getString("patient_amka");
                String fullName = json.getString("fullName");
                String service_id = json.getString("service_id");


                visits.add(new R4_Visit(date_time, patient_amka, fullName, service_id));
            }
            System.out.println("----------------");
            for(int i=0; i<visits.size();i++)System.out.println(visits.get(i).getDateString()+" "+visits.get(i).getService_id());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return visits;
    }

}
