package com.miao.administrator.zhihudiarylite;

/**
 * Created by Administrator on 2015/10/28.
 */
public class DiaryNews {
    private static final long serialVersionUID = 1;
    private String mTitle;
    private String mUrlImg;
    private String mUrlData;

    public DiaryNews() {

    }

    public DiaryNews(String Title, String UrlImg, String UrlData) {
        mTitle = Title;
        mUrlImg = UrlImg;
        mUrlImg = UrlData;
    }

    public DiaryNews(DiaryNews d) {
        mTitle = d.getmTitle();
        mUrlData = d.getmUrlData();
        mUrlImg = d.getmUrlImg();
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmUrlImg() {
        return mUrlImg;
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

    public void setmUrlData(String str) {
        mUrlImg = str;
    }
}
