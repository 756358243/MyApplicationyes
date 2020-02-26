package com.vkeline.zlibrary.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * @author Zhou
 *         Created on 2017/11/30 17:46.
 *         Email:qishuichixi@163.com
 *         Desc:  使用在listview gridview
 */
public abstract class CommonListViewAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<T> mListDatas;
    protected LayoutInflater mInflater;
    protected int mLayoutId;

    public CommonListViewAdapter(Context context, List<T> datas, int layoutId) {

        this.mContext = context;
        this.mListDatas = datas;
        this.mInflater = LayoutInflater.from(context);
        this.mLayoutId = layoutId;
    }

    @Override
    public int getCount() {
        return mListDatas == null ? 0 : mListDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mListDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final BaseHolder viewHolder = getViewHolder(position, convertView, parent);
        setData(viewHolder, getItem(position), position);
        return viewHolder.getConvertView();

    }

    public abstract void setData(BaseHolder holder, T item, int position);

    private BaseHolder getViewHolder(int position, View convertView, ViewGroup parent) {
        return BaseHolder.get(mContext, convertView, parent, mLayoutId, position);
    }

    /**
     * 缓存优化存储控件
     */
    public static class BaseHolder {

        private final SparseArray<View> mViews;
        private View mConvertView;
        protected int mPosition;

        private BaseHolder(Context context, ViewGroup parent, int layoutId, int position) {
            this.mViews = new SparseArray<View>();
            this.mPosition = position;
            mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
            //setTag
            mConvertView.setTag(this);
        }

        /**
         * 拿到一个BaseHolderr对象
         *
         * @param context
         * @param convertView
         * @param parent
         * @param layoutId
         * @param position
         * @return 来自鸿洋的博客
         */
        public static BaseHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {

            if (convertView == null) {
                return new BaseHolder(context, parent, layoutId, position);
            }
            return (BaseHolder) convertView.getTag();
        }


        /**
         * 通过控件的Id获取对于的控件，如果没有则加入views
         *
         * @param viewId
         * @return
         */
        public <T extends View> T getView(int viewId) {

            View view = mViews.get(viewId);
            if (view == null) {
                view = mConvertView.findViewById(viewId);
                mViews.put(viewId, view);
            }
            return (T) view;
        }

        public View getConvertView() {
            return mConvertView;
        }


        public int getPosition() {
            return mPosition;
        }

        /**
         * 扩展方法
         */

        public BaseHolder setText(int id, String text) {

            if (text == null) {
                text = "";
            }

            TextView tv = getView(id);
            tv.setText(text);

            return this;
        }

        public BaseHolder setImageResource(int id, int resId) {

            ImageView iv = getView(id);
            iv.setImageResource(resId);

            return this;
        }

        public BaseHolder setVisible(int id) {
            getView(id).setVisibility(View.VISIBLE);
            return this;
        }

        public BaseHolder setInVisible(int id) {
            getView(id).setVisibility(View.INVISIBLE);
            return this;
        }

        public BaseHolder setGone(int id) {
            getView(id).setVisibility(View.GONE);
            return this;
        }
    }
}
