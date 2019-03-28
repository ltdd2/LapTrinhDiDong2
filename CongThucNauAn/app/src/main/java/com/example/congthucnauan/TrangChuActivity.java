package com.example.congthucnauan;


import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TrangChuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    RecyclerView monAnNoiBat;
    GridView gridViewChuyenMuc;
    ChuyenMucAdapter chuyenMucAdapter;
    ImageView imgLogo;
    ArrayList<Integer> arrayHinh;
    ArrayList<ChuyenMuc> chuyenMucArrayList;
    Timer timer;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trang_chu_layout);
        //Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.trangchu);

        drawerLayout = (DrawerLayout) findViewById(R.id.draw_layout);
        NavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Recyclerview
        monAnNoiBat = (RecyclerView) findViewById(R.id.dsMonAnNoiBat);
        monAnNoiBat.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        monAnNoiBat.setLayoutManager(linearLayoutManager);
        final ArrayList<MonAn> monAnArrayList = new ArrayList<>();

        for (int i = 0; i < DuLieuMonAn.imgHinh.length; i++) {
            monAnArrayList.add(new MonAn(DuLieuMonAn.imgHinh[i], DuLieuMonAn.txtTenMonAn[i]));
        }
        MonAnAdapter monAnAdapter = new MonAnAdapter(monAnArrayList, this);
        monAnNoiBat.setAdapter(monAnAdapter);
        monAnNoiBat.setItemAnimator(new DefaultItemAnimator());
        //Dat hinh logo
        imgLogo = (ImageView) findViewById(R.id.imgHinhDemo);
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

        //Girview
        gridViewChuyenMuc = (GridView) findViewById(R.id.gv);
        chuyenMucArrayList = new ArrayList<>();
        for (int i = 0; i < DuLieuChuyenMuc.imgHinhChuyenMuc.length; i++) {
            chuyenMucArrayList.add(new ChuyenMuc(DuLieuChuyenMuc.imgHinhChuyenMuc[i], DuLieuChuyenMuc.txtTenChuyenMuc[i]));
        }
        chuyenMucAdapter = new ChuyenMucAdapter(this,R.layout.chuyenmuc_layout,chuyenMucArrayList);
        gridViewChuyenMuc.setAdapter(chuyenMucAdapter);
      /* // chuyenMucAdapter = new ChuyenMucAdapter(view.getContext(),R.layout.chuyenmuc_layout,chuyenMucArrayList);
        gridViewChuyenMuc.setAdapter(chuyenMucAdapter);
        reDanhMuc = (RecyclerView) view.findViewById(R.id.reDanhMuc);
        reDanhMuc.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        reDanhMuc.setLayoutManager(linearLayoutManager1);
        final ArrayList<ChuyenMuc> chuyenMucs = new ArrayList<>();

        for(int i = 0; i < DuLieuChuyenMuc.imgHinhChuyenMuc.length;i++){
            chuyenMucs.add(new ChuyenMuc(DuLieuChuyenMuc.imgHinhChuyenMuc[i],DuLieuChuyenMuc.txtTenChuyenMuc[i]));
        }
        MonAnAdapter monAnAdapter1 = new MonAnAdapter(monAnArrayList, view.getContext());
        reDanhMuc.setAdapter(monAnAdapter1);
        reDanhMuc.setItemAnimator(new DefaultItemAnimator());*/
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        return onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.monkhaivi:
                Toast.makeText(this,"Trang Chu",Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.monnuong:
                Toast.makeText(this,"Chi Tiet",Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.monlau:
                break;
            case R.id.diadiem:
                break;
            case R.id.thoat:
                break;
        }

        return true;
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
}
