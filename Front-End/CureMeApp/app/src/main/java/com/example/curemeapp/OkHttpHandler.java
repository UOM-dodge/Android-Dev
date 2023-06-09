package com.example.curemeapp;

import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONException;
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
    final int image = R.drawable.baseline_person_24;

    public OkHttpHandler() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    List<Event> searchEvents(String url) throws Exception {
        List<Event> events = new ArrayList<>();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        RequestBody body = RequestBody.create(" ", MediaType.parse("text/plain"));
        Request request = new Request.Builder().url(url).method("POST", body).build();
        Response response = client.newCall(request).execute();
        String data = response.body().string();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(data);

        try {
            JSONArray jsonArray = new JSONArray(data);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);
                String event_id = json.getString("id");
                String patientFullName = json.getString("patientFullName");
                String patient_amka = json.getString("amka_id");
                LocalDateTime date_time = LocalDateTime.parse(json.getString("date_time"), f);
                String status = json.getString("status");
                events.add(new Event(event_id, patientFullName, patient_amka, date_time, status, image));
            }
        } catch (JSONException e) {
            e.printStackTrace();



        }

        return events;
    }
}
