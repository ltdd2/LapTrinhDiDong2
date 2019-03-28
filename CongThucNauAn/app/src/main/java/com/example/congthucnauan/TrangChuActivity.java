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
    RecyclerView reDanhMuc,reMonAn;
    GridView gvQuanAn;
    ChuyenMucAdapter chuyenMucAdapter;
    MonAnAdapter monAnAdapter;
    QuanAnAdapter  quanAnAdapter;
    ImageView imgLogo;
    ArrayList<Integer> arrayHinh;
    ArrayList<ChuyenMuc> chuyenMucs;
    ArrayList<QuanAn> quanAns;
    ArrayList<MonAn> monAns;
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
        //Recyclerview danh muc mon an
        reDanhMuc = (RecyclerView) findViewById(R.id.reDanhMuc);
        reDanhMuc.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        reDanhMuc.setLayoutManager(linearLayoutManager);
        chuyenMucs = new ArrayList<>();

        for (int i = 0; i < DuLieuChuyenMuc.imgHinhChuyenMuc.length; i++) {
            chuyenMucs.add(new ChuyenMuc(DuLieuChuyenMuc.imgHinhChuyenMuc[i], DuLieuChuyenMuc.txtTenChuyenMuc[i]));
        }
         chuyenMucAdapter = new ChuyenMucAdapter(chuyenMucs,this);
        reDanhMuc.setAdapter(chuyenMucAdapter);
        reDanhMuc.setItemAnimator(new DefaultItemAnimator());
        //Recyclerview  mon an
        reMonAn = (RecyclerView) findViewById(R.id.reMonAn);
        reMonAn.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        reMonAn.setLayoutManager(linearLayoutManager1);
        monAns = new ArrayList<>();
        for(int i = 0 ; i< 3 ;i++){
            monAns.add(new MonAn(DuLieuMonAn.imgHinh[i],DuLieuMonAn.txtTenMonAn[i],DuLieuMonAn.txtMoTaMonAn[i]));
        }
        monAnAdapter = new MonAnAdapter(monAns,this);
        reMonAn.setAdapter(monAnAdapter);
        reMonAn.setItemAnimator(new DefaultItemAnimator());
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
        //Girview Quan  An
        gvQuanAn = (GridView) findViewById(R.id.gvQuanAn);
        quanAns = new ArrayList<>();
        for(int i = 0; i < DuLieuQuanAn.imgHinhQuanAn.length;i++){
            quanAns.add(new QuanAn(DuLieuQuanAn.imgHinhQuanAn[i],DuLieuQuanAn.txtTenQuanAn[i]));
        }
        quanAnAdapter = new QuanAnAdapter(quanAns,this,R.layout.item_quan_an_layout);
        gvQuanAn.setAdapter(quanAnAdapter);

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
                Intent intent = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent.putExtra("Key","MÓN KHAI VỊ");
                startActivity(intent);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.monnuong:
                Intent intent1 = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent1.putExtra("Key","MÓN NƯỚNG");
                startActivity(intent1);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.monlau:
                Intent intent2 = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent2.putExtra("Key","MÓN LẨU");
                startActivity(intent2);
                break;
            case R.id.dsQuanAn:
                Intent intent3 = new Intent(TrangChuActivity.this,QuanAnActivity.class);
                intent3.putExtra("Key","DANH SÁCH QUÁN  ĂN");
                startActivity(intent3);
                break;
            case R.id.thoat:
                break;
        }

        return true;
    }


    //Timer
    class dHinh extends TimerTask {

        @Override
        public void run() {
            handler.sendEmptyMessage(0);
        }
    }
    //Đổi hình
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
