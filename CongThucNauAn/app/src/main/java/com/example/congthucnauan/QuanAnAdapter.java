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
import android.widget.TextView;

import java.util.ArrayList;

public class QuanAnAdapter extends RecyclerView.Adapter<QuanAnAdapter.ViewHolder> {
    private ArrayList<QuanAn> quanAns;
    private Context context;


    public QuanAnAdapter(ArrayList<QuanAn> quanAns, Context context) {
        this.quanAns = quanAns;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_quan_an_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.imgHinhQuanAn.setImageResource(quanAns.get(i).getImgHinhQuanAn());
        viewHolder.txtTenQuanAn.setText(quanAns.get(i).getTxtTenQuanAn());
    }

    @Override
    public int getItemCount() {
        return quanAns.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinhQuanAn;
        TextView txtTenQuanAn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhQuanAn = (ImageView) itemView.findViewById(R.id.imgHinhQuanAn);
            txtTenQuanAn =(TextView) itemView.findViewById(R.id.txtTenQuanAn);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,ReviewQuanAnActivity.class);
                    intent.putExtra("Key",txtTenQuanAn.getText());
                    context.startActivity(intent);
                }
            });
        }
    }
}
