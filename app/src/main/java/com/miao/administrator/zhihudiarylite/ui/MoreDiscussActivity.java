package com.miao.administrator.zhihudiarylite.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

import com.miao.administrator.zhihudiarylite.R;

public class MoreDiscussActivity extends AppCompatActivity {
    private WebView webViewDiscuss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_discuss);

        String strURL = getIntent().getStringExtra("HTML");
        webViewDiscuss = (WebView) findViewById(R.id.webviewDiscuss);
        webViewDiscuss.setBackgroundColor(0x00000000);
        if (strURL != null && !strURL.equals(""))
            webViewDiscuss.loadData(strURL, "text/html;charset=UTF-8", null);
        else
            webViewDiscuss.loadUrl("http://www.zhihu.com/");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_more_discuss, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
