package com.example.congthucnauan;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.RawRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAnAdapter extends RecyclerView.Adapter<MonAnAdapter.ViewHolder> {
    ArrayList<MonAn> monAns;
    Context context;

    public MonAnAdapter(ArrayList<MonAn> monAns, Context context) {
        this.monAns = monAns;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_mon_an,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.imgHinhMonAn.setImageResource(monAns.get(i).getImgHinhMonAn());
        viewHolder.txtTenMonAn.setText(monAns.get(i).getTxtTenMonAn());
        viewHolder.txtMoTaMonAn.setText(monAns.get(i).getTxtMoTaMonAn());
    }

    @Override
    public int getItemCount() {
        return monAns.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinhMonAn;
        TextView txtTenMonAn, txtMoTaMonAn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhMonAn = (ImageView) itemView.findViewById(R.id.imgHinhMonAn);
            txtMoTaMonAn = (TextView) itemView.findViewById(R.id.txtMoTaMonAn);
            txtTenMonAn = (TextView) itemView.findViewById(R.id.txtTenMonAn);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,ChiTietMonAnActivity.class);
                    intent.putExtra("Key",txtTenMonAn.getText());
                    context.startActivity(intent);
                }
            });
        }

    }
}
