package com.test.androidretrofit2example;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    class NewsViewHolder extends RecyclerView.ViewHolder{

        public TextView title;

        public TextView description;

        public NewsViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.post_title);
            description = (TextView) itemView.findViewById(R.id.post_description);
        }
    }//end of innerClass

    private Context context;

    private List<ApiObject> apiObjectList;

    public NewsAdapter(Context context, List<ApiObject> apiObjects){
        this.context = context;
        this.apiObjectList =  apiObjects;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        ApiObject apiObject = apiObjectList.get(position);
        holder.title.setText(apiObject.getTitle());
        holder.description.setText(apiObject.getDescription());
    }

    @Override
    public int getItemCount() {
        return apiObjectList.size();
    }

}
