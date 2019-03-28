package com.example.congthucnauan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class ChiTietMonAnActivity extends AppCompatActivity {
    Toolbar toolbarChiTiet;
    ImageView imgHinh;
    private ListView lv;
    private String number[] = {"30 gr bột bắp", "30 gr bột mì", "20 gr dầu ăn", "10 gr sữa tươi", "3 trứng gà", "50 gr đường", "1/4 muỗng nước cốt chanh", "1 nhúm muối", "1 lòng đỏ trứng", "25 gr đường", "2 gr muối", "20 gr bột ngô", "240 ml nước", "25 gr bơ nhạt","1 cây xúc xích 35 gr", "5 quả trứng muối", "2 Miếng phô mai bò cười"};

    private ListView lv2;
    private String number2[] = {"Cốt bánh: Cho dầu ăn và sữa vào cùng một chén. Tách lòng trắng và lòng đỏ riêng. bật lò nhiệt độ 160 để làm nóng trước. Đánh lòng trắng trứng ở tốc độ chậm (que đánh trứng phải sạch), đánh đến khi nổi bọt to thì cho nước cốt chanh vào, tiếp tục đánh cho đến khi trứng nổi bọt khí nhỏ mịn như xà phòng, cho đường vào từng chút một đánh đến khi đường tan thì bật máy đánh tốc độ cao nhất. Đánh cho đến khi trứng bông đứng ở đầu chóp que đánh trứng thì ngừng, cho từng lòng đỏ vào đánh ở tốc độ chậm nhất (mỗi quả đánh khoảng 5 giây), sau đó tiếp tục khuấy đều sữa và dầu ăn lúc nãy, cho vào trứng đánh tiếp tục ở tốc độ chậm nhất, đến khi hỗn hợp đều mịn thì trộn bột bắp + bột mì xong chia làm 3 lần rây vào trứng, đánh ở tốc độ chậm nhất để hỗn hợp bột được trộn đều", "Sau đó dùng phới trộn fold từ dưới lên trên, tránh trộn nhiều làm vỡ hết bọt khí bánh sẽ bị chai. lót giấy nến (hoặc a4 dưới đáy khuôn), đổ bột vào khuôn và đập khuôn xuống bàn để vỡ bớt bọt khí to trong bột. Cho vào lò nướng, để vỉ nướng ở bậc cuối lò, để nhiệt độ 175 độ nướng khoảng 35 - 40 phút", "Làm sốt bơ trứng: cho lòng đỏ trứng vào thau, đánh cùng đường đến khi tan hoàn toàn và trứng đến khi vàng nhạt mịn màng, tiếp tục rây bột vào, cho 50ml nước vào đánh đều, bơ làm chảy ở nhiệt độ phòng cho vào đánh đều, tiếp tục cho phần nước còn lại vào đánh chung. Rây qua để bỏ bột bị bón. cuối cùng bắc lên bếp, khuấy đều đến khi hỗn hợp chín, sánh mịn là xong", "Tách trứng muối lấy lòng đỏ rửa sạch bằng nước, rửa lại bằng rượu trắng hoặc Rum. Phết dầu ăn lên lòng đỏ, cho vào lò nướng nướng ở nhiệt độ 100 độ trong 7 phút là xong. Phết sốt lên mặt bánh, thái xúc xích, phô mai, trang trí lên mặt bánh, cho trứng muối lên, rắc chà bông lên và ăn thôi"};

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
        //Nội Đung
        imgHinh =(ImageView) findViewById(R.id.imageView);
        imgHinh.setImageResource(R.drawable.goimuc);

        lv = (ListView) findViewById(R.id.lvnguyenlieu);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, number);
        lv.setAdapter(arrayAdapter);

        lv2 = (ListView) findViewById(R.id.lvcachlam);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this,android.R.layout.simple_list_item_1, number2);
        lv2.setAdapter(arrayAdapter2);
    }
}
