package com.example.curemeapp;

import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpHandlerR5 {
    public OkHttpHandlerR5() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public ArrayList<PatientR5> requestPatientData (String url) throws Exception{
        ArrayList<PatientR5> patientList = new ArrayList<>();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        RequestBody body = RequestBody.create(" ", MediaType.parse("text/plain"));
        Request request = new Request.Builder().url(url).method("POST", body).build();
        Response response = client.newCall(request).execute();
        String data = response.body().string();
        System.out.println("My response: " + data);
        try {
            JSONArray jsonArray = new JSONArray(data);
            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);
                String patient_name = json.getString("first_name")+" " + json.getString("last_name");
                String patient_AMKA = json.getString("amka");
                String patient_phoneNumber = json.getString("phone_number");
                patientList.add(new PatientR5( patient_name,patient_phoneNumber,patient_AMKA, R.drawable.cont2));
            }

        }catch (JSONException e){e.printStackTrace();}


        return patientList;
    }

}
