package com.miao.administrator.diarycontentresolver;

import android.util.Log;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Administrator on 2015/10/29.
 */
public class StringUtil {
    public static String getQuesionURL(String strContent) {
        String strResult = "";
        try {
            JSONObject newsDetail = new JSONObject(strContent);
            if (newsDetail.has("body")) {
                Document doc = Jsoup.parse(newsDetail.getString("body"));
                strResult = doc.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strResult;
    }

    public static String getQuestionURLAdapterPic(String strContent) {
        String strResult = "";
        try {
            JSONObject newsDetail = new JSONObject(strContent);
            if (newsDetail.has("body")) {
                Document doc = Jsoup.parse(newsDetail.getString("body"));

                Elements elementImgs = doc.getElementsByTag("img");//获取所有img标签

                for (Element img : elementImgs) {
                    img.attr("width", "100%");//设置width属性
                }
                strResult = doc.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strResult;
    }
}
