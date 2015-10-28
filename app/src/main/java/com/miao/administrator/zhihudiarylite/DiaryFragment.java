package com.miao.administrator.zhihudiarylite;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class DiaryFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private List<DiaryNews> list = new ArrayList<DiaryNews>();
    private List<String> listTitle = new ArrayList<String>();
    private String date;
    SwipeRefreshLayout swipeLayout;
    ListView lvContent;


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0x01:
                    swipeLayout.setRefreshing(false);
                    listTitle.clear();
                    for (DiaryNews daily : list) {
                        listTitle.add(daily.getmTitle());
                    }
                    lvContent.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, listTitle));
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Bundle bundle = getArguments();

            date = bundle.getString("date");

            setRetainInstance(true);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        onRefresh();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_diary, container, false);

        swipeLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        swipeLayout.setOnRefreshListener(this);
        lvContent = (ListView) view.findViewById(R.id.lvContent);

        return view;
    }

    public void onRefresh() {
        new Thread() {
            @Override
            public void run() {
                try {
                    list.clear();
                    String strURL = URLUtil.ZHIHU_DAILY_BEFORE + date;
                    JSONObject contents = new JSONObject(NetUtil.get(strURL));
                    JSONArray newsArray = contents.getJSONArray("stories");
                    for (int i = 0; i < newsArray.length(); i++) {
                        JSONObject singleNews = newsArray.getJSONObject(i);
                        String thumbnailUrl = "";
                        if (singleNews.has("images")) {
                            thumbnailUrl = (String) singleNews.getJSONArray("images").get(0);
                        }
                        String title = singleNews.getString("title");
                        String contentURL = URLUtil.ZHIHU_DAILY_OFFLINE_NEWS + singleNews.getInt("id");
                        list.add(new DiaryNews(title, thumbnailUrl, contentURL));
                    }
                    mHandler.sendEmptyMessage(0x01);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
