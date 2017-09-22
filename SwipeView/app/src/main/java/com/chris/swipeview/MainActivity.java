package com.chris.swipeview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    private List<String> mDatas;
    private SwipeView mOpenedSwipeView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);

        // 模拟数据
        mDatas = new ArrayList<String>();
        for (int i = 0; i < 200; i++) {
            mDatas.add("单词本  " + i+"号");
        }
        System.out.println(mDatas);

        // 给listView设置数据
        mListView.setAdapter(new MyAdapter());// adapter --》list
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("onItemClick");
                if(mOpenedSwipeView!=null){
                    mOpenedSwipeView.reset();
                }
                Toast.makeText(MainActivity.this,position+"",Toast.LENGTH_SHORT).show();
            }
        });

    }
    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            if (mDatas != null) {
                return mDatas.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            if (mDatas != null) {
                return mDatas.get(position);
            }
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                // 没有复用
                convertView = View.inflate(MainActivity.this, R.layout.item,
                        null);
                // 初始化Holder
                holder = new ViewHolder();
                // 设置标记
                convertView.setTag(holder);

                // view的初始化
                holder.sv = (SwipeView) convertView.findViewById(R.id.item_sv);
                holder.mRl_item_wordbooklist = (View) convertView.findViewById(R.id.rl_item_wordbooklist);
                holder.tv_wordbookName = (TextView) convertView
                        .findViewById(R.id.tv_wordbookName);
                holder.item_tv_delete = (TextView) convertView
                        .findViewById(R.id.item_tv_delete);
                holder.item_tv_top = (TextView)convertView
                        .findViewById(R.id.item_tv_top);
                holder.sv.setOnSwipeListener(new SwipeView.OnSwipeListener() {
                    @Override
                    public void onSwipeChanged(SwipeView view, boolean isOpened) {
                        if(mOpenedSwipeView!=null){
                            mOpenedSwipeView.reset();
                        }
                        if(isOpened){
                            mOpenedSwipeView =view;
                        }else {
                            mOpenedSwipeView =null;
                        }
                    }
                });
            } else {
                // 有复用
                holder = (ViewHolder) convertView.getTag();
            }

            holder.sv.reset();
            // 数据的加载
            final String data = mDatas.get(position);
            System.out.println("数据的加载:"+data);
            holder.tv_wordbookName.setText(data);

            holder.sv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println(position+"holder.sv.setOnClickListener");
                    Toast.makeText(MainActivity.this,position+"holder.sv.setOnClickListener",Toast.LENGTH_SHORT).show();
                }
            });
            holder.sv.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    System.out.println("holder.sv.setOnLongClickListener");
                    Toast.makeText(MainActivity.this,position+"holder.sv.setOnLongClickListener",Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
            holder.item_tv_delete.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    mDatas.remove(data);
                    notifyDataSetChanged();
                }
            });
            holder.item_tv_top.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    mDatas.remove(data);
                    mDatas.add(0,data);
                    notifyDataSetChanged();
                }
            });

            return convertView;
        }
    }



    class ViewHolder {
        View mRl_item_wordbooklist;
        SwipeView sv;
        TextView tv_wordbookName;
        TextView item_tv_delete;
        TextView item_tv_top;
    }
}
