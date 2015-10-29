package com.miao.administrator.diarycontentresolver;

/**
 * Created by Administrator on 2015/10/29.
 */
public class StringUtil {
    public static String toHTMLString(String in) {
        StringBuffer out = new StringBuffer();
        for (int i = 0; in != null && i < in.length(); i++) {
            char c = in.charAt(i);
            if (c == '\'')
                out.append("'");
            else if (c == '\"')
                out.append("");
            else if (c == '<')
                out.append("<");
            else if (c == '>')
                out.append(">");
            else if (c == '&')
                out.append("&");
            else if (c == ' ')
                out.append(" ");
            else if (c == '\n')
                out.append("<br/>");
            else
                out.append(c);
        }
        return out.toString();
    }
}
