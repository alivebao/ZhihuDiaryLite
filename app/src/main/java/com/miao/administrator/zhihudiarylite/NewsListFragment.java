package com.miao.administrator.zhihudiarylite;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class NewsListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, NewsAdapter.OnRecyclerViewListener {
    private List<DiaryNews> list = new ArrayList<DiaryNews>();
    private NewsAdapter mAdapter;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0x01:
                    mAdapter.notifyDataSetChanged();
                    mSwipeRefreshLayout.setRefreshing(false);
                    break;
                default:
                    break;
            }
        }
    };
    private String date;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;

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
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);

        assert view != null;
        mRecyclerView = (RecyclerView) view.findViewById(R.id.news_list);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        mAdapter = new NewsAdapter(list);
        mAdapter.setOnRecyclerViewListener(this);
        mRecyclerView.setAdapter(mAdapter);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);

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
                        String title = singleNews.getString("title");
                        String contentURL = URLUtil.ZHIHU_DAILY_OFFLINE_NEWS + singleNews.getInt("id");
                        list.add(new DiaryNews(title, contentURL));
                    }
                    mHandler.sendEmptyMessage(0x01);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    public void onItemClick(int position) {
        String str = "position:" + position + "\tTitle:" + list.get(position).getmTitle() + "\tContentURL:" + list.get(position).getmUrlData();
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(int position) {
        return false;
    }
}
