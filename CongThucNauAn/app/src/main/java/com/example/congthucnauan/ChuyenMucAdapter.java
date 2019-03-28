package com.example.congthucnauan;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChuyenMucAdapter extends RecyclerView.Adapter<ChuyenMucAdapter.ViewHolder> {
    ArrayList<ChuyenMuc> chuyenMucs;
    Context context;

    public ChuyenMucAdapter(ArrayList<ChuyenMuc> chuyenMucs, Context context) {
        this.chuyenMucs = chuyenMucs;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.chuyen_muc_layout,viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.imgHinhChuyenMuc.setImageResource(chuyenMucs.get(i).getImgHinh());
        viewHolder.txtTenChuyenMuc.setText(chuyenMucs.get(i).getTxtTen());
    }

    @Override
    public int getItemCount() {
        return chuyenMucs.size();
    }

    public class ViewHolder  extends  RecyclerView.ViewHolder{
        ImageView imgHinhChuyenMuc;
        TextView txtTenChuyenMuc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhChuyenMuc = itemView.findViewById(R.id.imgHinhChuyenMuc);
            txtTenChuyenMuc = itemView.findViewById(R.id.txtTenChuyenMuc);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,DanhSachMonAnActivity.class);
                    intent.putExtra("Key",txtTenChuyenMuc.getText());
                    context.startActivity(intent);
                }
            });
        }
    }
}
