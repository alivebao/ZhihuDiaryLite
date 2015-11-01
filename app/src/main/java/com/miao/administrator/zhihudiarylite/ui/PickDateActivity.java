package com.miao.administrator.zhihudiarylite.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.miao.administrator.zhihudiarylite.Constants;
import com.miao.administrator.zhihudiarylite.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PickDateActivity extends AppCompatActivity implements PickDateFragment.PickDateListener{
    private Calendar calendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_date);

        showPickDateFragment();
    }
    private void showPickDateFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("date", Constants.Date.simpleDateFormat.format(calendar.getTime()));

        Fragment displayFragment = new PickDateFragment();
        displayFragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_frame, displayFragment)
                .commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pick_date, menu);
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
    @Override
    public void onValidDateSelected(Date date) {
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);

        Intent intent = new Intent(PickDateActivity.this,MainActivity.class);
        intent.putExtra("date",date);

        startActivity(intent);
    }

    @Override
    public void onInvalidDateSelected(Date date) {
       Toast.makeText(PickDateActivity.this,"Bad Chioce",Toast.LENGTH_SHORT).show();
    }

    @Override
    public Date getDate() {
        return calendar.getTime();
    }
}
