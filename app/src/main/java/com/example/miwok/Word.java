package com.example.miwok;

public class Word {
    private String miwok;
    private String english;
    private int imgId;
    private int sid;



    public Word(String a, String b, int c, int d){
        miwok=a;
        english=b;
        imgId=c;
        sid=d;
    }

    public Word(String a, String b, int d){//--------------->because for phrases we dont want images
        miwok=a;
        english=b;
        sid=d;
    }

    public String getMiwok(){
        return miwok;
    }

    public String getEnglish(){
        return english;
    }

    public int getImgId(){ return imgId;}

    public int getSid(){ return sid; }

}
