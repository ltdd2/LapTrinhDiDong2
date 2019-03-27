package com.example.congthucnauan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ChuyenMucAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ChuyenMuc> chuyenMucList;

    public ChuyenMucAdapter(Context context, int layout, List<ChuyenMuc> chuyenMucList) {
        this.context = context;
        this.layout = layout;
        this.chuyenMucList = chuyenMucList;
    }

    @Override
    public int getCount() {
        return chuyenMucList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if(convertView == null){
                viewHolder = new ViewHolder();
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(layout,null);
                viewHolder.imgHinh = (ImageView) convertView.findViewById(R.id.imgHinhChuyenMuc);
                viewHolder.txtTenChuyenMuc = (TextView) convertView.findViewById(R.id.txtTenChuyenMuc);
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            ChuyenMuc chuyenMuc = chuyenMucList.get(position);
            viewHolder.imgHinh.setImageResource(chuyenMuc.getImgHinh());
            viewHolder.txtTenChuyenMuc.setText(chuyenMuc.getTxtTen());
        return convertView;
    }
    private class ViewHolder{
        ImageView imgHinh;
        TextView txtTenChuyenMuc;
    }
}
