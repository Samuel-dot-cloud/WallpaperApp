package com.studiofive.wallpaperapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.studiofive.wallpaperapp.Models.Collection;
import com.studiofive.wallpaperapp.R;
import com.studiofive.wallpaperapp.utils.SquareImage;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectionsAdapter extends BaseAdapter {
    private Context context;
    private List<Collection> collections;

    public CollectionsAdapter(Context context, List<Collection> collections){
        this.context = context;
        this.collections = collections;
    }
    @Override
    public int getCount() {
        return collections.size();
    }

    @Override
    public Object getItem(int position) {
        return collections.get(position);
    }

    @Override
    public long getItemId(int position) {
        return collections.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_collection, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        ButterKnife.bind(this, convertView);
        Collection collection = collections.get(position);
        if (collection.getTitle() != null){
            holder.title.setText(collection.getTitle());
        }
        holder.totalPhotos.setText(String.valueOf(collection.getTotalPhotos()) + " photos");
        GlideApp.with(context).load(collection.getCoverPhoto().getUrl().getRegular())
                .into(holder.collectionPhoto);
        return convertView;
    }

    static class ViewHolder{
        @BindView(R.id.item_collection_title)
        TextView title;
        @BindView(R.id.item_collection_total_photo)
        TextView totalPhotos;
        @BindView(R.id.item_collection_photo)
        SquareImage collectionPhoto;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}
