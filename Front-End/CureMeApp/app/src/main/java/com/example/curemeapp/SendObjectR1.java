package com.example.curemeapp;

public class SendObjectR1 {
    private String myIP;
    PhysioCenterObjectR1 phsCntr;


    public SendObjectR1(String myIP) {
        this.myIP = myIP;
    }

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
