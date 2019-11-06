package com.example.pointearning.ui.fragment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pointearning.R;
import com.example.pointearning.bean.NewsEntity;

import java.util.List;

/**
 * created by shengfeiyu
 * on 2019/9/4
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<NewsEntity> newsEntityList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivIcon;
        TextView tvTitle;
        TextView tvContent;
        TextView tvCount;

        public ViewHolder(View view){
            super(view);
            ivIcon = view.findViewById(R.id.iv_icon);
            tvTitle = view.findViewById(R.id.tv_title);
            tvContent = view.findViewById(R.id.tv_content);
            tvCount = view.findViewById(R.id.tv_count);

        }
    }

    public NewsAdapter(List<NewsEntity> iconList){
        newsEntityList = iconList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
}

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsEntity news = newsEntityList.get(position);
        holder.ivIcon.setImageResource(news.getIcon());
        holder.tvTitle.setText(news.getTitle());
        holder.tvContent.setText(news.getContent());
        holder.tvCount.setText("参与人数："+news.getCount()+"人");
    }

    @Override
    public int getItemCount() {
        return newsEntityList.size();
    }
}
