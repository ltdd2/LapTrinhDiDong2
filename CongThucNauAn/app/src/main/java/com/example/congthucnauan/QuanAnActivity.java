package com.example.congthucnauan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;

public class QuanAnActivity extends AppCompatActivity {
    Toolbar toolbarQuanAn;
    GridView gvDSQuanAn;
    ArrayList<QuanAn> quanAns;
    QuanAnAdapter quanAnAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quan_an_layout);
        //Toolbar
        toolbarQuanAn = (Toolbar) findViewById(R.id.toolbarQuanAn);
        Intent intent = getIntent();
        String quanAn = intent.getStringExtra("Key");
        toolbarQuanAn.setTitle(quanAn);
        setSupportActionBar(toolbarQuanAn);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarQuanAn.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //Nội Dung
        gvDSQuanAn = (GridView) findViewById(R.id.gvDSQuanAn);
        quanAns = new ArrayList<>();
        for(int i = 0; i < DuLieuQuanAn.imgHinhQuanAn.length;i++){
            quanAns.add(new QuanAn(DuLieuQuanAn.imgHinhQuanAn[i],DuLieuQuanAn.txtTenQuanAn[i]));
        }
        quanAnAdapter = new QuanAnAdapter(quanAns,this,R.layout.item_quan_an_layout);
        gvDSQuanAn.setAdapter(quanAnAdapter);
    }
}
