package com.example.pointearning.contact;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pointearning.R;

import java.util.List;

import butterknife.BindView;

/**
 * created by shengfeiyu
 * on 2019/9/16   联系人页面 自定义Recyclerview的适配器
 */


public class ContactSortAdapter extends RecyclerView.Adapter {

    List<SortModel> mData;


    private int TYPE_HEADER = 1001;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder;
        if (viewType == TYPE_HEADER) {
            View inflate = View.inflate(parent.getContext(), R.layout.item_contact, null);
            holder = new HeaderViewHolder(inflate);
        } else {
            View inflate = View.inflate(parent.getContext(), R.layout.adapter_sort2, null);
            holder = new ContactHolder(inflate);
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        //单独添加两个头部不参与排序
        if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            if (position == 0) {
                headerViewHolder.icon.setImageResource(R.drawable.haoyou);
                headerViewHolder.name.setText("新的好友");
                headerViewHolder.xinde.setVisibility(View.VISIBLE);
                headerViewHolder.view_line.setVisibility(View.VISIBLE);
            }
            if (position == 1) {
                headerViewHolder.icon.setImageResource(R.drawable.qunliao);
                headerViewHolder.name.setText("创建群聊");
                headerViewHolder.xinde.setVisibility(View.GONE);
                headerViewHolder.view_line.setVisibility(View.GONE);
            }
        }

        if (holder instanceof ContactHolder) {
            SortModel sortModel = mData.get(position - 2);
            ContactHolder holder1 = (ContactHolder) holder;
            holder1.name.setText(sortModel.getName());
            holder1.img.setImageResource(sortModel.getIcon());
            if (!compareSection(position)) {
                holder1.tv_letter.setVisibility(View.VISIBLE);
                holder1.line_view.setVisibility(View.GONE);
                holder1.tv_letter.setText(sortModel.getLetter());
            } else {
                holder1.tv_letter.setVisibility(View.GONE);
                holder1.line_view.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() + 2 : 0;
    }

    public class ContactHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_letter;
        TextView name;
        View line_view;
        ImageView img;

        public ContactHolder(@NonNull View itemView) {
            super(itemView);
            tv_letter = itemView.findViewById(R.id.tv_letter);
            line_view = itemView.findViewById(R.id.line_view);
            name = itemView.findViewById(R.id.name);
            img = itemView.findViewById(R.id.img);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (onContactRecyclerViewItemCLickListener != null)
                onContactRecyclerViewItemCLickListener.OnItemClick(getAdapterPosition());
        }
    }


    public final boolean compareSection(int position) {
        boolean flag;
        if (position == 2) {
            flag = false;
        } else {
            int current = this.getSectionForPosition(position);
            int previous = this.getSectionForPosition(position - 1);
            flag = current == previous;
        }
        return flag;
    }

    // 获取当前位置的首字母(int表示ascii码)
    public int getSectionForPosition(int position) {
        return mData.get((position - 2)).getLetter().charAt(0);
    }

    // 获取字母首次出现的位置
    public final int getPositionForSection(int section) {

        for (int i = 0; i < this.getItemCount(); ++i) {
            String s = mData.get(i).getLetter();
            char firstChar = s.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }
        return -1;
    }


    public void initData(List<SortModel> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        //在一二位置添加头
        if (position == 0 || position == 1) {
            return TYPE_HEADER;
        }
        return super.getItemViewType(position - 2);
    }


    /**
     * 头布局的viewholder
     */
    class HeaderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView icon;
        TextView name;
        View view_line;
        Button xinde;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            name = itemView.findViewById(R.id.name);
            view_line = itemView.findViewById(R.id.view_line);
            xinde = itemView.findViewById(R.id.xinde);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onContactRecyclerViewItemCLickListener != null)
                onContactRecyclerViewItemCLickListener.OnItemClick(getAdapterPosition());

        }
    }

    private OnContactRecyclerViewItemCLickListener onContactRecyclerViewItemCLickListener;

    public void setOnContactRecyclerViewItemCLickListener(OnContactRecyclerViewItemCLickListener listener) {
        this.onContactRecyclerViewItemCLickListener = listener;
    }

    interface OnContactRecyclerViewItemCLickListener {
        void OnItemClick(int position);
    }
}
