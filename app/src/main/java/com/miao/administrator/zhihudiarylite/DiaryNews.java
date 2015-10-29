package com.miao.administrator.zhihudiarylite;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2015/10/28.
 */
public class DiaryNews {
    private static final long serialVersionUID = 1;
    private String mTitle;
    private String mUrlData;

    public DiaryNews() {

    }

    public DiaryNews(String Title, String UrlData) {
        mTitle = Title;
        mUrlData = UrlData;
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

    public void setmTitle(String str) {
        mTitle = str;
    }

    public void setmUrlImg(String str) {
        mUrlData = str;
    }

}
