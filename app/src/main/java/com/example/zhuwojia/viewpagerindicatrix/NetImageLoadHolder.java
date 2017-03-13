package com.example.zhuwojia.viewpagerindicatrix;

import android.content.Context;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;

/**
 * author：shixinxin on 2016/12/14
 * version：v1.0
 */

public class NetImageLoadHolder implements Holder<String> {
    private ImageView image_lv;

    //可以是一个布局也可以是一个Imageview
    @Override
    public ImageView createView(Context context) {
        image_lv = new ImageView(context);
        image_lv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return image_lv;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
//        String pic_rl = Url.BASE_URL_PIC + data;
        Glide.with(context).load(data).into(image_lv);
    }
}

