package com.miao.administrator.zhihudiarylite.ui;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.miao.administrator.zhihudiarylite.R;
import com.miao.administrator.zhihudiarylite.util.NetUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private final int PAGE_COUNT = 5;
    @Bind(R.id.date_tabs)
    TabLayout mTabLayout;
    @Bind(R.id.main_pager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mViewPager.setOffscreenPageLimit(PAGE_COUNT);
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab_pick_date);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PickDateActivity.class));
            }
        });

        if (NetUtil.isNetworkConnected(this) == false) {
            Toast.makeText(this, getString(R.string.no_network_warning), Toast.LENGTH_SHORT).show();
            return;
        }

    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            NewsListFragment fragment = new NewsListFragment();
            Bundle bundle = new Bundle();
            Calendar dateToGetUrl = Calendar.getInstance();

            Date dDate = (Date) getIntent().getSerializableExtra("date");
            if (null != dDate)
                dateToGetUrl.setTime(dDate);

            dateToGetUrl.add(Calendar.DAY_OF_YEAR, 1 - i);
            String strDate = (new SimpleDateFormat("yyyyMMdd", Locale.US)).format(dateToGetUrl.getTime());
            bundle.putString("date", strDate);
            bundle.putBoolean("bFirst", true);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Calendar displayDate = Calendar.getInstance();
            Date dDate = (Date) getIntent().getSerializableExtra("date");
            if (null != dDate)
                displayDate.setTime(dDate);
            displayDate.add(Calendar.DAY_OF_YEAR, -position);

            return DateFormat.getDateInstance().format(displayDate.getTime());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
