package com.example.zhuwojia.viewpagerindicatrix;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.zhuwojia.viewpagerindicatrix.R.id.home_viewPager;


/**
 * author：shixinxin on 2017/3/13
 * version：v1.0
 */

public class ViewPagerIndicatrix extends LinearLayout {

    private ConvenientBanner viewPager;
    private LinearLayout ll_line;

    private float lineHeight;

    private List<ImageView> imageViewList = new ArrayList<>();

    public ViewPagerIndicatrix(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ViewPagerLine);
        lineHeight = typedArray.getDimension(R.styleable.ViewPagerLine_lineHeight, 2.0f);
        typedArray.recycle();
        LayoutInflater.from(context).inflate(R.layout.activity_vp, this);
        viewPager = (ConvenientBanner) findViewById(home_viewPager);
        ll_line = (LinearLayout) findViewById(R.id.pointer_line);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
               if(imageViewList.size()>position){
                   for (int i = 0; i < imageViewList.size(); i++) {
                       imageViewList.get(i).setSelected(false);
                   }
                   imageViewList.get(position).setSelected(true);
               }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void setViewPagerAdapter(Context context, String[] images) {
        viewPager.setPages(new CBViewHolderCreator<NetImageLoadHolder>() {
            @Override
            public NetImageLoadHolder createHolder() {
                return new NetImageLoadHolder();
            }
        }, Arrays.asList(images));
        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(context);
            LayoutParams ll = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            ll.weight = 1;
            imageView.setLayoutParams(ll);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                imageView.setBackground(getResources().getDrawable(R.drawable.fragment_vp_point_sl));
            }
            imageViewList.add(imageView);
            ll_line.addView(imageView);
            if (i == 0) {
                imageView.setSelected(true);
            }
        }
    }

}
