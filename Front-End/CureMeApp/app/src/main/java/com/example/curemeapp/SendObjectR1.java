package com.example.curemeapp;

public class SendObjectR1 {
    final String myIP = "192.168.1.3";
    PhysioCenterObjectR1 phsCntr;


    public String sendPhysioData(PhysioCenterObjectR1 phsCntr){
        String url = "http://"+myIP+"/cure_db/sendPhysioData.php?afm="+phsCntr.getAFM()+
                "&address="+phsCntr.getAddress()+
                "&name="+phsCntr.getPhysioName();

        String response = null;

        try {
            OkHttpHandlerR1 okHttpHandler = new OkHttpHandlerR1();
            response = okHttpHandler.sendPhysioData(url);
        }catch (Exception e) {
            e.printStackTrace();
        }


        return response;
    }


}
