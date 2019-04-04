package com.example.congthucnauan;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class QuanAnAdapter extends BaseAdapter {
    private ArrayList<QuanAn> quanAns;
    private Context context;


    public QuanAnAdapter(ArrayList<QuanAn> quanAns, Context context) {
        this.quanAns = quanAns;
        this.context = context;
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
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.item_quan_an_layout,null);
        CircleImageView imgHinhQuanAn =  (CircleImageView) convertView.findViewById(R.id.imgHinhQuanAn);
        final TextView txtTenQuanAn = (TextView) convertView.findViewById(R.id.txtTenQuanAn);
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
