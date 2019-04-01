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
import android.view.View;
import android.widget.Button;
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
    RecyclerView reMonAn,reQuanAn;
    MonAnAdapter monAnAdapter;
    QuanAnAdapter  quanAnAdapter;
    ImageView imgLogo;
    ArrayList<QuanAn> quanAns;
    ArrayList<MonAn> monAns;

    Button btnMonXao,btnMonLau,btnTrangMieng,btnQuanAn,btnMonChien,btnMonKho;
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
        //Button
        btnMonXao = (Button) findViewById(R.id.btnMonXao);
        btnMonLau =(Button) findViewById(R.id.btnMonLau);
        btnTrangMieng =(Button) findViewById(R.id.btnTrangMieng);
        btnQuanAn =(Button) findViewById(R.id.btnQuanAn);
        btnMonChien =(Button)findViewById(R.id.btnMonChien);
        btnMonKho=(Button) findViewById(R.id.btnMonKho);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        //Girview Quan  An
        reQuanAn = (RecyclerView) findViewById(R.id.reQuanAn);
        reQuanAn.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        reQuanAn.setLayoutManager(linearLayoutManager2);
        quanAns = new ArrayList<>();
        for(int i = 0; i < 3;i++){
            quanAns.add(new QuanAn(DuLieuQuanAn.imgHinhQuanAn[i],DuLieuQuanAn.txtTenQuanAn[i]));
        }
        quanAnAdapter = new QuanAnAdapter(quanAns,this);
        reQuanAn.setAdapter(quanAnAdapter);
        reQuanAn.setItemAnimator(new DefaultItemAnimator());

        //Sự kiện click
        btnTrangMieng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent.putExtra("Key","Món Tráng Miệng");
                startActivity(intent);
            }
        });
        btnMonChien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent.putExtra("Key","Món Chiên");
                startActivity(intent);
            }
        });
        btnMonKho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent.putExtra("Key","Món Kho");
                startActivity(intent);
            }
        });
        btnMonLau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent.putExtra("Key","Món Lẩu");
                startActivity(intent);
            }
        });
        btnMonXao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent.putExtra("Key","Món Xào");
                startActivity(intent);
            }
        });
        btnQuanAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangChuActivity.this,QuanAnActivity.class);
                intent.putExtra("Key","DANH SÁCH QUÁN ĂN");
                startActivity(intent);
            }
        });

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
            case R.id.montrangmieng:
                Intent intent = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent.putExtra("Key","Món Tráng Miệng");
                startActivity(intent);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.monxao:
                Intent intent1 = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent1.putExtra("Key","Món Xào");
                startActivity(intent1);

                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.monlau:
                Intent intent2 = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent2.putExtra("Key","Món Lẩu");
                startActivity(intent2);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.monkho:
                Intent intent3 = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent3.putExtra("Key","Món Kho");
                startActivity(intent3);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.monchien:
                Intent intent4 = new Intent(TrangChuActivity.this,DanhSachMonAnActivity.class);
                intent4.putExtra("Key","Món Chiên");
                startActivity(intent4);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.quanan:
                Intent intent5 = new Intent(TrangChuActivity.this,QuanAnActivity.class);
                intent5.putExtra("Key","DANH SÁCH QUÁN ĂN");
                startActivity(intent5);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.thoat:
                finish();
                break;
        }

        return true;
    }
}
