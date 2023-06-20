package com.example.curemeapp;



public class ServiceSendObjectR2 {

    private String myIP;



    public ServiceSendObjectR2(String myIP){
        this.myIP = myIP;
    };



    public String setServiceData(String name, String code, String desc, String cost){
        String url = "http://"+myIP+"/cure_db/setServiceData.php?name="+name+"&code="+code+"&desc="+desc+"&cost="+cost;
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
