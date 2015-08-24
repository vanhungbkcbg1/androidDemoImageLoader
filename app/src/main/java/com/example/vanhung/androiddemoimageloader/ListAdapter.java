package com.example.vanhung.androiddemoimageloader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by vanhung on 24/08/2015.
 */
public class ListAdapter extends ArrayAdapter<String> {

    private Context context;
    private Integer layout;
    private List<String>data;
    DisplayImageOptions options=OlayApp.imageOptionsDefault;
    ImageLoader imageLoader=ImageLoader.getInstance();
    public ListAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.context=context;
        this.layout=resource;
        this.data=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(layout,parent,false);
            ViewHolder viewHolder=new ViewHolder();
            viewHolder.img=(ImageView)convertView.findViewById(R.id.image_item);
            convertView.setTag(viewHolder);
        }

        ViewHolder viewHolder= (ViewHolder) convertView.getTag();
        imageLoader.displayImage(data.get(position),viewHolder.img,options);
        return convertView;

    }

    private static class ViewHolder
    {
        private ImageView img;
    }
}
