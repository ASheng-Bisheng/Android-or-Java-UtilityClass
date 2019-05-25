package cn.whzwl.xbs.utilityclass.adapter.uiltAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @param <T> List
 *            公共Adapter
 */
public abstract class CommentAdapter<T> extends RecyclerView.Adapter<CommentViewHolder> {

    /**
     * 提取的公共的，所以我在这用泛型T，而不是给出具体的值，具体的交给我们的实现类去传入
     */
    private List<T> mTList;
    //布局id
    private int layoutId;

    /**
     * 构造函数，传入数据的list和布局
     *
     * @param TList
     * @param layoutId
     */
    public CommentAdapter(List<T> TList, int layoutId) {
        mTList = TList;
        this.layoutId = layoutId;

    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(layoutId, parent,false);

        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        convert(holder, mTList.get(position), position);

    }

    /**
     * 留给调用者去实现
     *
     * @param holder
     * @param t
     */
    public abstract void convert(CommentViewHolder holder, final T t, int position);

    @Override
    public int getItemCount() {
        return mTList.size();
    }

    public void removeItem(int position) {
        mTList.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();

    }



}
