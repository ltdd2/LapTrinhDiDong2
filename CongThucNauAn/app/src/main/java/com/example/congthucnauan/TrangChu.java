package com.example.congthucnauan;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TrangChu extends Fragment {
    RecyclerView monAnNoiBat;
    ImageView imgLogo;
    ArrayList<Integer> arrayHinh;
    Timer timer;
    Handler handler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.trangchu, container, false);
        //Recyclerview
        monAnNoiBat = (RecyclerView) view.findViewById(R.id.dsMonAnNoiBat);
        monAnNoiBat.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        monAnNoiBat.setLayoutManager(linearLayoutManager);
        final ArrayList<MonAn> monAnArrayList = new ArrayList<>();

        for (int i = 0; i < DuLieu.imgHinh.length; i++) {
            monAnArrayList.add(new MonAn(DuLieu.imgHinh[i], DuLieu.txtTenMonAn[i]));
        }
        MonAnAdapter monAnAdapter = new MonAnAdapter(monAnArrayList, view.getContext());
        monAnNoiBat.setAdapter(monAnAdapter);
        monAnNoiBat.setItemAnimator(new DefaultItemAnimator());

        imgLogo = (ImageView) view.findViewById(R.id.imgHinhDemo);
        timer = new Timer();
        Handler.Callback callback = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                doiHinh();
                return false;
            }
        };
        handler = new Handler(callback);
        timer.schedule(new dHinh(), 2000, 2000);
        return view;
    }

    class dHinh extends TimerTask {

        @Override
        public void run() {
            handler.sendEmptyMessage(0);
        }
    }

    private void doiHinh() {
        arrayHinh = new ArrayList<>();
        arrayHinh.add(R.drawable.goicatre);
        arrayHinh.add(R.drawable.goimuc);
        arrayHinh.add(R.drawable.goioc);
        arrayHinh.add(R.drawable.goitom);
        arrayHinh.add(R.drawable.rauxanh);
        Random random = new Random();
        int i = random.nextInt(arrayHinh.size());
        imgLogo.setImageResource(arrayHinh.get(i));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
