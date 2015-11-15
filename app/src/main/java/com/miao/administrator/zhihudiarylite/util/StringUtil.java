package com.miao.administrator.zhihudiarylite.util;

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
    public static String getHTMLbyContent(String strContent) {
        String strResult = "";
        try {
            JSONObject newsDetail = new JSONObject(strContent);
            if (newsDetail.has("body")) {
                Document doc = Jsoup.parse(newsDetail.getString("body"));
//                setHTMLBlack(doc);
                setPictureFitScreen(doc);
                strResult = doc.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strResult;
    }

    public static Document setPictureFitScreen(Document doc) {
        Elements elementImgs = doc.getElementsByTag("img");//获取所有img标签

        for (Element img : elementImgs) {
            if (!img.className().equals("avatar"))
                img.attr("width", "100%");//设置width属性
        }
        return doc;
    }

    public static Document setHTMLBlack(Document doc) {
        Element eleBackSet = doc.body();
        eleBackSet.attr("style", "background:#000; color:#FFF");
        return doc;
    }
}