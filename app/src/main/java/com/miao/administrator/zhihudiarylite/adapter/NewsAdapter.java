package com.miao.administrator.zhihudiarylite.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.miao.administrator.zhihudiarylite.bean.DiaryNews;
import com.miao.administrator.zhihudiarylite.R;

import java.util.List;

/**
 * Created by Administrator on 2015/10/28.
 */
public class NewsAdapter extends RecyclerView.Adapter {
    public static interface OnRecyclerViewListener {
        void onItemClick(int position);

        boolean onItemLongClick(int position);
    }

    private OnRecyclerViewListener onRecyclerViewListener = null;

    private List<DiaryNews> newsList;

    public void setOnRecyclerViewListener(OnRecyclerViewListener listener) {
        onRecyclerViewListener = listener;
    }

    public NewsAdapter(List<DiaryNews> newsList) {
        this.newsList = newsList;
    }

    public void setNewsList(List<DiaryNews> newsList) {
        this.newsList = newsList;
    }

    public void updateNewsList(List<DiaryNews> newsList) {
        setNewsList(newsList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_item_layout, null);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        NewsViewHolder holder = (NewsViewHolder) viewHolder;
        holder.position = i;
        DiaryNews diaryNews = newsList.get(i);
        holder.tvTitle.setText(diaryNews.getmTitle());
    }

    class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public View rootView;
        public TextView tvTitle;
        public int position;

        public NewsViewHolder(View itemView) {
            super(itemView);
            rootView = itemView.findViewById(R.id.rootCardView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);

            rootView.setOnClickListener(this);
            rootView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (null != onRecyclerViewListener)
                onRecyclerViewListener.onItemClick(position);
            else
                Log.e("Faued", "no listener");
        }

        @Override
        public boolean onLongClick(View v) {
            if (null != onRecyclerViewListener)
                return onRecyclerViewListener.onItemLongClick(position);
            return false;
        }
    }
}
