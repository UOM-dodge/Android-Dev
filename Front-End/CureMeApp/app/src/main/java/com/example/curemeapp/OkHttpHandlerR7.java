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

public class OkHttpHandlerR7 {

    final int image = R.drawable.baseline_person_24;

    public OkHttpHandlerR7() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }


    List<ItemR7> requestItems(String url) throws Exception {
        ArrayList<ItemR7> items = new ArrayList<>();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        RequestBody body = RequestBody.create(" ", MediaType.parse("text/plain"));
        Request request = new Request.Builder().url(url).method("POST", body).build();
        Response response = client.newCall(request).execute();
        String data = response.body().string();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(data);

        try {
            JSONArray jsonArray = new JSONArray(data);

            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);
                int request_id = json.getInt("id");
                String fullName = json.getString("patient_name");
                LocalDateTime date_time = LocalDateTime.parse(json.getString("date_time"), f);
                String status = json.getString("status");
                items.add(new ItemR7(request_id, fullName, date_time, status, image));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return items;
    }

    public String requestConfirmed(String url) throws Exception {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        RequestBody body = RequestBody.create(" ", MediaType.parse("text/plain"));
        Request request = new Request.Builder().url(url).method("POST", body).build();
        Response response = client.newCall(request).execute();
        String data = response.body().string();
        return data;
    }



}
