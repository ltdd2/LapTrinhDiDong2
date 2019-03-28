package com.example.congthucnauan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class QuanAnAdapter extends BaseAdapter {
    private ArrayList<QuanAn> quanAns;
    private Context context;
    private int layout;

    public QuanAnAdapter(ArrayList<QuanAn> quanAns, Context context,int layout) {
        this.quanAns = quanAns;
        this.context = context;
        this.layout = layout;
    }


    @Override
    public int getCount() {
        return quanAns.size();
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
        ImageView imgHinhQuanAn;
        final TextView txtTenQuanAn;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout,null);
        imgHinhQuanAn = (ImageView) convertView.findViewById(R.id.imgHinhQuanAn);
        txtTenQuanAn =(TextView) convertView.findViewById(R.id.txtTenQuanAn);
        QuanAn quanAn = quanAns.get(position);
        imgHinhQuanAn.setImageResource(quanAn.getImgHinhQuanAn());
        txtTenQuanAn.setText(quanAn.getTxtTenQuanAn());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ReviewQuanAnActivity.class);
                intent.putExtra("Key",txtTenQuanAn.getText());
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
