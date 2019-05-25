package cn.whzwl.xbs.utilityclass.adapter;

import android.view.View;

import java.util.List;

import cn.whzwl.xbs.utilityclass.R;
import cn.whzwl.xbs.utilityclass.adapter.uiltAdapter.CommentAdapter;
import cn.whzwl.xbs.utilityclass.adapter.uiltAdapter.CommentViewHolder;

/**
 * 项目名称:UtilityClass
 * <p>
 * 版权：智味来 版权所有
 * <p>
 * 作者：ASheng
 * <p>
 * 创建日期：2019/5/25 11:37
 * <p>
 * 描述：
 */
public class StringAdapter extends CommentAdapter<String> {
    /**
     * 构造函数，传入数据的list和布局
     *
     * @param TList
     * @param layoutId
     */
    public StringAdapter(List<String> TList, int layoutId) {
        super(TList, layoutId);
    }

    @Override
    public void convert(CommentViewHolder holder, final String s, final int position) {
        holder.setShapeTextView(R.id.tv,s);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener!=null){
                    mOnItemClickListener.onItemClick(position,s);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (OnLongClickListener != null) {
                    OnLongClickListener.onItemLongClick(position, s);
                }
                return true;
            }
        });
    }


    private OnItemClickListener mOnItemClickListener = null;
    private LongClickListener OnLongClickListener = null;

    public static interface OnItemClickListener {
        void onItemClick(int position, Object o);
    }


    public static interface LongClickListener {
        void onItemLongClick(int position, Object o);
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public void setOnLongClickListener(LongClickListener onLongClickListener) {
        this.OnLongClickListener = onLongClickListener;
    }
}
