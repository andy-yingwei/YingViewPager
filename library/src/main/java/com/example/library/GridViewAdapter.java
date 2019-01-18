package com.example.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GridViewAdapter extends BaseAdapter {

    private int textSize;
    private String stringCheckTextColor;
    private int intCheckTextColor;
    private String stringUncheckTextColor;
    private int intUncheckTextColor;
    private int intLineColor;

    private Context context;
    private List<String> myTitleList;
    private List<Boolean> isClicks;//控件是否被点击,默认为false，如果被点击，改变值，控件根据值改变自身颜色
    private ViewHolder.OnItemClickListener myOnItemClickListener = null;

    public static class ViewHolder{
        ImageView imageView;
        TextView textView;

        public  interface OnItemClickListener {
            void onItemClick(int position);
        }
    }

    public void setOnItemClickLitener(ViewHolder.OnItemClickListener mOnItemClickListener) {
        this.myOnItemClickListener = mOnItemClickListener;
    }

    public GridViewAdapter(Context context,List<String> myTitleList){
        this.context=context;
        this.myTitleList=myTitleList;
        isClicks = new ArrayList<>();
        for(int i = 0;i<myTitleList.size();i++){
            if(i==0){
                isClicks.add(true);
            }else {
                isClicks.add(false);
            }
        }
    }

    @Override
    public int getCount() {
        return myTitleList.size();
    }

    @Override
    public Object getItem(int position) {
        return myTitleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.gridview_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.imageView=(ImageView) convertView.findViewById(R.id.gridview_item_imageView);
            viewHolder.textView=(TextView) convertView.findViewById(R.id.gridview_item_textView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(myTitleList.get(position));
        viewHolder.textView.setTextSize(textSize);
        viewHolder.imageView.setBackgroundColor(intLineColor);
        //将数据保存在itemView的Tag中，以便点击时进行获取
        //viewHolder.itemView.setTag(viewHolder.textView);
        if(isClicks.get(position)){
            viewHolder.textView.setTextColor(intCheckTextColor);
            viewHolder.imageView.setVisibility(View.VISIBLE);
        }else{
            viewHolder.textView.setTextColor(intUncheckTextColor);
            viewHolder.imageView.setVisibility(View.INVISIBLE);
        }
        if (myOnItemClickListener != null) {
            viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int i = 0; i < isClicks.size(); i++) {
                        isClicks.set(i, false);
                    }
                    isClicks.set(position, true);
                    notifyDataSetChanged();
                    myOnItemClickListener.onItemClick(position);
                }
            });
        }
        return convertView;
    }




    //当ViewPager选中改变标题文字颜色
    public void onPageSelected(int position){
        for (int i = 0; i < isClicks.size(); i++) {
            isClicks.set(i, false);
        }
        isClicks.set(position, true);
        notifyDataSetChanged();
    }

    //设置标题字体大小
    public void setTextSize(int textSize){
        this.textSize=textSize;
    }

    //设置标题字体选中时颜色-八位的十六进制：前二位是透明度，后六位是颜色Rgb
    public void setCheckTextColor(String stringCheckTextColor){
        this.stringCheckTextColor=stringCheckTextColor;
    }

    //设置标题字体选中时颜色-int
    public void setCheckTextColor(int intCheckTextColor){
        this.intCheckTextColor=intCheckTextColor;
    }

    //设置标题字体未选中时颜色-八位的十六进制：前二位是透明度，后六位是颜色Rgb
    public void setUncheckTextColor(String stringUncheckTextColor){
        this.stringUncheckTextColor=stringUncheckTextColor;
    }

    //设置标题字体未选中时颜色-int
    public void setUncheckTextColor(int intUncheckTextColor){
        this.intUncheckTextColor=intUncheckTextColor;
    }


    //设置选中标题时下划线颜色-int
    public void setLineColor(int intLineColor){
        this.intLineColor=intLineColor;
    }



}
