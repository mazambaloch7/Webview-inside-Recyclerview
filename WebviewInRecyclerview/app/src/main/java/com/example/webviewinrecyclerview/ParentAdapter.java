package com.example.webviewinrecyclerview;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;

import com.example.webviewinrecyclerview.MyWebView;
import com.example.webviewinrecyclerview.R;
import com.example.webviewinrecyclerview.ParentAdapter.MyViewHolder;


public class ParentAdapter extends RecyclerView.Adapter<MyViewHolder> {


    private String urlList[] = {
            "https://www.google.com",
            "https://www.google.com",
            "https://www.youtube.com",
            "https://www.youtube.com",
            "https://www.youtube.com",
            "https://www.google.com",
            "https://www.google.com",
            "https://www.google.com",
            "https://www.bling.com"};


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_my_web, parent, false);
        return new MyViewHolder(itemView);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myWebView.load(urlList[position]);
        holder.myWebView.setWebViewClient(new WebViewClient());
        holder.myWebView.getSettings().setUseWideViewPort(true);
        holder.myWebView.getSettings().setSafeBrowsingEnabled(true);
        holder.myWebView.getSettings().setSafeBrowsingEnabled(true);
        holder.myWebView.getSettings().setLoadWithOverviewMode(true);
        holder.myWebView.getSettings().setJavaScriptEnabled(true);


    }

    @Override
    public int getItemCount() {
        return urlList.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        MyWebView myWebView;

        MyViewHolder(View itemView) {
            super(itemView);
            myWebView = itemView.findViewById(R.id.myWebView);


        }
    }
}
