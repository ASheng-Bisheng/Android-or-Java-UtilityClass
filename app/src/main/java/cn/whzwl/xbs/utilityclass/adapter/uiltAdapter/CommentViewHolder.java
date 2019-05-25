package cn.whzwl.xbs.utilityclass.adapter.uiltAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.io.File;

import cn.whzwl.xbs.utilityclass.customView.ShapeTextView;

/**
 * 公共ViewHolder
 */
public class CommentViewHolder extends RecyclerView.ViewHolder {

    /**
     * 这个稀疏数组，网上说的是提高效率的
     */
    private final SparseArray<View> views;
    private View convertView;

    /**
     * 如果用到了，比如我们用glide加载图片的时候，还有其他的需要用到上下文的时候
     */
    private Context mContext;

    public CommentViewHolder(View itemView) {
        super(itemView);

        views = new SparseArray<>();
        convertView = itemView;
        mContext = itemView.getContext();
    }

    /**
     * 返回一个具体的view对象
     * 这个就是借鉴的base-adapter-helper中的方法
     *
     * @param viewId
     * @param <T>
     * @return
     */
    protected <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = convertView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    public void setShapeTextView(int resId, String text) {
        ShapeTextView view = getView(resId);
        view.setText(text);
    }

    public  void setText(int resId, String text) {
        TextView view = getView(resId);
        view.setText(text);
    }

    /**
     * 下面的这个是加载显示图片的，我用到了glide
     *
     * @param resId
     * @param url
     */
    public void setImageByUrl(int resId, Object url) {
        ImageView imageView = getView(resId);

        if ((url + "").equals("/mnt")){
            File file = new File(url + "");
            Glide.with(mContext).load(file).dontAnimate().into(imageView);
        }else
            {
                Glide.with(mContext).load(url).dontAnimate().into(imageView);
            }

    }

    /**
     * 设置EditText
     *
     * @param resId
     * @param url
     */
    public void setEditText(int resId, String url) {
        EditText editView = getView(resId);

    }

    /**
     * 设置任意View的公共属性
     *
     * @param resId
     * @return
     */
    public View finalview(int resId) {
        View view = getView(resId);
        return view;
    }


    /**
     * 设置背景资源文件
     *
     * @param resId
     * @param url
     */
    public void setBackgroundResource(int resId, int url) {
        View view = getView(resId);
        view.setBackgroundResource(url);
    }


    public View setView (int resId)
    {
        View view = getView(resId);
        return view;
    }




}
