package com.example.curemeapp;

public class ServiceSendObjectR2 {

    private final String myIP = "192.168.1.100";



    public ServiceSendObjectR2(){};



    public String setServiceData(String name, String code, String desc, String cost, String physio_center){
        String url = "http://"+myIP+"/cure_db/setServiceData.php?name="+name+"&code="+code+"&desc="+desc+"&cost="+cost+"&physio_center="+physio_center;
        String response = "SET FAILED";


        try {
            OkHttpHandlerR2 okHttpHandler = new OkHttpHandlerR2();
            response = okHttpHandler.setServiceData(url);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
