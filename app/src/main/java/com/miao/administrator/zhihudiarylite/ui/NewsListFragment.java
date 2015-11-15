package com.miao.administrator.zhihudiarylite.ui;

import android.content.Intent;
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

import com.miao.administrator.zhihudiarylite.bean.DiaryNews;
import com.miao.administrator.zhihudiarylite.MyApplication;
import com.miao.administrator.zhihudiarylite.adapter.NewsAdapter;
import com.miao.administrator.zhihudiarylite.R;
import com.miao.administrator.zhihudiarylite.util.NetUtil;
import com.miao.administrator.zhihudiarylite.util.StringUtil;
import com.miao.administrator.zhihudiarylite.util.URLUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class NewsListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, NewsAdapter.OnRecyclerViewListener {
    private boolean bFirst = false;
    private List<DiaryNews> list = new ArrayList<DiaryNews>();
    private NewsAdapter mAdapter;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0x01:
                    mAdapter.notifyDataSetChanged();
                    mSwipeRefreshLayout.setRefreshing(false);
                    if (bFirst == false)
                        Toast.makeText(getActivity(), getString(R.string.refresh_finish), Toast.LENGTH_SHORT).show();
                    bFirst = false;
                    break;
                case 0x02:
                    Bundle bundle = msg.getData();
                    String strURLContent = bundle.getString("HTML");
                    Intent intent = new Intent();
                    intent.putExtra("HTML", strURLContent);
                    intent.setClass(MyApplication.getInstance(), MoreDiscussActivity.class);
                    startActivity(intent);
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
            bFirst = bundle.getBoolean("bFirst");

            setRetainInstance(true);
            if (NetUtil.isNetworkConnected(getActivity()))
                onRefresh();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
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
        if (NetUtil.isNetworkConnected(getActivity()) == false) {
            Toast.makeText(getActivity(), getString(R.string.no_network_warning), Toast.LENGTH_SHORT).show();
            mSwipeRefreshLayout.setRefreshing(false);
            return;
        }
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

                        String imageURL = singleNews.getString("images");
                        imageURL = imageURL.substring(2,imageURL.length() - 2);
                        imageURL = imageURL.replace("\\/","/");
                        list.add(new DiaryNews(title, contentURL,imageURL));
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
        if (NetUtil.isNetworkConnected(getActivity()) == false) {
            Toast.makeText(getActivity(), getString(R.string.no_network_warning), Toast.LENGTH_SHORT).show();
            return;
        }
        String str = "position:" + position + "\tTitle:" + list.get(position).getmTitle() + "\tContentURL:" + list.get(position).getmUrlData();
        final String strURL = list.get(position).getmUrlData();

        new Thread() {
            @Override
            public void run() {
                try {
                    String strURLContent = NetUtil.get(strURL);
                    String strHTML = StringUtil.getHTMLbyContent(strURLContent);
                    //set html background to black

                    Message msg = new Message();
                    Bundle bundle = new Bundle();
                    bundle.putString("HTML", strHTML);
                    msg.setData(bundle);
                    msg.what = 0x02;
                    mHandler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    public boolean onItemLongClick(int position) {
        return false;
    }
}
