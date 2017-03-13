package com.example.zhuwojia.viewpagerindicatrix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ViewPagerIndicatrix viewPagerIndicatrix;
    private String images[] = new String[]{
            "http://img1.mydrivers.com/img/20141125/9ac06a39d6e44d41afee6daf5c3bfa72.jpg",
            "http://img3.redocn.com/20130328/Redocn_2013032813053442.jpg",
            "http://img3.redocn.com/20100324/Redocn_2010032211114681.jpg",
            "http://img.taopic.com/uploads/allimg/130708/318749-130FR1424755.jpg",
            "http://img3.redocn.com/20130110/Redocn_2013011017532360.jpg",
            "http://img.sucai.redocn.com/attachments/images/201203/20120320/Redocn_2012032007315863.jpg",
            "http://e.hiphotos.baidu.com/image/h%3D300/sign=364bc6a808d79123ffe092749d355917/48540923dd54564e6e937299b7de9c82d0584f98.jpg",
            "http://img4.duitang.com/uploads/item/201509/28/20150928193800_Z4Jdv.jpeg",
            "http://pic.58pic.com/58pic/17/56/38/51D58PICB8h_1024.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPagerIndicatrix = (ViewPagerIndicatrix) findViewById(R.id.viewPager);
        viewPagerIndicatrix.setViewPagerAdapter(this, images );
    }


}
