package com.miao.administrator.zhihudiarylite.bean;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2015/10/28.
 */
public class DiaryNews {
    private static final long serialVersionUID = 1;
    private String mTitle;
    private String mUrlData;
    private String mUrlImage;
    private Bitmap mBitmap;

    public DiaryNews() {

    }

    public DiaryNews(String Title, String UrlData) {
        mTitle = Title;
        mUrlData = UrlData;
    }

    public DiaryNews(String Title, String UrlData, String UrlImage) {
        this(Title, UrlData);
        mUrlImage = UrlImage;

        try{
            URL url = new URL(mUrlImage);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if(conn.getResponseCode() == 200) {
                InputStream inputStream = conn.getInputStream();
                mBitmap = BitmapFactory.decodeStream(inputStream);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public DiaryNews(DiaryNews d) {
        mTitle = d.getmTitle();
        mUrlData = d.getmUrlData();
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmUrlData() {
        return mUrlData;
    }

    public String getmUrlImage() {
        return mUrlImage;
    }

    public Bitmap getmBitmap() {
        return mBitmap;
    }

    public void setmTitle(String str) {
        mTitle = str;
    }

    public void setmUrlImg(String str) {
        mUrlData = str;
    }

}
