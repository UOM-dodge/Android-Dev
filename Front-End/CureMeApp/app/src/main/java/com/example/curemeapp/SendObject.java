package com.example.curemeapp;

public class SendObject {
    final String myIP = "192.168.1.3";
    PhysioCenterObject phsCntr;


    public String sendPhysioData(PhysioCenterObject phsCntr){
        String url = "http://"+myIP+"/cure_db/sendPhysioData.php?afm="+phsCntr.getAFM()+
                "&address="+phsCntr.getAddress()+
                "&name="+phsCntr.getPhysioName();

        String response = null;

        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            response = okHttpHandler.sendPhysioData(url);
        }catch (Exception e) {
            e.printStackTrace();
        }


        return response;
    }


}
