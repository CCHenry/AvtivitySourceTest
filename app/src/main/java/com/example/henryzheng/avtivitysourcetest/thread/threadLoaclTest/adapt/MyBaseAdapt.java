package com.example.henryzheng.avtivitysourcetest.thread.threadLoaclTest.adapt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.henryzheng.avtivitysourcetest.R;
import com.example.henryzheng.avtivitysourcetest.thread.threadLoaclTest.model.Model;

import java.util.List;

/**
 * Created by henryzheng on 2016/12/30.
 */
public class MyBaseAdapt extends BaseAdapter{
    List<Model> datas;
    Context context;
    LayoutInflater inflater;
    public MyBaseAdapt(Context context, List<Model> datas) {
        this.datas=datas;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
             viewHolder=new ViewHolder();
            convertView =inflater.inflate(R.layout.activity_thread_local_list_item,null);
            viewHolder.tv=(TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(viewHolder);
        }else
        {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        for (int i=1;i<1000;i++)
        viewHolder.tv.setText("data:"+datas.get(position).getData());
        return convertView;
    }
    class ViewHolder {
        public TextView tv;
    }
}
