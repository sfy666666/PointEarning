package com.example.pointearning.ui.main.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.pointearning.R;
import com.example.pointearning.bean.ChatEntity;

import java.util.List;

/**
 * created by shengfeiyu
 * on 2019/9/12
 */
public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<ChatEntity, BaseViewHolder> {

    private static final int VIEWTYPETIME = 10001;
    private static final int VIEWTYPERIGHT = 10002;
    private static final int VIEWTYPELEFT = 10003;

    public MultipleItemQuickAdapter(List<ChatEntity> data) {
        super(data);
        addItemType(VIEWTYPETIME, R.layout.item_chat_time);
        addItemType(VIEWTYPERIGHT,R.layout.item_char_right);
        addItemType(VIEWTYPELEFT,R.layout.item_char_left);
    }

    @Override
    protected void convert(BaseViewHolder helper, ChatEntity item) {

        switch (helper.getItemViewType()){
            case VIEWTYPETIME:
                helper.setText(R.id.time,item.getChat());
                break;
            case VIEWTYPERIGHT:
            case VIEWTYPELEFT:
                helper.setImageResource(R.id.icon,item.getIcon());
                helper.setText(R.id.chat,item.getChat());
                break;
        }
    }
}
