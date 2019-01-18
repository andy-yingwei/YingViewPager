package com.example.library;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private int textSize;
    private String stringCheckTextColor;
    private int intCheckTextColor;
    private String stringUncheckTextColor;
    private int intUncheckTextColor;
    private int intLineColor;

    private List<String> myTitleList;
    private List<Boolean> isClicks;//控件是否被点击,默认为false，如果被点击，改变值，控件根据值改变自身颜色
    private ViewHolder.OnItemClickListener myOnItemClickListener = null;


    /*
    private ItemClickListener itemClickListener;


    public interface ItemClickListener {
        void onClick(int position);
    }

    public void setOnItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
    */




    public RecyclerViewAdapter(List<String> myTitleList){
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

    public static class  ViewHolder extends  RecyclerView.ViewHolder {
        View titleView;
        TextView textView;
        ImageView imageView;

        public ViewHolder(View view){
            super(view);
            titleView=view;
            textView = (TextView) view.findViewById(R.id.recyclerview_item_textView);
            imageView = (ImageView) view.findViewById(R.id.recyclerview_item_imageView);
            /*
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClickListener!= null) {
                        itemClickListener.onClick(getAdapterPosition());
                    }
                }
            });
            */
        }



        public interface OnItemClickListener {
            void onItemClick(View view, TextView textView,int position);
        }
    }

    public void setOnItemClickLitener(ViewHolder.OnItemClickListener mOnItemClickListener) {
        this.myOnItemClickListener = mOnItemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item,viewGroup,false);
        final ViewHolder viewHolder=new ViewHolder(view);
        //viewHolder.textView = (TextView) view.findViewById(R.id.textView);
        //viewHolder.imageView = (ImageView) view.findViewById(R.id.imageView);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  final ViewHolder viewHolder, final int position) {
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
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int i = 0; i < isClicks.size(); i++) {
                        isClicks.set(i, false);
                    }
                    isClicks.set(position, true);
                    notifyDataSetChanged();
                    myOnItemClickListener.onItemClick(viewHolder.itemView, viewHolder.textView, position);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return myTitleList.size();
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

