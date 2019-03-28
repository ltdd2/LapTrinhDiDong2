package com.example.congthucnauan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ChiTietMonAnActivity extends AppCompatActivity {
    Toolbar toolbarChiTiet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chi_tiet_mon_an_layout);
        //Toolbar
        toolbarChiTiet = (Toolbar) findViewById(R.id.toolbarChiTiet);
        Intent intent = getIntent();
        String tenMonAn = intent.getStringExtra("Key");
        toolbarChiTiet.setTitle(tenMonAn);
        setSupportActionBar(toolbarChiTiet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarChiTiet.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
